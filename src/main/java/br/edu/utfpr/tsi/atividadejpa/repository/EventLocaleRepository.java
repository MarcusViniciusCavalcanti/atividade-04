package br.edu.utfpr.tsi.atividadejpa.repository;

import br.edu.utfpr.tsi.atividadejpa.model.EventLocale;
import br.edu.utfpr.tsi.atividadejpa.repository.JPA.Repository;

public class EventLocaleRepository extends Repository<EventLocale> {
    public EventLocaleRepository() {
        super(EventLocale.class);
    }
}
