package model;

public class SafeBox {
	
	public static double currentPass=000000;
	public static String safeBoxInsides="";
	
	public static boolean unlockSafe(double pass) {
		boolean unlock=false;
		if(pass==currentPass){
			unlock=true;
		}
		
		return unlock;
	}
	
	public static boolean samePasswords(double pass) {
		boolean same=false;
		if(pass==currentPass){
			same=true;
		}
		
		return same;
	}
	
	public static String safeContents(String safeContents) {
		
		safeBoxInsides=safeContents;
		
		return safeBoxInsides;
		
	}

}
