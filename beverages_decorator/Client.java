package beverages_decorator;

public class Client {

	public static void main(String[] args) {
		Beverage base = new Cappuccino(); // 10
		Beverage withMilk = new Milk(base); // +3 => 13
		Beverage withMocha = new Mocha(withMilk); // +5 => 18
		Beverage withWhip = new Whip(withMocha); // +2 => 20
		Beverage deluxe = new Sugar(withWhip); // +1 => 21
		System.out.println("Deluxe Cappuccino cost: " + deluxe.cost());

		Beverage latte = new Latte(); // 20
		Beverage latteMocha = new Mocha(latte); // +5 => 25
		System.out.println("Mocha Latte cost: " + latteMocha.cost());
	}

}