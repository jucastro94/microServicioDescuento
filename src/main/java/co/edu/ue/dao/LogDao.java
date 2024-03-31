package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.model.Log;

@Repository
public class LogDao implements LogDaoI{
	@Autowired
	LogJPA logJPA;

	@Override
	public Log addLog(Log log) {
		// TODO Auto-generated method stub
		return logJPA.save(log);
	}

	@Override
	public Log getLog(int id) {
		// TODO Auto-generated method stub
		return logJPA.findById(id).orElse(null);
	}

	@Override
	public List<Log> getAllLog() {
		// TODO Auto-generated method stub
		return logJPA.findAll();
	}
}
