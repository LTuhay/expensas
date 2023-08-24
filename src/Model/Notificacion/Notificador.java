package Model.Notificacion;

/**
 * 
 */
public class Notificador {

    private Notificacion notificacion;
    private EstrategiaNotificacion estrategia;
    
    
    public void enviar() {
    	this.estrategia.enviar(notificacion);
    }
    
    public void cambiarEstrategia(EstrategiaNotificacion nuevaEstrategia) {
        this.estrategia = nuevaEstrategia;
    }

	public EstrategiaNotificacion getEstrategiaDeNotificacion() {
		return estrategia;
	}

	public Notificacion getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(Notificacion notificacion) {
		this.notificacion = notificacion;
		
		//cambia estrategia a la más apropiada
		if (!notificacion.getPersona().getTelefono().isEmpty())
			this.cambiarEstrategia(new WhatsApp());
		else if (!notificacion.getPersona().getEmail().isEmpty())
			this.cambiarEstrategia(new Email());
		else
			this.cambiarEstrategia(new SMS());
	}


}