package com.Uisrael.consultaJPQL.repositories;

import com.Uisrael.consultaJPQL.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // 3. Obtener todos los pedidos que contienen un producto específico
    @Query("SELECT p FROM Pedido p JOIN p.productos pr WHERE pr.id = :productoId")
    List<Pedido> findPedidosByProductoId(Long productoId);

    // 4. Obtener todos los pedidos de un cliente específico
    @Query("SELECT p FROM Pedido p WHERE p.cliente.id = :clienteId")
    List<Pedido> findPedidosByClienteId(Long clienteId);
}