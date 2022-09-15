package com.example.demo.repository;

import com.example.demo.entity.DevEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevRepository extends JpaRepository<DevEntity, Long> {
}
