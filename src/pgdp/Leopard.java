package pgdp;

public class Leopard extends Predator {

    // Ein Leopard kann nur 5 Tage bzw. Spielrunden ohne Essen auskommen.
    // Die Deklaration darf entfernt (und der Wert z. B. direkt im Code
    // verwendet) werden.
    private static int withoutFood = 5;


    /**
     * Dem Konstruktor wird das Geschlecht des Tiers uebergeben.
     *
     */
    public Leopard(boolean female) {
        super(female);
    }

    @Override
    public Move[] possibleMoves() {

        Integer row = Globals.i(this.square.charAt(0));
        Integer col = Globals.i(this.square.charAt(1));

        // Elephant
        int counter = 0;
        String[] straightMoves = new String[15];

        for (int i = 0; i < 8; i++) {
            if (i != row) {
                straightMoves[counter] = Globals.s(i)+col;
                counter++;
            }

            if (i != col) {
                straightMoves[counter] = ""+this.square.charAt(0)+i;
                counter++;
            }
        }

        // Diagonalen
        counter = 0;
        String[] diagMoves = new String[13];

        for (int i = 1; i < 7; i++) {

            // To the top left
            int newRow = row - i;
            int newCol = col - i;
            if (newRow > 0 && newCol > 0) {
                diagMoves[counter] = Globals.s(newRow)+newCol;
                counter++;
            }

            // To the top right
            newRow = row + i;
            newCol = col - i;
            if (newRow < 9 && newCol > 0) {
                diagMoves[counter] = Globals.s(newRow)+newCol;
                counter++;
            }

            // To the bottom right
            newRow = row + i;
            newCol = col + i;
            if (newRow < 9 && newCol < 9) {
                diagMoves[counter] = Globals.s(newRow)+newCol;
                counter++;
            }

            // To the top right
            newRow = row - i;
            newCol = col + i;
            if (newRow > 0 && newCol < 9) {
                diagMoves[counter] = Globals.s(newRow)+newCol;
                counter++;
            }
        }

        Move[] moves = new Move[counter+15];

        // insert diagonal moves
        for (int i = 0; i < counter; i++) {
            moves[i] = new Move(this.square, diagMoves[i]);
        }

        // insert straight moves
        for (int i = counter; i < counter+15; i++) {
            moves[i] = new Move(this.square, straightMoves[i]);
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
          ? (Globals.darkSquare(this.square) ? Globals.ts_female_leopard_dark : Globals.ts_female_leopard_light)
          : (Globals.darkSquare(this.square) ? Globals.ts_male_leopard_dark : Globals.ts_male_leopard_light);
    }

}
