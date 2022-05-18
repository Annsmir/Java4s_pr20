package com.example.ex20;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class BuldingServiceImpl implements BuildingService {
    private final BuildingRepository rep;

    @Override
    public List<Building> getAll() {
        log.info("Building Service getAll()");
        return rep.findAll();
    }

    @Override
    public Building getById(long id) {
        log.info("Building Service getById( {} )", id);
        if(rep.existsById(id)) {
            return rep.getById(id);
        } else {
            return null;
        }

    }

    @Override
    public void deleteById(long id) {
        log.info("Building Service deleteById( {} )", id);
        rep.deleteById(id);
    }

    @Override
    public void update(Building a) {
        log.info("Building Service update( {} )", a);
        rep.saveAndFlush(a);
    }

    @Override
    public void create(Building a) {
        log.info("Building Service create( {} )", a);
        rep.saveAndFlush(a);
    }

    @Override
    public List<Building> findByCreationDate(String creationDate) {
        log.info("Building Service findByCreationDate( {} )", creationDate);
        return rep.findByCreationDate(creationDate);
    }

    @Override
    public List<Building> findByType(String type) {
        log.info("Building Service findByType( {} )", type);
        return rep.findByType(type);
    }
}
