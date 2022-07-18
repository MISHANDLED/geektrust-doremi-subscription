package com.example.geektrust;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.example.geektrust.plans.Music;
import com.example.geektrust.plans.Podcast;
import com.example.geektrust.plans.Video;

public class Main {
	
	static Subscription ins;
	static Music music;
	static Podcast podcast;
	static Video video;
	static MetaHelper helpObj;

    public static void main(String[] args) throws Exception {
        
    	ins = Subscription.getInstance();
    	music = new Music();
    	podcast = new Podcast();
    	video = new Video();
    	helpObj = new MetaHelper();
    	
    	File file=new File(args[0]);
    	FileReader fr = new FileReader(file);
    	BufferedReader br=new BufferedReader(fr);
    	String line;
    	
    	while((line=br.readLine())!=null) {
    		helper(line);
    	}  
    	fr.close();
    	
    }
    
    public static void helper(String s) {
    	String[] arr = s.split(" ");
    	//System.out.println(arr[0]);
    	if(arr[0].equals("START_SUBSCRIPTION")) {
    		if(!ins.setDate(arr[1])) {
    			System.out.println(PreDefinedStrings.INVALID_DATE);
    		}
    	} else if(arr[0].equals("ADD_SUBSCRIPTION")) {
    		if(arr[1].equals("MUSIC")) {
    			helpObj.helper(music, arr);
    		}else if(arr[1].equals("PODCAST")) {
    			helpObj.helper(podcast, arr);
    		}else {
    			helpObj.helper(video, arr);
    		}
    	} else if(arr[0].equals("ADD_TOPUP")) {
    		helpObj.topupHelper(arr);
    	} else {
    		helpObj.printRecipt(music, podcast, video);
    	}
    }
}
