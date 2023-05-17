package kh.spring.elec;

import kh.spring.interfaces.Speaker;

public class AppleSpeaker implements Speaker{
	public void volumeUp() {
		System.out.println("Apple : VolumeUP");
		
		
	}
	
	public void volumeDown() {
		System.out.println("Apple : VolumeDown");
	}
}
