package demo_tonghop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ListCar {
    public static void main(String[] args) {
        List<Car> listCar = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choose;

        while (true) {
            System.out.println("============= QUẢN LÝ Ô TÔ ============");
            System.out.println("1. Thêm mới ô tô");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Cập nhật thông tin");
            System.out.println("4. Xoá thông tin");
            System.out.println("5. Tìm kiếm thông tin theo hãng");
            System.out.println("6. Sắp xếp giảm dần theo giá và hiển thị");
            System.out.println("7. Sắp xếp tăng dần theo tên xe và hiển thị");
            System.out.println("0. Kết thúc");
            System.out.println("=================================");
            System.out.println("Hãy chọn chức năng: ");
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    Car car1 = new Car();
                    car1.input();
                    listCar.add(car1);
                    System.out.println("Đã thêm mới 1 ô tô");
                    break;
                case 2:
                    if(listCar.size()==0){
                        System.out.println("Danh sách rỗng");
                    }else{
                        for (Car car : listCar) {
                            car.display();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Nhập vào biến số xe cần cập nhật: ");
                    String numberPlate = sc.nextLine();
                    boolean exists = false;
                    for (Car car : listCar) {
                        if(car.getNumberPlate().equals(numberPlate)){
                            exists = true;
                            System.out.println("Nhập vào tên xe cần cập nhật (enter bỏ qua): ");
                            String carName = sc.nextLine();
                            if(!carName.isEmpty()){
                                car.setVehicleName(carName);
                            }
                            System.out.println("Nhập vào hãng xe cần cập nhật (enter bỏ qua): ");
                            String manufacturerName = sc.nextLine();
                            if(!manufacturerName.isEmpty()){
                                car.setFacturerName(manufacturerName);
                            }
                            System.out.println("Nhập vào năm sản xuất cần cập nhật (enter bỏ qua): ");
                            String strYear = sc.nextLine();
                            if(!strYear.isEmpty()){
                                car.setYearMaking(Integer.parseInt(strYear));
                            }
                            System.out.println("Nhập vào trọng lượng cần cập nhật (enter bỏ qua): ");
                            String strWeight = sc.nextLine();
                            if(!strWeight.isEmpty()){
                                car.setWeight(Double.parseDouble(strWeight));
                            }
                            System.out.println("Nhập vào tổng số ghế cần cập nhật (enter bỏ qua): ");
                            String strTotalSeats = sc.nextLine();
                            if(!strTotalSeats.isEmpty()){
                                car.setTotalSeats(Integer.parseInt(strTotalSeats));
                            }
                            System.out.println("Nhập vào loại nhiên liệu cần cập nhật (enter bỏ qua): ");
                            String fuelType =  sc.nextLine();
                            if(!fuelType.isEmpty()){
                                car.setFuelType(fuelType);
                            }
                            System.out.println("Đã cập nhật thông tin");
                            break;
                        }
                    }
                    if(!exists){
                        System.out.println("Không tìm thấy phương tiện!");
                    }
                    break;
                case 4:
                    System.out.println("Nhập vào biến số xe cần cập nhật: ");
                    numberPlate = sc.nextLine();
                    exists = false;
                    for (Car car : listCar) {
                        if (car.getNumberPlate().equals(numberPlate)) {
                            listCar.remove(car);
                            exists = true;
                            break;
                        }
                    }
                    if(exists){
                        System.out.println("Đã xoá phương tiện khỏi danh sách");
                    }else{
                        System.out.println("Không tìm thấy phương tiện nào");
                    }
                    break;
                case 5:
                    System.out.println("Nhập vào tên hãng cần tìm: ");
                    String manuFacturerName = sc.nextLine();
                    int found = 0;

                    System.out.println("Kết quả tìm kiếm: ");
                    for(Car car : listCar){
                        if(car.getFacturerName().equals(manuFacturerName)){
                            car.display();
                            found++;
                        }
                    }
                    System.out.println("Có "+found+" phương tiện được tìm thấy!");
                    break;
                case 6:
                    listCar.sort(new Comparator<Car>() {
                        @Override
                        public int compare(Car o1, Car o2) {
                            return o2.getPrice().compareTo(o1.getPrice());
                        }
                    });
                    System.out.println("Danh sách giảm dần theo giá: ");
                    for (Car car : listCar) {
                        car.display();
                    }
                    break;
                case 7:
                    listCar.sort((c1,c2)-> c1.getVehicleName().compareTo(c2.getVehicleName()));
                    System.out.println("Danh sách tăng dần theo tên xe: ");
                    for (Car car : listCar) {
                        car.display();
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Bạn chọn sai!");
            }
        }
    }
}
