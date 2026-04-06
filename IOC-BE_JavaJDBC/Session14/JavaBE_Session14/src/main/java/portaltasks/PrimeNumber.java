package portaltasks;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        int number;

        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Nhập vào 1 số nguyên dương: ");
            String strNumber = sc.nextLine();
            if(strNumber.isEmpty()){
                System.err.println("Bạn phải nhập vào dữ liệu");
            }else{
                try{
                    number = Integer.parseInt(strNumber);
                    if(number<0){
                        System.err.println("Phải nhập vào số dương");
                    }else{
                        break;
                    }
                }catch (Exception e){
                    System.err.println("Phải nhập vào là số");
                }
            }
        }
        System.out.println("Số bạn vừa nhập: "+number);
        System.out.println(isPrime(number)?"Đây là một số nguyên tố.":"Đây là một hợp số.");
    }

    static boolean isPrime(int number){
        for(int i=2;i<=Math.sqrt(number);i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }
}
