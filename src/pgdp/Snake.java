package pgdp;

public class Snake extends Predator {

    // Eine Schlange kann 9 Tage bzw. Spielrunden ohne Essen auskommen.
    // Die Deklaration darf entfernt (und der Wert z. B. direkt im Code
    // verwendet) werden.
    private static int withoutFood = 9;


    /**
     * Dem Konstruktor wird das Geschlecht des Tiers uebergeben.
     *
     */
    public Snake(boolean female) {
        super(female);
    }

    @Override
    public Move[] possibleMoves() {

        Integer row = Globals.i(this.square.charAt(0));
        Integer col = Globals.i(this.square.charAt(1));

        String[] allMoves = new String[14];
        Integer counter = 0;
        boolean left = true;

        // nach oben links
        Integer rowCache = row-1;
        Integer colCache = col-1;

        while (rowCache > 0 && colCache > 0) {
            if (position.boardRepresentation()[rowCache][colCache] != null) { break; }
            allMoves[counter] = Globals.s(rowCache)+colCache;
            counter++;

            rowCache = row - (left ? 0 : 1);
            colCache = colCache - 1;
            left = !left;
        }

        // nach oben rechts
        rowCache = row+1;
        colCache = col-1;

        while (rowCache < 9 && colCache > 0) {
            if (position.boardRepresentation()[rowCache][colCache] != null) { break; }
            allMoves[counter] = Globals.s(rowCache)+colCache;
            counter++;

            rowCache = rowCache + 1;
            colCache = col - (left ? 0 : 1);
            left = !left;
        }

        // nach unten rechts
        rowCache = row+1;
        colCache = col+1;

        while (rowCache < 9 && colCache < 9) {
            if (position.boardRepresentation()[rowCache][colCache] != null) { break; }
            allMoves[counter] = Globals.s(rowCache)+colCache;
            counter++;

            rowCache = row + (left ? 0 : 1);
            colCache = colCache + 1;
            left = !left;
        }

        // nach unten links
        rowCache = row-1;
        colCache = col+1;

        while (rowCache > 0 && colCache < 9) {
            if (position.boardRepresentation()[rowCache][colCache] != null) { break; }
            allMoves[counter] = Globals.s(rowCache)+colCache;
            counter++;

            rowCache = rowCache - 1;
            colCache = col + (left ? 0 : 1);
            left = !left;
        }

        Move[] moves = new Move[counter];

        for (int i = 0; i < counter; i++) {
            moves[i] = new Move(this.square, allMoves[i]);
        }

        return moves;
    }

    @Override
    public void sunset() {
        super.sunset();
    }

    @Override
    public String toString(){
        return this.female
          ? (Globals.darkSquare(this.square) ? Globals.ts_female_snake_dark : Globals.ts_female_snake_light)
          : (Globals.darkSquare(this.square) ? Globals.ts_male_snake_dark : Globals.ts_male_snake_light);
    }

}
