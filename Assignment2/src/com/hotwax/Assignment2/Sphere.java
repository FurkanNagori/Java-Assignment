package com.hotwax.Assignment2;

public class Sphere {
    private double radius;
    private double pi = 3.142;

    Sphere(double radius) {
        this.radius = radius;
    }

    public void calculateVolume() {
        double volume = (4.0 / 3.0) * pi * (radius * radius * radius);
        ;
        System.out.println("Volume of the Sphere with radius " + this.radius + " is : " + volume);
    }

    public void calculateCircumference() {
        System.out.println("Circumference of the Sphere with radius " + this.radius + " is : " + 2 * pi * radius);
    }

    public void calculateSurfaceArea() {
        System.out.println("Surface area of the Sphere with radius " + this.radius + " is : " + 4 * pi * radius * radius);
    }
}
