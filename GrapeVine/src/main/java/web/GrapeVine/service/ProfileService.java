package web.GrapeVine.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Root;

import org.hibernate.cfg.Configuration;

import web.GrapeVine.modules.Profile;
import web.GrapeVine.resources.ProfileResoure;

public class ProfileService {


	EntityManagerFactory entityManagerFactory = null;
	EntityManager entityManager = null;
//	CriteriaBuilder criteriaBuilder = null;
//	CriteriaQuery<Object> criteriaQuery = null;
//	Root<Member> fromRoot = null;

	
	
	public ProfileService() {
		super();
		this.init();
	}

	public ProfileService(EntityManagerFactory entityManagerFactory, EntityManager entityManager,
			CriteriaBuilder criteriaBuilder, CriteriaQuery<Object> criteriaQuery, Root<Profile> fromRoot) {
		super();
		this.entityManagerFactory = entityManagerFactory;
		this.entityManager = entityManager;
//		this.criteriaBuilder = criteriaBuilder;
//		this.criteriaQuery = criteriaQuery;
//		this.fromRoot = fromRoot;
	}

	public void init() {
		System.out.println("Initilizing");
		//configuration = new Configuration().configure("persistence.xml");//na not working
		entityManagerFactory = Persistence
				.createEntityManagerFactory("hibernate");
		System.out.println("made factory");
		entityManager = entityManagerFactory.createEntityManager();
		//criteriaBuilder = entityManager.getCriteriaBuilder();
		//criteriaQuery = criteriaBuilder.createQuery();
		//fromRoot = criteriaQuery.from(Member.class);
		//criteriaQuery.select(fromRoot);
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
		//entityManager.flush();
		return profile;
	}

	public Profile updateProfile(Profile profile) {

		entityManager.getTransaction().begin();
		entityManager.persist(profile);
		//Profile dbProfile = (Profile) entityManager.find(Profile.class, profile.getId());
		//dbProfile = profile;
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
		
		Profile dbProfile = (Profile) entityManager.find(Profile.class, 1);//TODO add in Criteria
		
		entityManager.getTransaction().commit();
		entityManager.flush();
		return dbProfile;
	}

}
