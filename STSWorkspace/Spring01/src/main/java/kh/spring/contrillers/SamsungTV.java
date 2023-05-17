package kh.spring.contrillers;

public class SamsungTV implements TV{
	
	private int price;
	private String brand;
	
	public void powerOn() {	
		System.out.println("Samsung");
	}
	public void powerOff() { }


}
