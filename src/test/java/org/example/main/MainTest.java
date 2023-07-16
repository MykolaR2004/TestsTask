package org.example.main;

import main.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MainTest {
    Main main;
@BeforeEach
void setUp(){
main = new Main();
}
    @ParameterizedTest
    @CsvSource({"0.7, 1.0", "1.4, -0.329743", "3.0, -0.278565"})
    void testTabul( double x, double expected) {
        assertEquals(expected,main.tabulation(x),1e-6);
    }

    @Test
    void testTabulation(){
    double x = 0.7, expected = 1.0, result = main.tabulation(x);
    assertEquals(expected,result,1e-6);
    double x1 = 1.4, expected1 = -0.329743, result1 = main.tabulation(x1);
    assertEquals(expected1,result1,1e-6);
    double x2 = 3.0, expected2 = -0.278565, result2 = main.tabulation(x2);
    assertEquals(expected2,result2,1e-6);
    }

    @Test
    void testCountSteps() {
        int expected = 751;
        assertEquals(expected, main.countSteps());
    }

    @ParameterizedTest
    @CsvSource({"175, 1.0", "350, -0.329743", "750, -0.278565"})
    void testTabulationElement(int position, double expected) {
        assertEquals(expected, main.tabulationElement(position),1e-6);
    }

    @Test
    void testMaxElementIndex() {
        double expected = 7;
        double[] array = new double[] {8,6,3,8,5,5,2,9,5,4};
        assertEquals(expected, main.maxElementIndex(array));
    }
    @Test
    void testMinElementIndex() {
        double expected = 6;
        double[] array = new double[] {8,6,3,8,5,5,2,9,5,4};
        assertEquals(expected, main.minElementIndex(array));
    }

    @Test
    void testSumOfElements() {
        double expected = 39.00005;
        double[] array = new double[] {1.0, 2.0, 3.5, 4.250, 5.0, 6.125, 7.125, 10.00005};
        assertEquals(expected, main.sumOfElements(array),1e-6);
    }

    @Test
    void testAverage() {
        double expected = 3.0;
    double[] array = new double[] {3,3,3};
    assertEquals(expected, main.average(array));
    }

}