package com.sparta.spring.repository;

import com.sparta.spring.entity.Spring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringRepository extends JpaRepository<Spring, Long> {
    List<Spring> findAllByOrderByModifiedAtDesc();

}
