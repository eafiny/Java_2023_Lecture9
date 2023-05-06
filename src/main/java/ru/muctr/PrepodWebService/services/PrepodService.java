package ru.muctr.PrepodWebService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.muctr.PrepodWebService.models.Prepod;
import ru.muctr.PrepodWebService.repositories.InMemoryPrepodRepository;

/**
 * @author Evgenia Skichko
 */

@Service
public class PrepodService {
    InMemoryPrepodRepository prepodRepository;

    @Autowired
    public PrepodService(InMemoryPrepodRepository prepodRepository) {
        this.prepodRepository = prepodRepository;
    }

    public Prepod findPrepodById(int id){
        return prepodRepository.getPrepodById(id).get();
    }

    public void createPrepod(Prepod prepod){
        prepodRepository.createPrepod(prepod);
    }
}
