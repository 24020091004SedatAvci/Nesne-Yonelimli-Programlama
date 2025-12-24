package tr.edu.istiklal;

import Test.IllegalTriangleException;


public class Triangle {

    private double side1;
    private double side2;
    private double side3;

    /** Construct a triangle with the specified sides */
    public Triangle(double side1, double side2, double side3)
            throws IllegalTriangleException {

        if (side1 + side2 <= side3 ||
            side1 + side3 <= side2 ||
            side2 + side3 <= side1) {

            throw new IllegalTriangleException(
                    "Gecersiz ucgen: iki kenarin toplami ucunden buyuk olmalidir"
            );
        }

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
}

