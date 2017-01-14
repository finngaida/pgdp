package pgdp;

/**
 * Die Klasse Main enthaelt das Hauptprogramm.
 *
 * Im Hauptprogramm wird zuerst der Benutzer gefragt,
 * wer das Spiel beginnen soll.
 *
 * Dann wird das Spiel gestartet.
 *
 */
public class Main {

    public static void main(String args[]) {

        Boolean whoBegins = IO.readInt("Wer fängt an? (0 für w, 1 für m)", 0, 1) == 0;
        boolean wPlaying = whoBegins;

        Game game = new Game();
        game.startGame(whoBegins);

        while (!game.finished()) {

            // Bisschen Info
            System.out.println((wPlaying ? "W" : "M") + " ist am Zug. Du hast noch:");
            System.out.println(game.animalsDescription(wPlaying));

            int moveCount = 0;
            String[] moves = new String[4];
            String move = "";
            while (moveCount < 4) {

                move = "";
                //System.out.println("[DEBUG]: move " + moveCount);

                // erstmal einen Zug einholen
                while (!game.validMove(move, wPlaying)) {
                    move = IO.readString((wPlaying ? "W" : "M") + ": (Zug " + (moveCount + 1) + " von 4) Gib einen Zug im Format 'a2a3' ein. (oder 'pass' falls du nicht mehr ziehen möchtest)");
                    //System.out.println("[DEBUG]: got move: " + move);
                }

                // Abbruchfall
                if (move.equals("pass")) {
                    //System.out.println("[DEBUG]: passed");
                    break;
                }

                // move speichern
                moves[moveCount] = move;
                moveCount++;
            }

            //System.out.println("[DEBUG]: that's it");

            // strings in Moves konvertieren
            Move[] realMoves = new Move[moveCount];
            for (int i = 0; i < moveCount; i++) {
                realMoves[i] = new Move(moves[i]);
            }

            game.playMoves(realMoves);
            wPlaying = !wPlaying;

            if (wPlaying == whoBegins) {
                game.sunset();
            }

            game.printBoard();
        }

        System.out.println("Game Over! " + game.winner() + " gewinnt.");
    }

}
