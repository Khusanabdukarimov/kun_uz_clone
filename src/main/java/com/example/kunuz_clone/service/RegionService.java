package com.example.kunuz_clone.service;

import com.example.kunuz_clone.entity.Region;
import com.example.kunuz_clone.exception.MyException;
import com.example.kunuz_clone.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

    @Autowired
    private RegionRepository repository;

    public Region create(Region region) {
        repository.save(region);
        return region;
    }

    public Region get(Integer id) {
        return check(id);
    }

    public Region update(Region region, Integer id) {
       Region r = get(id);
       r.setName(region.getName());
       repository.save(r);
       return r;
    }

    public boolean delete(Integer id) {
        Region region = get(id);
        repository.delete(region);
        return true;
    }

    public List<Region> All() {
        List<Region> alls = repository.findAll();
        if(alls.isEmpty()) {
            throw new MyException("There are no Regions");
        }
        return alls;
    }

    public Region check(Integer id) {
        Optional<Region> optional = repository.findById(id);
        if(optional.isEmpty()) {
            throw new MyException("not found");
        }
        return optional.get();
    }
}
