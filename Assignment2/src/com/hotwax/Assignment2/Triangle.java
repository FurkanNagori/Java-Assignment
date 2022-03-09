package com.hotwax.Assignment2;

public class Triangle {
    private double base;
    private	double height;
    Triangle(double base,double height)
    {
        this.base = base;
        this.height=height;
    }
    public void calculateArea()
    {
        double area = ( base*height) / 2 ;
        System.out.println("Area of the Triangle with base "+this.base+" and height "+this.height+" is : "+area);
    }
}
