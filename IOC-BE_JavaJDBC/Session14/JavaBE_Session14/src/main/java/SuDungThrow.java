import java.util.Scanner;

public class SuDungThrow {
    public static void main(String[] args) throws Exception {
        int number;

        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Nhập vào 1 số nguyên dương: ");
            String strNumber = sc.nextLine();
            if(strNumber.isEmpty()){
                System.out.println("Bạn phải nhập vào dữ liệu");
            }else{
                try{
                    number = Integer.parseInt(strNumber);
                    if(number<0){

                        System.out.println("Phải nhập vào số dương");
                    }else{
                        break;
                    }
                }catch (Exception e){
                    System.out.println("Phải nhập vào là số");
                }
            }
        }
        System.out.println("Số bạn vừa nhập: "+number);
        if(number==5){
            throw new Exception("Không xử lý với số 5");
        }else{
            System.out.println("Không có lỗi, kết quả bình phương: "+number*number);
        }

        System.out.println("Kết thúc chương trình!");
    }
}
