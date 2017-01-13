package pgdp;

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

        for (int i = 0; i < 8; i++) {
            if (i != row) {
                moves[counter] = new Move(this.square, Globals.s(i)+col);
                counter++;
            }

            if (i != col) {
                moves[counter] = new Move(this.square, ""+this.square.charAt(0)+i);
                counter++;
            }
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
          ? (Globals.darkSquare(this.square) ? Globals.ts_female_elephant_dark : Globals.ts_female_elephant_light)
          : (Globals.darkSquare(this.square) ? Globals.ts_male_elephant_dark : Globals.ts_male_elephant_light);
    }

}
