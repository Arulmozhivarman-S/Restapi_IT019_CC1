package com.example.demo.Repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Medical;

@Repository
public interface MedicalRepo extends JpaRepository<Medical,Integer> {
   // List<Medical> getMedicalBymanufacturedIn(String manufacturedIn);
}
