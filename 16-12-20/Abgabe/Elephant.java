

public class Elephant extends Vegetarian {

    /**
     * Dem Konstruktor wird das Geschlecht des Tiers uebergeben.
     *
     */
    public Elephant(boolean female) {
        super(female);
    }

    @Override
    public Move[] possibleMoves() {
        Integer row = Globals.i(this.square.charAt(0));
        Integer col = Globals.i(this.square.charAt(1));

        int counter = 0;
        Move[] moves = new Move[15];

        // nach links
        for (int i = row-1; i >= 0; i--) {
            if (position.boardRepresentation()[i][col] != null) {
                break;
            } else {
                moves[counter] = new Move(this.square, Globals.s(i) + (col+1));
                counter++;
            }
        }

        // nach rechts
        for (int i = row+1; i < 8; i++) {
            if (position.boardRepresentation()[i][col] != null) {
                break;
            } else {
                moves[counter] = new Move(this.square, Globals.s(i) + (col+1));
                counter++;
            }
        }

        // nach unten
        for (int i = col-1; i >= 0; i--) {
            if (position.boardRepresentation()[row][i] != null) {
                break;
            } else {
                moves[counter] = new Move(this.square, Globals.s(row)+(i+1));
                counter++;
            }
        }

        // nach oben
        for (int i = col+1; i < 9; i++) {
            if (position.boardRepresentation()[row][i] != null) {
                break;
            } else {
                moves[counter] = new Move(this.square, Globals.s(row)+(i+1));
                counter++;
            }
        }

        Move[] lessMoves = new Move[counter];
        for (int i = 0; i < counter; i++) {
            lessMoves[i] = moves[i];
        }

        return lessMoves;
    }

    @Override
    public String toString(){
        return this.female
          ? (Globals.darkSquare(this.square) ? Globals.ts_female_elephant_dark : Globals.ts_female_elephant_light)
          : (Globals.darkSquare(this.square) ? Globals.ts_male_elephant_dark : Globals.ts_male_elephant_light);
    }

}
