package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.LogDaoI;
import co.edu.ue.model.Log;

@Service
public class LogService implements LogServiceI{
	@Autowired
	LogDaoI logDao;
	
	@Override
	public Log addLog(Log log) {
		// TODO Auto-generated method stub
		return logDao.addLog(log);
	}

	@Override
	public Log getLog(int id) {
		// TODO Auto-generated method stub
		return logDao.getLog(id);
	}

	@Override
	public List<Log> getAllLog() {
		// TODO Auto-generated method stub
		return logDao.getAllLog();
	}
}
