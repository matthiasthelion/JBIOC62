package org.example;

public abstract class Shape {
    public String name;


    public abstract double getArea();
    public abstract double getPerimeter();
    public void displayInfo() {
        System.out.println(name);
    }
}
