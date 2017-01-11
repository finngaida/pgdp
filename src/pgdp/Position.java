package pgdp;

/**
 * Die Klasse Position repraesentiert eine Spielsituation.
 *
 */
public class Position {

    /**
     * Die Tiere werden intern in einem Array gespeichert.
     * nrAnimals gibt an, wie viele Tiere auf dem Brett sind.
     * Diese sind in myAnimals an den Positionen 0 bis nrAnimals-1 enthalten.
     *
     * Es ist empfohlen, aber nicht vorgeschrieben, diese Attribute zu verwenden.
     *
     * Falls die beiden Attribute NICHT verwendet werden, muss die Ausgabe
     * der Spielposition unten entsprechend auf die verwendete Datenstruktur
     * angepasst werden. Die toString-Methode darf dabei nicht veraendert werden,
     * muss jedoch die selbe Rueckgabe liefern. D.h. es ist dann notwendig,
     * die Hilfsmethode boardRepresentation auf die verwendete Datenstruktur anzupassen.
     */
    private Animal[] myAnimals;
    private int nrAnimals;

    /**
     * Spieler, der als naechstes ziehen darf ('M' oder 'W').
     * Wird jedes Mal aktualisiert, wenn eine Seite ihre Zuege ausfuehrt.
     */
    private char next = 'W';


    /**
     * Stellt die Anfangsposition des Spiels her.
     * Der Parameter gibt an, welche Seite beginnt ('M' oder 'W').
     */
    public void reset(char movesNext) {

        Snake a8 = new Snake(false);
        a8.square = "a8";

        Elephant b8 = new Elephant(false);
        b8.square = "b8";

        Horse c8 = new Horse(false);
        c8.square = "c8";

        Leopard d8 = new Leopard(false);
        d8.square = "d8";

        Leopard e8 = new Leopard(false);
        e8.square = "e8";

        Horse f8 = new Horse(false);
        f8.square = "f8";

        Elephant g8 = new Elephant(false);
        g8.square = "g8";

        Snake h8 = new Snake(false);
        h8.square = "h8";


        Penguin a7 = new Penguin(false);
        a7.square = "a7";

        Rabbit b7 = new Rabbit(false);
        b7.square = "b7";

        Rabbit c7 = new Rabbit(false);
        c7.square = "c7";

        Rabbit d7 = new Rabbit(false);
        d7.square = "d7";

        Rabbit e7 = new Rabbit(false);
        e7.square = "e7";

        Rabbit f7 = new Rabbit(false);
        f7.square = "f7";

        Rabbit g7 = new Rabbit(false);
        g7.square = "g7";

        Penguin h7 = new Penguin(false);
        h7.square = "h7";



        Penguin a2 = new Penguin(true);
        a2.square = "a2";

        Rabbit b2 = new Rabbit(true);
        b2.square = "b2";

        Rabbit c2 = new Rabbit(true);
        c2.square = "c2";

        Rabbit d2 = new Rabbit(true);
        d2.square = "d2";

        Rabbit e2 = new Rabbit(true);
        e2.square = "e2";

        Rabbit f2 = new Rabbit(true);
        f2.square = "f2";

        Rabbit g2 = new Rabbit(true);
        g2.square = "g2";

        Penguin h2 = new Penguin(true);
        h2.square = "h2";


        Snake a1 = new Snake(true);
        a1.square = "a1";

        Elephant b1 = new Elephant(true);
        b1.square = "b1";

        Horse c1 = new Horse(true);
        c1.square = "c1";

        Leopard d1 = new Leopard(true);
        d1.square = "d1";

        Leopard e1 = new Leopard(true);
        e1.square = "e1";

        Horse f1 = new Horse(true);
        f1.square = "f1";

        Elephant g1 = new Elephant(true);
        g1.square = "g1";

        Snake h1 = new Snake(true);
        h1.square = "h1";

        myAnimals = new Animal[]{   a8, b8, c8, d8, e8, f8, g8, h8,
                                    a7, b7, c7, d7, e7, f7, g7, h7,

                                    a2, b2, c2, d2, e2, f2, g2, h2,
                                    a1, b1, c1, d1, e1, f1, g1, h1};
        nrAnimals = myAnimals.length;

        for (int i = 0; i < nrAnimals; i++) {
            myAnimals[i].position = this;
            myAnimals[i].alive = true;
        }
    }


    /**
     * Fuehrt die uebergebenen Zuege fuer einen der Spieler aus.
     * Die Reihenfolge soll keinen Unterschied machen.
     * Diese Methode geht davon aus, dass dies bereits ueberprueft wurde.
     *
     * Der Zustand des Spiels wird entsprechend angepasst, d. h. ein Spiel
     * kann von der Anfangsposition aus allein mittels Aufrufen dieser Methode
     * gespielt werden. Insbesondere wechselt durch den Aufruf das Zugrecht,
     * da M und W abwechselnd ziehen.
     *
     * @param move Array mit den Zuegen, die ausgefuehrt werden sollen.
     *
     */
    public void applyMoves(Move[] move){
        //TODO
    }


    /**
     * Ermittelt, ob/wer gewonnen hat.
     *
     * @return 'W' falls W gewonnen hat,
     *         'M' falls M gewonnen hat,
     *         'N' falls das Spiel unentschieden zu Ende ist,
     *         'X' falls das Spiel noch nicht zu Ende ist.
     *
     */
    public char theWinner() {
        //TODO
        return Character.MIN_VALUE;
    }





    // Ausgabe der Spielposition

    private static final int[] I = {8,7,6,5,4,3,2,1};
    private static final String[] J = {"a","b","c","d","e","f","g","h"};
    private static int toIndex(String s){return (s.charAt(0)-'a');}

    // Erzeugt eine 2D-Repraesentation der Spielposition.
    // Darf ggf. auf neue Datenstruktur angepasst werden (s.o.)
    // Die Rueckgabe ist ein zweidimensionales Array, welches
    // jedem Feld das darauf befindliche Tier (oder null) zuordnet.
    // Dabei laeuft der erste Index von der 'a'-Linie zur 'h'-Linie,
    // der zweite von der 1. zur 8. Reihe. D.h. wenn z.B. bei a[3][7]
    // ein Tier ist, ist das zugehörige Feld "d8" (vierter Buchstabe,
    // achte Zahl).
    public Animal[][] boardRepresentation(){
        Animal[][] a = new Animal[8][8];
        for (int i : I) {
            for (String j : J) {
                for (int k = 0; k < myAnimals.length; k++) {
                    if (null == myAnimals[k]) {break;}
                    if (myAnimals[k].square.equals(j+i)) {
                        a[toIndex(j)][i-1] = myAnimals[k];
                    }
                }
            }
        }
        return a;
    }


    @Override
    public String toString(){
        String str = "   a b c d e f g h\n";
        Animal[][] ani = boardRepresentation();
        for (int i : I) {
            str += (i+" ");
            for (String j : J) {
                if (null == ani[toIndex(j)][i-1]) {
                    str += (i+toIndex(j))%2==1 ? Globals.ts_empty_square_dark : Globals.ts_empty_square_light;
                } else {
                    str += ani[toIndex(j)][i-1].toString();
                }
            }
            str += " " + i + "\n";
        }
        str += "  a b c d e f g h\nIt is " + next + "'s turn.\n";
        return str;
    }

}
