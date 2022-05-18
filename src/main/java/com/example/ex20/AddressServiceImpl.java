package com.example.ex20;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressServiceImpl implements AddressService {
    private final AddressRepository rep;

    @Override
    public List<Address> getAll() {
        log.info("Address Service getAll()");
        return rep.findAll();
    }

    @Override
    public Address getById(Long id) {
        log.info("Address Service getById( {} )", id);
        if(rep.existsById(id)) {
            return rep.getById(id);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id){
        log.info("Address Service deleteById( {} )", id);
        rep.deleteById(id);
    }

    @Override
    public void update(Address a) {
        log.info("Address Service update( {} )", a);
        rep.saveAndFlush(a);
    }

    @Override
    public void create(Address a) {
        log.info("Address Service create( {} )", a);
        rep.saveAndFlush(a);
    }

    @Override
    public List<Address> findByZip(String zip) {
        log.info("Address Service findByZip( {} )", zip);
        return rep.findAllByZipCode(zip);
    }

    @Override
    public List<Address> findByText(String text) {
        log.info("Address Service findByText( {} )", text);
        return rep.findAllByAddressText(text);
    }

    @Override
    public List<Address> findByBuilding(Long bId) {
        log.info("Address Service findByBuilding( {} )", bId);
        return rep.findAllByBuildingId(bId);
    }

}
