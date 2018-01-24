package com.project.ssh.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ssh.dao.DeviceDao;
import com.project.ssh.dao.Impl.DeviceDaoImpl;
import com.project.ssh.domain.Device;
import com.project.ssh.service.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService{

	
	@Autowired
	private DeviceDao deviceDao;
	
	
	public DeviceServiceImpl(){
		deviceDao = new DeviceDaoImpl();
	}
	@Override
	public boolean registDevice(Device device) {
		return deviceDao.createDevice(device);
	}

	@Override
	public boolean modifyDevice(Device device) {
		return deviceDao.updateDevice(device);
	}

	@Override
	public boolean removeDevice(String deviceId) {
		System.out.println("In service");
		return deviceDao.deleteDevice(deviceId);
	}

	@Override
	public List<Device> findDevicesByOwner(String userId) {
		return deviceDao.retrieveDevicesByOwner(userId);
	}
	@Override
	public Device findDevice(String deviceId) {
		return deviceDao.retrieveDevice(deviceId);
	}

}
