

public class Penguin extends Predator {

    // Ein Pinguin kann 12 Tage bzw. Spielrunden ohne Essen auskommen.
    // Die Deklaration darf entfernt (und der Wert z. B. direkt im Code
    // verwendet) werden.
    private static int withoutFood = 12;

    public int daysLeft() { return withoutFood; }

    public void eat() {
        withoutFood = 12;
    }

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

        String top = ""+(col+2);
        String bottom = ""+col;

        Integer topI = col+1;
        Integer bottomI = col-1;

        String[] allMoves = new String[8];
        int count = 0;

        if (row > 0) {
            if (col < 7 && (position.boardRepresentation()[leftI][topI] == null || position.boardRepresentation()[leftI][topI] instanceof Vegetarian)) {
                allMoves[count] = left + top;
                count++;
            }

            if (position.boardRepresentation()[leftI][col] == null || position.boardRepresentation()[leftI][col] instanceof Vegetarian){
                allMoves[count] = left + (col+1);
                count++;
            }

            if (col > 0 && (position.boardRepresentation()[leftI][bottomI] == null || position.boardRepresentation()[leftI][bottomI] instanceof Vegetarian)) {
                allMoves[count] = left + bottom;
                count++;
            }
        }

        if (row < 7) {
            if (col < 7 && (position.boardRepresentation()[rightI][topI] == null || position.boardRepresentation()[rightI][topI] instanceof Vegetarian)) {
                allMoves[count] = right + top;
                count++;
            }

            if (position.boardRepresentation()[rightI][col] == null || position.boardRepresentation()[rightI][col] instanceof Vegetarian) {
                allMoves[count] = right + (col+1);
                count++;
            }

            if (col > 0 && (position.boardRepresentation()[rightI][bottomI] == null || position.boardRepresentation()[rightI][bottomI] instanceof Vegetarian)) {
                allMoves[count] = right + bottom;
                count++;
            }
        }

        if (col < 7 && (position.boardRepresentation()[centerI][topI] == null || position.boardRepresentation()[centerI][topI] instanceof Vegetarian)) {
            allMoves[count] = center+top;
            count++;
        }

        if (col > 0 && (position.boardRepresentation()[centerI][bottomI] == null || position.boardRepresentation()[centerI][bottomI] instanceof Vegetarian)) {
            allMoves[count] = center+bottom;
            count++;
        }

        Move[] moves = new Move[count];
        for (int i = 0; i < count; i++) {
            //System.out.println("[DEBUG] penguin move: " + allMoves[i]);
            moves[i] = new Move(this.square, allMoves[i]);
        }

        return moves;
    }

    @Override
    public void sunset() {
        withoutFood--;
        if (withoutFood < 0) {
            position.kill(Globals.i(square.charAt(0)), Globals.i(square.charAt(1)));
        }
    }

    @Override
    public String toString(){
        return this.female
          ? (Globals.darkSquare(this.square) ? Globals.ts_female_penguin_dark : Globals.ts_female_penguin_light)
          : (Globals.darkSquare(this.square) ? Globals.ts_male_penguin_dark : Globals.ts_male_penguin_light);
    }

}
