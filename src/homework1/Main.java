package homework1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {


    public static void changeVal(Object[] arr, int i, int j) {
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        System.out.println("Результат замены: " + Arrays.toString(arr));
    }

    public static <T> void asList(T[] arr) {
        ArrayList<T> arrayList = new ArrayList<>(Arrays.asList(arr));
        System.out.println("Результат преобразования: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {

        Integer[] arrInt = {1, 2, 3, 4, 5, 6};

        changeVal(arrInt, 1, 5);

        asList(arrInt);

        Box<Orange> orangeBox = new Box<>();
        Box<Orange> orangeBox1 = new Box<>();
        Box<Apple> appleBox = new Box<>();
        Box<Apple> appleBox1 = new Box<>();
        orangeBox.addFruit(new Orange(), 10);
        orangeBox1.addFruit(new Orange(), 20);
        appleBox.addFruit(new Apple(), 15);
        appleBox1.addFruit(new Apple(), 30);
        System.out.println("\nBox 1: " + orangeBox.boxWeight());
        System.out.println("Box 2: " + orangeBox1.boxWeight());
        System.out.println("Box 3: " + appleBox.boxWeight());
        System.out.println("Box 4: " + appleBox1.boxWeight());
        System.out.println("Box 1 equals box 3: " + orangeBox.compare(appleBox));
        System.out.println("Box 2 equals box 4: " + orangeBox1.compare(appleBox1));
        orangeBox.pourBox(orangeBox1);
        appleBox.pourBox(appleBox1);
        System.out.println("Box 1 pour Box 2: " + orangeBox.boxWeight());
        System.out.println("Box 2: " + orangeBox1.boxWeight());
        System.out.println("Box 3 pour Box 4: " + appleBox.boxWeight());
        System.out.println("Box 4: " + appleBox1.boxWeight());


    }
}
