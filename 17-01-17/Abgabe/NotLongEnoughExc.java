//package pgdp;

/**
 * Created by fga on 16/01/2017.
 */
public class NotLongEnoughExc extends Exception {

    private final int should;

    private final int is;

    NotLongEnoughExc(int should, int is) {
        super();
        this.should = should;
        this.is = is;
    }

    @Override
    public String toString() {
        return "Die Mindestlänge von " + should + " wurde mit der Länge " + is + " unterschritten.";
    }
}
