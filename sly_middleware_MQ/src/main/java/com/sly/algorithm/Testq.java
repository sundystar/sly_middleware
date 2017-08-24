package com.sly.algorithm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Testq {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(1);
		service.submit(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
}
