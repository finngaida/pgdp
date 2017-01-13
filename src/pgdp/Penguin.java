package pgdp;

public class Penguin extends Predator {

    // Ein Pinguin kann 12 Tage bzw. Spielrunden ohne Essen auskommen.
    // Die Deklaration darf entfernt (und der Wert z. B. direkt im Code
    // verwendet) werden.
    private static int withoutFood = 12;

    public int daysLeft() { return withoutFood; }

    /**
     * Dem Konstruktor wird das Geschlecht des Tiers uebergeben.
     *
     */
    public Penguin(boolean female) {
        super(female);
    }

    @Override
    public Move[] possibleMoves() {
        Integer row = Globals.i(this.square.charAt(0));
        Integer col = Globals.i(this.square.charAt(1));

        String left = Globals.s(row-1);
        String center = Globals.s(row);
        String right = Globals.s(row+1);

        Integer leftI = row-1;
        Integer centerI = row;
        Integer rightI = row+1;

        Integer top = col-1;
        Integer bottom = col+1;

        String[] allMoves = new String[8];
        int count = 0;

        if (row > 1) {
            if (col > 1 && (position.boardRepresentation()[leftI][top] == null || position.boardRepresentation()[leftI][top] instanceof Vegetarian)) {
                allMoves[count] = left + top;
            }

            if (position.boardRepresentation()[leftI][col] == null || position.boardRepresentation()[leftI][col] instanceof Vegetarian){
                allMoves[count + 1] = left + col;
            }

            if (col < 9 && (position.boardRepresentation()[leftI][bottom] == null || position.boardRepresentation()[leftI][bottom] instanceof Vegetarian)) {
                allMoves[count + 2] = left + bottom;
            }

            count = count+3;
        }

        if (row < 8) {
            if (col > 1 && (position.boardRepresentation()[rightI][top] == null || position.boardRepresentation()[rightI][top] instanceof Vegetarian)) {
                allMoves[count] = right + top;
            }

            if (position.boardRepresentation()[rightI][col] == null || position.boardRepresentation()[rightI][col] instanceof Vegetarian) {
                allMoves[count + 1] = right + col;
            }

            if (col < 9 && (position.boardRepresentation()[rightI][bottom] == null || position.boardRepresentation()[rightI][bottom] instanceof Vegetarian)) {
                allMoves[count + 2] = right + bottom;
            }

            count = count+3;
        }

        if (col > 1 && (position.boardRepresentation()[centerI][top] == null || position.boardRepresentation()[centerI][top] instanceof Vegetarian)) {
            allMoves[count+1] = center+top;
            count++;
        }

        if (col < 8 && (position.boardRepresentation()[centerI][bottom] == null || position.boardRepresentation()[centerI][bottom] instanceof Vegetarian)) {
            allMoves[count+1] = center+bottom;
            count++;
        }

        Move[] moves = new Move[count];
        for (int i = 0; i < count; i++) {
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
          ? (Globals.darkSquare(this.square) ? Globals.ts_female_penguin_dark : Globals.ts_female_penguin_light)
          : (Globals.darkSquare(this.square) ? Globals.ts_male_penguin_dark : Globals.ts_male_penguin_light);
    }

}
