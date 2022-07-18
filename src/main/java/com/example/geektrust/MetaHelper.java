package com.example.geektrust;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.example.geektrust.plans.Music;
import com.example.geektrust.plans.Plan;
import com.example.geektrust.plans.Podcast;
import com.example.geektrust.plans.Video;

public class MetaHelper {
	
	Subscription ins = Subscription.getInstance();
	
	public void helper(Plan obj, String[] arr) {
		if(ins.getDate()==null) {
			System.out.println(PreDefinedStrings.ADD_SUBSCRIPTION_FAILED + " " + PreDefinedStrings.INVALID_DATE);
		}else if(obj.activated) {
			System.out.println(PreDefinedStrings.ADD_SUBSCRIPTION_FAILED + " " + PreDefinedStrings.DUPLICATE_CATEGORY);
		}else {
			LocalDate dt = ins.getDate();
			obj.startService(dt, arr[2]);
		}
	}
	
	public void topupHelper(String[] arr) {
		if(ins.topUpMonth!=0) {
			System.out.println(PreDefinedStrings.ADD_TOPUP_FAILED + " " + PreDefinedStrings.DUPLICATE_TOPUP);
		}else if(!ins.isRealSub()){
			System.out.println(PreDefinedStrings.ADD_TOPUP_FAILED + " " + PreDefinedStrings.SUBSCRIPTIONS_NOT_FOUND);
		}else {
			ins.addTopUp(arr[1], arr[2]);
		}
	}
	
	public void printRecipt(Music music, Podcast podcast, Video video) {
		
		if(!ins.isRealSub()) {
			System.out.println(PreDefinedStrings.SUBSCRIPTIONS_NOT_FOUND);
			return;
		}
		int bill = 0;
		
		if(music.activated) {
			bill += music.findTotal();
			int time = music.getPlantype()==3?3:1;
			String formattedDate = music.getDate().plusMonths(time).minusDays(10).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			System.out.println(PreDefinedStrings.RENEWAL_REMINDER + " " + PreDefinedStrings.MUSIC + " " + formattedDate);
		}
		if(video.activated) {
			bill += video.findTotal();
			int time = video.getPlantype()==3?3:1;
			String formattedDate = video.getDate().plusMonths(time).minusDays(10).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			System.out.println(PreDefinedStrings.RENEWAL_REMINDER + " " + PreDefinedStrings.VIDEO + " " + formattedDate);
		}
		if(podcast.activated) {
			bill += podcast.findTotal();
			int time = podcast.getPlantype()==3?3:1;
			String formattedDate = podcast.getDate().plusMonths(time).minusDays(10).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			System.out.println(PreDefinedStrings.RENEWAL_REMINDER + " " + PreDefinedStrings.PODCAST + " " + formattedDate);
		}
		
		if(ins.topUpMonth!=0) {
			bill += (ins.topUpMonth*ins.topUpQuant);
		}
		System.out.println(PreDefinedStrings.RENEWAL_AMOUNT + " " + bill);
	}
	
}
