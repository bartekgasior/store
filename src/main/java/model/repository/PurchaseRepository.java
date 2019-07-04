package model.repository;

import java.util.List;

import model.Purchase;

public interface PurchaseRepository {

	public Purchase getPurchase(int id);
	public List<Purchase> getAllPurchases();
	public void addPurchase(Purchase purchase);
}
