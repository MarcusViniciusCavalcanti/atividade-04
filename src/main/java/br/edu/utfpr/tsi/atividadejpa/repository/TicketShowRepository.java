package br.edu.utfpr.tsi.atividadejpa.repository;

import br.edu.utfpr.tsi.atividadejpa.model.TicketShow;
import br.edu.utfpr.tsi.atividadejpa.model.User;
import br.edu.utfpr.tsi.atividadejpa.repository.JPA.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

public class TicketShowRepository extends Repository<TicketShow> {
    public TicketShowRepository() {
        super(TicketShow.class);
    }

    public List<TicketShow> getTicketTo(User user) {
        TypedQuery<TicketShow> typedQuery = entityManager.createQuery("select t from TicketShow t where t.user = :user", TicketShow.class);
        typedQuery.setParameter("user", user);
        return typedQuery.getResultList();
    }
}
