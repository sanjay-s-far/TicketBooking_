package com.ticketbooking.Service;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

	public static void main(String[] args) {
		List<Integer> EvenNumberList = new ArrayList<>();
		for(int i = 0;i<=100;i++) {
			if(i % 2 == 0) {
//				System.out.print(i + " ");
				EvenNumberList.add(i);
			}
		}
		System.out.println(EvenNumberList);
       
	}

}
