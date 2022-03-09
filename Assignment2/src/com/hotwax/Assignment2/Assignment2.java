package com.hotwax.Assignment2;
//import com.hotwax.Assignment2.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Assignment2 {
    public static void main(String arg[]) {
        int shape = 0;
        String againOperation = "";
        do {

            shape = shapeOptions(); //calling method for all shapes option.

            Scanner sc = new Scanner(System.in);
            switch (shape) {
                case 1: // 1 means circle
                    System.out.println("circle selected ");
                    System.out.print("Enter the radius of circle: ");
                    double radius;
                    radius = sc.nextDouble();
                    Circle circle = new Circle(radius);
                    circle.calculateArea();
                    circle.calculateCircumference();
                    break;
                case 2: // 2 means rectangle
                    System.out.println("Rectangle selected ");
                    System.out.print("Enter the length of rectangle: ");
                    double length;
                    length = sc.nextDouble();
                    System.out.print("Enter the width of rectangle: ");
                    double width;
                    width = sc.nextDouble();
                    Rectangle rectangle = new Rectangle(length, width);
                    rectangle.calculateArea();
                    rectangle.calculatePerimeter();
                    break;
                case 3: // 3 means Triangle.
                    System.out.println("Triangle selected ");
                    System.out.print("Enter the base of Triangle: ");
                    double base;
                    base = sc.nextDouble();
                    System.out.print("Enter the height of Triangle: ");
                    double height;
                    height = sc.nextDouble();
                    Triangle triangle = new Triangle(base, height);
                    triangle.calculateArea();
                    break;
                case 4: // 4 means Square
                    System.out.println("Square selected ");
                    System.out.print("Enter the side of Square: ");
                    double side;
                    side = sc.nextDouble();
                    Square square = new Square(side);
                    square.calculateArea();
                    square.calculatePerimeter();
                    break;

                case 5: // 5 means Sphere
                    System.out.println("Sphere selected ");
                    System.out.print("Enter the radius of Sphere: ");
                    radius = sc.nextDouble();
                    Sphere sphere = new Sphere(radius);
                    sphere.calculateVolume();
                    sphere.calculateCircumference();
                    sphere.calculateSurfaceArea();
                    break;


                case 6: // 6 means Cylinder
                    System.out.println("Cylinder selected ");
                    System.out.print("Enter the radius of Cylinder: ");
                    radius = sc.nextDouble();
                    System.out.print("Enter the height of Cylinder: ");
                    height = sc.nextDouble();
                    Cylinder cylinder = new Cylinder(radius,height);
                    cylinder.calculateVolume();
                    cylinder.calculateSurfaceArea();
                    //calculated shape now if user want to continue.
                    break;

            }
            System.out.print("Do you want to continue (type yes/no) : ");
            sc.nextLine();
            againOperation = sc.nextLine();
        } while (againOperation.equalsIgnoreCase("yes"));

    }

    public static int shapeOptions() throws NumberFormatException {
        int shape = 0;

        try {
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Triangle");
            System.out.println("4. Square");
            System.out.println("5. Sphere");
            System.out.println("6. Cylinder");
            System.out.print("Enter the shape : ");
            Scanner sc = new Scanner(System.in);
            shape = sc.nextInt();
        } catch (InputMismatchException imme) {
            System.out.print("only numbers allowed");
        }
        return shape;
    }
}

