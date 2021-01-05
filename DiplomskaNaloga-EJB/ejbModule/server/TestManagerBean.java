package server;

import java.util.List;

import javax.ejb.Stateless;

import entities.Test;

@Stateless
public class TestManagerBean extends AManager {

	@SuppressWarnings("unchecked")
	public List<Test> getAllTest() {
		List<Test> test = em.createQuery("select t from Test t where t.id='009'").getResultList();
		return test;
	}
}
