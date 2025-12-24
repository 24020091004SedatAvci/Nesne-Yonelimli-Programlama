package Test;
import tr.edu.istiklal.Triangle;

public class Test {
    public static void main(String[] args) {

        try {
            Triangle t = new Triangle(2, 3, 10); // hata
        } catch (IllegalTriangleException e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }
}

