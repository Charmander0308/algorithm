package sep2025.day19_0909.BOJ.sum3273;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> numlist = new ArrayList<>();
		for(int i=0; i<n; i++) {
			numlist.add(sc.nextInt());
		}
		int x = sc.nextInt();
		int count = 0;
		numlist.sort(Comparator.naturalOrder());
		
		int start = 0;
		int end = numlist.size()-1;
		
		//점점 서로에게 다가가는..
		while(start < end) {
			int sum = numlist.get(start) + numlist.get(end);
			
			if(sum == x) {
				count++;
				start++;
			} else if(sum > x) {
				end--;
			} else if(sum < x) {
				start++;
			}
		}
		System.out.println(count);
		
	}
}
