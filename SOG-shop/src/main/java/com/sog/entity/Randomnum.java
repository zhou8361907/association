package com.sog.entity;



public class Randomnum {

	    


	 public  int[] randomSet(int min, int max, int n2){  
		    if (n2 > (max - min + 1) || max < min) {  
		           return null;  
		       }  
		    int[] result = new int[n2];  
		    int count = 0;  
		    while(count < n2) {  
		        int num = (int) (Math.random() * (max - min)) + min;  
		        boolean flag = true;  
		        for (int j = 0; j < n2; j++) {  
		            if(num == result[j]){  
		                flag = false;  
		                break;  
		            }  
		        }  
		        if(flag){  
		            result[count] = num;  
		            count++;  
		        }  
		    }  
		    return result;  
		}  

}
