package com.Reto3_Ciclo3.Reto3.Service;

import com.Reto3_Ciclo3.Reto3.Models.Score;
import com.Reto3_Ciclo3.Reto3.Repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAllScores(){
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int score_id){
        return scoreRepository.getScore(score_id);
    }

    public Score insertScore(Score score){
        return scoreRepository.save(score);
    }

    public Score updateScore(Score score){
        if (score.getId() != null){
            Optional<Score> scoreTem = scoreRepository.getScore(score.getId());
            if (!scoreTem.isEmpty()){
                if (score.getScore() != null){
                    scoreTem.get().setScore(score.getScore());
                }

                return scoreRepository.save(scoreTem.get());
            }else {
                return score;
            }
        }else {
            return score;
        }
    }

    public Boolean deleteScore(int score_id){
        Boolean success = scoreRepository.getScore(score_id).map(score -> {
            scoreRepository.delete(score);
            return true;
        }).orElse(false);
        return success;
    }
}