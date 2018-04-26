package web.GrapeVine.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

import web.GrapeVine.modules.Profile;

public class ProfileService {

	EntityManagerFactory entityManagerFactory = null;
	EntityManager entityManager = null;
	CriteriaBuilder criteriaBuilder = null;

	public ProfileService() {
		super();
		this.init();
	}

	public ProfileService(EntityManagerFactory entityManagerFactory, EntityManager entityManager,
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

	public Profile getProfile(Long id) {

		entityManager.getTransaction().begin();
		Profile profile = (Profile) entityManager.find(Profile.class, id);
		entityManager.getTransaction().commit();
		return profile;
	}

	public Profile createProfile(Profile profile) {

		entityManager.getTransaction().begin();
		entityManager.persist(profile);
		entityManager.getTransaction().commit();
		// entityManager.flush();
		return profile;
	}

	public Profile updateProfile(Profile profile) {

		entityManager.getTransaction().begin();
		entityManager.persist(profile);
		// Profile dbProfile = (Profile) entityManager.find(Profile.class,
		// profile.getId());
		// dbProfile = profile;
		entityManager.getTransaction().commit();
		entityManager.flush();
		return profile;
	}

	public void deleteProfile(Profile profile) {
		entityManager.getTransaction().begin();
		entityManager.remove(profile);
		entityManager.getTransaction().commit();
		entityManager.flush();

	}

	public Profile getProfile(String username, String password) {

		entityManager.getTransaction().begin();

		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<Profile> fromRoot = criteriaQuery.from(Profile.class);
		criteriaQuery.select(fromRoot);

		criteriaQuery.where(criteriaBuilder.equal(fromRoot.get("userName"), username),
				criteriaBuilder.equal(fromRoot.get("password"), password));

		List<Object> resultList = entityManager.createQuery(criteriaQuery).getResultList();
		Profile dbProfile = null;
		if (resultList.isEmpty()) {
			// Handle Error
		} else {
			dbProfile = (Profile) resultList.get(0);
		}

		entityManager.getTransaction().commit();
		return dbProfile;
	}
}
