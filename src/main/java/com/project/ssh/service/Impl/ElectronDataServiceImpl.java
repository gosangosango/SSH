package com.project.ssh.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ssh.dao.ElectronDataDao;
import com.project.ssh.dao.Impl.ElectronDataDaoImpl;
import com.project.ssh.domain.ElectronData;
import com.project.ssh.service.ElectronDataService;

@Service
public class ElectronDataServiceImpl implements ElectronDataService {

	@Autowired
	private ElectronDataDao dao = new ElectronDataDaoImpl();
	@Override
	public boolean createData(ElectronData data) {
		
		return dao.createData(data);
	}

	@Override
	public boolean updateData(ElectronData data) {
		
		return dao.updateData(data);
	}

	@Override
	public List<ElectronData> retrieveNewestData(String deviceId) {
		
		return dao.retrieveNewestData(deviceId);
	}

	@Override
	public List<ElectronData> retrieveUncheckedData(String deviceId) {
		
		return dao.retrieveUncheckedData(deviceId);
	}

}
