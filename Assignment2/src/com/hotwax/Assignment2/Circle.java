package com.hotwax.Assignment2;
public class Circle
{
    private double radius;
    private	double pi = 3.142;
    Circle(double radius)
    {
        this.radius = radius;
    }
    public void calculateArea()
    {
        double radiusSquare = radius*radius;
        System.out.println("Area of the Circle with radius "+this.radius+" is : "+pi*radiusSquare);
    }
    public void calculateCircumference()
    {
        System.out.println("Circumference of the Circle with radius "+this.radius+" is : "+2*pi*radius);
    }
}