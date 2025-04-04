package lab6;

public abstract class ACalculator {
    public Object state;
    public Object result() {
        return state;
    }
    public Object clear(){
        state = 0;
        return this;
    }
    public abstract Object init();



    public static void main(String[] args) {
        NewIntCalculator calculator = new NewIntCalculator(10);
        calculator.init();
        int result = (Integer)calculator.add(5).subtract(3).multiply(2).result();
        System.out.println("5.4.2 a) " + result);
        DoubleCalculator fCalculator = new DoubleCalculator(10);
        fCalculator.init();
        double result2 =
                (Double)fCalculator.add(5).subtract(3.3).multiply(2.2).result();
        System.out.println("5.4.2 b) "+result2);
}

}

