//package pgdp;

/**
 * Created by fga on 17/01/2017.
 */
public class NotEnoughExc extends Exception {

    protected final int should;

    protected final int is;

    NotEnoughExc(int should, int is) {
        super();
        this.should = should;
        this.is = is;
    }

}
