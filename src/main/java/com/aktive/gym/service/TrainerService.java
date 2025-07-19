package com.aktive.gym.service;


import com.aktive.gym.dto.request.CreateTrainerRequest;
import com.aktive.gym.dto.request.GetTrainerRequest;
import com.aktive.gym.model.Trainer;
import com.aktive.gym.model.User;
import com.aktive.gym.repo.TrainerRepository;
import com.aktive.gym.repo.UserRepository;
import com.aktive.gym.service.pagination.CustomPage;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class TrainerService {

    private final TrainerRepository trainerRepository;
    private final UserService userService;
    private final UserRepository userRepository;

    public CustomPage<Trainer> getTrainers(GetTrainerRequest getTrainerRequest){
        Pageable pageable = PageRequest.of(getTrainerRequest.getPageNumber() - 1, getTrainerRequest.getPageSize());
        Date cutoffDate = java.sql.Date.valueOf(LocalDate.now().minusDays(3));
        Page<Trainer> trainerPage  = trainerRepository.searchTrainers(
                StringUtils.hasText(getTrainerRequest.getSearchQuery()) ? getTrainerRequest.getSearchQuery() : null,
                StringUtils.hasText(getTrainerRequest.getCategory()) ? getTrainerRequest.getCategory() : null,
                cutoffDate,
                pageable);
        return getTrainerResponseCustomPage(trainerPage.getContent(), trainerPage);
    }

    public Trainer createTrainer(CreateTrainerRequest createTrainerRequest){
        Trainer trainer = new Trainer();
        trainer.setFullName(createTrainerRequest.getFullName());
        trainer.setRole(createTrainerRequest.getRole());
        trainer.setYearsOfExperience(createTrainerRequest.getYearsOfExperience());
        trainer.setDescription(createTrainerRequest.getDescription());
        trainer.setSpeciality(createTrainerRequest.getSpeciality());
        trainer.setAvailablePeriod(createTrainerRequest.getAvailablePeriod());
        trainer.setCertification(createTrainerRequest.getCertification());
        trainer.setRating(createTrainerRequest.getRating());
        trainer.setEmail(createTrainerRequest.getEmail());
        trainer.setRating(generateTrainerRating());
        return trainerRepository.save(trainer);
    }

    private static CustomPage<Trainer> getTrainerResponseCustomPage(List<Trainer> trainers, Page trainersPage) {
        CustomPage<Trainer> customPage = new CustomPage<>();
        customPage.setContent(trainers);
        customPage.setPageNumber(trainersPage.getNumber() + 1);
        customPage.setPageSize(trainersPage.getSize());
        customPage.setTotalElements(trainersPage.getTotalElements());
        customPage.setTotalPages(trainersPage.getTotalPages());
        customPage.setLast(trainersPage.isLast());
        customPage.setFirst(trainersPage.isFirst());
        customPage.setEmpty(trainersPage.isEmpty());
        return customPage;
    }


    public Trainer getTrainer(Long trainerId) throws BadRequestException {
        Optional<Trainer> trainerOptional = trainerRepository.findById(trainerId);
        if (trainerOptional.isEmpty()) {
            throw new BadRequestException("Trainer not found");
        }
        return trainerOptional.get();
    }

    public void deleteTrainer(Long trainerId) throws BadRequestException {
        Optional<Trainer> trainerOptional = trainerRepository.findById(trainerId);
        if (trainerOptional.isEmpty()) {
            throw new BadRequestException("Trainer not found");
        }
        Trainer trainer = trainerOptional.get();
        trainer.setStatus("Inactive");
        trainerRepository.save(trainer);
    }

    public List<Trainer> getTrainerRecommendation(){
        return trainerRepository.searchRandomTrainers();
    }


    public void assignTrainer(Long trainerId){
        Trainer trainer = trainerRepository.findById(trainerId).orElseThrow(() -> new EntityNotFoundException("Trainer not found"));
        User currentUser = userService.getCurrentUser();
        User user = userRepository.findById(currentUser.getId()).orElseThrow(() -> new EntityNotFoundException("User not found"));
        user.setTrainer(trainer);
        userRepository.save(user);
    }


    public double generateTrainerRating(){
        Random random = new Random();
        int min = 41;
        int max = 50;
        int randomInt = random.nextInt((max - min) + 1) + min;
        return randomInt / 10.0;
    }
}
