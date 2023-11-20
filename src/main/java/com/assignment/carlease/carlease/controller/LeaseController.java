package com.assignment.carlease.carlease.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.assignment.carlease.carlease.model.Lease;
import com.assignment.carlease.carlease.service.LeaseService;

import java.util.List;

@RestController
@RequestMapping("/api/leases")
public class LeaseController {

    @Autowired
    private LeaseService leaseService;
    

    @GetMapping
    public ResponseEntity<List<Lease>> getAllLeases() {
        List<Lease> leases = leaseService.getAllLeases();
        return new ResponseEntity<>(leases, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lease> getLeaseById(@PathVariable Long id) {
        Lease lease = leaseService.getLeaseById(id);
        if (lease != null) {
            return new ResponseEntity<>(lease, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Lease> addLease(@RequestBody Lease lease) {
        Lease leaseResponse = leaseService.addLease(
        		lease.getCustomer(),
        		lease.getCar(),
        		lease.getMileage(),
        		lease.getDuration(),
        		lease.getInterestRate(),
        		lease.getNettPrice(),
        		lease.getStartDate()
        );

        return new ResponseEntity<>(leaseResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lease> updateLease(@PathVariable Long id, @RequestBody Lease lease) {
        Lease updatedLease = leaseService.updateLease(
                id,
                lease.getCustomer(),
                lease.getCar(),
                lease.getMileage(),
                lease.getDuration(),
                lease.getInterestRate(),
                lease.getNettPrice(),
                lease	.getStartDate()
        );

        if (updatedLease != null) {
            return new ResponseEntity<>(updatedLease, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteLease(@PathVariable Long id) {
        boolean deleted = leaseService.deleteLease(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
   
}
