package ViewTest;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Controller.AdministradorController;
import Controller.ConsorcioController;
import Controller.ExpensaController;
import Controller.GastoController;
import Controller.UnidadFuncionalController;
import Model.Consorcio;
import Model.CuentaBancaria.CuentaBancaria;
import Model.Expensa.*;
import Model.ExpensaCriterio.PagoCompletoGastos;
import Model.Notificacion.Notificador;

public class Main {
    public static void main(String[] args) {
        //System.out.println(Date.from(Instant.now()).toString());
        //System.out.println(new Date().toString());
    	
        System.out.println("Inicializar Administrador");
        AdministradorController admControlador = AdministradorController.obtenerInstancia();
        admControlador.login("adoopinamar","123456");
    
        System.out.println();
        
        System.out.println("Inicializar Unidades Funcionales");
        UnidadFuncionalController ufControlador = UnidadFuncionalController.obtenerInstancia();
        
        System.out.println();
        
        System.out.println("Inicializar Cuenta Bancaria");
        CuentaBancaria ctaBanco = new CuentaBancaria(1111, "token1111");
        System.out.println("El saldo de la cuenta bancaria es: " + ctaBanco.saldoActual());
        
        System.out.println();
        
        System.out.println("Gastos cargados");
        GastoController gastoControlador = GastoController.getInstancia();
        gastoControlador.initGasto();
        

        GastoDTO gasto1 = new GastoDTO(new Date(), 1000.00, "pintura", TipoExpensa.ORDINARIA, true);

        gastoControlador.crearGasto(gasto1);

        System.out.println();
        
        
        ExpensaController expensaControlador = ExpensaController.obtenerInstancia();
        ArrayList<Gasto>listaGastos = gastoControlador.getListaGastos();
        imprimirGastos(listaGastos);
        Expensa nuevaExpensa = expensaControlador.crearExpensa(listaGastos);
       
        System.out.println("Calcular Expensa");
        System.out.println("Monto total Expensa: " + expensaControlador.calcular(nuevaExpensa));

        System.out.println();
        
        System.out.println("Inicializar Consorcio");
        ConsorcioController consControlador = ConsorcioController.obtenerInstancia();
        consControlador.setConsorcio(new Consorcio(admControlador.getAdministrador(), ufControlador.getUnidadesFuncionales(), ctaBanco, expensaControlador.getExpensas(), new PagoCompletoGastos(), new Notificador()));
        
        consControlador.cambiarCriterio("FondosReservas");
        consControlador.liquidar(nuevaExpensa);
        
        System.out.println();
        
        consControlador.cambiarCriterio("GenerarFuturoFondos");
        consControlador.liquidar(nuevaExpensa);
        
    }
    
    public static void imprimirGastos(ArrayList<Gasto> lista) {
    	System.out.println("");
        System.out.println("Imprimiendo gastos");
        for (Gasto gasto : lista ) {
        	System.out.println("Gasto "+gasto.getTipoGasto());
        	System.out.println("Monto "+gasto.getMonto());
        	System.out.println("");
        	
        }
    }

    
    
}