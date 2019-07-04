package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.repository.PurchaseItemRepository;
import service.PurchaseItemService;

@Service
public class PurchaseItemServiceImplementation implements PurchaseItemService{

	@Autowired
	private PurchaseItemRepository purchaseItemRepository;
}
