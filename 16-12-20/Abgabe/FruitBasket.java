
import java.util.LinkedList;

/**
 * Created by fga on 19/12/2016.
 */
public class FruitBasket {

    public LinkedList<Fruit> fruits;

    public FruitBasket() {
        this.fruits = new LinkedList<Fruit>();
    }

    public void addFruit(Fruit f) {
        fruits.add(f);
    }

    public LinkedList<Apple> getApples() {
        LinkedList<Apple> ret = new LinkedList<Apple>();

        for (Fruit f: fruits) {
            if (f instanceof Apple || f instanceof GrannySmith || f instanceof PinkLady) {
                ret.add((Apple)f);
            }
        }

        return ret;
    }

    public LinkedList<Fruit> getEqualOrLongerShelfLife(int n) {
        LinkedList<Fruit> ret = new LinkedList<Fruit>();

        for (Fruit f: fruits) {
            if (f.shelfLife() >= n) {
                ret.add(f);
            }
        }

        return ret;
    }

    public String toString() {
        String out = "{";

        for (Fruit f: fruits) {

            if (!out.equals("{")) { out += ", "; }

            if (f instanceof GrannySmith) {
                out += "GS"; //"\uD83C\uDF4F";
            } else if (f instanceof PinkLady) {
                out += "PL"; //"\uD83C\uDF4E";
            } else if (f instanceof Pineapple) {
                out += "PA"; //"\uD83C\uDF4D";
            } else if (f instanceof Banana) {
                out += "BA"; //"\uD83C\uDF4C";
            } else if (f instanceof Apple) {
                out += "AP";
            } else {
                out += f.getClass().toString();
            }

        }

        return out + "}";
    }
}
