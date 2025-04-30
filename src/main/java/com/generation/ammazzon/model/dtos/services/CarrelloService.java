package com.generation.ammazzon.model.dtos.services;

import com.generation.ammazzon.exceptions.CreazioneUtenteMalformataException;
import com.generation.ammazzon.exceptions.UtenteNonEsistenteException;
import com.generation.ammazzon.model.daos.CarrelloDao;
import com.generation.ammazzon.model.daos.ItemDao;
import com.generation.ammazzon.model.daos.ProdottoDao;
import com.generation.ammazzon.model.daos.UtenteDao;
import com.generation.ammazzon.model.dtos.CarrelloPageDto;
import com.generation.ammazzon.model.dtos.mappers.CarrelloMapper;
import com.generation.ammazzon.model.entities.Carrello;
import com.generation.ammazzon.model.entities.ItemAmmazzon;
import com.generation.ammazzon.model.entities.Prodotto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrelloService
{
    @Autowired
    CarrelloDao cDao;
    @Autowired
    ProdottoDao pDao;
    @Autowired
    ItemDao iDao;
    @Autowired
    UtenteDao uDao;
    @Autowired
    CarrelloMapper cMapper;

    /**
     * Questo metodo si aspetta in ingresso lo username di un utente
     * Se l'utente non esiste deve dare eccezione UtenteNonEsistenteException
     * Se l'utente esiste ma non ha un carrello, deve dare eccezzione CreazioneUtenteMalformataException
     * Se tutto è a posto, deve resistuire un oggetto CarrelloPageDto
     */
    public CarrelloPageDto getMyCarrello(String username)
    {
        if(!uDao.existsByUsername(username))
            throw new UtenteNonEsistenteException("Utente con username: " + username+ " non esistente");
        Carrello c = cDao.findByUtente_Username(username);
        if (c == null)
            throw new CreazioneUtenteMalformataException("Utente on username: "+username+" non ha carrello"  );
        return cMapper.toDto(c);
    }

    public CarrelloPageDto aggiungiProdotto(String username, Long idProdotto)
    {
        Carrello c = cDao.findByUtente_Username(username);
        Prodotto p = pDao.findById(idProdotto).orElse(null);

        ItemAmmazzon i = c.productAlreadyPresent(p);
        if(i==null)
        {
            i = new ItemAmmazzon();
            i.setCarrello(c);
            i.setProdotto(p);
            i.setQtn(1);
        }
        else
            i.setQtn(i.getQtn()+1);

        iDao.save(i);//save fa upsert, se già esiste fa un update, altrimenti un insert

        return getMyCarrello(username);
    }
}
