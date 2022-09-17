package com.example.demo.repository;

import com.example.demo.entity.RetiredDev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetiredRepository extends JpaRepository<RetiredDev, Long> {
}
