package pgdp;

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

        Integer top = col-1;
        Integer bottom = col+1;

        String[] allMoves = new String[8];
        int count = 0;

        if (row > 1) {
            if (col > 1 && position.boardRepresentation()[leftI][top] == null) {
                allMoves[count] = left + top;
            }

            if (position.boardRepresentation()[leftI][col] == null) {
                allMoves[count + 1] = left + col;
            }

            if (col < 9 && position.boardRepresentation()[leftI][bottom] == null) {
                allMoves[count + 2] = left + bottom;
            }

            count = count+3;
        }

        if (row < 8) {
            if (col > 1 && position.boardRepresentation()[rightI][top] == null) {
                allMoves[count] = right + top;
            }

            if (position.boardRepresentation()[rightI][col] == null){
                allMoves[count + 1] = right + col;
            }

            if (col < 9 && position.boardRepresentation()[rightI][bottom] == null) {
                allMoves[count + 2] = right + bottom;
            }

            count = count+3;
        }

        if (col > 1 && position.boardRepresentation()[centerI][top] == null) {
            allMoves[count+1] = center+top;
            count++;
        }

        if (col < 8 && position.boardRepresentation()[centerI][bottom] == null) {
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
          ? (Globals.darkSquare(this.square) ? Globals.ts_female_rabbit_dark : Globals.ts_female_rabbit_light)
          : (Globals.darkSquare(this.square) ? Globals.ts_male_rabbit_dark : Globals.ts_male_rabbit_light);
    }

}
