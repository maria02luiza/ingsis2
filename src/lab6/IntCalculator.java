package lab6;

//ex 1
import java.awt.geom.Area;

public class IntCalculator {
    private int state;

    public IntCalculator(int initialState) {
        this.state = initialState;
    }

    public IntCalculator add(int value) {
        this.state += value;
        return this;
    }

    public IntCalculator subtract(int value) {
        this.state -= value;
        return this;
    }

    public IntCalculator multiply(int value) {
        this.state *= value;
        return this;
    }

    public int result() {
        return state;
    }

    public IntCalculator clear() {
        this.state = 0;
        return this;
    }

    public static void main(String[] args) {
        IntCalculator calculator = new IntCalculator(10);
        int result = calculator.add(5).subtract(3).multiply(2).result();
        System.out.println("a) " + result);
    }
}