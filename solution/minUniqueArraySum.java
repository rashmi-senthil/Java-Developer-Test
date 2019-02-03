import java.util.*;
public class minUniqueArraySum {
	public static void main(String[] args){
	    Scanner in=new Scanner(System.in);
	    int a=in.nextInt();
	    int b[]=new int[a];
	    for(int i=0;i<a;i++){
	      b[i]=in.nextInt();
	    }
	    System.out.println(getMinimumUniqueSum(b));
	  }

	static int getMinimumUniqueSum(int[] arr) {
		Arrays.sort(arr);
	    int sum = arr[0];
	    int prev =arr[0];
	    for( int i = 1; i < arr.length; i++ ) {
	        int curr = arr[i];

	        if( prev >= curr ) {
	            curr = prev+1;
	        }
	        sum += curr;
	        prev = curr;
	    }
	    return sum;
	}
}
