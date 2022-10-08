package com.Reto3_Ciclo3.Reto3.Controller;


import com.Reto3_Ciclo3.Reto3.Model.Score;
import com.Reto3_Ciclo3.Reto3.Services.ScoreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")
public class ScoreController {
    @Autowired
    private ScoreServices scoreServices;

    @GetMapping("/all")
    public List<Score> getAll() {
        return scoreServices.getAllScore();
    }
    @GetMapping("/{id}")
    public Optional<Score> getScore(@PathVariable("id")int id){
        return  scoreServices.getScore(id);
    }

    @PostMapping("/save")
    public Score insertScore(@RequestBody Score score) {
        return scoreServices.insertScore(score);
    }
    @PutMapping("/update")
    public Score updateScore (@RequestBody Score Score){
        return  scoreServices.updateScore(Score);
    }
}
