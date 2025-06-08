package com.aktive.gym.repo;

import com.aktive.gym.model.UserExercises;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserExerciseRepository extends JpaRepository<UserExercises, Long> {
    Optional<UserExercises> findByUsername(String username);
}
