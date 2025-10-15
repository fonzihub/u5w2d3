package alfosarno.u5w2d3.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Random;
import java.util.UUID;

@Entity
@Table(name = "blogs")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Blog {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID idBlog;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;
    @ManyToOne
    @JoinColumn
    private Author author;


    public Blog(String categoria, String titolo, String contenuto) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.contenuto = contenuto;

    }
}
