package Model.ExpensaCriterio;

import java.time.Instant;
import java.util.*;

import Model.UnidadFuncional.UnidadFuncional;

/**
 * 
 */
public class PagoCompletoGastos extends ExpensaCriterio {

    /**
     * Default constructor
     */
    public PagoCompletoGastos() {
    }

    
    /**
     * @param unidadesFuncionales 
     * @param expensa 
     * @return
     */
    public void divisionDeExpensas(List<UnidadFuncional> unidadesFuncionales, double montoTotal) {
        System.out.println("Pago Completo Gastos. Monto total: " + montoTotal);
        System.out.println("------------------------------------------------------------------");
    	
    	double totalFactura;
    		
    	for (UnidadFuncional uf : unidadesFuncionales) {
    		totalFactura = montoTotal * uf.getPorcentaje() + uf.calcularDeuda();
    		System.out.println("Deuda UF " + uf.getNro() + ": " + uf.calcularDeuda());
    		System.out.println("Monto actual UF " + uf.getNro() + ": " + montoTotal * uf.getPorcentaje());
    		System.out.println("Total UF " + uf.getNro() + ": " + totalFactura);
    		System.out.println();
    		
    		uf.agregarFactura(Date.from(Instant.now()), totalFactura);
        }
    }

}