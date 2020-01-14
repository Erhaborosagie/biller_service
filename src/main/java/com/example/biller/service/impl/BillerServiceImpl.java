package com.example.biller.service.impl;

import com.example.biller.Biller;
import com.example.biller.repos.BillerRepository;
import com.example.biller.service.BillerService;
import com.example.util.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


/**
 * Created by Osagie Erhabor on 14/01/2020.
 */
@Service
@Transactional
public class BillerServiceImpl implements BillerService{

    @Autowired
    private BillerRepository billerRepository;

    @Override
    public Biller createBiller(Biller biller){
        return billerRepository.save(biller);
    }

    @Override
    public Biller updateBiller(Biller biller) {
        Optional<Biller> billerDb= this.billerRepository.findById(biller.getId());

        if(billerDb.isPresent()){
            Biller billerUpdate = billerDb.get();
            billerUpdate.setId(biller.getId());
            billerUpdate.setEmail(biller.getEmail());
            billerUpdate.setUpdatedAt(LocalDateTime.now());
            billerUpdate.setName(biller.getName());
            billerRepository.save(billerUpdate);
            return billerUpdate;
        }else {
            throw new ResourceNotFoundException("No biller found with id" + biller.getId());
        }
    }

    @Override
    public List<Biller> getAllBillers() {
        return billerRepository.findAll();
    }

    @Override
    public Biller getBillerById(int id) {
        Optional<Biller> biller= billerRepository.findById(id);

        if (biller.isPresent()){
            return biller.get();
        }
        throw new ResourceNotFoundException("No biller found with id" + id);
    }

    @Override
    public void deleteBiller(int id) {
        Optional<Biller> biller= billerRepository.findById(id);

        if (biller.isPresent()){
            this.billerRepository.deleteById(id);
        }
    }
}
