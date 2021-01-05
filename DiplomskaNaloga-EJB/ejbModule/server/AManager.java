package server;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AManager {
	@PersistenceContext(unitName = "DiplomskaNaloga-JPA")
	protected EntityManager em;
}
