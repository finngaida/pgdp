

public class Rabbit extends Vegetarian {

    /**
     * Dem Konstruktor wird das Geschlecht des Tiers uebergeben.
     *
     */
    public Rabbit(boolean female) {
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

        if (row > 1) {
            if (col < 7 && position.boardRepresentation()[leftI][topI] == null) {
                allMoves[count] = left + top;
                count++;
            }

            if (position.boardRepresentation()[leftI][col] == null) {
                allMoves[count] = left + (col+1);
                count++;
            }

            if (col > 0 && position.boardRepresentation()[leftI][bottomI] == null) {
                allMoves[count] = left + bottom;
                count++;
            }
        }

        if (row < 7) {
            if (col < 7 && position.boardRepresentation()[rightI][topI] == null) {
                allMoves[count] = right + top;
                count++;
            }

            if (position.boardRepresentation()[rightI][col] == null){
                allMoves[count] = right + (col+1);
            }

            if (col > 0 && position.boardRepresentation()[rightI][bottomI] == null) {
                allMoves[count] = right + bottom;
            }
        }

        if (col < 7 && position.boardRepresentation()[centerI][topI] == null) {
            allMoves[count] = center+top;
            count++;
        }

        if (col > 0 && position.boardRepresentation()[centerI][bottomI] == null) {
            allMoves[count] = center+bottom;
            count++;
        }

        Move[] moves = new Move[count];
        for (int i = 0; i < count; i++) {
            moves[i] = new Move(this.square, allMoves[i]);
        }

        return moves;
    }

    @Override
    public String toString(){
        return this.female
          ? (Globals.darkSquare(this.square) ? Globals.ts_female_rabbit_dark : Globals.ts_female_rabbit_light)
          : (Globals.darkSquare(this.square) ? Globals.ts_male_rabbit_dark : Globals.ts_male_rabbit_light);
    }

}
