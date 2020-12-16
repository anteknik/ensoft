package com.example.voucherpool;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.voucherpool.entities.Offer;
import com.example.voucherpool.entities.User;
import com.example.voucherpool.entities.Voucher;
import com.example.voucherpool.repository.OfferRepository;
import com.example.voucherpool.repository.RecipientRepository;

@SpringBootTest
class VoucherTests {
	
	private static final Logger logger = LoggerFactory.getLogger(VoucherTests.class);
	
	
	@Autowired
	private RecipientRepository recipientRepo;

	@Autowired
	private OfferRepository offerRepo;

	@Test
	public void whenOfferExpirationDateEachUserGetVoucherCode() throws Exception {
		
		User user0 = new User();
		user0.setName("Anton");
		user0.setEmail("d@be.com");
		User user1 = new User("dini", "d@be.com");
		Offer promo1 = new Offer("2020-12-25");
		promo1.setUser(user0);
		Offer promo2 = new Offer("2020-12-31");
		promo2.setUser(user1);
		//recipientRepo.save(user0);
		//recipientRepo.save(user1);
		offerRepo.save(promo1);
		offerRepo.save(promo2);
		
		//logger.info(promo1.getName()+" "+promo1.getVoucher().getVoucherId());
		//logger.info(promo2.getUser().getName()+" "+promo2.getVoucher().getVoucherId());
		//boolean byId = offerRepo.existsById(1l);
		Optional<Offer> id = offerRepo.findById(1l);
		id.ifPresent(t -> logger.info(t.getUser().getName()+"--> "+t.getUser().getEmail() +"--> "+t.getVoucher().getVoucherId()));
		//id.ifPresent(t -> assertThat(t.getVoucher().getVoucherId()).isEqualTo(promo1.getVoucher().getVoucherId()));
				
	}
	

}