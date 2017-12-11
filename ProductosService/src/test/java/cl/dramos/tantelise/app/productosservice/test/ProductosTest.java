package cl.dramos.tantelise.app.productosservice.test;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;

import cl.dramos.tantelise.app.productosservice.domain.DetalleAdicional;
import cl.dramos.tantelise.app.productosservice.domain.DetallePersonas;
import cl.dramos.tantelise.app.productosservice.domain.Imagen;
import cl.dramos.tantelise.app.productosservice.domain.Producto;
import cl.dramos.tantelise.app.productosservice.domain.Torta;
import cl.dramos.tantelise.app.productosservice.domain.respuestas.RespuestaProductosServicePOST;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductosTest {
	
	private static final String URI = "http://localhost:8989/";

	private HttpHeaders headers;
	
	private static final Logger LOG = LoggerFactory.getLogger(ProductosTest.class);
	private String Bearer = "";
	
	
	@Before
	public void inicializarTests() {
		LOG.debug("Iniciando tests");
		resetBearer();
		headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=UTF-8");
		headers.add("Authorization", "Bearer "+Bearer);
	}
	
	public void resetBearer() {
		this.Bearer = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MTI2MTQ3NjIsInVzZXJfbmFtZSI6ImRhbmllbCIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNVQVJJTyIsIlJPTEVfQURNSU4iXSwianRpIjoiODkzNTA1NWEtMzQ0Zi00YWVkLTkyNDktYWJiODY4MDA3Y2VjIiwiY2xpZW50X2lkIjoiY2xpZW50ZSIsInNjb3BlIjpbIndlYiJdfQ.ntn5Ssx3hROlpKnkgxp6EhpR7ugz-S1sdOUBbYQ0Qyw";
	}
	
	
	
	@Test
	public void crearProductoOK() {
		LOG.trace("-------------------------------------------------------");
		LOG.trace("Iniciando test de crearProductoOK");
		String categoriaProducto = "Categoría N°: TEST";
		String descripcion = "Descripción del producto N° TEST ";
		String estado = "Estado nN°:TEST";
		String fechaIngreso = "2017-11-09";
		String fechaUltimaModificacion = "2017-11-09";
		String nombreProducto = "Producto N°: TEST";
		String unidadVenta = "Unidad tipo N°:  TEST";
		float precioUnidad = (float) Math.random();

		ArrayList<Imagen> imagen = new ArrayList<Imagen>();
		imagen.add(new Imagen("http://via.placeholder.com/350x150", "place1", false));
		imagen.add(new Imagen("http://via.placeholder.com/350x450", "place2", false));
		imagen.add(new Imagen("http://via.placeholder.com/350x650", "place3", true));

		Torta torta = new Torta();
		ArrayList<DetalleAdicional> detalleAdicional = new ArrayList<DetalleAdicional>();
		ArrayList<DetallePersonas> detallePersonas = new ArrayList<DetallePersonas>();
		torta.setTipoTorta("Tipo torta: TEST");
		detalleAdicional.add(new DetalleAdicional("Adicional : 1", "Consideraciones para Adicional 1", 2500));
		detalleAdicional.add(new DetalleAdicional("Adicional: 2", "Consideraciones para Adicional 2", 2500));
		detallePersonas.add(new DetallePersonas(300, 600));
		detallePersonas.add(new DetallePersonas(566, 788));
		torta.setDetalleAdicional(detalleAdicional);
		torta.setDetallePersonas(detallePersonas);

		Producto producto = new Producto();
		producto.setCategoriaProducto(categoriaProducto);
		producto.setDescripcion(descripcion);
		producto.setEstado(estado);
		producto.setFechaIngreso(fechaIngreso);
		producto.setFechaUltimaModificacion(fechaUltimaModificacion);
		producto.setImagen(imagen);
		producto.setNombreProducto(nombreProducto);
		producto.setPrecioUnidad(precioUnidad);
		producto.setTorta(torta);
		producto.setUnidadVenta(unidadVenta);
		producto.setId("1234567890");

		ArrayList<String> ids = new ArrayList<String>();
		ids.add(producto.getId());

		RespuestaProductosServicePOST respuestaExpected = new RespuestaProductosServicePOST();
		respuestaExpected.setCantidad(1);
		respuestaExpected.setCreado(true);
		respuestaExpected.setIdentificadores(ids);

		TestRestTemplate restTemplate = new TestRestTemplate();
		ArrayList<Producto> arrayProductos = new ArrayList<Producto>();
		arrayProductos.add(producto);
		Gson gson = new Gson();

		RequestEntity<String> request = null;
		try {
			request = new RequestEntity<String>(gson.toJson(arrayProductos), headers, HttpMethod.POST,
					new URI(URI+"productos"));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		ResponseEntity<RespuestaProductosServicePOST> respuesta = restTemplate.exchange(request, RespuestaProductosServicePOST.class);
		
		String httpObtenido,httpEsperado;
		httpEsperado = HttpStatus.CREATED.toString();
		httpObtenido = respuesta.getStatusCode().toString();		
		LOG.trace("Código HTTP obtenido: " +httpObtenido);
		LOG.trace("Código HTTP esperado: " +httpEsperado);
		if(!httpEsperado.equals(httpObtenido)) {
			LOG.debug("Los códigos no coinciden, la prueba fallará");
		}
		
		String respuestaObtenida, respuestaEsperada;
		
		respuestaObtenida = gson.toJson(respuestaExpected);
		respuestaEsperada = gson.toJson(respuesta.getBody());
		LOG.trace("Respuesta JSON obtenida: " +respuestaObtenida);
		LOG.trace("Respuesta JSON  esperada: " +respuestaEsperada);
		
		if(respuestaObtenida.equals(respuestaEsperada)){
			LOG.debug("[crearProducto] son identicas, prueba finalizará OK");
		}else {
			LOG.debug("[crearProducto]respuestas distintas, prueba fallará");
		}
		
		assertEquals(httpEsperado, httpObtenido);
		assertEquals(gson.toJson(respuestaExpected), gson.toJson(respuesta.getBody()));
	}
	
	@Test
	public void crearProductoNoOK_SinAutorizacion() {
		this.headers.remove("Authorization");
		LOG.trace("-------------------------------------------------------");
		LOG.trace("Iniciando test de crearProductoNoOK_SinAutorizacion");
		String categoriaProducto = "Categoría N°: TEST";
		String descripcion = "Descripción del producto N° TEST ";
		String estado = "Estado nN°:TEST";
		String fechaIngreso = "2017-11-09";
		String fechaUltimaModificacion = "2017-11-09";
		String nombreProducto = "Producto N°: TEST";
		String unidadVenta = "Unidad tipo N°:  TEST";
		float precioUnidad = (float) Math.random();

		ArrayList<Imagen> imagen = new ArrayList<Imagen>();
		imagen.add(new Imagen("http://via.placeholder.com/350x150", "place1", false));
		imagen.add(new Imagen("http://via.placeholder.com/350x450", "place2", false));
		imagen.add(new Imagen("http://via.placeholder.com/350x650", "place3", true));

		Torta torta = new Torta();
		ArrayList<DetalleAdicional> detalleAdicional = new ArrayList<DetalleAdicional>();
		ArrayList<DetallePersonas> detallePersonas = new ArrayList<DetallePersonas>();
		torta.setTipoTorta("Tipo torta: TEST");
		detalleAdicional.add(new DetalleAdicional("Adicional : 1", "Consideraciones para Adicional 1", 2500));
		detalleAdicional.add(new DetalleAdicional("Adicional: 2", "Consideraciones para Adicional 2", 2500));
		detallePersonas.add(new DetallePersonas(300, 600));
		detallePersonas.add(new DetallePersonas(566, 788));
		torta.setDetalleAdicional(detalleAdicional);
		torta.setDetallePersonas(detallePersonas);

		Producto producto = new Producto();
		producto.setCategoriaProducto(categoriaProducto);
		producto.setDescripcion(descripcion);
		producto.setEstado(estado);
		producto.setFechaIngreso(fechaIngreso);
		producto.setFechaUltimaModificacion(fechaUltimaModificacion);
		producto.setImagen(imagen);
		producto.setNombreProducto(nombreProducto);
		producto.setPrecioUnidad(precioUnidad);
		producto.setTorta(torta);
		producto.setUnidadVenta(unidadVenta);
		producto.setId("1234567890");

		ArrayList<String> ids = new ArrayList<String>();
		ids.add(producto.getId());

		RespuestaProductosServicePOST respuestaExpected = new RespuestaProductosServicePOST();
		respuestaExpected.setCantidad(1);
		respuestaExpected.setCreado(true);
		respuestaExpected.setIdentificadores(ids);

		TestRestTemplate restTemplate = new TestRestTemplate();
		ArrayList<Producto> arrayProductos = new ArrayList<Producto>();
		arrayProductos.add(producto);
		Gson gson = new Gson();

		RequestEntity<String> request = null;
		try {
			request = new RequestEntity<String>(gson.toJson(arrayProductos), headers, HttpMethod.POST,
					new URI(URI+"productos"));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		ResponseEntity<RespuestaProductosServicePOST> respuesta = restTemplate.exchange(request, RespuestaProductosServicePOST.class);
		
		String httpObtenido,httpEsperado;
		httpEsperado = HttpStatus.UNAUTHORIZED.toString();
		httpObtenido = respuesta.getStatusCode().toString();		
		LOG.trace("Código HTTP obtenido: " +httpObtenido);
		LOG.trace("Código HTTP esperado: " +httpEsperado);
		if(!httpEsperado.equals(httpObtenido)) {
			LOG.debug("Los códigos no coinciden, la prueba fallará");
		}else {
			LOG.debug("Prueba finalazará OK, códigos http coinciden");
		}
		resetBearer();
		assertEquals(httpEsperado, httpObtenido);
	}	

}
