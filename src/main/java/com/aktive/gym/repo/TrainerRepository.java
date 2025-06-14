package com.aktive.gym.repo;

import com.aktive.gym.model.Trainer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {

    @Query("SELECT t FROM Trainer t WHERE" +
            " (:searchQuery IS NULL OR  LOWER(t.fullName) LIKE LOWER(CONCAT('%', :searchQuery, '%')))  OR " +
            " (:searchQuery IS NULL OR  LOWER(t.role) LIKE LOWER(CONCAT('%', :searchQuery, '%'))) "
    )
    Page<Trainer> searchTrainers(@Param("searchQuery") String searchQuery,  Pageable pageable);


    @Query("SELECT t FROM Trainer t  ORDER BY RANDOM() LIMIT 5")
    List<Trainer> searchRandomTrainers();


}
