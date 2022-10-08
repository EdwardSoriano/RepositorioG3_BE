package com.Reto3_Ciclo3.Reto3.Services;

import com.Reto3_Ciclo3.Reto3.Model.Reservation;

import com.Reto3_Ciclo3.Reto3.Model.Score;
import com.Reto3_Ciclo3.Reto3.Repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreServices {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAllScore() {
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int id) {
        return scoreRepository.getScore(id);
    }

    public Score insertScore(Score score) {
        if (score.getId() == null) {
            if (score.getScore() != null){   //solicita campos obligatorios
                return scoreRepository.save(score);
            } else
                return score;
        }
        return score;
    }


    public Score updateScore(Score score){
        if (score.getId() != null) {
            Optional<Score> temp = scoreRepository.getScore(score.getId());
            if (temp.isEmpty()){
                if (score.getScore() != null)
                    temp.get().setScore(score.getScore());

                scoreRepository.save(temp.get());
                return temp.get();
            }
            else
                return score;

        }
        else
            return score;
    }




    public boolean deleteScore(int id) {
        boolean success = false;
        Optional<Score> temp=scoreRepository.getScore(id);
        if (temp.isEmpty()){
            success= true;
        }
        return success;
    }

}
