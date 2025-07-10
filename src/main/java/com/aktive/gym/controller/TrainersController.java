package com.aktive.gym.controller;


import com.aktive.gym.dto.request.CreateTrainerRequest;
import com.aktive.gym.dto.request.GetTrainerRequest;
import com.aktive.gym.model.Trainer;
import com.aktive.gym.service.TrainerService;
import com.aktive.gym.service.pagination.CustomPage;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/v1/trainer")
@RequiredArgsConstructor
public class TrainersController {

    private final TrainerService trainerService;

    @GetMapping
    public ResponseEntity<CustomPage<Trainer>> getTrainers(GetTrainerRequest getTrainerRequest){
        return ResponseEntity.ok().body(trainerService.getTrainers(getTrainerRequest));
    }

    @PostMapping
    public ResponseEntity<Trainer> createTrainer(@RequestBody  CreateTrainerRequest createTrainerRequest){
        return ResponseEntity.ok().body(trainerService.createTrainer(createTrainerRequest));
    }

    @GetMapping("/{trainerId}")
    public ResponseEntity<Trainer> getTrainer(@PathVariable Long trainerId) throws BadRequestException {
        return ResponseEntity.ok().body(trainerService.getTrainer(trainerId));
    }

    @GetMapping("/recommendation")
    public ResponseEntity<List<Trainer>> getTrainerRecommendation(){
        return ResponseEntity.ok().body(trainerService.getTrainerRecommendation());
    }


    @PutMapping("/assign")
    public ResponseEntity<Object> assignTrainer(@RequestParam Long trainerId)  {
        trainerService.assignTrainer(trainerId);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{trainerId}")
    public ResponseEntity<Object> deleteTrainer(@PathVariable Long trainerId) throws BadRequestException {
        trainerService.deleteTrainer(trainerId);
        return ResponseEntity.ok().build();
    }
}
