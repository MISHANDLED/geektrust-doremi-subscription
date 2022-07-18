package com.example.geektrust;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Subscription {
	boolean subscribed;
	boolean realSub;
	LocalDate date;
	DateTimeFormatter dtf;
	
	int topUpMonth;
	int topUpQuant;
	
	private static Subscription instance;
	
	private Subscription() {
		subscribed = false;
		realSub = false;
		date = null;
		dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		topUpMonth = 0;
		topUpQuant = 0;
	}
	
	public boolean isRealSub() {
		return realSub;
	}

	public void setRealSub(boolean realSub) {
		this.realSub = realSub;
	}

	public boolean setDate(String sdate) {

			try {
				date = LocalDate.parse(sdate,dtf);
			} catch (Exception e) {
				return false;
			}
			
			subscribed = true;
			return true;

	}
	
	public static Subscription getInstance() {
		if(instance==null) {
			instance = new Subscription();
		}
		return instance;
	}
	
	public void addTopUp(String quantity, String month) {
		topUpMonth = Integer.parseInt(month);
		topUpQuant = quantity.equals("TEN_DEVICE")?100:50;
	}

	public boolean isSubscribed() {
		return subscribed;
	}

	public LocalDate getDate() {
		return date;
	}

}
