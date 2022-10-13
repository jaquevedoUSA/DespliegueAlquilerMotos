/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ejemplojpa.crud.services;

import co.edu.usa.ejemplojpa.crud.models.Score;
import co.edu.usa.ejemplojpa.crud.repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Victor
 */
@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRep;

    public List<Score> getAll() {
        return (List<Score>) scoreRep.getAll();
    }

    public Optional<Score> getScore(int id) {
        return scoreRep.getScore(id);
    }

    public Score save(Score c) {
        if (c.getIdScore() == null) {
            return scoreRep.save(c);
        } else {
            Optional<Score> caux = scoreRep.getScore(c.getIdScore());
            if (caux.isPresent()) {
                return c;
            } else {
                return scoreRep.save(c);
            }
        }
    }

    public Score update(Score c) {

        if (c.getIdScore() != null) {

            Optional<Score> q = scoreRep.getScore(c.getIdScore());

            if (q.isPresent()) {
                if (c.getMessageText() != null) {
                    q.get().setMessageText(c.getMessageText());
                }

                if (c.getStars() != null) {
                    q.get().setStars(c.getStars());
                }
                
                if (c.getReservation() != null) {
                    q.get().setReservation(c.getReservation());
                }

                scoreRep.save(q.get());
                return q.get();
            } else {
                return c;
            }
        } else {
            return c;
        }
    }

    public boolean delete(int id) {
        boolean flag = false;

        Optional<Score> c = scoreRep.getScore(id);

        if (c.isPresent()) {
            scoreRep.delete(c.get());
            flag = true;
        }
        return flag;
    }
}
