package Model.ExpensaCriterio;

import java.util.*;

import Model.CuentaBancaria.CuentaBancaria;
import Model.Expensa.Expensa;
import Model.UnidadFuncional.UnidadFuncional;

/**
 * 
 */
public abstract class ExpensaCriterio {

    /**
     * @param ctaBancaria
     * @return
     */
    public double obtencionDeSaldo(CuentaBancaria ctaBancaria) {
        return ctaBancaria.saldoActual();
    }

    /**
     * @param e 
     * @return
     */
    public double calculoDeGastos(Expensa e) {
        return e.calcular();
    }

    /**
     * @param unidadesFuncionales 
     * @param expensa 
     * @return
     */
    public abstract void divisionDeExpensas(List<UnidadFuncional> unidadesFuncionales, double montoTotal);

}