package com.daifubackend.server.controller;


import com.daifubackend.server.exception.ResourceNotFoundException;
import com.daifubackend.server.entity.Admin;
import com.daifubackend.server.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/admins")
public class AdminAuthController {

    @Autowired
    private AdminRepository AdminRepository;

    @GetMapping
    public List<Admin> getAllAdmins(){
        return AdminRepository.findAll();
    }

    // build create Admin REST API
    @PostMapping
    public Admin createAdmin(@RequestBody Admin Admin) {
        return AdminRepository.save(Admin);
    }

    // build get Admin by id REST API
    @GetMapping("{idx}")
    public ResponseEntity<Admin> getAdminById(@PathVariable  long idx){
        Admin Admin = AdminRepository.findById(idx)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not exist with id:" + idx));
        return ResponseEntity.ok(Admin);
    }

    // build update Admin REST API
    @PutMapping("{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable long id,@RequestBody Admin AdminDetails) {
        Admin updateAdmin = AdminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not exist with id: " + id));

//        updateAdmin.setFirstName(AdminDetails.getFirstName());
//        updateAdmin.setLastName(AdminDetails.getLastName());
//        updateAdmin.setEmailId(AdminDetails.getEmailId());

        AdminRepository.save(updateAdmin);

        return ResponseEntity.ok(updateAdmin);
    }

    // build delete Admin REST API
    @DeleteMapping("{idx}")
    public ResponseEntity<HttpStatus> deleteAdmin(@PathVariable long idx){

        Admin Admin = AdminRepository.findById(idx)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not exist with id: " + idx));

        AdminRepository.delete(Admin);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}