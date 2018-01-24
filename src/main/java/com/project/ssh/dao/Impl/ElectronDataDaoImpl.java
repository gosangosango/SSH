package com.project.ssh.dao.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.ssh.dao.ElectronDataDao;
import com.project.ssh.dao.mybatis.QuickMatchSessionFactory;
import com.project.ssh.domain.ElectronData;

@Repository	
public class ElectronDataDaoImpl implements ElectronDataDao {
	
	private QuickMatchSessionFactory factory;
	
	public ElectronDataDaoImpl() {
		factory = QuickMatchSessionFactory.getInstance();
	}
	
	@Override
	public boolean createData(ElectronData data) {
		SqlSession session = factory.getSession();
		int result = session.insert("createData", data);
		if(result != 0){
			session.commit();
		}
		return result > 0;
	}
	
	@Override
	public boolean updateData(ElectronData data){
		SqlSession session = factory.getSession();
		int result = session.update("updateData", data);
		if(result != 0){
			session.commit();
		}
		return result > 0;
	}

	@Override
	public List<ElectronData> retrieveNewestData(String deviceId) {
		SqlSession session = factory.getSession();
		List<ElectronData> datas = session.selectList("retrieveNewestData", deviceId);
		return datas;
	}

	@Override
	public List<ElectronData> retrieveUncheckedData(String deviceId) {
		SqlSession session = factory.getSession();
		List<ElectronData> datas = session.selectList("retrieveUncheckedData", deviceId);
		return datas;
	}
	

}
