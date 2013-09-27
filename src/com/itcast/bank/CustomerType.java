package com.itcast.bank;

public enum CustomerType {
	COMMON,EXPRESS,VIP;

	@Override
	public String toString() {
		switch(this) {
		case COMMON:
			return "普通客户";
		case EXPRESS:
			return "快速客户";
		case VIP:
			return "VIP客户";
		}
		return null;
	}
	
	
}
