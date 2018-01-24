package com.project.ssh.dao.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.ssh.dao.DeviceDao;
import com.project.ssh.dao.mybatis.QuickMatchSessionFactory;
import com.project.ssh.domain.Device;

@Repository
public class DeviceDaoImpl implements DeviceDao{
	
	private QuickMatchSessionFactory factory;
	
	public DeviceDaoImpl() {
		factory  = QuickMatchSessionFactory.getInstance();
	}

	@Override
	public boolean createDevice(Device device) {
		SqlSession session = factory.getSession();
		
		int cnt = 0;
		try{
		
				cnt = session.insert("createDevice", device);
				session.commit();
		}catch(Exception e){
			return false;
		}finally{
			session.close();
		}
		return cnt > 0;
		
	}

	@Override
	public boolean updateDevice(Device device) {
		SqlSession session = factory.getSession();
		int cnt = 0;
		try{
				cnt = session.update("updateDevice", device);
				session.commit();
		}catch(Exception e){
			return false;
		}finally {
			session.close();
		}
		
		return cnt > 0;
	}

	@Override
	public boolean deleteDevice(String deviceId) {
		SqlSession session = factory.getSession();
		int cnt = 0;
		try{
				cnt = session.delete("deleteDevice", deviceId);
				System.out.println("in deleteDaoImpl");
				session.commit();
		}catch(Exception e){
			return false;
		}finally{
			session.close();
		}
		return cnt > 0;
	}

	@Override
	public List<Device> retrieveDevicesByOwner(String userId) {
		SqlSession session = factory.getSession();
		try{
			List<Device> deviceList = session.selectList("retrieveDevicesByOwner", userId);
			return deviceList;
		}catch(Exception e){
			return null;
		}finally{
			session.close();
		}
	}

	@Override
	public Device retrieveDevice(String deviceId) {
		System.out.println("Device dao");
		SqlSession session = factory.getSession();
		try{
			Device device = session.selectOne("retrieveDevice", deviceId);
			return device;
		}catch(Exception e){
			return null;
		}finally{
			session.close();
		}
	}
	
	

}
