package Model.Notificacion;

public class Email implements EstrategiaNotificacion{

	public void enviar(Notificacion notificacion) {
		System.out.print("Enviado a " + notificacion.getPersona().getNombre());
		System.out.print(" " + notificacion.getPersona().getApellido());
		System.out.println(" por Email al " + notificacion.getPersona().getEmail());
	}
}