package com.itcast.bank;

public enum CustomerType {
	COMMON,EXPRESS,VIP;

	@Override
	public String toString() {
		switch(this) {
		case COMMON:
			return "��ͨ�ͻ�";
		case EXPRESS:
			return "���ٿͻ�";
		case VIP:
			return "VIP�ͻ�";
		}
		return null;
	}
	
	
}
