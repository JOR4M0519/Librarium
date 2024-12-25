package co.edu.glm.librarium.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
public class BookEntity implements Book<AuthorEntity>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "copyright", nullable = false)
    private Boolean copyright;

    @Column(name = "download_count")
    private int downloadCount;

    @ElementCollection
    @CollectionTable(name = "book_language", joinColumns = @JoinColumn(name = "book_id"))
    @Column(name = "language")
    private List<String> languagesList;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<AuthorEntity> authorEntityDTOList;

    @Override
    public Integer id() {
        return this.id;
    }
    @Override
    public String title() {
        return this.title;
    }
    @Override
    public List<AuthorEntity> authorList() {
        return this.authorEntityDTOList;
    }
    @Override
    public int downloadCount() {
        return this.downloadCount;
    }
}

