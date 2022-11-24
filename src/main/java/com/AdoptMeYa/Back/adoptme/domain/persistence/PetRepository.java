package com.AdoptMeYa.Back.adoptme.domain.persistence;

import com.AdoptMeYa.Back.adoptme.domain.model.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    @Query(value =
            " SELECT pe FROM Pet pe INNER JOIN Publication pu " +
                    "on pe.publication.id = pu.id  WHERE pu.id = :id")
    List<Pet> ReadPetsByPublicationId(@Param("id")Long id);

    @Query(value =
            " SELECT pe FROM Pet pe WHERE pe.user.id = :id")
    List<Pet> ReadPetsByUserId(@Param("id")Long id);

    @Query(value =
            " SELECT pe FROM Pet pe WHERE pe.attention = :attention")
    List<Pet> ReadPetsByAttention(@Param("attention")String attention);

    @Query(value =
            " SELECT pe FROM Pet pe WHERE pe.type = :type")
    List<Pet> ReadPetsByType(@Param("type")String type);

    @Query(value =
            " SELECT pe FROM Pet pe WHERE pe.gender = :gender")
    List<Pet> ReadPetsByGender(@Param("gender")String gender);

    @Query(value =
            " SELECT pe FROM Pet pe WHERE pe.gender = :gender AND pe.attention= :attention")
    List<Pet> ReadPetsByGenderAttention(@Param("gender")String gender, @Param("attention")String attention);

    @Query(value =
            " SELECT pe FROM Pet pe WHERE pe.type = :type AND pe.attention= :attention")
    List<Pet> ReadPetsByTypeAttention(@Param("type")String type, @Param("attention")String attention);

    @Query(value =
            " SELECT pe FROM Pet pe WHERE pe.type = :type AND pe.gender= :gender")
    List<Pet> ReadPetsByTypeGender(@Param("type")String type, @Param("gender")String gender);

    @Query(value =
            " SELECT pe FROM Pet pe WHERE pe.type = :type AND pe.gender= :gender AND pe.attention= :attention")
    List<Pet> ReadPetsByTypeGenderAttention(@Param("type") String type, @Param("gender")String gender, @Param("attention") String attention);

}
