package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shape[] s = new Shape[100];
        int n;
        System.out.println( "Enter number of shapes: " );
        do{
            try{
                n = Integer.parseInt(sc.nextLine());
            } catch(Exception e){
                System.out.println("Invalid input");
                n = -1;
            }
        } while(n<0);

    }
}