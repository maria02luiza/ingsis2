package lab6;

public class NewIntCalculator extends ACalculator{
    public NewIntCalculator(int a) {
        state = a;
    }
    public NewIntCalculator add(int a) {
        state = (int) state + a;
        return this;
    }
    public NewIntCalculator subtract(int a) {
        state = (int) state - a;
        return this;
    }
    public NewIntCalculator multiply(int a) {
        state = (int) state * a;
        return this;
    }
    public NewIntCalculator divide(int a) {
        state = (int) state / a;
        return this;
    }

    @Override
    public NewIntCalculator init() {
        state=0;
        return this;
    }

}