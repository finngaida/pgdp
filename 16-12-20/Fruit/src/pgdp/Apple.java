package pgdp;

/**
 * Created by fga on 19/12/2016.
 */
public class Apple extends Fruit {

    @Override
    public boolean isApple() {
        return true;
    }

    @Override
    public int shelfLife() {
        return 30;
    }
}
