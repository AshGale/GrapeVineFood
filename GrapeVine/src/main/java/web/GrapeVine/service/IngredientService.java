package web.GrapeVine.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

import web.GrapeVine.modules.Allergy;
import web.GrapeVine.modules.Ingredient;
import web.GrapeVine.modules.Nutrition;

public class IngredientService {

	EntityManagerFactory entityManagerFactory = null;
	EntityManager entityManager = null;
	CriteriaBuilder criteriaBuilder = null;

	public IngredientService() {
		super();
		this.init();
	}

	public IngredientService(EntityManagerFactory entityManagerFactory, EntityManager entityManager,
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

	public Ingredient getIngredient(Long id) {

		entityManager.getTransaction().begin();
//		//TODO remove test code http://localhost:8080/GrapeVine/api/ingredient/0
//		Allergy allergy = new Allergy();
//		allergy.setNut(true);
//		allergy.setSulfites(true);
//		allergy.setTartrazine(true);
//		allergy.setFruit(true);
//		
//		Nutrition nutrition = new Nutrition();
//		nutrition.setCalcium(0);
//		nutrition.setFiber(30);
//		nutrition.setFat(4);
//		
//		Ingredient newIngredient = new Ingredient();
//		newIngredient.setName("Orange");
//		newIngredient.setSingleWeight(80);
//		newIngredient.setAllergy(allergy);
//		newIngredient.setNutritionalValue(nutrition);
//		
//		//entityManager.persist(allergy);
//		entityManager.persist(newIngredient);
//		entityManager.flush();
//		Long dbid = newIngredient.getIdIngredient();
//		Ingredient dbIngredient = (Ingredient) entityManager.find(Ingredient.class, dbid);
//		entityManager.getTransaction().commit();
//		return dbIngredient;
//		//end test code
		
		
		Ingredient Ingredient = (Ingredient) entityManager.find(Ingredient.class, id);
		entityManager.getTransaction().commit();
		return Ingredient;
	}

	public Ingredient createIngredient(Ingredient Ingredient) {

		entityManager.getTransaction().begin();
		entityManager.persist(Ingredient);
		entityManager.getTransaction().commit();
		return Ingredient;
	}

	public Ingredient updateIngredient(Ingredient Ingredient) {
		System.out.println("update");
		entityManager.getTransaction().begin();
		 Ingredient dbIngredient = (Ingredient) entityManager.find(Ingredient.class,Ingredient.getIdIngredient());
		 
		 entityManager.merge(Ingredient);

		entityManager.getTransaction().commit();
		return Ingredient;
	}

	public void deleteIngredient(Ingredient Ingredient) {
		entityManager.getTransaction().begin();
		entityManager.remove(Ingredient);
		entityManager.getTransaction().commit();

	}

	public List<Ingredient> getIngredient(String name) {
		
		//http://www.baeldung.com/jpa-pagination
		entityManager.getTransaction().begin();

		CriteriaQuery<Ingredient> criteriaQuery = criteriaBuilder.createQuery(Ingredient.class);
		Root<Ingredient> fromRoot = criteriaQuery.from(Ingredient.class);
		criteriaQuery.select(fromRoot);
		criteriaQuery.where(criteriaBuilder.equal(fromRoot.get("name"), name));
		
		TypedQuery<Ingredient> typedQuery  =  entityManager.createQuery(criteriaQuery);
		typedQuery.setFirstResult(0);
		typedQuery.setMaxResults(10);
		List<Ingredient> resultList = typedQuery.getResultList();

		entityManager.getTransaction().commit();
		return resultList;
	}
}
