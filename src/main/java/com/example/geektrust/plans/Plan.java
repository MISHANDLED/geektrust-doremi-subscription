package com.example.geektrust.plans;

import java.time.LocalDate;

import com.example.geektrust.Subscription;

public abstract class Plan {
	
	LocalDate date;
	public boolean activated;
	Subscription ins = Subscription.getInstance();
	public LocalDate getDate() {
		return date;
	}

	int plantype;
	
	
	public Plan(){
		date = null;
		activated = false;
		plantype = 0;
	}
	
	public void startService(LocalDate startDate, String plan) {
		activated = true;
		ins.setRealSub(true);
		date = startDate;
		if(plan.equals("FREE")) {
			plantype = 1;
			date.plusMonths(1);
		}else if(plan.equals("PERSONAL")) {
			plantype = 2;
			date.plusMonths(1);
		}else {
			plantype = 3;
			date.plusMonths(1);
		}
	
	}
	
	public int getPlantype() {
		return plantype;
	}

	public abstract int findTotal();
	
}
