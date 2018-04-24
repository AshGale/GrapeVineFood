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
import web.GrapeVine.resources.MemberResoure;

public class MemberService {


	EntityManagerFactory entityManagerFactory = null;
	EntityManager entityManager = null;
//	CriteriaBuilder criteriaBuilder = null;
//	CriteriaQuery<Object> criteriaQuery = null;
//	Root<Member> fromRoot = null;

	
	
	public MemberService() {
		super();
		this.init();
	}

	public MemberService(EntityManagerFactory entityManagerFactory, EntityManager entityManager,
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

	public Profile getMember(Long id) {
		
		//try http://localhost:8080/GrapeVine/api/member/1
		
		System.out.println("In getMember");
		
		//for save
		entityManager.getTransaction().begin();
		//Profile newProfile = new Profile();
		System.out.println("saving member");
		entityManager.persist(new Profile());
		System.out.println("commiting member");
		entityManager.getTransaction().commit();
		
		
		System.out.println("Starting Transaction");
		entityManager.getTransaction().begin();
		
		Profile profile = (Profile) entityManager.find(Profile.class, id);
		
		entityManager.getTransaction().commit();
		
		
		//List<MemberResoure> members = (List<MemberResoure>) criteriaQuery.where(criteriaBuilder.equal(fromRoot.get("id"), id));
		return profile;
		
	}
}
