package com.AdoptMeYa.Back.adoptme.domain.model.entity;

import com.AdoptMeYa.Back.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@With
@Table(name="advertisements")
public class Advertisement extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @NotNull
    @Size(max = 100)
    @Column(unique = false)
    private String title;

    @NotNull
    @Size(max = 100)
    @Column(unique = false)
    private String description;


    @Column(unique = false)
    private Float discount;


    @Size(max = 300)
    @Column(unique = false)
    private String url;

    @Column(unique = false)
    private Boolean promoted;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
