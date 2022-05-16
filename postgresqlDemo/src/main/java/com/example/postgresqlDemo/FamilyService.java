package com.example.postgresqlDemo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FamilyService {
    final FamilyRepository familyRepository;
    FamilyMember member;

    public String addFamilyMember(FamilyMember familyMember) {
        familyRepository.save(familyMember);
        return "Family member added to DB";
    }

    public List listFamilyMembers() {
        List<FamilyMember> list = familyRepository.findAll();
        return list;
    }

    public FamilyMember updateFamilyMember(Long id, FamilyMember familyMember) {

        FamilyMember memberUpdate = familyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Family member not found with id no: " + id));

        memberUpdate.setName(familyMember.getName());
        memberUpdate.setSurname(familyMember.getSurname());
        memberUpdate.setAge(familyMember.getAge());
        memberUpdate.setGender(familyMember.getGender());
        return familyRepository.save(memberUpdate);
    }

    public Optional findFamilyMember(@PathVariable Long id) {
        Optional<FamilyMember> member = familyRepository.findById(id);
        return member;
    }

    public String deleteFamilyMember(Long id) {
        FamilyMember member = familyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Family member not found with id no: " + id));
        familyRepository.delete(member);
        return "Family member has been removed!";
    }
}
