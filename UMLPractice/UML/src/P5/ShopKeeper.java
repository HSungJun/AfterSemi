package P5;

public class ShopKeeper {
	public int makeBillPaper() {
		Item item = new Item();
		return 0;
	}
	
	private Cart cart;

	public ShopKeeper() {
		super();
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public void calculator(Calculator calculator) {
		calculator.calculate();
	}
	
	
}
