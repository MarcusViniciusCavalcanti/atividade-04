package br.edu.utfpr.tsi.atividadejpa.model;

import br.edu.utfpr.tsi.atividadejpa.repository.ShowRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ticket_show")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TicketShow implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column private int amount;
    @Column private long price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "show_id")
    private Show show;

    @PrePersist
    private void saveShow() {
        if (this.show.getId() == 0) {
            ShowRepository repository = new ShowRepository();
            repository.save(show);
        }
    }
}
