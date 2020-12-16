package com.example.voucherpool.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.voucherpool.entities.Offer;
import com.example.voucherpool.entities.User;
import com.example.voucherpool.repository.OfferRepository;
import com.example.voucherpool.repository.RecipientRepository;

@RestController
public class VoucherController {

	@Autowired
	private RecipientRepository recipientRepo;

	@Autowired
	private OfferRepository offerRepo;
	
	@GetMapping("/add/{date}")
	String add(@PathVariable String date) throws Exception{
		
		User user0 = new User();
		user0.setName("Anton");
		user0.setEmail("a@be.com");
		Offer promo1 = new Offer(date);
		promo1.setUser(user0);
		offerRepo.save(promo1);
		return "ok";
	}
	
	@GetMapping("/search/{id}")
	Optional<String> allid(@PathVariable long id) {

		 Optional<Offer> sid = offerRepo.findById(id);
		 
		return sid.map(t ->"{ name : "+ t.getUser().getName()+", email: "+t.getUser().getEmail() +", voucherId : "+t.getVoucher().getVoucherId()+"}");

	}
	
	@GetMapping("/voucher")
	String voucher(@RequestParam(required = false) String voucher, @RequestParam(required = false) String email) {

		 List<Offer> r=(List<Offer>) offerRepo.findAll();
		 for (Offer o:r) {
			 if (o.getVoucher().getVoucherId().equals(voucher) || o.getUser().getEmail().equals(email)) {
				 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				return "{ discount : "+String.valueOf(o.getDiscount()+", dateUsage : "+sdf.format(new Date())+"}");
			} 
		}
		 return "not Valid voucher no : "+voucher;
		
	}
	
	@DeleteMapping("/users/{id}")
	void deleteId(@PathVariable Long id) {
		recipientRepo.deleteById(id);
	}

}