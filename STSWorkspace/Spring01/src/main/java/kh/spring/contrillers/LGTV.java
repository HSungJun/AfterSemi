package kh.spring.contrillers;

public class LGTV implements TV{
	
	private int price;
	private String brand;
	
	public void powerOn() {	
		System.out.println("LG");
	}
	public void powerOff() { }
	
}
