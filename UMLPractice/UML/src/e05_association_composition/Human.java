package e05_association_composition;

import java.util.ArrayList;
import java.util.List;

public class Human {
	private List<Heart> heart = new ArrayList<>();
	private Eyes eyes = new Eyes();
	
	public List<Heart> getHeart() {
		return heart;
	}
	public void setHeart(List<Heart> heart) {
		this.heart = heart;
	}
	public Eyes getEyes() {
		return eyes;
	}
	public void setEyes(Eyes eyes) {
		this.eyes = eyes;
	}
	public Human(List<Heart> heart, Eyes eyes) {
		this.heart = heart;
		this.eyes = eyes;
	}
	public Human() {
		super();
	}
	
	
	
	
	
	
}
