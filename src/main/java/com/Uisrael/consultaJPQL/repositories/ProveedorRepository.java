package com.Uisrael.consultaJPQL.repositories;

import com.Uisrael.consultaJPQL.entities.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
}