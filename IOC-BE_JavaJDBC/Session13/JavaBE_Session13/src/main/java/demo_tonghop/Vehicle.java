package demo_tonghop;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Scanner;

public abstract class Vehicle implements Machine {
    private String vehicleName;
    private Integer yearMaking;
    private Double weight;
    private String facturerName;
    private Double price;


    public Vehicle() {
    }

    public Vehicle(String facturerName, Double price, String vehicleName, Double weight, Integer yearMaking) {
        this.facturerName = facturerName;
        this.price = price;
        this.vehicleName = vehicleName;
        this.weight = weight;
        this.yearMaking = yearMaking;
    }

    public String getFacturerName() {
        return facturerName;
    }

    public void setFacturerName(String facturerName) {
        this.facturerName = facturerName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getYearMaking() {
        return yearMaking;
    }

    public void setYearMaking(Integer yearMaking) {
        this.yearMaking = yearMaking;
    }

    @Override
    public void display() {
        System.out.println("Tên phương tiện: "+vehicleName);
        System.out.println("Hãng sản xuất: "+facturerName);
        System.out.println("Năm sản xuất: "+yearMaking);
        System.out.println("Trọng lượng: "+weight);
        NumberFormat nf = NumberFormat.getNumberInstance();
        System.out.println("Giá trị gốc: "+nf.format(price));
        System.out.println("Giá trị còn lại: "+nf.format(calPriceDownForEachYear()));
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào tên phương tiện: ");
        vehicleName = sc.nextLine();
        System.out.println("Nhập vào tên hãng sản xuất: ");
        facturerName = sc.nextLine();
        System.out.println("Nhập vào năm sản xuất: ");
        yearMaking = sc.nextInt();
        System.out.println("Nhập vào trọng lượng phương tiện: ");
        weight = sc.nextDouble();
        System.out.println("Nhập vào giá trị gốc: ");
        price = sc.nextDouble();
    }

    @Override
    public double calPriceDownForEachYear() {
        int currentYear = LocalDate.now().getYear();
        int remainYear = currentYear - yearMaking;
        if(remainYear >=20){
            return 0;
        }else{
            return price * Math.pow(0.95, remainYear);
        }
    }
}
