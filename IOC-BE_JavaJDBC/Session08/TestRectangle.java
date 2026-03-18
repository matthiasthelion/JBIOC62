//package IOC-BE_JavaJDBC.Session08;

import java.util.Scanner;

public class TestRectangle {
    static Rectangle getLargerArea(Rectangle r1, Rectangle r2) {
        if (r1.getArea() > r2.getArea()) {
            return r1;
        } else {
            return r2;
        }
    }


    public static void main(String[] args) {
        // Test the rectangle class
        Scanner sc = new Scanner(System.in);
        double[] a = new double[6];
        for (int i = 0; i < a.length; i++) {
            //System.out.print("Enter length and width of rectangle " + (i + 1) + ": ");
            a[i] = sc.nextDouble();
        }
        Rectangle r1 = new Rectangle(a[0], a[1]);
        Rectangle r2 = new Rectangle(a[2], a[3]);
        Rectangle r3 = new Rectangle(a[4], a[5]);
        System.out.println("r1: \t" + r1);
        System.out.println("r2: \t" + r2);
        System.out.println("r3: \t" + r3);
        Rectangle maxArea = getLargerArea(r1, getLargerArea(r2, r3));
        int maxIndex = 0;
        if (maxArea == r1) {
            maxIndex = 1;
        } else if (maxArea == r2) {
            maxIndex = 2;
        } else {
            maxIndex = 3;
        }
        System.out.println("The rectangle with the largest area is r" + maxIndex + "\n\twith " + maxArea.toStringWH());
        sc.close();
    }
}

class Rectangle {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getArea() {
        return height * width;
    }

    public double getPerimeter() {
        return 2 * (height + width);
    }

    public double getDiagonal() {
        return Math.sqrt(height * height + width * width);
    }
    
    public String toString() {
        return "W = " + width + "\tH = " + height + "\tAREA = " + getArea() + "\tPRMT = " + getPerimeter();
    }

    public String toStringWH() {
        return "W = " + width + "\tH = " + height;
    }
}

/* TEST DATA
3 4 5 2 4.5 3.5
--------------------------
OUTPUT
r1: 	W = 4.0	H = 3.0	AREA = 12.0	PRMT = 14.0
r2: 	W = 2.0	H = 5.0	AREA = 10.0	PRMT = 14.0
r3: 	W = 3.5	H = 4.5	AREA = 15.75	PRMT = 16.0
--------------------------
 */