package com.itcast.bank;

public class NumberMachine {
	private NumberManager commonManager = new NumberManager();
	private NumberManager expressManager = new NumberManager();
	private NumberManager VIPManager = new NumberManager();
	
	private static NumberMachine instance = null;	
	private NumberMachine() {}
	public static NumberMachine getInstance() {
		if(instance == null) {
			instance = new NumberMachine();
		}
		return instance;
	}
	
	public NumberManager getCommonManager() {
		return commonManager;
	}
	public NumberManager getExpressManager() {
		return expressManager;
	}
	public NumberManager getVIPManager() {
		return VIPManager;
	}
	
	
}
