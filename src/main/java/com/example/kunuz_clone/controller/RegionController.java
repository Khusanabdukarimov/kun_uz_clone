package com.example.kunuz_clone.controller;

import com.example.kunuz_clone.entity.Post;
import com.example.kunuz_clone.entity.Region;
import com.example.kunuz_clone.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regions")
public class RegionController {
    @Autowired
    private RegionService regionService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Region region) {
        Region ans = regionService.create(region);

        return ResponseEntity.ok(ans);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable  Integer id) {
        Region region = regionService.get(id);
        return ResponseEntity.ok(region);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable("id") Integer id, @RequestBody Region region) {
        Region ans = regionService.update(region, id);
        return ResponseEntity.ok(ans);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?> detrition(@PathVariable("id") Integer id) {
        boolean ans = regionService.delete(id);
        return ResponseEntity.ok(ans);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        List<Region> regionList = regionService.All();
        return ResponseEntity.ok(regionList);
    }

}
