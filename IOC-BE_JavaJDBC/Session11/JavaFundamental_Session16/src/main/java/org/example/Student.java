package org.example;

import java.time.LocalDate;

public class Student {
    private int stuID;
    private String stuName;
    private LocalDate stuDOB;

    private String classNumber;

    public Student(int stuID, String stuName, LocalDate stuDOB) {
        this.stuID = stuID;
        this.stuName = stuName;
        this.stuDOB = stuDOB;
    }

    public Student(int stuID, String stuName, LocalDate stuDOB, String classNumber) {
        this.stuID = stuID;
        this.stuName = stuName;
        this.stuDOB = stuDOB;
        this.classNumber = classNumber;
    }

    public int getStuID() {
        return stuID;
    }

    public String getFormattedStuID(){
        return String.format("%09d", stuID).replaceAll("(\\d{3})(\\d{2})(\\d{4})", "$1-$2-$3");
    }

    public void setStuID(int stuID) {
        this.stuID = stuID;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public LocalDate getStuDOB() {
        return stuDOB;
    }

    public void setStuDOB(LocalDate stuDOB) {
        this.stuDOB = stuDOB;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public String getNameLastWord(){
        return stuName.trim().substring(stuName.lastIndexOf(" ") + 1);
    }

    public String getNameLastTwoWords(){
        return stuName.trim().substring(stuName.lastIndexOf(" ", stuName.lastIndexOf(" ")-1)).trim();
    }
}
