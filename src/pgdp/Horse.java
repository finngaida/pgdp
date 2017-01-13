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
        if (row > 1) {
            allMoves[counter] = Globals.s(row-1)+col;
            counter++;
        }

        // 1 nach oben
        if (col > 1) {
            allMoves[counter] = Globals.s(row)+(col-1);
            counter++;
        }

        // 1 nach rechts
        if (row < 8) {
            allMoves[counter] = Globals.s(row+1)+col;
            counter++;
        }

        // 1 nach unten
        if (col < 8) {
            allMoves[counter] = Globals.s(row)+(col+1);
            counter++;
        }

        // Oben links 1
        if (row > 2 && col > 2) {
            allMoves[counter] = Globals.s(row-2)+Globals.s(col-2);
            counter++;
        }

        // Oben links 2
        if (row > 3 && col > 3) {
            allMoves[counter] = Globals.s(row-3)+Globals.s(col-3);
            counter++;
        }

        // Oben rechts 1
        if (row < 7 && col > 2) {
            allMoves[counter] = Globals.s(row+2)+Globals.s(col-2);
            counter++;
        }

        // Oben rechts 2
        if (row < 6 && col > 3) {
            allMoves[counter] = Globals.s(row+3)+Globals.s(col-3);
            counter++;
        }

        // Unten rechts 1
        if (row < 7 && col < 7) {
            allMoves[counter] = Globals.s(row+2)+Globals.s(col+2);
            counter++;
        }

        // Oben links 2
        if (row < 6 && col < 6) {
            allMoves[counter] = Globals.s(row+3)+Globals.s(col+3);
            counter++;
        }

        // Unten links 1
        if (row > 2 && col < 7) {
            allMoves[counter] = Globals.s(row-2)+Globals.s(col+2);
            counter++;
        }

        // Unten links 2
        if (row > 3 && col < 6) {
            allMoves[counter] = Globals.s(row-3)+Globals.s(col+3);
            counter++;
        }

        Move[] moves = new Move[counter];
        for (int i = 0; i < counter; i++) {
            moves[i] = new Move(this.square+allMoves[i]);
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
          ? (Globals.darkSquare(this.square) ? Globals.ts_female_horse_dark : Globals.ts_female_horse_light)
          : (Globals.darkSquare(this.square) ? Globals.ts_male_horse_dark : Globals.ts_male_horse_light);
    }

}
