package Controller;

import Model.Expensa.*;


import java.util.*;

/**
 *
 */
public class ExpensaController {


    private static ExpensaController instancia;
    private static List<Expensa> expensas = new ArrayList<>();


    public static List<Expensa> getExpensas() {
		return expensas;
	}

	public static void setExpensas(List<Expensa> expensas) {
		ExpensaController.expensas = expensas;
	}

	public static synchronized ExpensaController obtenerInstancia() {
        if (instancia == null) {
            instancia = new ExpensaController();
        }
        initExpensas();
        return instancia;
    }

    private static void initExpensas(){

    }

    public void add(Expensa e) {
        expensas.add(e);
    }


    public Expensa crearExpensa(ArrayList<Gasto> gastos){
        ArrayList<Gasto> ordi = new ArrayList<>();
        ArrayList<Gasto> extra = new ArrayList<>();
        ArrayList<Gasto> particulares = new ArrayList<>();
        ArrayList<Gasto> reserva = new ArrayList<>();
        for (Gasto gasto : gastos){
            if (gasto.getTipoExpensa().toString().equals("ORDINARIA")) {
                ordi.add(gasto);
            } else if (gasto.getTipoExpensa().toString().equals("EXTRAORDINARIA")){
                extra.add(gasto);
            } else if (gasto.getTipoExpensa().toString().equals("GASTOS_PARTICULARES")){
                particulares.add(gasto);
            } else if (gasto.getTipoExpensa().toString().equals("FONDOS_DE_RESERVA")) {
                reserva.add(gasto);
            }

        }
        Expensa nuevaExpensa = new Expensa(new Date (),ordi, extra, particulares,reserva);
        add(nuevaExpensa);
        return nuevaExpensa;
    }

    public double calcular (Expensa exp){
        return exp.calcular();
    }
    

}