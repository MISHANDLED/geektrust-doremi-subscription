package com.example.geektrust.plans;

public class Video extends Plan {
	
	int MonthOne;
	int MonthThree;
	
	public Video() {
		// TODO Auto-generated constructor stub
		super();
		MonthOne = 200;
		MonthThree = 500;
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
