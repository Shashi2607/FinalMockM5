package com.crm.javaUtility;

import java.util.Random;

public class GenrateRandomNumbers {

	public static int random() {
		Random rd= new Random();
		int value=rd.nextInt(1000);
		return value;
	}
}
