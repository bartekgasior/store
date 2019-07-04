package service;

import java.util.List;

import model.Purchase;

public interface PurchaseService {

	public Purchase getPurchase(int id);
	public List<Purchase> getAllPurchases();
	public void addPurchase(Purchase purchase);
}
