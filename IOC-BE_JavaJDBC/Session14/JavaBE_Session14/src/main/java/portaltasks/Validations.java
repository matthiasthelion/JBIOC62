package portaltasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Validations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strNumber;
        int number;
        List<Integer> valids = new ArrayList<>();
        int invalids = 0;
        while (true){
            System.out.println("Nhập vào một chuỗi ký tự: ");
            strNumber = sc.nextLine();
            if(strNumber.isEmpty()){
                System.err.println("Bạn phải nhập vào dữ liệu");
            }else if(strNumber.equals("///")){
                System.out.println("----------------- KẾT QUẢ -----------------");
                System.out.println("Số chuỗi hợp lệ: "+valids.size());
                System.out.println("Số chuỗi không hợp lệ: "+invalids);
                System.out.println("Danh sách số nguyên hợp lệ: " + valids.toString());
                System.out.println("----------------- KẾT THÚC ----------------");
                break;
            } else {
                try{
                    number = Integer.parseInt(strNumber);
                    System.out.println("Hợp lệ");
                    valids.add(number);
                }catch (Exception e){
                    System.err.println("Không hợp lệ");
                    invalids++;
                }
            }
        }
    }
}
