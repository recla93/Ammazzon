package com.generation.ammazzon;

import com.generation.ammazzon.model.daos.CarrelloDao;
import com.generation.ammazzon.model.daos.ItemDao;
import com.generation.ammazzon.model.daos.ProdottoDao;
import com.generation.ammazzon.model.daos.UtenteDao;
import com.generation.ammazzon.model.entities.Carrello;
import com.generation.ammazzon.model.entities.ItemAmmazzon;
import com.generation.ammazzon.model.entities.Prodotto;
import com.generation.ammazzon.model.entities.Utente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class AmmazzonApplicationTests
{

	@Autowired
	private PasswordEncoder criptatore;
	@Autowired
	private UtenteDao dao;
	@Autowired
	private CarrelloDao cDao;
	@Autowired
	private ItemDao iDao;
	@Autowired
	private ProdottoDao pDao;
	
	@Test
	void testCreazioneUtenteProdottiECart() {
		// Crea i prodotti
		Prodotto p1 = new Prodotto();
		p1.setNome("Laptop ASUS ROG");
		p1.setPrezzo(1499.99);
		p1 = pDao.save(p1);

		Prodotto p2 = new Prodotto();
		p2.setNome("Mouse Logitech G Pro");
		p2.setPrezzo(89.99);
		p2 = pDao.save(p2);

		Prodotto p3 = new Prodotto();
		p3.setNome("Monitor LG UltraFine");
		p3.setPrezzo(399.50);
		p3 = pDao.save(p3);

		// Crea l'utente
		Utente u = new Utente();
		u.setUsername("prova");
		u.setMail("mario.rossi@example.com");
		u.setPassword(criptatore.encode("prova"));
		u.setRoles("ROLE_USER");
		u = dao.save(u);

		// Crea il carrello e lo collega all'utente
		Carrello c = new Carrello();
		c.setUtente(u);
		u.setCarrello(c);
		c=cDao.save(c);

		// Crea due item e li collega a due prodotti e al carrello
		ItemAmmazzon item1 = new ItemAmmazzon();
		item1.setProdotto(p1);
		item1.setQtn(1);
		item1.setCarrello(c);
		item1 = iDao.save(item1);

		ItemAmmazzon item2 = new ItemAmmazzon();
		item2.setProdotto(p2);
		item2.setQtn(2);
		item2.setCarrello(c);
		item2 = iDao.save(item2);



	}

}
