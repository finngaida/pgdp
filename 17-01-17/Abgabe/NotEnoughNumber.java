//package pgdp;

/**
 * Created by fga on 17/01/2017.
 */
public class NotEnoughNumber extends NotEnoughExc {

    NotEnoughNumber(int should, int is) {
        super(should, is);
    }

    @Override
    public String toString() {
        return "Die Mindestanzahl an Zahlen von " + should + " wurde mit dem Wert " + is + " unterschritten.";
    }

}
