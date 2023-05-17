package kh.spring.elec;

import kh.spring.interfaces.TV;

public class SamsungTV implements TV {
	
	private int price;
	private String brand;
	
	public void powerOn() {
		System.out.println("Samsung");
	}
	public void powerOff() {}
	
	@Override
	public void volDown() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void volUp() {
		// TODO Auto-generated method stub
		
	}
	
}
