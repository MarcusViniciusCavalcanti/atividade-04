package br.edu.utfpr.tsi.atividadejpa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column private String name;
    @Column private int age;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<TicketShow> ticketShows;
}
