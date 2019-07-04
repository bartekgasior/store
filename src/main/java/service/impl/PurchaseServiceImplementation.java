package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Purchase;
import model.repository.PurchaseRepository;
import service.PurchaseService;

@Service
public class PurchaseServiceImplementation implements PurchaseService{
	
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	public Purchase getPurchase(int id) {
		return purchaseRepository.getPurchase(id);
	}

	public List<Purchase> getAllPurchases() {
		return purchaseRepository.getAllPurchases();
	}

	public void addPurchase(Purchase purchase) {
		purchaseRepository.addPurchase(purchase);
	}
}
