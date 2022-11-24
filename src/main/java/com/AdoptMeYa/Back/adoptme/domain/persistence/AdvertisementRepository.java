package com.AdoptMeYa.Back.adoptme.domain.persistence;

import com.AdoptMeYa.Back.adoptme.domain.model.entity.Advertisement;
import com.AdoptMeYa.Back.adoptme.domain.model.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
    @Query(value =
            " SELECT pe FROM Advertisement pe WHERE pe.user.id = :id")
    List<Advertisement> ListAdvertisementByUserId(@Param("id")Long id);
}
