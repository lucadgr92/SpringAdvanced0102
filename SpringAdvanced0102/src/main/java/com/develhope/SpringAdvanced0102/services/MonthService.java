package com.develhope.SpringAdvanced0102.services;

import com.develhope.SpringAdvanced0102.entities.MonthEntity;
import com.develhope.SpringAdvanced0102.repositories.MonthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonthService {

    @Autowired
    private MonthRepository repo;

    public MonthEntity findMonth(Integer monthNumber) {
        return repo.findByNumber(monthNumber);
    }

    public MonthEntity addMonth(MonthEntity month) {
        return repo.save(month);
    }
}
