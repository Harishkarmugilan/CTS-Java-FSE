package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Stock;
import com.cognizant.orm_learn.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getStocksByDate(String code,LocalDate startDate,LocalDate endDate) {

        List<Stock> stocks =
                stockRepository.findByCodeAndDateBetween(
                        code,
                        startDate,
                        endDate );
        return stocks;

    }

    public List<Stock> findByCodeAndCloseGreaterThan(String code,double close) {

        List<Stock> stocks = stockRepository.findByCodeAndCloseGreaterThan(code,close);
        return stocks;

    }

    public List<Stock> findTop3ByCodeOrderByCloseAsc(String code) {

        List<Stock> stocks =
                stockRepository.findTop3ByCodeOrderByCloseAsc(code);
        return stocks;


    }


}
