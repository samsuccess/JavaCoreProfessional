package homework1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Box<T extends Fruit> {

    private List<T> box; ;

    public Box() {
        this.box = new ArrayList<>();
    }

    public Box(T... fruits) {
        this.box = new ArrayList(Arrays.asList(fruits));
    }

    public float boxWeight() {
        float weight = 0.0f;
        for(T o : box){
            weight += o.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.boxWeight() - anotherBox.boxWeight()) < 0.001;
    }

    public void pourBox(Box<? super T> anotherBox) {
        if (anotherBox == this) {
            return;
        }
        anotherBox.box.addAll(this.box);
        this.box.clear();
    }


    public void addFruit(T fruit, int amount) {
//        или так
//        public void addFruit(T fruit){
//            box.add(fruit);
//        }
        for (int i = 0; i < amount; i++) {
            box.add(fruit);
        }

    }
}

