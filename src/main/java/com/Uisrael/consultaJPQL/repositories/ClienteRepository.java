package com.Uisrael.consultaJPQL.repositories;

import com.Uisrael.consultaJPQL.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // 1. Obtener todos los clientes con pedidos mayores a un monto específico
    @Query("SELECT c FROM Cliente c JOIN c.pedidos p WHERE p.total > :monto")
    List<Cliente> findClientesWithPedidosAboveMonto(Double monto);

    // 2. Obtener todos los clientes que tienen pedidos (con JOIN)
    @Query("SELECT DISTINCT c FROM Cliente c JOIN c.pedidos p WHERE c.id = :clienteId")
    List<Cliente> findClientesWithPedidos(Long clienteId);  // Devuelve Clientes con pedidos
}
