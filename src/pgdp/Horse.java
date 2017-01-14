package pgdp;

public class Horse extends Vegetarian {

    /**
     * Dem Konstruktor wird das Geschlecht des Tiers uebergeben.
     *
     */
    public Horse(boolean female) {
        super(female);
    }

    @Override
    public Move[] possibleMoves() {

        Integer row = Globals.i(this.square.charAt(0));
        Integer col = Globals.i(this.square.charAt(1));

        int counter = 0;
        String[] allMoves = new String[12];

        // 1 nach links
        if (row > 1 && position.boardRepresentation()[row-1][col] == null) {
            allMoves[counter] = Globals.s(row-1)+(col+1);
            counter++;
        }

        // 1 nach oben
        if (col < 6 && position.boardRepresentation()[row][col+1] == null) {
            allMoves[counter] = Globals.s(row)+(col+2);
            counter++;
        }

        // 1 nach rechts
        if (row < 8 && position.boardRepresentation()[row+1][col] == null) {
            allMoves[counter] = Globals.s(row+1)+(col+1);
            counter++;
        }

        // 1 nach unten
        if (col > 1 && position.boardRepresentation()[row][col-1] == null) {
            allMoves[counter] = Globals.s(row)+(col);
            counter++;
        }

        // Oben links 1
        if (row > 2 && col < 6 && position.boardRepresentation()[row-2][col+2] == null) {
            allMoves[counter] = Globals.s(row-2)+Globals.s(col+3);
            counter++;
        }

        // Oben links 2
        if (row > 3 && col < 5 && position.boardRepresentation()[row-3][col+3] == null) {
            allMoves[counter] = Globals.s(row-3)+Globals.s(col+4);
            counter++;
        }

        // Oben rechts 1
        if (row < 7 && col < 6 && position.boardRepresentation()[row+2][col+2] == null) {
            allMoves[counter] = Globals.s(row+2)+Globals.s(col+3);
            counter++;
        }

        // Oben rechts 2
        if (row < 6 && col < 5 && position.boardRepresentation()[row-3][col+3] == null) {
            allMoves[counter] = Globals.s(row+3)+Globals.s(col+4);
            counter++;
        }

        // Unten rechts 1
        if (row < 7 && col > 1 && position.boardRepresentation()[row+2][col-2] == null) {
            allMoves[counter] = Globals.s(row+2)+Globals.s(col-1);
            counter++;
        }

        // Oben links 2
        if (row < 6 && col > 2 && position.boardRepresentation()[row+3][col-3] == null) {
            allMoves[counter] = Globals.s(row+3)+Globals.s(col-2);
            counter++;
        }

        // Unten links 1
        if (row > 2 && col > 1 && position.boardRepresentation()[row-2][col-2] == null) {
            allMoves[counter] = Globals.s(row-2)+Globals.s(col-1);
            counter++;
        }

        // Unten links 2
        if (row > 3 && col > 2 && position.boardRepresentation()[row-3][col-3] == null) {
            allMoves[counter] = Globals.s(row-3)+Globals.s(col-2);
            counter++;
        }

        Move[] moves = new Move[counter];
        for (int i = 0; i < counter; i++) {
            moves[i] = new Move(this.square+allMoves[i]);
        }

        return moves;
    }

    @Override
    public String toString(){
        return this.female
          ? (Globals.darkSquare(this.square) ? Globals.ts_female_horse_dark : Globals.ts_female_horse_light)
          : (Globals.darkSquare(this.square) ? Globals.ts_male_horse_dark : Globals.ts_male_horse_light);
    }

}
