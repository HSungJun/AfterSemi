package P5;

import java.util.List;

public class Cart {
	
	private List<Item> Item;

	public Cart(List<P5.Item> item) {
		super();
		this.Item = item;
	}

	public Cart() {
		super();
	}

	public List<Item> getItem() {
		return Item;
	}

	public void setItem(List<Item> item) {
		Item = item;
	}
	
	public void additem(Item item) {
		this.Item.add(null);
	}
	
	
	
	
	
	
	
}
