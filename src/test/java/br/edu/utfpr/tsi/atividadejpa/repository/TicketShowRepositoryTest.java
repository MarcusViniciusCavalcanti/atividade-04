package br.edu.utfpr.tsi.atividadejpa.repository;

import br.edu.utfpr.tsi.atividadejpa.dto.AmountSalesShowDTO;
import br.edu.utfpr.tsi.atividadejpa.model.EventLocale;
import br.edu.utfpr.tsi.atividadejpa.model.Show;
import br.edu.utfpr.tsi.atividadejpa.model.TicketShow;
import br.edu.utfpr.tsi.atividadejpa.model.User;
import br.edu.utfpr.tsi.atividadejpa.repository.JPA.Repository;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class TicketShowRepositoryTest extends AbstractTest{

    @Test
    public void ususario_cadastrado_deve_fazer_pedido_de_ingresso() {
        Repository<User> userRepository = new UserRepository();
        Repository<EventLocale> eventLocaleRepository = new EventLocaleRepository();
        TicketShowRepository ticketShowRepository = new TicketShowRepository();

        User user = userRepository.findById(1L).get();
        EventLocale eventLocale = eventLocaleRepository.findById(1L).get();

        Show show = new Show();
        show.setBanda("banda");
        show.setEventLocale(eventLocale);
        show.setDate(eventLocale.getStart().plusDays(1));

        TicketShow ticketShow = new TicketShow();
        ticketShow.setAmount(1000);
        ticketShow.setPrice(100000);
        ticketShow.setShow(show);
        ticketShow.setUser(user);

        Optional<TicketShow> save = ticketShowRepository.save(ticketShow);

        assertNotNull(save.get());
        assertThat(save.get().getUser(), CoreMatchers.is(user));
    }

    @Test
    public void deve_apresentar_todos_os_eventos() {
        Repository<TicketShow> repository = new TicketShowRepository();
        List<TicketShow> eventLocales = repository.findAll();

        assertThat(eventLocales.size(), CoreMatchers.is(111));
    }
}