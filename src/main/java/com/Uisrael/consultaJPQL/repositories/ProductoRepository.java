package com.Uisrael.consultaJPQL.repositories;

import com.Uisrael.consultaJPQL.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // 5. Obtener todos los productos de una categoría específica
    @Query("SELECT p FROM Producto p WHERE p.categoria.id = :categoriaId")
    List<Producto> findProductosByCategoriaId(Long categoriaId);
}