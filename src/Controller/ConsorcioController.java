package Controller;

import Model.Consorcio;
import Model.Administrador.Administrador;
import Model.CuentaBancaria.CuentaBancaria;
import Model.Expensa.*;
import Model.ExpensaCriterio.*;
import Model.Notificacion.Notificador;
import Model.UnidadFuncional.UnidadFuncional;

import java.time.Instant;
import java.util.*;

/**
 * 
 */
public class ConsorcioController {

    private static ConsorcioController instancia;
    private static Consorcio consorcio;
	
    public static Consorcio getConsorcio() {
		return consorcio;
	}

	public static void setConsorcio(Consorcio consorcio) {
		ConsorcioController.consorcio = consorcio;
	}

	public static ConsorcioController obtenerInstancia() {
        if (instancia == null) instancia = new ConsorcioController();
        
        return instancia;
    }
    
    private ConsorcioController() {
    	this.consorcio = new Consorcio();
    }

    public void liquidar(Expensa e) {
        this.consorcio.liquidar(e);
    }
    
    public void cambiarCriterio(String criterio) {
    	switch (criterio) {
    		case "GenerarFuturoFondos":
    			this.consorcio.cambiarCriterio(new PagoCompleto_GenerarFuturoFondos());
    			break;
	    	case "FondosReservas":
	    		this.consorcio.cambiarCriterio(new PagoCompletoFondosReservas());
    			break;
	    	case "Gastos" :
    		default:
    			this.consorcio.cambiarCriterio(new PagoCompletoGastos());
    			break;
    	}
    }

    public void cargarTest() {
    	Administrador administrador;
    	List<UnidadFuncional> unidadesFuncionales;
    	CuentaBancaria cuentaBancaria;
    	List<Expensa> expensas;
    	ExpensaCriterio criterio;
    	Notificador notificador;
    	
    	
    	
    	//this.consorcio = new Consorcio(administrador, unidadesFuncionales, cuentaBancaria, expensas, criterio, notificador);
    }

}