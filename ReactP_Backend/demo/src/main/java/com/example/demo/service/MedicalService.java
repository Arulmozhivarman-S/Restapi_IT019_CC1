package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.MedicalRepo;
import com.example.demo.model.Medical;

@Service
public class MedicalService {
    
    @Autowired
    MedicalRepo medicalrepo;
    
    public Medical addMedicine(Medical o){
        return medicalrepo.save(o);
    }

    public List<Medical> findMedicine(){
        return medicalrepo.findAll();
    }

    public Optional<Medical> getByMedicineId(int id){
        return medicalrepo.findById(id);
    }

    public Medical editMedical(int id,Medical o){
         Medical ob=medicalrepo.findById(id).orElse(null);
         if(ob!=null){
            ob.setMedicineId(ob.getMedicineId());
            ob.setMedicineBrand(ob.getMedicineBrand());
            ob.setMedicineFor(ob.getMedicineFor());
            ob.setMedicineName(ob.getMedicineName());
            ob.setMedicinePrice(ob.getMedicinePrice());
            ob.setExpiryDate(ob.getExpiryDate());
            return medicalrepo.saveAndFlush(ob);
         }
         else return null;
         
    }

    public String deleteMedicine(int id){
        medicalrepo.deleteById(id);
        return "Medicine Deleted";
    }

   // public List<Medical> getMedicalBymanufacturedIn(String manufacturedIn){
    //    return medicalrepo.getMedicalBymanufacturedIn(manufacturedIn);
    //}

}
