package br.edu.utfpr.tsi.atividadejpa.repository;

import br.edu.utfpr.tsi.atividadejpa.model.Show;
import br.edu.utfpr.tsi.atividadejpa.model.User;
import br.edu.utfpr.tsi.atividadejpa.repository.JPA.Repository;

import javax.persistence.TypedQuery;
import java.util.HashSet;

import java.util.Set;

public class UserRepository extends Repository<User> {
    public UserRepository() {
        super(User.class);
    }

    public Set<User> findByShow(Show show) {
        String query =  "select u from TicketShow t join t.user u where t.show = :show";
        TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class).setParameter("show", show);
        return new HashSet<>(typedQuery.getResultList());
    }

    public User findByMajorPrice() {
        String query = "select u from TicketShow t join t.user u where t.amount = (select max(tt.amount) from TicketShow tt)";
        TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
        return typedQuery.getSingleResult();
    }
}
