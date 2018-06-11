package web.GrapeVine.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

public class DataBaseService {
	
	//TODO make services call this class
	EntityManagerFactory entityManagerFactory = null;
	EntityManager entityManager = null;
	CriteriaBuilder criteriaBuilder = null;

	public DataBaseService() {
		super();
		this.init();
	}

	public DataBaseService(EntityManagerFactory entityManagerFactory, EntityManager entityManager,
			CriteriaBuilder criteriaBuilder) {
		super();
		this.entityManagerFactory = entityManagerFactory;
		this.entityManager = entityManager;
		this.criteriaBuilder = criteriaBuilder;
	}

	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		entityManager = entityManagerFactory.createEntityManager();
		criteriaBuilder = entityManager.getCriteriaBuilder();
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public CriteriaBuilder getCriteriaBuilder() {
		return criteriaBuilder;
	}

	public void setCriteriaBuilder(CriteriaBuilder criteriaBuilder) {
		this.criteriaBuilder = criteriaBuilder;
	}
	
}
