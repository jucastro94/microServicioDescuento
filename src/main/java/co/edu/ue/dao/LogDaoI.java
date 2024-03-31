package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.model.Log;

public interface LogDaoI {
	Log addLog(Log log);
	Log getLog(int id);
	List<Log>getAllLog();
}
