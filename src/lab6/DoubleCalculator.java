package lab6;

public class DoubleCalculator extends ACalculator{

    public DoubleCalculator(double a) {
        state = a;
    }
    public DoubleCalculator add(double a){
        state = (double) state + a;
        return this;
    }
    public DoubleCalculator subtract(double a){
        state = (double) state - a;
        return this;
    }
    public DoubleCalculator multiply(double a){
        state = (double) state * a;
        return this;
    }
    public DoubleCalculator divide(double a){
        state = (double) state / a;
        return this;
    }

    @Override
    public DoubleCalculator init() {
        state=0.0;
        return this;}
}
