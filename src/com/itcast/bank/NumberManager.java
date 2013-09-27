package com.itcast.bank;

import java.util.ArrayList;
import java.util.List;

public class NumberManager {
	private int lastnumber = 1;
	private List<Integer> queueNumber = new ArrayList<Integer>();
	
	public synchronized Integer generateNumber() {
		queueNumber.add(lastnumber);
		return lastnumber++;
	}
	
	public synchronized Integer fetchNumber() {
		Integer number = null;
		if(queueNumber.size()>0) {
			number = queueNumber.remove(0);
		}
		return number;
	}
}
