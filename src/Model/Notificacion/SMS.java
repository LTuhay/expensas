package Model.Notificacion;

/**
 * 
 */
public class SMS implements EstrategiaNotificacion{

	public void enviar(Notificacion notificacion) {
		System.out.print("Enviado a " + notificacion.getPersona().getNombre());
		System.out.print(" " + notificacion.getPersona().getApellido());
		System.out.println(" por SMS al " + notificacion.getPersona().getTelefono());
	}
}