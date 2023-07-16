package org.example.main;

import main.Main;
import org.assertj.core.data.Percentage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import static org.assertj.core.api.Assertions.assertThat;


public class MainTestNG {
    private final static double EPS = 1e-6;

    Main main;
    @BeforeMethod
    void setUp(){
        main = new Main();
    }



    @Test
 //   @CsvSource({"0.7, 1.0", "1.4, -0.329743", "3.0, -0.278565"})
    void testTabulation() {
        double x = 0.7;
        double expected = 1.0;
        double actual = main.tabulation(x);

        assertThat(actual)
                .as("error conversion")
                .isCloseTo(expected, Percentage.withPercentage(0.001));

        double x1 = 1.4;
        double expected1 = -0.329743;
        double actual1 = main.tabulation(x1);

        assertThat(actual1)
                .as("error conversion")
                .isCloseTo(expected1, Percentage.withPercentage(0.001));

    }

    @DataProvider(name = "testF")
    public Object[][] createData() {
        return new Object[][] {
                {0.7, 1.0},
                {1.4, -0.329743},
                {3.0, -0.278565}
        };
    }
    @Test(dataProvider = "testF")
    public void testF(double x, double expected) {
        assertThat(main.tabulation(x)).isCloseTo(expected, Percentage.withPercentage(0.001));
    }


    @Test
    public void testCountSteps() {
        int expected = 751;
        int actual = main.countSteps();
        assertThat(actual)
                .as("error conversion")
                .isCloseTo(expected, Percentage.withPercentage(0.001));
    }


    @Test
    public void testTabulationElement() {
        int x = 175;
        double expected = 1.0;
        double actual = main.tabulationElement(x);

        assertThat(actual)
                .as("error conversion")
                .isCloseTo(expected, Percentage.withPercentage(0.001));

        int x1 = 350;
        double expected1 = -0.329743;
        double actual1 = main.tabulationElement(x1);

        assertThat(actual1)
                .as("error conversion")
                .isCloseTo(expected1, Percentage.withPercentage(0.001));

        int x2 = 750;
        double expected2 = -0.278565;
        double actual2 = main.tabulationElement(x2);

        assertThat(actual2)
                .as("error conversion")
                .isCloseTo(expected2, Percentage.withPercentage(0.001));
    }

    @Test
    public void testMaxElementIndex() {
        double[] array = new double[] {8,6,3,8,5,5,2,9,5,4};
        double expected = 7;
        double actual = main.maxElementIndex(array);

        assertThat(actual)
                .as("error conversion")
                .isEqualTo(expected);
    }

    @Test
    public void testMinElementIndex() {
        double[] array = new double[] {8,6,3,8,5,5,2,9,5,4};
        double expected = 6;
        double actual = main.minElementIndex(array);

        assertThat(actual)
                .as("error conversion")
                .isEqualTo(expected);
    }

    @Test
    public void testSumOfElements() {
        double[] array = new double[] {1.0, 2.0, 3.5, 4.250, 5.0, 6.125, 7.125, 10.00005};
        double expected = 39.00005;
        double actual = main.sumOfElements(array);

        assertThat(actual)
                .as("error conversion")
                .isCloseTo(expected,Percentage.withPercentage(EPS));
    }

    @Test
    public void testAverage() {
        double[] array = new double[] {3,3,3};
        double expected = 3.0;
        double actual = main.average(array);

        assertThat(actual)
                .as("error conversion")
                .isEqualTo(expected);
    }
}