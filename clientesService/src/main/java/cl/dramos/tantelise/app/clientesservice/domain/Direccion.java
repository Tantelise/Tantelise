package cl.dramos.tantelise.app.clientesservice.domain;

public class Direccion {
	
	private String calle;
	private String numero;
	private String numeroResidencia;
	private boolean esPrincipal;
	private boolean esComercial;
	private String comuna;
	private String ciudad;
	
	public Direccion() {
		
	}
	
	public Direccion(String calle, String numero, String numeroResidencia, boolean esPrincipal, boolean esComercial,
			String comuna, String ciudad) {
		this.calle = calle;
		this.numero = numero;
		this.numeroResidencia = numeroResidencia;
		this.esPrincipal = esPrincipal;
		this.esComercial = esComercial;
		this.comuna = comuna;
		this.ciudad = ciudad;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNumeroResidencia() {
		return numeroResidencia;
	}
	public void setNumeroResidencia(String numeroResidencia) {
		this.numeroResidencia = numeroResidencia;
	}
	public boolean isEsPrincipal() {
		return esPrincipal;
	}
	public void setEsPrincipal(boolean esPrincipal) {
		this.esPrincipal = esPrincipal;
	}
	public boolean isEsComercial() {
		return esComercial;
	}
	public void setEsComercial(boolean esComercial) {
		this.esComercial = esComercial;
	}
	public String getComuna() {
		return comuna;
	}
	public void setComuna(String comuna) {
		this.comuna = comuna;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	

}
