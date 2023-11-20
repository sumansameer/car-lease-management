package com.assignment.carlease.carlease.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.carlease.carlease.model.Lease;

public interface LeaseRepository extends JpaRepository<Lease, Long>  {

}
