package com.hotwax;
import java.util.*;
public class Assignment2 {
    public static void main(String arg[])
    {
        int shape;
        String againOperation="";
            do {
                shape = shapeOptions(); //calling method for all shapes option.
                Scanner sc = new Scanner(System.in);
                switch(shape)
                {
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
                    default: return;

                }

            }while(againOperation.equalsIgnoreCase("yes"));
            }

        public static int shapeOptions()
        {
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Triangle");
            System.out.println("4. Square");
            System.out.println("5. Sphere");
            System.out.println("6. Cylinder");
            System.out.print("Enter the shape : ");
            Scanner sc = new Scanner(System.in);
            int shape = sc.nextInt();
            return shape;
        }
    }

