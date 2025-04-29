package com.generation.ammazzon.model.daos;

import com.generation.ammazzon.model.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UtenteDao extends JpaRepository<Utente,Long>
{
	Utente findByUsernameAndPassword(String username, String password);

	Utente findByUsername(String username);

//	@Query("SELECT u FROM Utente u WHERE (u.username=:boh OR u.mail=:boh) and u.password=:password ")
//	Utente trovaUtente(String boh, String password);
}
