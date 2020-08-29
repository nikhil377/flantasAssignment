/*
Steps to execute code-->

javac templeCost.java
java templeCost

sample input- 
4
4
300 400 600 700
2
1321 2450
3
500 123 873
4
600 800 150 700

*/
import java.util.*; 

public class templeCost 
{ 
	
	static long minCostRequired(long cost[], int n) 
	{ 
	    long finalCost = 0; 
		Arrays.sort(cost); 
		
	    for (int i = n - 1; i > 1; i=i-2) 
		{ 
			if (i == 2) 
			{ 
				finalCost = finalCost+ cost[2] + cost[0]; 
			} 
			else
			{ 
	
				long costFirstTime = cost[i] + cost[0] + 2 * cost[1]; 
				long costSecondTime = cost[i] + cost[i - 1] + 2 * cost[0]; 
				finalCost = finalCost + Math.min(costFirstTime, costSecondTime); 
			} 
		} 
		if (n == 1) 
		{ 
			finalCost += cost[0]; 
		} 
		else
		{ 
			finalCost += cost[1]; 
		} 
	
		return finalCost; 
	} 
	
	public static void main (String[] args) 
	{ 
	    long cost[];
	    Scanner sc= new Scanner(System.in);
	    int testCases= sc.nextInt();  // number of test cases input
	    
	    for(int i=0;i<testCases;i++){
	        int numberOfPerson =sc.nextInt();  // number of person in total
	        cost=new long[numberOfPerson];
	        for(int j=0;j<numberOfPerson;j++){
	            cost[j]=sc.nextInt(); // cost input
	        }
	        System.out.println(minCostRequired(cost, numberOfPerson));  // method call
	    }
	} 
} 
