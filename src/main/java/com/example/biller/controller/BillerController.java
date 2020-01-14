package com.example.biller.controller;

import com.example.biller.Biller;
import com.example.biller.service.BillerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Osagie Erhabor on 14/01/2020.
 */
@RequestMapping("/billers")
@RestController
public class BillerController {


    private BillerService billerService;

    @Autowired
    public BillerController(BillerService billerService) {
        System.out.println("Initializing biller controller");
        this.billerService = billerService;
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Biller> getAllBillers(){
        return billerService.getAllBillers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Biller> getProductById(@PathVariable int id){
        return ResponseEntity.ok().body(billerService.getBillerById(id));
    }

    @PostMapping(path="/create")
    public ResponseEntity createBiller(@RequestBody Biller biller){
        return ResponseEntity.ok().body(billerService.createBiller(biller));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Biller> updateBiller(@PathVariable int id, @RequestBody Biller biller){
        biller.setId(id);
        return ResponseEntity.ok().body(billerService.updateBiller(biller));
    }
}
