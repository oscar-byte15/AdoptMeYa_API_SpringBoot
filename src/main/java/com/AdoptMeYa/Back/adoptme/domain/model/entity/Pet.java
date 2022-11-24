package com.AdoptMeYa.Back.adoptme.domain.model.entity;

import com.AdoptMeYa.Back.shared.domain.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@With
@Table(name = "pets")
public class Pet extends AuditModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String type;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String attention;

    @NotNull
    @NotBlank
    private String race;

    @NotNull
    private Integer age;

    @NotNull
    @NotBlank
    private String isAdopted;

    @NotNull
    @NotBlank
    private String gender;

    @OneToOne(mappedBy = "pet", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Publication publication;

    @ManyToOne(optional=false)
    @NotNull
    @JoinColumn(name= "user_id")
    private User user;

}