package com.compunet.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.compunet.springboot.model.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    
}
