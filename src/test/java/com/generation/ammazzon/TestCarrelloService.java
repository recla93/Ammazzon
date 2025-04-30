package com.generation.ammazzon;

import com.generation.ammazzon.exceptions.CreazioneUtenteMalformataException;
import com.generation.ammazzon.exceptions.UtenteNonEsistenteException;
import com.generation.ammazzon.model.dtos.CarrelloPageDto;
import com.generation.ammazzon.model.dtos.ItemAmmazzonDto;
import com.generation.ammazzon.model.dtos.services.CarrelloService;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


//Permette al test di accedere al contesto di applicazione
//può fare autowired
@SpringBootTest
public class TestCarrelloService
{

    @Autowired
    private CarrelloService carrelloService;

    //contiene metodi per verificare il funzionamento di parti del programma
    //qui voglio testare il metodo getMyCarrello
    @Test
    public void testGetMyCarrello()
    {
        //Se il test arriva al fondo, allora è passato
        //noi mettiamo dei "roadblock" per fare dei controlli e fermarlo se non li passa

        //Good Case, il metodo riceve dati accettabili e deve funzionare come previsto
        String username = "prova";
        CarrelloPageDto dto = carrelloService.getMyCarrello(username);
        //verifico che abbia funzionato correttamente
        //lavoriamo nei test con dati NOTI
        Long idCarrello = dto.id();
        //assert -> verifica di valore ottenuto con valore atteso
        //assert idCarrello ==3; metodo banale
        assertEquals(3, idCarrello);//uguale a sopra, è più bello in lettura
        List<ItemAmmazzonDto> items = dto.items();
        assertEquals(2, items.size());//verifichiamo che siano 2
        double totale = dto.totale();
        assertEquals(1679.97,totale,0.001);//ultimo è il margine di errore accettabile

        //Bad Case
        String usernameFinto = "paperino";
        try
        {
            CarrelloPageDto dtoFinto = carrelloService.getMyCarrello(usernameFinto);
            //se raggiungi questa riga, fallisci
            fail("Dovevo dare UtenteNonEsistenteException");
        }catch (UtenteNonEsistenteException e)
        {
            //tutto bene
        }

        String usernameNoCarrello = "NOCARRELLO";
        try
        {
            CarrelloPageDto dtoFinto = carrelloService.getMyCarrello(usernameNoCarrello);
            //se raggiungi questa riga, fallisci
            fail("Dovevo dare CreazioneUtenteMalformataException");
        }catch (CreazioneUtenteMalformataException e)
        {
            //tutto bene
        }
    }
}
