package com.generation.ammazzon.model;

import com.generation.ammazzon.model.daos.UtenteDao;
import com.generation.ammazzon.model.entities.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UtenteService implements UserDetailsService
{
	@Autowired
	UtenteDao dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		//1 leggo utente da dao
		Utente u = dao.findByUsername(username);

		//2 se non lo trovo lancio eccezione
		if(u==null)
			throw new UsernameNotFoundException("Non esiste utente con usn "+username);

		//vado a gestire i ruoli, devo creare una lista di SimpleGrantedAuthority (sono ruoli)
		List<SimpleGrantedAuthority> ruoli = new ArrayList<>();

		String[] ruoliSplittati = u.getRoles().split(",");
		// la riempio con i vari ruoli
		for(String ruolo:ruoliSplittati)
			ruoli.add(new SimpleGrantedAuthority(ruolo));
		//restituisco l'utente cosi fatto
		return new User(u.getUsername(),u.getPassword(),ruoli);
	}
}
