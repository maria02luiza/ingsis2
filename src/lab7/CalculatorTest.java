package lab7;

import lab6.ACalculator;
import lab6.NewIntCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    public ACalculator calc;
    public  ACalculator calc2;
    @BeforeEach
    public void setUp()  {
        calc= new ACalculator() {
            @Override
            public Object init() {
                return null;
            }
        };
        calc2= new ACalculator() {
            @Override
            public Object init() {
                return null;
            }
        };
    }
    @Test
    public void testAddPositive() {
        // Arrange
        NewIntCalculator calc = new NewIntCalculator(5);
        // Act
        calc.add(3);
        // Assert
        Assertions.assertEquals(8, calc.result());
    }
    @Test
    public void testAddNegative() {
        // Arrange
        NewIntCalculator calc2 = new NewIntCalculator(-5);
        // Act
        calc2.add(-2);
        // Assert
        Assertions.assertEquals(-7, calc2.result());
    }
    @Test
    public void testSubtract() {
        NewIntCalculator calc = new NewIntCalculator(10);
        calc.subtract(4);
        Assertions.assertEquals(6, calc.result());
    }
    @Test
    public void testSubtractNegative() {
        NewIntCalculator calc2 = new NewIntCalculator(-10);
        calc2.subtract(-4);
        Assertions.assertEquals(-14, calc2.result());
    }


    @Test
    public void testMultiply() {
        NewIntCalculator calc = new NewIntCalculator(3);
        calc.multiply(7);
        Assertions.assertEquals(21, calc.result());
    }

    @Test
    public void testMultiplyNegative() {
        NewIntCalculator calc2 = new NewIntCalculator(-3);
        calc2.multiply(-7);
        Assertions.assertEquals(21, calc2.result());
    }

    @Test
    public void testDivide() {
        NewIntCalculator calc = new NewIntCalculator(20);
        calc.divide(4);
        Assertions.assertEquals(5, calc.result());
    }

    @Test
    public void testInit() {
        NewIntCalculator calc = new NewIntCalculator(100);
        calc.init();
        Assertions.assertEquals(0, calc.result());
    }

    @Test
    public void testDivideByZero() {
        NewIntCalculator calc = new NewIntCalculator(10);
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calc.divide(0);
        });
    }
    @AfterEach //metoda este executata la sfarsitul fiecarui test
    public void tearDown() {
        calc = null;
    }







}
