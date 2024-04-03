package com.john.abstractinterface;

public class Nokia extends Phone implements Chargeable {

	public Nokia(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);

	}

	@Override
	public void displayInfo() {
		System.out.println("Nokia display:\n version:" + this.getVersionNumber() + "\n battery: " + this.getBatteryPercentage() + "\n on " + this.getCarrier() + " network");

	}

	@Override
	public void notificationRing() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int chargeInfo() {
		// TODO Auto-generated method stub
		return 0;
	}

}
