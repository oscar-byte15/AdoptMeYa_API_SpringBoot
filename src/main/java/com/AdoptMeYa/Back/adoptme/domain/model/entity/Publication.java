package com.AdoptMeYa.Back.adoptme.domain.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.AdoptMeYa.Back.shared.domain.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@With
@Table(name = "publications")
public class Publication{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    private String comment;

    @ManyToOne(optional=false)
    @NotNull
    @JoinColumn(name= "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;


//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
//
//    @OneToOne(optional = true)
//    @JoinColumn(name = "pet_id", nullable = true)
//    private Pet pet;
}
