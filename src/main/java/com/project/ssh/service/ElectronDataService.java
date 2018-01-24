package com.project.ssh.service;

import java.util.List;

import com.project.ssh.domain.ElectronData;

public interface ElectronDataService {

boolean createData(ElectronData data);
	
	boolean updateData(ElectronData data);
	
	List<ElectronData> retrieveNewestData(String deviceId);
	
	List<ElectronData> retrieveUncheckedData(String deviceId);
	
}
