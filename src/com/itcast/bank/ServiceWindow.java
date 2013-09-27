package com.itcast.bank;

import java.util.Random;
import java.util.concurrent.Executors;

public class ServiceWindow {
	protected static final int MAX_SERVICE_TIME = 10000;
	protected static final int MIN_SERVICE_TIME = 1000;
	private int windowid = 1;
	private CustomerType type = CustomerType.COMMON;
	

	public void setWindowid(int windowid) {
		this.windowid = windowid;
	}

	public void setType(CustomerType type) {
		this.type = type;
	}

	public void start() {
		Executors.newSingleThreadExecutor().execute(new Runnable(){
			public void run() {
				while(true) {
					switch(type) {
						case COMMON: 
							commonService();
							break;
						case EXPRESS:
							expressService();
							break;
						case VIP:
							VIPService();
							break;
					}
				}
			}
		});
	}

	private void commonService() {
		String windowName = "第"+windowid+"号"+type+"窗口";
		Integer number = NumberMachine.getInstance().getCommonManager().fetchNumber();
		System.out.println(windowName+"正在获取业务");
		if(number!=null) {
			System.out.println(windowName+"正在为第"+number+"个普通客户服务");
			long beginTime = System.currentTimeMillis();
			int rangeNumber = MAX_SERVICE_TIME - MIN_SERVICE_TIME;
			long serverTime = new Random().nextInt(rangeNumber)+MIN_SERVICE_TIME;
			try {
				Thread.sleep(serverTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long elapsedTime = System.currentTimeMillis() - beginTime;
			System.out.println(windowName+"为第"+number+"个普通客户完成服务，耗时"+elapsedTime/1000+"秒");
		}
		else {
			System.out.println(windowName+"没有获取到业务");
			System.out.println("等待1秒叫下一位");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void expressService() {
		String windowName = "第"+windowid+"号"+type+"窗口";
		Integer number = NumberMachine.getInstance().getExpressManager().fetchNumber();
		System.out.println(windowName+"正在获取业务");
		if(number!=null) {
			System.out.println(windowName+"正在为第"+number+"个"+type+"服务");
			long beginTime = System.currentTimeMillis();			
			try {
				Thread.sleep(MIN_SERVICE_TIME);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long elapsedTime = System.currentTimeMillis() - beginTime;
			System.out.println(windowName+"为第"+number+"个"+type+"完成服务，耗时"+elapsedTime/1000+"秒");
		}
		else {
			System.out.println(windowName+"没有获取到业务");
			commonService();
		}
	}
	
	private void VIPService() {
		String windowName = "第"+windowid+"号"+type+"窗口";
		Integer number = NumberMachine.getInstance().getVIPManager().fetchNumber();
		System.out.println(windowName+"正在获取业务");
		if(number!=null) {
			System.out.println(windowName+"正在为第"+number+"个"+type+"服务");
			long beginTime = System.currentTimeMillis();
			int rangeNumber = MAX_SERVICE_TIME - MIN_SERVICE_TIME;
			long serverTime = new Random().nextInt(rangeNumber)+MIN_SERVICE_TIME;
			try {
				Thread.sleep(serverTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long elapsedTime = System.currentTimeMillis() - beginTime;
			System.out.println(windowName+"为第"+number+"个"+type+"完成服务，耗时"+elapsedTime/1000+"秒");
		}
		else {
			System.out.println(windowName+"没有获取到业务");
			commonService();
		}
	}
}
