package com.aktive.gym.repo;

import com.aktive.gym.model.Trainer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {

    @Query("SELECT t FROM Trainer t " +
            "WHERE (t.status = 'Active' OR t.status IS NULL) " +
            "AND (:searchQuery IS NULL OR " +
            "     LOWER(t.fullName) LIKE LOWER(CONCAT('%', :searchQuery, '%')) OR " +
            "     LOWER(t.role) LIKE LOWER(CONCAT('%', :searchQuery, '%'))) " +
            "AND (" +
            "     :category = 'ALL' OR " +
            "     (:category = 'NEW' AND t.createdAt >= :cutoffDate) OR " +
            "     (:category = 'PAST' AND (t.createdAt < :cutoffDate OR t.createdAt IS NULL))" +
            ")")
    Page<Trainer> searchTrainers(@Param("searchQuery") String searchQuery,
                                 @Param("category") String category,
                                 @Param("cutoffDate") Date cutoffDate,
                                 Pageable pageable);

    @Query("SELECT t FROM Trainer t  ORDER BY RANDOM() LIMIT 5")
    List<Trainer> searchRandomTrainers();


}
