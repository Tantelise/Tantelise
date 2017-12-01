package cl.dramos.tantelise.app.productosservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import cl.dramos.tantelise.app.productosservice.domain.Producto;
import cl.dramos.tantelise.app.productosservice.domain.respuestas.RespuestaProductosServiceDELETE;
import cl.dramos.tantelise.app.productosservice.domain.respuestas.RespuestaProductosServiceGET;
import cl.dramos.tantelise.app.productosservice.domain.respuestas.RespuestaProductosServicePOST;
import cl.dramos.tantelise.app.productosservice.domain.respuestas.RespuestaProductosServicePUT;

public interface ProductosService {
	
	public ResponseEntity<RespuestaProductosServiceGET> buscarProductoLista();
	public ResponseEntity<RespuestaProductosServiceGET> buscarProductoPorId(String productoId);
	public ResponseEntity<RespuestaProductosServiceDELETE> eliminarProducto(String productoId);
	public ResponseEntity<RespuestaProductosServicePUT> actualizarProducto(String id, Producto producto);
	public ResponseEntity<RespuestaProductosServicePOST> crearProducto(Producto producto);
	public ResponseEntity<RespuestaProductosServicePOST> crearProductoLista(List<Producto> producto);
}
