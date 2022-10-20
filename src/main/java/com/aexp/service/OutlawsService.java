package com.aexp.service;

import com.aexp.entities.Idea;
import com.aexp.repositories.OutlawsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OutlawsService {

    @Autowired
    private OutlawsRepository repo;

    public List<Idea> listAll() {
        return repo.findAll();
    }

    public void save(Idea idea) {
        repo.save(idea);
    }

    public Idea get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }


}