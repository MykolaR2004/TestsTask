package main;



public class Main {
    double a = -0.5, b = 2.0, start = 0.0, finish = 3.0, step = 0.004;
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        double[] array = arrayOfY();
        int max = maxElementIndex(array);
        int min = minElementIndex(array);
        printMinMaxElement(max,min,array);
    }

    public double tabulation(double x){
        if (x>1.4+1e-9) {
            double c;
            c = a*x;
            return (Math.exp(c)*Math.cos(b)*x);}
        if (x>0.7+1e-9) {
            return (a*x*x*Math.log(x));}
        else  {return 1.0;
        }
}

public int countSteps() {
        return (int) Math.round(((finish-start)/step)+1);
}

    public double[] arrayOfX() {
        int size = countSteps();
        double[] array = new double[size];
        for (int i = 1; i < array.length; i++) {
            array[i] = i * step;
        }
        return array;
    }
    public double[] arrayOfY() {
        double[] arrayX = arrayOfX();
        double[] arrayY = new double[arrayX.length];
        for (int i = 0; i < arrayX.length; i++) {
            arrayY[i] = tabulation(arrayX[i]);
        }
        return arrayY;
    }
    public double tabulationElement(int index) {
        double[] array = arrayOfY();
        return array[index];
    }
    public int maxElementIndex(double[] arrayY) {
        double max = arrayY[0];
        int maxIndex = 0;
        for(int i = 1; i < arrayY.length; ++i) {
            if(arrayY[i] > max) {
                max = arrayY[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    public int minElementIndex(double[] array) {
        double min = array[0];
        int minIndex = 0;
        for(int i = 1; i < array.length; ++i) {
            if(array[i] < min) {
                min = array[i];
                minIndex=i;
            }
        }
        return minIndex;
    }
    public double sumOfElements(double[] arrayY) {
        double sum = 0;
        for (int i = 0; i < arrayY.length; i++) {
            sum += arrayY[i];
        }
        return sum;
    }

    public double average(double[] array){
        return sumOfElements(array)/ array.length;
    }

    public void printMinMaxElement(int max, int min, double[] array){
        System.out.println("Максимальний елемент: "+array[max] + " з індексом: "+ max);
        System.out.println("Мінімальний елемент: " + String.format("%.2f",array[min]) + " з індексом: "+ min);
        System.out.println("Сума елементів масиву значень функції: " + String.format("%.2f",sumOfElements(array)));
    }
}


