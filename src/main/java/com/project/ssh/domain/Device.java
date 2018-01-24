package com.project.ssh.domain;

public class Device {
	private String deviceId;
	private String deviceName;
	private String deviceOwner;
	private String deviceUser;
	private String deviceUserPH;
	
	
	
	public Device() {
		super();
	}
	
	
	

	public Device(String deviceId, String deviceName, String deviceOwner, String deviceUser, String deviceUserPH) {
		super();
		this.deviceId = deviceId;
		this.deviceName = deviceName;
		this.deviceOwner = deviceOwner;
		this.deviceUser = deviceUser;
		this.deviceUserPH = deviceUserPH;
	}




	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceOwner() {
		return deviceOwner;
	}
	public void setDeviceOwner(String deviceOwner) {
		this.deviceOwner = deviceOwner;
	}
	public String getDeviceUser() {
		return deviceUser;
	}
	public void setDeviceUser(String deviceUser) {
		this.deviceUser = deviceUser;
	}
	public String getDeviceUserPH() {
		return deviceUserPH;
	}
	public void setDeviceUserPH(String deviceUserPH) {
		this.deviceUserPH = deviceUserPH;
	}




	public String getDeviceName() {
		return deviceName;
	}




	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}




	@Override
	public String toString() {
		return "Device [deviceId=" + deviceId + ", deviceName=" + deviceName + ", deviceOwner=" + deviceOwner
				+ ", DeviceUser=" + deviceUser + ", DeviceUserPH=" + deviceUserPH + "]";
	}
	
	
	
	
	
	
	
}
