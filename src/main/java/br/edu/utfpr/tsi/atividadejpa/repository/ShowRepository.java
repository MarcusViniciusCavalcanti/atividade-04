package br.edu.utfpr.tsi.atividadejpa.repository;

import br.edu.utfpr.tsi.atividadejpa.dto.AmountSalesShowDTO;
import br.edu.utfpr.tsi.atividadejpa.model.Show;
import br.edu.utfpr.tsi.atividadejpa.repository.JPA.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

public class ShowRepository extends Repository<Show> {
    public ShowRepository() {
        super(Show.class);
    }

    public List<AmountSalesShowDTO> getAmountSalesTickets() {
        String query = "select new br.edu.utfpr.tsi.atividadejpa.dto.AmountSalesShowDTO(s.id, s.banda, sum(t.amount))" +
                " from Show as s join s.ticketShows as t group by s.id order by sum(t.amount)";
        TypedQuery<AmountSalesShowDTO> typedQuery = entityManager.createQuery(query, AmountSalesShowDTO.class);
        return typedQuery.getResultList();
    }
}
