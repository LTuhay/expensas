package Model.Notificacion;

import Model.Expensa.Expensa;
import Model.UnidadFuncional.Persona;

/**
 * 
 */
public class Notificacion {

    private Expensa expensa;
    private Persona persona;
    private String mensaje;
    
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public Expensa getExpensa() {
		return expensa;
	}
	public void setExpensa(Expensa expensa) {
		this.expensa = expensa;
	}
}