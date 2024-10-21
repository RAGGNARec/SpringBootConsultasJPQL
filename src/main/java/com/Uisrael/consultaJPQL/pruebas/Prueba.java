package com.Uisrael.consultaJPQL.pruebas;

import com.Uisrael.consultaJPQL.entities.*;
import com.Uisrael.consultaJPQL.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Prueba implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public void run(String... args) throws Exception {

        // Crear y guardar categorías
        Categoria categoria1 = new Categoria();
        categoria1.setNombre("Comida");
        categoriaRepository.save(categoria1);

        Categoria categoria2 = new Categoria();
        categoria2.setNombre("Bebidas");
        categoriaRepository.save(categoria2);

        // Crear y guardar proveedores
        Proveedor proveedor1 = new Proveedor();
        proveedor1.setNombre("Proveedor 1");
        proveedor1.setContacto("123456789");
        proveedorRepository.save(proveedor1);

        Proveedor proveedor2 = new Proveedor();
        proveedor2.setNombre("Proveedor 2");
        proveedor2.setContacto("987654321");
        proveedorRepository.save(proveedor2);

        // Crear y guardar productos
        Producto producto1 = new Producto();
        producto1.setNombre("Pizza");
        producto1.setPrecio(12.50);
        producto1.setCategoria(categoria1);
        producto1.setProveedor(proveedor1);
        productoRepository.save(producto1);

        Producto producto2 = new Producto();
        producto2.setNombre("Cerveza");
        producto2.setPrecio(3.00);
        producto2.setCategoria(categoria2);
        producto2.setProveedor(proveedor2);
        productoRepository.save(producto2);

        // Crear y guardar clientes
        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Juan Pérez");
        cliente1.setDireccion("Calle Falsa");
        clienteRepository.save(cliente1);

        // Crear y guardar pedidos
        Pedido pedido1 = new Pedido();
        pedido1.setTotal(15.50);
        pedido1.setCliente(cliente1);

        // Agregar productos al pedido
        List<Producto> productosPedido = new ArrayList<>();
        productosPedido.add(producto1);
        productosPedido.add(producto2);
        pedido1.setProductos(productosPedido);
        pedidoRepository.save(pedido1);

        // Llamadas a consultas

        // 1. Obtener todos los pedidos de un cliente por su ID
        List<Pedido> pedidosPorCliente = pedidoRepository.findPedidosByClienteId(cliente1.getId());
        System.out.println("Pedidos del cliente: " + pedidosPorCliente.size());

        // 2. Obtener clientes con pedidos mayores a un monto específico
        List<Cliente> clientesConPedidosAltos = clienteRepository.findClientesWithPedidosAboveMonto(10.00);
        System.out.println("Clientes con pedidos mayores a 10.00: " + clientesConPedidosAltos.size());

        // 3. Obtener todos los pedidos que contienen un producto específico
        List<Pedido> pedidosPorProducto = pedidoRepository.findPedidosByProductoId(producto1.getId());
        System.out.println("Pedidos que contienen el producto Pizza: " + pedidosPorProducto.size());

        // 4. Obtener productos de una categoría específica
        List<Producto> productosPorCategoria = productoRepository.findProductosByCategoriaId(categoria1.getId());
        System.out.println("Productos en la categoría Comida: " + productosPorCategoria.size());

        // 5. Obtener todos los clientes que tienen pedidos
        List<Cliente> clientesConPedidos = clienteRepository.findClientesWithPedidos(cliente1.getId());
        System.out.println("Clientes con pedidos: " + clientesConPedidos.size());
    }
}
