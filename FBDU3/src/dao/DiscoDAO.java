package dao;

import java.util.List;

import model.Disco;



public interface DiscoDAO {
	void createDisco(Disco disco);
	Disco readDisco(int id);
	List<Disco> readAllDiscs();
	void updateDisco(Disco disco);
	void deleteDisco(int id);
	
}
