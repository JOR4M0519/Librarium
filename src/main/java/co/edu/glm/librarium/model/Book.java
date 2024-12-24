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
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "copyright", nullable = false)
    private Boolean copyright;

    @ElementCollection
    @CollectionTable(name = "book_language", joinColumns = @JoinColumn(name = "book_id"))
    @Column(name = "language")
    private List<String> languagesList;

    @ElementCollection
    @CollectionTable(name = "book_download_count", joinColumns = @JoinColumn(name = "book_id"))
    @Column(name = "download_count")
    private List<String> downloadCount;

    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authorDTOList;
}

