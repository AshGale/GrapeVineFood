package web.GrapeVine.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import web.GrapeVine.modules.Allergy;
import web.GrapeVine.modules.Ingredient;

public class IngredientService {

	EntityManagerFactory entityManagerFactory = null;
	@PersistenceContext
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

	public boolean init() {
		
		if(entityManager == null) {
			try {
				entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
				entityManager = entityManagerFactory.createEntityManager();
				criteriaBuilder = entityManager.getCriteriaBuilder();
				System.out.println("Server initialized");//TODO look into serialization  
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("failed to initilaze");
				return false;
			}
		}
		System.out.println("Server already Initialized");
		return false;
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

	public Ingredient createIngredient(Ingredient ingredient) {
		
		Ingredient exists = getNamedIngredient(ingredient.getName());
		if(exists != null) {
			System.out.println(ingredient.getName() + " exists in db");
			return exists;
		}
		else {
			entityManager.getTransaction().begin();
			entityManager.persist(ingredient);
			entityManager.getTransaction().commit();
			return ingredient;
		}
		
		
	}

	public Ingredient updateIngredient(Ingredient ingredient) {
		
		Ingredient exists = getNamedIngredient(ingredient.getName());
		if(exists == null) {
			//should never get here due to handled on front end
			System.out.println("not an existing Ingredient");
			//to ensure new id's generated
			ingredient.setIdIngredient((Long)null);
			
			Allergy allergy = ingredient.getAllergy();
			//allergy.setIdAllergy((Long)null);//not working//TODO add full ingrediant assignment with no id's
			ingredient.setAllergy(allergy);
			//ingredient.getAllergy().setIdAllergy((Long)null);//not working
			//ingredient.getNutritionalValue().setIdNutrition((Long)null);
			return createIngredient(ingredient);
		}
		else {

			entityManager.getTransaction().begin();
			Ingredient dbIngredient = (Ingredient) entityManager.find(Ingredient.class,ingredient.getIdIngredient());		 
			entityManager.merge(ingredient);
			entityManager.getTransaction().commit();
			return ingredient;
		}
	}

	public void deleteIngredient(Ingredient Ingredient) {
		entityManager.getTransaction().begin();
		Ingredient remove = (Ingredient) entityManager.find(Ingredient.class, Ingredient.getIdIngredient());
		entityManager.remove(remove);
		entityManager.getTransaction().commit();
		//entityManager.flush();
		//entityManager.clear();
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

	public Ingredient getNamedIngredient(String name) {
		entityManager.getTransaction().begin();
		
		CriteriaQuery<Ingredient> criteriaQuery = criteriaBuilder.createQuery(Ingredient.class);
		Root<Ingredient> fromRoot = criteriaQuery.from(Ingredient.class);
		criteriaQuery.select(fromRoot);
		criteriaQuery.where(criteriaBuilder.equal(fromRoot.get("name"), name));
		
		TypedQuery<Ingredient> typedQuery  =  entityManager.createQuery(criteriaQuery);
		typedQuery.setFirstResult(0);
		typedQuery.setMaxResults(1);
		List<Ingredient> resultList = typedQuery.getResultList();
		
		entityManager.getTransaction().commit();
		
		if(resultList.isEmpty()) {
			System.out.println("No entity found!!!"); 
			return null;
		}
		else System.out.println("entity exists:"+resultList); return resultList.get(0);

	}
}
