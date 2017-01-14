package pgdp;

import java.util.Arrays;

/**
 * Die Klasse Game fuehrt die Benutzerinteraktion durch.
 *
 */

public class Game {

    private Position pos;

    /**
     * Startet ein neues Spiel.
     * Der Benutzer wird ueber das Spielgeschehen informiert.
     *
     * Dazu gehoert auch die Information, wie lange die
     * einzelnen Raubtiere noch ohne Essen auskommen koennen.
     * Diese Information soll auf Anfrage oder immer angezeigt werden.
     *
     * Es soll ausserdem eine Moeglichkeit geben, sich alle Zuege
     * anzeigen zu lassen, die in der Spielsituation moeglich sind.
     *
     * Bei fehlerhaften Eingaben wird die Eingabe natuerlich wiederholt.
     *
     * Der Parameter spezifiziert, wer das Spiel beginnen darf.
     */
    public void startGame(boolean ladiesFirst){
        pos = new Position();
        pos.reset(ladiesFirst ? 'W' : 'M');

        printBoard();
    }

    public void printBoard() {
        System.out.println(pos.toString());
    }

    public Boolean finished() {
        return pos.theWinner() != 'X';
    }

    public char winner() {
        return pos.theWinner();
    }

    public void playMoves(Move[] moves) {
        pos.applyMoves(moves);
    }

    public Boolean validMove(String move) {

        System.out.println("[DEBUG]: checking move " + move);

        System.out.println("[DEBUG]: Length is " + move.length());

        if (move.length() != 4) {
            return false;
        }

        if (move.equals("pass")) {
            return true;
        }

        int a = Globals.i(move.charAt(0));
        int b = Globals.i(move.charAt(1));
        int c = Globals.i(move.charAt(2));
        int d = Globals.i(move.charAt(3));

        System.out.println("[DEBUG]: parts: " + a + b + c + d);

        if (a == Integer.MAX_VALUE || b == Integer.MAX_VALUE || c == Integer.MAX_VALUE || d == Integer.MAX_VALUE) {
            return false;
        }

        Animal[][] board = pos.boardRepresentation();

        System.out.println("[DEBUG]: board is used at the animal location: " + board[a][b]);

        if (board[a][b] == null) {
            return false;
        }

        Animal animal = board[a][b];
        Boolean contains = false;

        System.out.println("[DEBUG]: moving animal: " + animal.toString());

        for (int i = 0; i < animal.possibleMoves().length; i++) {
            if (animal.possibleMoves()[i].toString().equals(move)) {
                contains = true;
            }
        }

        System.out.println("[DEBUG]: found move in animal.possibleMoves(): " + Arrays.toString(animal.possibleMoves()) + contains);

        return contains;
    }

    public String animalsDescription(Boolean forW) {
        int eleCount = 0, horseCount = 0, rabbitCount = 0;
        String ret = "";

        for (int i = 0; i < pos.animals().length; i++) {
            Animal a = pos.animals()[i];

            if (a.female == forW) {
                if (a instanceof Leopard) {
                    ret = ret + "Leopard (" + ((Leopard) a).daysLeft() + " Tage noch), ";
                } else if (a instanceof Penguin) {
                    ret = ret + "Pinguin (" + ((Penguin) a).daysLeft() + " Tage noch), ";
                } else if (a instanceof Snake) {
                    ret = ret + "Schlange (" + ((Snake) a).daysLeft() + " Tage noch), ";
                } else if (a instanceof Elephant) {
                    eleCount++;
                } else if (a instanceof Horse) {
                    horseCount++;
                } else if (a instanceof Rabbit) {
                    rabbitCount++;
                }
            }
        }

        ret = ret + eleCount + " Elefanten, " + horseCount + " Pferde, " + rabbitCount + " Kaninchen";
        return ret;
    }
}
