package pgdp;

public class Main {

    public static void main(String[] args) {
	// write your code here
        FruitBasket basket = new FruitBasket();

        System.out.println(basket.toString());

        basket.addFruit(new Pineapple());
        basket.addFruit(new Banana());
        basket.addFruit(new GrannySmith());
        basket.addFruit(new PinkLady());
        basket.addFruit(new Apple());
        basket.addFruit(new Banana());
        basket.addFruit(new GrannySmith());
        basket.addFruit(new Pineapple());

        System.out.println(basket.toString());
        System.out.println(basket.getApples().toString());
        System.out.println(basket.getEqualOrLongerShelfLife(10).toString());
    }
}
