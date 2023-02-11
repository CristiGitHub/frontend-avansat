package com.fmi.demo.infra.repository.jpa;

import com.fmi.demo.infra.jpa.ClothesCategoryJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothesCategoryJPARepository extends JpaRepository<ClothesCategoryJPA,String> {
}
