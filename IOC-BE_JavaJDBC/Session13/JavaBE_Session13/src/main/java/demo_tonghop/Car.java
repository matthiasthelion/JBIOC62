package demo_tonghop;

import java.util.Scanner;

public class Car extends Vehicle{
    private int totalSeats;
    private String fuelType;
    private String numberPlate;

    public Car() {
    }

    public Car(String facturerName, Double price, String vehicleName, Double weight, Integer yearMaking, String fuelType, int totalSeats, String numberPlate) {
        super(facturerName, price, vehicleName, weight, yearMaking);
        this.fuelType = fuelType;
        this.totalSeats = totalSeats;
        this.numberPlate = numberPlate;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public void getNewNumberPlate(){
        String alpha = "ABCDEFGHKLMNPSTUVXYZ";
        String num = "0123456789";
        String newNumberPlate = "";
        for(int i=0;i<2;i++){
            newNumberPlate += num.charAt((int)(Math.random()*10));
        }
        newNumberPlate += alpha.charAt((int)(Math.random()*20));
        for(int i=0;i<2;i++){
            newNumberPlate += (num+alpha).charAt((int)(Math.random()*30));
        }
        for(int i=0;i<2;i++){
            newNumberPlate += num.charAt((int)(Math.random()*10));
        }
        this.numberPlate = newNumberPlate;
    }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào tổng số ghế: ");
        totalSeats = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập vào loại nhiên liệu: ");
        fuelType = sc.nextLine();
        System.out.println("Nhập vào biên số xe (7 ký tự, enter cấp random): ");
        String plate = sc.nextLine();
        if(plate.isEmpty()){
            getNewNumberPlate();
            System.out.println("Biển số mới: "+numberPlate);
        } else{
            numberPlate = plate;
        }
    }

    @Override
    public void display() {
        System.out.println("-----------------------");
        super.display();
        System.out.println("Tổng số ghế: "+totalSeats);
        System.out.println("Loại nhiên liệu: "+fuelType);
        System.out.println("Biển số: "+numberPlate);
        System.out.println("-----------------------");
    }
}
