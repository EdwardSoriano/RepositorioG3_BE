package com.Reto3_Ciclo3.Reto3.Controller;

import com.Reto3_Ciclo3.Reto3.Models.Score;
import com.Reto3_Ciclo3.Reto3.Service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Score")

public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/all")
    public List<Score> getAllScores(){
        return scoreService.getAllScores();
    }

    @GetMapping("/{id}")
    public Optional<Score> getScore(@PathVariable("id") int score_id){
        return scoreService.getScore(score_id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score insertScore(@RequestBody Score score){
        return scoreService.insertScore(score);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score updateScore(@RequestBody Score score){
        return scoreService.updateScore(score);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteScore(@PathVariable("id") int score_id){
        return scoreService.deleteScore(score_id);
    }
}