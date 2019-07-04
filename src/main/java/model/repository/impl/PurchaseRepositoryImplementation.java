package model.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import model.Purchase;
import model.repository.PurchaseRepository;

@Repository
public class PurchaseRepositoryImplementation implements PurchaseRepository{

	List<Purchase> purchases = new ArrayList<Purchase>();
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public Purchase getPurchase(int id) {
		return entityManager.find(Purchase.class, id);
	}

	public List<Purchase> getAllPurchases() {

		return purchases;
	}
	
	@Transactional
	public void addPurchase(Purchase purchase) {
		entityManager.merge(purchase);
		entityManager.flush();
	}

	
}
