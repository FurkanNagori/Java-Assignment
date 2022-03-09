package com.hotwax.Assignment2;
//import com.hotwax.Assignment2.*;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Assignment2 {
    public static void main(String arg[]) {
        int shape=0;
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
                    //calculated shape now if user want to continue.
                    System.out.print("Do you want to continue (type yes/no) : ");
                    againOperation = sc.next();

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
                    //calculated shape now if user want to continue.
                    System.out.print("Do you want to continue (type yes/no) : ");
                    againOperation = sc.next();

                case 3: // 3 means Triangle.
                    System.out.println("Triangle selected ");
                    System.out.print("Enter the base of Triangle: ");
                    double base;
                    base = sc.nextDouble();
                    System.out.print("Enter the height of Triangle: ");
                    double height;
                    height = sc.nextDouble();
                    Triangle triangle = new Triangle(base,height);
                    triangle.calculateArea();
                    //calculated shape now if user want to continue.
                    System.out.print("Do you want to continue (type yes/no) : ");
                    againOperation = sc.next();

                    //default: return;
            }

        } while (againOperation.equalsIgnoreCase("yes"));

    }

    public static int shapeOptions() throws NumberFormatException
        {
            int shape=0;

          try
        {
                System.out.println("1. Circle");
                System.out.println("2. Rectangle");
                System.out.println("3. Triangle");
                System.out.println("4. Square");
                System.out.println("5. Sphere");
                System.out.println("6. Cylinder");
                System.out.print("Enter the shape : ");
                Scanner sc = new Scanner(System.in);
                shape = sc.nextInt();
        }catch (InputMismatchException imme)
        {
            System.out.print("only numbers allowed");
        }
            return shape;
        }
    }

