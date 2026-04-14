package org.example;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.


        /// Dữ liệu test
        Student s1 = new Student(277154025, "Trương Thanh Hà", LocalDate.of(2011, 6, 12));
        System.out.println("Xin chào " + s1.getNameLastTwoWords() + " (MSSV " + s1.getFormattedStuID() +")");
        Student partner = new Student(68221067, "Đinh Vũ Hải", LocalDate.of(2009, 7, 5));
        System.out.println(partner.getNameLastTwoWords() + " (" + partner.getFormattedStuID() +") là bạn đồng hành của bạn");
    }
}