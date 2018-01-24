package com.project.ssh.service;

import java.util.List;

import com.project.ssh.domain.Device;

public interface DeviceService {

	boolean registDevice(Device device);
	
	boolean modifyDevice(Device device);
	
	boolean removeDevice(String deviceId);
	
	List<Device> findDevicesByOwner(String userId);
	
	Device findDevice(String deviceId);
}
