package boj;

import java.util.*;

class Info {
	int weight;
	int height;
	int rank;
	
	public Info(int weight, int height) {
		this.weight = weight;
		this.height = height;
		this.rank = 0;
	}
}

public class BOJ_7568 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		Info[] people = new Info[n];
		boolean[] check = new boolean[n];
		
		for(int i=0; i<n; i++) {
			int weight = scan.nextInt();
			int height = scan.nextInt();
			people[i] = new Info(weight, height);
		}
		compare(people, check, 0);
		printResult(people);
	}
	
	public static void compare(Info[] people, boolean[] check, int index) {
		// ±âÀú
		if(index == people.length-1) {
			return;
		}
		
		for(int i=index+1; i<people.length; i++) {
			if(!check[index]) {
				if(people[index].height > people[i].height && people[index].weight > people[i].weight) {
					people[i].rank++;
				}
				else if(people[index].height < people[i].height && people[index].weight < people[i].weight) {
					people[index].rank++;
				}
				compare(people, check, index+1);
			}
		}
		check[index] = true;
	}
		
	public static void printResult(Info[] people) {
		for(int i=0; i<people.length; i++) {
			System.out.print((people[i].rank + 1) + " ");
		}
	}
}