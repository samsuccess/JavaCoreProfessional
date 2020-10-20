package homework1;

import java.util.ArrayList;
import java.util.Arrays;


public class Box<T extends Fruit> {

    private ArrayList<T> box = new ArrayList<>();

    public Box() {

    }

    public float boxWeight() {
        float weight = 0.0f;
        for(T o : box){
            weight += o.getWeight();
        }
        return weight;
    }

    public boolean compare(Box anotherBox) {
        return boxWeight() == anotherBox.boxWeight();
    }

    public void pourBox(Box<T> anotherBox) {
        anotherBox.box.addAll(box);
        box.clear();
    }


    public void addFruit(T fruit, int amount) {
        for (int i = 0; i < amount; i++) {
            box.add(fruit);
        }
    }
}

