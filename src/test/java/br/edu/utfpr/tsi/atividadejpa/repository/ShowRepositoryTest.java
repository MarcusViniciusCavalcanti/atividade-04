package br.edu.utfpr.tsi.atividadejpa.repository;

import br.edu.utfpr.tsi.atividadejpa.dto.AmountSalesShowDTO;
import br.edu.utfpr.tsi.atividadejpa.model.EventLocale;
import br.edu.utfpr.tsi.atividadejpa.model.Show;
import br.edu.utfpr.tsi.atividadejpa.model.TicketShow;
import br.edu.utfpr.tsi.atividadejpa.repository.JPA.Repository;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class ShowRepositoryTest extends AbstractTest {

    @Test
    public void deve_apresentar_todos_os_eventos() {
        Repository<Show> repository = new ShowRepository();
        List<Show> eventLocales = repository.findAll();

        assertThat(eventLocales.size(), CoreMatchers.is(42));
    }

    @Test
    public void deve_salvar_um_show() {
        Show show = new Show();
        show.setDate(LocalDate.of(2019, 11, 30));
        show.setBanda("banda");

        Repository<EventLocale> eventLocaleRepository = new EventLocaleRepository();
        Optional<EventLocale> byId = eventLocaleRepository.findById(1);

        show.setEventLocale(byId.get());

        ShowRepository showRepository = new ShowRepository();
        Optional<Show> save = showRepository.save(show);

        assertNotNull(save.get());
        assertThat(save.get().getId(), CoreMatchers.not(0));
        assertThat(save.get().getBanda(), CoreMatchers.is(show.getBanda()));
    }

    @Test
    public void deve_apresentar_a_quantidade_de_ingressos_vendidos_para_cada_show() {
        ShowRepository showRepository = new ShowRepository();

        List<AmountSalesShowDTO> salesShowDTO = showRepository.getAmountSalesTickets();

        Optional<Show> byId = showRepository.findById(salesShowDTO.get(1).getId());

        long size = byId.get().getTicketShows().stream().mapToInt(TicketShow::getAmount).sum();

        assertThat(salesShowDTO.get(1).getAmountSales(), CoreMatchers.is(size));
    }
}