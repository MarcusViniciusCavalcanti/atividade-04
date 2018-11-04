package br.edu.utfpr.tsi.atividadejpa.repository;

import br.edu.utfpr.tsi.atividadejpa.model.EventLocale;
import br.edu.utfpr.tsi.atividadejpa.repository.JPA.Repository;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class EventLocaleRepositoryTest extends AbstractTest {

    @Test
    public void deve_apresentar_todos_os_eventos() {
        Repository<EventLocale> repository = new EventLocaleRepository();
        List<EventLocale> eventLocales = repository.findAll();

        assertThat(eventLocales.size(), CoreMatchers.is(3));
    }

    @Test
    public void deve_cadastrar_um_evento() {
        Repository<EventLocale> repository = new EventLocaleRepository();

        EventLocale eventLocale = new EventLocale();
        eventLocale.setCity("Pinhão");
        eventLocale.setStart(LocalDate.now());
        eventLocale.setEnd(LocalDate.now().plusWeeks(4));

        Optional<EventLocale> save = repository.save(eventLocale);
        assertNotNull(save.get());
        assertThat(save.get().getId(), CoreMatchers.not(0));
        assertThat(save.get().getCity(), CoreMatchers.is(eventLocale.getCity()));
    }
}