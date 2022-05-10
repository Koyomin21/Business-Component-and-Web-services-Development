package itse1909r.borangaziyev.service;


import itse1909r.borangaziyev.model.ElectricityBill;
import itse1909r.borangaziyev.repository.ElectricityBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ElectricityBillService {

    private ElectricityBillRepository billRepository;

    @Autowired
    public ElectricityBillService(ElectricityBillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public List<ElectricityBill> getAllBills() {
        List<ElectricityBill> bills = billRepository.getAllElectricityBills();

        // sorting bills by startPeriod
        if(bills != null || !bills.isEmpty()) {
            List<ElectricityBill> sortedList = bills.stream()
                    .sorted(Comparator.comparing(ElectricityBill::getStartPeriod))
                    .collect(Collectors.toList());

            return sortedList;
        }

        return new ArrayList<>();
    }
}
