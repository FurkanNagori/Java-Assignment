package com.hotwax.Assignment2;
public class Rectangle {

    private double length;
    private double width;
    //    private	double pi = 3.142;
    Rectangle(double length,double width)
    {
        this.length = length;
        this.width = width;
    }
    public void calculateArea()
    {
        double area = length*width;
        System.out.println("Area of the Rectangle with length "+this.length+" and width "+this.width+" is : "+area);
    }
    public void calculatePerimeter()
    {
        System.out.println("Perimeter of the Rectangle with length "+this.length+" and width "+this.width+" is : "+2*(length+width));
    }
}
