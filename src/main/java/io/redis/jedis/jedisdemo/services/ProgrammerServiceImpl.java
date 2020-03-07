package io.redis.jedis.jedisdemo.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.redis.jedis.jedisdemo.dao.ProgrammerRepository;
import io.redis.jedis.jedisdemo.model.Programmer;

@Service
public class ProgrammerServiceImpl implements ProgrammerService {

	@Autowired
	ProgrammerRepository repository;

	@Override
	public void setProgrammerAsString(String idKey, String programmer) {
		repository.setProgrammerAsString(idKey, programmer);
	}

	@Override
	public String getProgrammerAsString(String idKey) {
		return repository.getProgrammerAsString(idKey);
	}
	
	
	//List
	
	@Override
	public void AddToProgrammerList(Programmer programmer) {
		repository.AddToProgrammerList(programmer);
	}

	@Override
	public List<Programmer> getProgrammerListMember() {
		return repository.getProgrammerListMember();
	}

	@Override
	public Long getProgrammerListCount() {
		return repository.getProgrammerListCount();
	}
	
	//Set

	@Override
	public void AddToProgrammerSet(Programmer... programmer) {
		repository.AddToProgrammerSet(programmer);
	}

	@Override
	public Set<Programmer> getProgrammerSetsMember() {
		return repository.getProgrammerSetsMember();
	}

	@Override
	public boolean isSetMember(Programmer programmer) {
		return repository.isSetMember(programmer);
	}
	
	
	//Hash
	
	@Override
	public void saveHash(Programmer programmer) {
		repository.saveHash(programmer);
	}

	@Override
	public void updateHash(Programmer programmer) {
		repository.updateHash(programmer);
	}

	@Override
	public Map<Integer, Programmer> findAllHash() {
		return repository.findAllHash();
	}

	@Override
	public Programmer findInHash(int id) {
		return repository.findInHash(id);
	}

	@Override
	public void deleteHash(int id) {
		repository.deleteHash(id);
	}

	
	
}
