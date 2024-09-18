package org.example.persona.repositories;

import org.example.persona.entities.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomiclioRepository extends JpaRepository<Domicilio, Long>{

}
