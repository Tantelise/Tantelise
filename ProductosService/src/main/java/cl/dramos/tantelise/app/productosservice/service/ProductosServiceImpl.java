package cl.dramos.tantelise.app.productosservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import cl.dramos.tantelise.app.productosservice.domain.Producto;
import cl.dramos.tantelise.app.productosservice.domain.ProductoRepositorio;
import cl.dramos.tantelise.app.productosservice.domain.respuestas.RespuestaProductosServiceDELETE;
import cl.dramos.tantelise.app.productosservice.domain.respuestas.RespuestaProductosServiceGET;
import cl.dramos.tantelise.app.productosservice.domain.respuestas.RespuestaProductosServicePOST;
import cl.dramos.tantelise.app.productosservice.domain.respuestas.RespuestaProductosServicePUT;

@Service
public class ProductosServiceImpl implements ProductosService{
	
	@Autowired
	private ProductoRepositorio productoRepositorio;
	private HttpHeaders headers;
	
	public ProductosServiceImpl() {
		headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=UTF-8");
	}

	@Override
	public ResponseEntity<RespuestaProductosServiceGET> buscarProductoLista() {
		RespuestaProductosServiceGET respuestaGET = new RespuestaProductosServiceGET();
		respuestaGET.setDatos(productoRepositorio.findAll());
		return new ResponseEntity<RespuestaProductosServiceGET>(respuestaGET,headers,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<RespuestaProductosServiceGET> buscarProductoPorId(String productoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<RespuestaProductosServiceDELETE> eliminarProducto(String productoId) {
		RespuestaProductosServiceDELETE body = new RespuestaProductosServiceDELETE();
		body.setIdentificador(productoId);
		body.setEliminado(false);

		if (productoId.equals(null) || productoId == "") {
			return new ResponseEntity<RespuestaProductosServiceDELETE>(body,headers,HttpStatus.BAD_REQUEST);
		}
		
		long resultado =  productoRepositorio.deleteById(productoId);
		
		if(resultado>0) {
			body.setEliminado(true);
			return new ResponseEntity<RespuestaProductosServiceDELETE>(body,headers,HttpStatus.OK);
		}else {
			return new ResponseEntity<RespuestaProductosServiceDELETE>(body,headers,HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<RespuestaProductosServicePUT> actualizarProducto(Producto producto) {
		RespuestaProductosServicePUT body = new RespuestaProductosServicePUT();
		body.setIdentificador(producto.getId());
		body.setActualizado(false);
		
		Producto resultado = productoRepositorio.save(producto);
		if (resultado.equals(producto)) {
			body.setActualizado(true);
			return new ResponseEntity<RespuestaProductosServicePUT>(body,headers,HttpStatus.OK);
		}else if(resultado.equals(null)){
			return new ResponseEntity<RespuestaProductosServicePUT>(body,headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}else {
			return new ResponseEntity<RespuestaProductosServicePUT>(body,headers,HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity<RespuestaProductosServicePOST> crearProducto(Producto producto) {
		RespuestaProductosServicePOST resp = new RespuestaProductosServicePOST();
		resp.setCantidad(1);
		try {
			productoRepositorio.insert(producto);
			resp.getIdentificadores().add(producto.getId());		
			resp.setCreado(true);
			return new ResponseEntity<RespuestaProductosServicePOST>(resp,headers,HttpStatus.CREATED);
		}catch(Exception e) {
			resp.setCreado(false);
			return new ResponseEntity<RespuestaProductosServicePOST>(resp,headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<RespuestaProductosServicePOST> crearProductoLista(List<Producto> producto) {
		RespuestaProductosServicePOST resp = new RespuestaProductosServicePOST();
		resp.setCantidad(producto.size());
		try {
			for (Producto p : producto) {
				productoRepositorio.save(p);
				resp.getIdentificadores().add(p.getId());		
			}
			resp.setCreado(true);
			return new ResponseEntity<RespuestaProductosServicePOST>(resp,headers,HttpStatus.CREATED);
		}catch(Exception e) {
			resp.setCreado(false);
			e.printStackTrace();
			return new ResponseEntity<RespuestaProductosServicePOST>(resp,headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
