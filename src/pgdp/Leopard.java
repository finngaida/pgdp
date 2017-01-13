package pgdp;

public class Leopard extends Predator {

    // Ein Leopard kann nur 5 Tage bzw. Spielrunden ohne Essen auskommen.
    // Die Deklaration darf entfernt (und der Wert z. B. direkt im Code
    // verwendet) werden.
    private static int withoutFood = 5;

    public int daysLeft() { return withoutFood; }

    /**
     * Dem Konstruktor wird das Geschlecht des Tiers uebergeben.
     *
     */
    public Leopard(boolean female) {
        super(female);
    }

    private int min(int a, int b) {
        if (a > b) { return b; }
        else { return a; }
    }

    @Override
    public Move[] possibleMoves() {

        Integer row = Globals.i(this.square.charAt(0));
        Integer col = Globals.i(this.square.charAt(1));

        // Elephant
        int counter = 0;
        Move[] moves = new Move[15];

        // nach links
        for (int i = row-1; i > 0; i--) {
            if (position.boardRepresentation()[i][col] != null && position.boardRepresentation()[i][col] instanceof Predator) {
                break;
            } else {
                moves[counter] = new Move(this.square, Globals.s(i) + col);
                counter++;
                if (position.boardRepresentation()[i][col] != null && position.boardRepresentation()[i][col] instanceof Predator) { break; }
            }
        }

        // nach rechts
        for (int i = row+1; i < 9; i++) {
            if (position.boardRepresentation()[i][col] != null && position.boardRepresentation()[i][col] instanceof Predator) {
                break;
            } else {
                moves[counter] = new Move(this.square, Globals.s(i) + col);
                counter++;
                if (position.boardRepresentation()[i][col] != null && position.boardRepresentation()[i][col] instanceof Predator) { break; }
            }
        }

        // nach oben
        for (int i = col-1; i > 0; i--) {
            if (position.boardRepresentation()[row][i] != null && position.boardRepresentation()[i][col] instanceof Predator) {
                break;
            } else {
                moves[counter] = new Move(this.square, Globals.s(row)+i);
                counter++;
                if (position.boardRepresentation()[i][col] != null && position.boardRepresentation()[i][col] instanceof Predator) { break; }
            }
        }

        // nach unten
        for (int i = col+1; i < 9; i++) {
            if (position.boardRepresentation()[row][i] != null && position.boardRepresentation()[i][col] instanceof Predator) {
                break;
            } else {
                moves[counter] = new Move(this.square, Globals.s(row)+i);
                counter++;
                if (position.boardRepresentation()[i][col] != null && position.boardRepresentation()[i][col] instanceof Predator) { break; }
            }
        }

        Move[] lessMoves = new Move[counter];
        for (int i = 0; i < counter; i++) {
            lessMoves[i] = moves[i];
        }

        // Diagonalen
        counter = 0;
        String[] diagMoves = new String[13];

        // To the top left
        for (int i = 1; i < min(row,col)+1; i++) {
            int newRow = row - i;
            int newCol = col - i;
            if (position.boardRepresentation()[newRow][newCol] != null && position.boardRepresentation()[newRow][newCol] instanceof Predator) { break; }
            diagMoves[counter] = Globals.s(newRow) + newCol;
            counter++;
            if (position.boardRepresentation()[newRow][newCol] != null && position.boardRepresentation()[newRow][newCol] instanceof Vegetarian) { break; }
        }

            // To the top right
        for (int i = 1; i < min(row,col)+1; i++) {
            int newRow = row + i;
            int newCol = col - i;
            if (position.boardRepresentation()[newRow][newCol] != null && position.boardRepresentation()[newRow][newCol] instanceof Predator) {
                break;
            }
            diagMoves[counter] = Globals.s(newRow) + newCol;
            counter++;
            if (position.boardRepresentation()[newRow][newCol] != null && position.boardRepresentation()[newRow][newCol] instanceof Vegetarian) {
                break;
            }
        }

            // To the bottom right
            for (int i = 1; i < min(row,col)+1; i++) {
                int newRow = row + i;
                int newCol = col + i;
                if (position.boardRepresentation()[newRow][newCol] != null && position.boardRepresentation()[newRow][newCol] instanceof Predator) {
                    break;
                }
                diagMoves[counter] = Globals.s(newRow) + newCol;
                counter++;
                if (position.boardRepresentation()[newRow][newCol] != null && position.boardRepresentation()[newRow][newCol] instanceof Vegetarian) {
                    break;
                }
            }

        // To the top right
        for (int i = 1; i < min(row,col)+1; i++) {
            int newRow = row - i;
            int newCol = col + i;
            if (position.boardRepresentation()[newRow][newCol] != null && position.boardRepresentation()[newRow][newCol] instanceof Predator) {
                break;
            }
            diagMoves[counter] = Globals.s(newRow) + newCol;
            counter++;
            if (position.boardRepresentation()[newRow][newCol] != null && position.boardRepresentation()[newRow][newCol] instanceof Vegetarian) {
                break;
            }
        }

        Move[] endmoves = new Move[counter+lessMoves.length];

        // insert diagonal moves
        for (int i = 0; i < counter; i++) {
            endmoves[i] = new Move(this.square, diagMoves[i]);
        }

        // insert straight moves
        for (int i = counter; i < counter+lessMoves.length; i++) {
            endmoves[i] = lessMoves[i];
        }

        return endmoves;

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
