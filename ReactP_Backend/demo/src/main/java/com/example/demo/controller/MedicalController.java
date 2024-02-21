package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Medical;
import com.example.demo.service.MedicalService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class MedicalController {
    
    @Autowired
    MedicalService medicalservice;

    @PostMapping("/path")
    public Medical postMethodName(@RequestBody Medical M){
        return medicalservice.addMedicine(M);
    }

    @GetMapping("/path1")
    public ResponseEntity<List<Medical>> getMethodName() {
        return new ResponseEntity<>(medicalservice.findMedicine(),HttpStatus.OK);
        
    }
    @GetMapping("path2/{id}")
    public ResponseEntity<Optional<Medical>> getMethodName(@PathVariable int id) {
        return new ResponseEntity<>(medicalservice.getByMedicineId(id),HttpStatus.OK);
    }
    
    //@GetMapping("/custom/{manufacturedIn}")
    //public List<Medical> getMethodName(@PathVariable String manufacturedIn) {
    //    return medicalservice.getMedicalBymanufacturedIn(manufacturedIn);
    //}
    
    
    @PutMapping("/path3/{medicineId}")
    public ResponseEntity<Medical> putMethodName(@PathVariable int id, @RequestBody Medical ent) {
        return new ResponseEntity<>(medicalservice.editMedical(id, ent),HttpStatus.OK);
    }

    @DeleteMapping("/path4/{id}")
    public ResponseEntity<String> deleteMedicine(@PathVariable int id){
        return new ResponseEntity<>(medicalservice.deleteMedicine(id),HttpStatus.OK);
    }


}
