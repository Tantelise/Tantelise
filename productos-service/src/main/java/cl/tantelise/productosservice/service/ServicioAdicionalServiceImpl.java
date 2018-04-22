package cl.tantelise.productosservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import cl.tantelise.productosservice.productos.Producto;
import cl.tantelise.productosservice.serviciosadicionales.ServicioAdicional;
import cl.tantelise.productosservice.serviciosadicionales.ServicioAdicionalRepositorio;

@Service
public class ServicioAdicionalServiceImpl implements ServicioAdicionalService{
	
	private static final Logger LOG = LoggerFactory.getLogger(ProductosService.class);
	@Autowired 
	private ServicioAdicionalRepositorio servicioAdicionalRepositorio;

	@Override
	public List<ServicioAdicional> buscarServicioAdicionalLista() {
		LOG.trace("buscarServicioAdicionalLista");
		List<ServicioAdicional> servicioAdicionalLista = new ArrayList<ServicioAdicional>();
		servicioAdicionalLista = this.servicioAdicionalRepositorio.findAll();
		LOG.trace("Servicios adicionales encontrados: ");
		LOG.trace(new Gson().toJson(servicioAdicionalLista));
		return servicioAdicionalLista;
	}

	@Override
	public Optional<ServicioAdicional> buscarServicioAdicionalPorID(String id) {
		LOG.trace("buscarServicioAdicionalPorID");
		Optional<ServicioAdicional> servicioAdicional = this.servicioAdicionalRepositorio.findById(id);
		LOG.trace("Servicio adicional encontrado ");
		LOG.trace(new Gson().toJson(servicioAdicional));
		return servicioAdicional;
	}

	@Override
	public boolean actualizarServicioAdicional(String id, ServicioAdicional servicioAdicional) {
		LOG.trace("actualizarServicioAdicional");
		LOG.trace("actualizando servicio adicional, verificando servicio adicional: " +id);
		LOG.trace(new Gson().toJson(servicioAdicional));

		boolean isUpdated = false;

		try {
			if(servicioAdicional.getId().equals(id)) {
				this.buscarServicioAdicionalPorID(id).get();
				this.servicioAdicionalRepositorio.save(servicioAdicional);
				LOG.trace("actualizado OK");
				isUpdated = true;
			}else {
				LOG.error(" No coinciden los IDs de servicios adicionales");
			}



		} catch (NoSuchElementException e) {
			LOG.trace("actualizado No OK");
			LOG.error("No se ha podido actualizar el servicio adicional indicado");
		}
		return isUpdated;
	}

	@Override
	public boolean eliminarServicioAdicional(String id) {
		LOG.trace("eliminarServicioAdicional");
		LOG.trace("Eliminando servicio adicional, verificando ");

		boolean isDeleted = false;

		try {
			this.buscarServicioAdicionalPorID(id).get();
			this.servicioAdicionalRepositorio.deleteById(id);
			LOG.trace("Eliminado OK");
			isDeleted = true;

		} catch (NoSuchElementException e) {
			LOG.trace("Eliminado No OK");
			LOG.error("No se ha podido eleiminar el servicio adicional indicado");
		}
		return isDeleted;
	}

	@Override
	public boolean crearServicioAdicional(ServicioAdicional servicioAdicional) {
		LOG.trace("crearServicioAdicional");
		LOG.trace("crear servicio: ");
		LOG.trace(new Gson().toJson(servicioAdicional));

		boolean isCreado = false;

		try {
			this.servicioAdicionalRepositorio.insert(servicioAdicional);
			LOG.trace("creado OK");
			isCreado = true;

		} catch (Exception e) {
			LOG.trace("creado No OK");
			LOG.error("No se ha podido crear el servicio indicado");
		}
		return isCreado;
	}

}
