package test;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.City;


@Stateless
public class CityManagerBean {

	@PersistenceContext(unitName="DiplomskaNaloga-JPA")
	protected EntityManager entityManager;
	
	
	@SuppressWarnings("unchecked")
	public List<City> getCities() {
		Query q = entityManager.createQuery("SELECT c from City c", City.class);
		List<City> cities = q.getResultList();
		return cities;
	}
}
