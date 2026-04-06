package org.example;

public class Circle extends Shape implements Drawable{
    public int radius;

    public Circle(int r) {
        super.name = "Circle";
        radius = r;
    }
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}
