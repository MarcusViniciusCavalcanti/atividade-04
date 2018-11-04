package br.edu.utfpr.tsi.atividadejpa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "shows")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Show implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column private LocalDate date;
    @Column private String banda;

    @OneToMany(mappedBy = "show")
    private List<TicketShow> ticketShows;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "local_id")
    private EventLocale eventLocale;

}
