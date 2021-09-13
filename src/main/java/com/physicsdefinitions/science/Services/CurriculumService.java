package com.physicsdefinitions.science.Services;

import java.util.List;

import com.physicsdefinitions.science.ErrorHandling.ApiException;
import com.physicsdefinitions.science.Models.Curriculum;
import com.physicsdefinitions.science.Repositories.CurriculumRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurriculumService {

    @Autowired
    private CurriculumRepository currRepo;

    public CurriculumService(CurriculumRepository currRepo) {
        this.currRepo = currRepo;
    }

    public List<Curriculum> getAllCurriculums() {
        return currRepo.findAll();
    }

    public Curriculum getCurriculum(int id) {
        return currRepo.findById(id).orElseThrow(() -> new ApiException("curriculum with id " + id + " not found."));
    }

    public void saveCurriculum(Curriculum curriculum) {
        try {
            currRepo.save(curriculum);
        } catch (Exception e) {
            throw new ApiException(e.getLocalizedMessage());
        }
    }

}
