package com.sly.algorithm;

public class bulling {

	static int[] result = new int[]{30,20,5,60,45,100,20,1,100,10,0};
	
	/**
	 * 20,5,30,60,45,100,
	 * @param args
	 */
	public static void main(String[] args) {
		
		for(int i=0;i<result.length-1;i++){
			
			for(int j=0;j<result.length-i-1;j++){
				if(result[j]>result[j+1]){
					int tmp = result[j];
					result[j] = result[j+1];
					result[j+1]=tmp;
				}
				
			}
				
		}
		for(int t:result){
			System.err.println(t);
		}		
	}
	
}
