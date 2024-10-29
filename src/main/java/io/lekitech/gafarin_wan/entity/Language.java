package io.lekitech.gafarin_wan.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "language")
@EqualsAndHashCode(of = {"id"})
public class Language {

    @Id
    @Column(length = 3)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "iso_2", length = 2)
    private String iso2;

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "language", cascade = CascadeType.PERSIST)
    private Set<Dialect> dialects = new HashSet<>();

    @OneToMany(mappedBy = "language", cascade = CascadeType.PERSIST)
    private Set<Expression> expressions = new HashSet<>();

    public Language(String id, String name, String iso2) {
        this.id = id;
        this.name = name;
        this.iso2 = iso2;
    }
}
