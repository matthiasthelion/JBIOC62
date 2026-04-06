import java.util.Scanner;

public class XacThucDL_So {
    public static void main(String[] args) {
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
    }
}
