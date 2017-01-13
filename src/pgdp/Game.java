package pgdp;

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
        if (move.length() != 4) {
            return false;
        }

        int a = Globals.i(move.charAt(0));
        int b = Globals.i(move.charAt(1));
        int c = Globals.i(move.charAt(2));
        int d = Globals.i(move.charAt(3));

        if (a == Integer.MAX_VALUE || b == Integer.MAX_VALUE || c == Integer.MAX_VALUE || d == Integer.MAX_VALUE) {
            return false;
        }

        Animal[][] board = pos.boardRepresentation();

        if (board[a][b] == null) {
            return false;
        }

        Animal animal = board[a][b];
        Boolean contains = false;

        for (int i = 0; i < animal.possibleMoves().length; i++) {
            if (animal.possibleMoves()[i].toString().equals(move)) {
                contains = true;
            }
        }

        return contains;
    }
}
