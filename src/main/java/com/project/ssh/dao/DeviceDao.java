package com.project.ssh.dao;


import java.util.List;

import com.project.ssh.domain.Device;

public interface DeviceDao {

	boolean createDevice(Device device);
	
	boolean updateDevice(Device device);
	
	boolean deleteDevice(String deviceId);
	
	List<Device> retrieveDevicesByOwner(String userId);

	Device retrieveDevice(String deviceId);
	
}
