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

import web.GrapeVine.modules.Ingredient;

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
		Ingredient Ingredient = (Ingredient) entityManager.find(Ingredient.class, id);
		entityManager.getTransaction().commit();
		return Ingredient;
	}

	public Ingredient createIngredient(Ingredient Ingredient) {

		entityManager.getTransaction().begin();
		entityManager.persist(Ingredient);
		entityManager.getTransaction().commit();
		// entityManager.flush();
		return Ingredient;
	}

	public Ingredient updateIngredient(Ingredient Ingredient) {

		entityManager.getTransaction().begin();
		entityManager.persist(Ingredient);
		// Ingredient dbIngredient = (Ingredient) entityManager.find(Ingredient.class,
		// Ingredient.getId());
		// dbIngredient = Ingredient;
		entityManager.getTransaction().commit();
		entityManager.flush();
		return Ingredient;
	}

	public void deleteIngredient(Ingredient Ingredient) {
		entityManager.getTransaction().begin();
		entityManager.remove(Ingredient);
		entityManager.getTransaction().commit();
		entityManager.flush();

	}

	public Ingredient getIngredient(String name) {

		entityManager.getTransaction().begin();

		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<Ingredient> fromRoot = criteriaQuery.from(Ingredient.class);
		criteriaQuery.select(fromRoot);

		criteriaQuery.where(criteriaBuilder.equal(fromRoot.get("name"), name));

		List<Object> resultList = entityManager.createQuery(criteriaQuery).getResultList();
		Ingredient dbIngredient = null;
		if (resultList.isEmpty()) {
			// Handle Error
		} else {
			dbIngredient = (Ingredient) resultList.get(0);
		}

		entityManager.getTransaction().commit();
		return dbIngredient;
	}
}
