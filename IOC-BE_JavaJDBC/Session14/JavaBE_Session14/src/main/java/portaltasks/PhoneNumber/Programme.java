package portaltasks.PhoneNumber;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Scanner;

public class Programme {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập danh sách số điện thoại (ngăn cách bằng dấu phẩy):");
        String list = sc.nextLine();

    }
    public static void validatePhoneNumber(String phoneNumber) throws InvalidPhoneNumberLengthException {
        //List<Integer> validLength = List.of(10, 11);
        if(phoneNumber.length()!=10) {
            throw new InvalidPhoneNumberLengthException("Sai độ dài số điện thoại");
        }
        if (!phoneNumber.startsWith("0")){
            throw new InvalidPhoneNumberLengthException("Chữ số đầu phải là 0");
        }
        if (phoneNumber.matches("^[0-9]+$")){
            throw new InvalidPhoneNumberLengthException("Chứa ký tự không hợp lệ");
        }
    }
}
