package com.Reto3_Ciclo3.Reto3.Repository;
import com.Reto3_Ciclo3.Reto3.Model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCRUDRepository scoreCRUDRepository;

    public  List<Score>getAll(){
        return (List<Score>)  scoreCRUDRepository.findAll();
    }

    public Optional<Score>getScore(int id){
        return scoreCRUDRepository.findById(id);
    }
    public Score save(Score score) {
        return scoreCRUDRepository.save(score);
    }

    public void deleteScore(Score score) {
        scoreCRUDRepository.delete(score);
    }

}