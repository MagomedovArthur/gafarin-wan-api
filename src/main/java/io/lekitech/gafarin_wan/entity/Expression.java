package io.lekitech.gafarin_wan.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "expression")
@EqualsAndHashCode(of = {"id", "spelling", "language"})
public class Expression {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "spelling")
    private String spelling;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id")
    private Language language;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "expression", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<MediaFile> mediaFiles = new HashSet<>();

    public Expression(String spelling,
                      Language language) {
        this.spelling = spelling;
        this.language = language;
    }
}