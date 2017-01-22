//package pgdp;

/**
 * Created by fga on 17/01/2017.
 */
public class NotEnoughLower extends NotEnoughLetter {

    NotEnoughLower(int should, int is) {
        super(should, is);
    }

    @Override
    public String toString() {
        return "Die Mindestanzahl an Kleinbuchstaben von " + should + " wurde mit dem Wert " + is + " unterschritten.";
    }

}
