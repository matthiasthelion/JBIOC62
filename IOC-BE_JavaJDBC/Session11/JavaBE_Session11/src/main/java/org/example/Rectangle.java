package org.example;

public class Rectangle extends Shape implements Drawable{

    public int width;
    public int height;

    public Rectangle(int w, int h) {
        super.name = "Rectangle";
        width = w;
        height = h;
    }
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
    @Override
    public double getArea() {
        return width * height;
    }
    @Override
    public double getPerimeter() {
        return (width + height)*2;
    }
}
