package kh.spring.contrillers;

public class TvFactory {
	
	public static TV getTv(String type) {
	
	if(type.equals("samsung")) {
		return new SamsungTV();
	}else if(type.equals("lg")) {
		return new LGTV();
	}else {
		return null;
	}
	
	}
}
