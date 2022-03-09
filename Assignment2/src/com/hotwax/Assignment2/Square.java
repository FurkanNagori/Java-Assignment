package com.hotwax.Assignment2;

public class Square {
    private final double side;

    Square(double side) {
        this.side = side;
    }

    public void calculateArea() {
        double area = side * side;
        System.out.println("Area of the Square with side " + this.side + " is : " + area);
    }

    public void calculatePerimeter() {
        System.out.println("Perimeter of the Square with side " + this.side + " is : " + 4 * side);
    }
}
