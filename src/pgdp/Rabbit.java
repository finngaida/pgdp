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
        Penguin karl = new Penguin(this.female);
        karl.square = this.square;
        return karl.possibleMoves();
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
