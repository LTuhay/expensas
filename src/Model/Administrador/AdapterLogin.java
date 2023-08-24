package Model.Administrador;

/**
 * 
 */
public class AdapterLogin implements IAdapterLogin {

    public void login(String usuario, String pass) {
        // TODO implement here
    	if (usuario.equals("adoopinamar") && pass.equals("123456")) {
    		System.out.println("Se ha logueado exitosamente");
    	}else {
    		System.out.println("Datos Incorrectos");
    	}

    }


}