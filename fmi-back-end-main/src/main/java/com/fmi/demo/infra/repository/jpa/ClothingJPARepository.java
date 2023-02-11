package com.fmi.demo.infra.repository.jpa;

import com.fmi.demo.infra.jpa.ClothingJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothingJPARepository extends JpaRepository<ClothingJPA,String> {
}
