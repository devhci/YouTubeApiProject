package com.iitk.youtube.test;

import java.util.List;
import java.util.Scanner;

import com.iitk.youtube.Manager.YouTubeManager;
import com.iitk.youtube.model.YouTubeVideo;

public class YouTubeTester {
	
	public static void main(String[] args) throws Exception {
		
		String clientID = "TodayNews";
		String textQuery ;//= "java code";
		int maxResults = 5;
		boolean filter = true;
		int timeout = 2000;
		int count=1;
		Scanner in = new Scanner(System.in);
	
		/*try {
		     String url = "http://www.google.com";
		     java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
		} catch (java.io.IOException e) {
		     System.out.println(e.getMessage());
		}*/
		
		
		textQuery=in.nextLine();
		
		YouTubeManager ym = new YouTubeManager(clientID);
		
		List<YouTubeVideo> videos = ym.retrieveVideos(textQuery, maxResults, filter, timeout);
		
		for (YouTubeVideo youtubeVideo : videos) {
			System.out.println("Count=" +count++);
			System.out.println(youtubeVideo.getWebPlayerUrl());
			
			try {
			     //String url = "http://www.google.com";
			     java.awt.Desktop.getDesktop().browse(java.net.URI.create(youtubeVideo.getWebPlayerUrl()));
			} catch (java.io.IOException e) {
			     System.out.println(e.getMessage());
			}
			System.out.println("Thumbnails");
			for (String thumbnail : youtubeVideo.getThumbnails()) {
				System.out.println("\t" + thumbnail);
			}
			System.out.println(youtubeVideo.getEmbeddedWebPlayerUrl());
			System.out.println("**************************************************");
		}
		
	}

}
