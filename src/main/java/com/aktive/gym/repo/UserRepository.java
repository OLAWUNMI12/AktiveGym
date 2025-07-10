package com.aktive.gym.repo;

import com.aktive.gym.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    boolean existsByMembershipId(String membershipId);


    @Query("SELECT DISTINCT u FROM User u WHERE" +
            " (:searchQuery IS NULL OR  LOWER(u.fullName) LIKE LOWER(CONCAT('%', :searchQuery, '%')))  OR " +
            " (:searchQuery IS NULL OR  LOWER(u.email) LIKE LOWER(CONCAT('%', :searchQuery, '%'))) "
    )
    Page<User> searchUsers(@Param("searchQuery") String searchQuery, Pageable pageable);


}
