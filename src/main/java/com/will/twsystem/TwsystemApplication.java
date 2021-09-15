package com.will.twsystem;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.will.twsystem.domain.Client;
import com.will.twsystem.domain.Order;
import com.will.twsystem.domain.Product;
import com.will.twsystem.domain.Purchase;
import com.will.twsystem.repositories.ClientRepository;
import com.will.twsystem.repositories.OrderRepository;
import com.will.twsystem.repositories.ProductRepository;
import com.will.twsystem.repositories.PurchaseRepository;

@SpringBootApplication
public class TwsystemApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TwsystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Product p1 = new Product(null, "Terra 2kg",12.00); 
		
		productRepository.save(p1);
		
		Client c1 = new Client(null, "Thiago");
		
		clientRepository.save(c1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Purchase pur1 = new Purchase(null, sdf.parse("14/09/2021"), null, c1);
		
		purchaseRepository.save(pur1);
		
		Order ord1 = new Order(null, p1, 3, null, pur1);
		
		orderRepository.save(ord1);
		
	}

}
