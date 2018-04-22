package cl.tantelise.productosservice.service;

import java.util.List;
import java.util.Optional;

import cl.tantelise.productosservice.serviciosadicionales.ServicioAdicional;


public interface ServicioAdicionalService {
	public List<ServicioAdicional> buscarServicioAdicionalLista();
	public Optional<ServicioAdicional> buscarServicioAdicionalPorID(String id);
	public boolean actualizarServicioAdicional (String id,ServicioAdicional servicioAdicional);
	public boolean eliminarServicioAdicional (String id);
	public boolean crearServicioAdicional (ServicioAdicional servicioAdicional);
}
