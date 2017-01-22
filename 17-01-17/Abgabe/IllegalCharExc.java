//package pgdp;

/**
 * Created by fga on 17/01/2017.
 */
public class IllegalCharExc extends Exception {

    private final char used;

    IllegalCharExc(char used) {
        super();
        this.used = used;
    }

    @Override
    public String toString() {
        return "Das Zeichen \"" + used + "\" darf nicht verwendet werden. Selbiges gilt für Zeilenumbrüche (\\n), Tabstops (\\t), Wagenrückläufe (\\r), Backslashes (\\b) und Blattvorschübe (\\f)";
    }
}
