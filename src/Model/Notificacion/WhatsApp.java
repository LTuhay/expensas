package Model.Notificacion;

/**
 * 
 */
public class WhatsApp implements EstrategiaNotificacion{

	public void enviar(Notificacion notificacion) {
		System.out.print("Enviado a " + notificacion.getPersona().getNombre());
		System.out.print(" " + notificacion.getPersona().getApellido());
		System.out.println(" por WhatsApp al " + notificacion.getPersona().getTelefono());
	}
}