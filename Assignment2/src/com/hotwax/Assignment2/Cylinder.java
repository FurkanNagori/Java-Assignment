package com.hotwax.Assignment2;

public class Cylinder {
    private double radius;
    private double height;
    private double pi = 3.142;

    Cylinder(double radius,double height) {
        this.radius = radius;
        this.height=height;
    }

    public void calculateVolume() {
        double volume =  pi * radius * radius * height;
        ;
        System.out.println("Volume of the Sphere with radius " + this.radius + " and height "+this.height+" is : " + volume);
    }

    public void calculateSurfaceArea() {
        System.out.println("Surface area of the Cylinder with radius " + this.radius + " and height "+this.height+" is : " +2*pi*radius*(radius+height));
    }
}
