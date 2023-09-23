package com.svit.dayseven.finall;

public class FinalVariable {
	
	final int speedlimit=90; // constant
	
	void run() {
		speedlimit=125;
	}
	
	public static void main(String[] args) {
		
		FinalVariable obj = new FinalVariable();
		obj.run();
		
	}

}
