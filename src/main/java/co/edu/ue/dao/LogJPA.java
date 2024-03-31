package co.edu.ue.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.model.Log;

public interface LogJPA extends JpaRepository<Log, Integer>{

}
