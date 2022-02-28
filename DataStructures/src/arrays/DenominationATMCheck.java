package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DenominationATMCheck {
	
	public static int possibleChange(int amount, List<Integer> denominations, int preferredDeno) {
		
		Collections.sort(denominations, Comparator.reverseOrder());
		
		int deno[] = new int[6];
		int count[] = new int[6];
		int i = 0;
		
		
		for (int denomination : denominations) {
			int number = amount /denomination;
			deno[i] = denomination;
			count[i] = number;
			i++;
		}
		
		
		if (preferredDeno > amount)
			return -1;
		
		int locationofpreferred = Arrays.binarySearch(deno, preferredDeno);
		amount = amount - preferredDeno*count[locationofpreferred];
		
		if (amount == 0)
			return 1;
		
		int returncount = 0;
		
		for (int j = locationofpreferred+1; j < deno.length; j++ ) {
			int tempamount = amount;
			for (int k = j; k<deno.length; k++) {
				
				int tempamountnumber = tempamount/deno[k];
				if (tempamountnumber == 0) {
					break;
				}
				
				tempamount = tempamount - (tempamountnumber)*deno[k];
				
				if (tempamount > 0)
					continue;
				
				if (tempamount == 0) {
					returncount++;	
					break;
				}						
			}
		}		
		return returncount;
	}
	
	
	
	

	public static void main(String[] args) {
		int amount = 1300;
		List<Integer> denominations = Arrays.asList(100,200,300,500,1000,2000);
		int preferredDeno = 500;
		System.out.println(possibleChange(1300, denominations, preferredDeno));

	}

}
