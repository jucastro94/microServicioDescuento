package co.edu.ue.service;

import java.util.List;

import co.edu.ue.model.Log;

public interface LogServiceI {
	Log addLog(Log log);
	Log getLog(int id);
	List<Log>getAllLog();
}
