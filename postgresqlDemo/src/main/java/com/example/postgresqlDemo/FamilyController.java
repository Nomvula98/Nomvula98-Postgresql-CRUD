package com.example.postgresqlDemo;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(path = "/v1/family")
@RequiredArgsConstructor
public class FamilyController {
    final FamilyService service;

    @PostMapping(value = "/add")
    public ResponseEntity<?> addFamilyMember(@RequestBody FamilyMember familyMember){
        return ResponseEntity.ok(service.addFamilyMember(familyMember));
    }

    @GetMapping(value = "/list")
    public ResponseEntity<?> listFamilyMembers() {
        return ResponseEntity.ok(service.listFamilyMembers());
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateFamilyMember(@PathVariable Long id, @RequestBody FamilyMember familyMember) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.updateFamilyMember(id, familyMember));
    }


     @GetMapping(value = "/find/{id}")
     public ResponseEntity<?> findFamilyMember(@PathVariable Long id) {
       return ResponseEntity.ok(service.findFamilyMember(id));
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteFamilyMember(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteFamilyMember(id));
    }
}
