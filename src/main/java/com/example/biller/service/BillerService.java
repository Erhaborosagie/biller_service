package com.example.biller.service;

import com.example.biller.Biller;

import java.util.List;

/**
 * Created by Upperlink Digital PC on 14/01/2020.
 */
public interface BillerService {
    Biller createBiller(Biller biller);

    Biller updateBiller(Biller biller);

    List<Biller> getAllBillers();

    Biller getBillerById(int id);

    void deleteBiller(int id);
}
