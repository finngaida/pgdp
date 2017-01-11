package pgdp;

/**
 * Die Klasse Move repraesentiert einen einzelnen Zug.
 *
 * Es gibt zwei Konstruktoren. Einer bekommt
 * Ausgangsfeld und Zielfeld uebergeben, der andere
 * bekommt nur den eingegebenen Zug in der Form
 * <Ausgangsfeld><Zielfeld> als String uebergeben,
 * also z. B. "a7c5" fuer den Zug von "a7" nach "c5".
 */
public class Move {

    private String from;
    private String to;

    public Move(String from, String to){
        this(from+to);
    }

    public Move(String move){

        if (move.length() != 4) {
            throw new RuntimeException("Move has to be 4 characters long");
        }

        this.from = "" + move.charAt(0) + move.charAt(1);
        this.from = "" + move.charAt(2) + move.charAt(3);
    }

    @Override
    public String toString(){
        // Rueckgabe exakt in der Form <Ausgangsfeld><Zielfeld> als String,
        // also z. B. "b2b3" fuer den Zug eines Tiers von "b2" nach "b3".
        return from+to;
    }

    public boolean equals(Object other) {

        if (other instanceof Move) {
            Move cast = (Move)other;
            return (cast.from.equals(this.from) && cast.to.equals(this.to));
        } else {
            return false;
        }
    }

}
