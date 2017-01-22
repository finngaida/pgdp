//package pgdp;

/**
 * Created by fga on 17/01/2017.
 */
public class NotEnoughUpper extends NotEnoughLetter {

    NotEnoughUpper(int should, int is) {
        super(should, is);
    }

    @Override
    public String toString() {
        return "Die Mindestanzahl an Großbuchstaben von " + should + " wurde mit dem Wert " + is + " unterschritten.";
    }
}
