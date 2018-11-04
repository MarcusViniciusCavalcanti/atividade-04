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
@Table(name = "event_locale")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EventLocale implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column private LocalDate start;
    @Column private LocalDate end;
    @Column private String city;

    @OneToMany(mappedBy = "eventLocale")
    private List<Show> shows;

}
