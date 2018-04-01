
import java.util.*;
import java.awt.*;

public class RunLikeHell {
	
	
	//Begin recusrive call
	public static int maxGain(int [] array){
	
		
		return maxGain (array,array.length);
		
		
	}
	

	
public static int maxGain(int [] arr, int pos){
		
		
	int [] dp = new int[pos+1];
	int length = pos,temp=0;
	dp[0]=0;
	int [] array=new int[pos+3];
	
	//makes array with 3 more zeros for the overflow.
	for(int i=0;i<arr.length+3;i++){
		if(i<arr.length){
			array[i]=arr[i];	
		}
		else{
			array[i]=0;
		}
	}
	
	boolean flag = false;
	
	// run through array and check to make sure position n + (n+2) > n+1 if so take n, if not don't take n. If n is taken skip one cycle of the relation.
	for(int i=0;i<length;i++){
		
		if(flag==true){
			flag=false;
			dp[i+1]=dp[i];
			continue;
		}
		else{
			
			if(array[i+1]<array[i+2]+array[i]){
				temp=array[i];
				flag=true;
			}
			else{
				temp=0;
			}
			
			dp[i+1]=temp+dp[i];
			
		}
		
	}
	
	for(int i=0;i<length+1;i++){
		
		System.out.print(dp[i]+" ");
	}
		System.out.println();
	
	return dp[length];
}
	
	public static void main (String [] args){
		
			
			int [] arr = new int [] {3,2,10,300,15,13,12,200};
			
			System.out.println(maxGain(arr));
		
		
	}
	
	public static double difficultyRating() {
		
		return 3;
		
	}
	
	public static double hoursSpent() {
		
		return 5;
		
	}
}