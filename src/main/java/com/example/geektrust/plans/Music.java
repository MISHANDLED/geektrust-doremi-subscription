package com.example.geektrust.plans;

public class Music extends Plan {
	
	int MonthOne;
	int MonthThree;
	
	public Music(){
		// TODO Auto-generated constructor stub
		super();
		MonthOne = 100;
		MonthThree = 250;
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
