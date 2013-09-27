package com.itcast.bank;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainClass {

	private static final long COMMON_CUSTOMER_INTERVAL_TIME = 1;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i=1; i<5; i++) {
			ServiceWindow commonWindow = new ServiceWindow();
			commonWindow.setWindowid(i);
			commonWindow.start();
		}
		
		ServiceWindow expressWindow = new ServiceWindow();
		expressWindow.setType(CustomerType.EXPRESS);
		expressWindow.start();
		
		ServiceWindow VIPWindow = new ServiceWindow();
		VIPWindow.setType(CustomerType.VIP);
		VIPWindow.start();
		
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(
				new Runnable() {

					@Override
					public void run() {
						int number = NumberMachine.getInstance().getCommonManager().generateNumber();
						System.out.println(number+"号普通客户等待服务");
					}
					
				}, 
				0, 
				COMMON_CUSTOMER_INTERVAL_TIME, 
				TimeUnit.SECONDS);
		
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(
				new Runnable() {

					@Override
					public void run() {
						int number = NumberMachine.getInstance().getExpressManager().generateNumber();
						System.out.println(number+"号快速客户等待服务");
					}
					
				}, 
				0, 
				COMMON_CUSTOMER_INTERVAL_TIME*2, 
				TimeUnit.SECONDS);
		
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(
				new Runnable() {

					@Override
					public void run() {
						int number = NumberMachine.getInstance().getVIPManager().generateNumber();
						System.out.println(number+"号VIP客户等待服务");
					}
					
				}, 
				0, 
				COMMON_CUSTOMER_INTERVAL_TIME*6, 
				TimeUnit.SECONDS);
	}

}
