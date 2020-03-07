package io.redis.jedis.jedisdemo.controllers;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.redis.jedis.jedisdemo.model.Programmer;
import io.redis.jedis.jedisdemo.services.ProgrammerService;

@RestController
public class ProgrammerController {

	@Autowired
	ProgrammerService programmerService;

	@RequestMapping(method = RequestMethod.POST, value = "/programmer-string")
	public void addTopic(@RequestBody Programmer programmer) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		programmerService.setProgrammerAsString(String.valueOf(programmer.getId()),
				mapper.writeValueAsString(programmer));

	}

	@RequestMapping("/programmer-string/{id}")
	public String readString(@PathVariable String id) {
		return programmerService.getProgrammerAsString(id);
	}

	/***** LIST PROGRAMMER DEMO *****/
	// add programmer to list
	@RequestMapping(method = RequestMethod.POST, value = "/programmers-list")
	public void addToProgrammerList(@RequestBody Programmer programmer) {
		programmerService.AddToProgrammerList(programmer);
	}

	@RequestMapping("/programmers-list")
	public List<Programmer> getProgrammerListMembers() {
		return programmerService.getProgrammerListMember();
	}

	@RequestMapping("/programmers-list/count")
	public Long getProgrammerListCount() {
		return programmerService.getProgrammerListCount();
	}

	/***** SET PROGRAMMER DEMO *****/

	// add programmer to set
	@RequestMapping(method = RequestMethod.POST, value = "/programmers-set")
	public void addToProgrammerSet(@RequestBody Programmer... programmer) {
		programmerService.AddToProgrammerSet(programmer);
	}

	// get all programmer from set
	@RequestMapping("/programmers-set")
	public Set<Programmer> getProgrammerSetMembers() {
		return programmerService.getProgrammerSetsMember();
	}

	// check if programmer already exists in the set
	@RequestMapping(method = RequestMethod.POST, value = "/programmers-set/member")
	public boolean isSetMember(@RequestBody Programmer programmer) {
		return programmerService.isSetMember(programmer);
	}

	// ***************HASH DEMO *********************/

	// add Programmer to Hash
	@RequestMapping(method = RequestMethod.POST, value = "/programmers-hash")
	public void saveHash(@RequestBody Programmer programmer) {
		programmerService.saveHash(programmer);
	}

	// update all programmer in Hash
	@RequestMapping(method = RequestMethod.PUT, value = "/programmers-hash")
	public void updateHash(@RequestBody Programmer programmer) {
		programmerService.updateHash(programmer);
	}

	// get all programmers from hash
	@RequestMapping(method = RequestMethod.GET, value = "/programmers-hash")
	public Map<Integer, Programmer> findAllHash() {
		return programmerService.findAllHash();
	}

	// get programmer from hash
	@RequestMapping(method = RequestMethod.GET, value = "/programmers-hash/{id}")
	public Programmer findAllHash(@PathVariable int id) {
		return programmerService.findInHash(id);
	}

	// delete programmer from hash
	@RequestMapping(method = RequestMethod.DELETE, value = "/programmers-hash/{id}")
	public void deleteHash(@PathVariable int id) {
		programmerService.deleteHash(id);
	}

}
