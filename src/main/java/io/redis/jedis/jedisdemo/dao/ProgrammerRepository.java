package io.redis.jedis.jedisdemo.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import io.redis.jedis.jedisdemo.model.Programmer;

public interface ProgrammerRepository {

	void setProgrammerAsString(String idKey, String programmer);

	String getProgrammerAsString(String idKey);

	// list
	void AddToProgrammerList(Programmer programmer);

	List<Programmer> getProgrammerListMember();

	Long getProgrammerListCount();

	// Set
	void AddToProgrammerSet(Programmer... programmer);

	Set<Programmer> getProgrammerSetsMember();

	boolean isSetMember(Programmer programmer);

	// hash
	void saveHash(Programmer programmer);

	void updateHash(Programmer programmer);

	Map<Integer, Programmer> findAllHash();

	Programmer findInHash(int id);

	void deleteHash(int id);

}
