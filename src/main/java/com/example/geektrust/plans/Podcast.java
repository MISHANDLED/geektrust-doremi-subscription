package com.example.geektrust.plans;

public class Podcast extends Plan {
	
	int MonthOne;
	int MonthThree;
	
	public Podcast() {
		// TODO Auto-generated constructor stub
		super();
		MonthOne = 100;
		MonthThree = 300;
	}

	@Override
	public int findTotal() {
		
		if(plantype == 1) {
			return 0;
		}else if(plantype ==2) {
			return MonthOne;
		}
		return MonthThree;
		
	}
	
}
