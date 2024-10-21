package com.Uisrael.consultaJPQL.repositories;

import com.Uisrael.consultaJPQL.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}