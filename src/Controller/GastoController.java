package Controller;

import Model.Expensa.*;
import java.util.*;
import java.util.ArrayList;


/**
 *
 */
public class GastoController {

    private ArrayList<Gasto> GastosLista = new ArrayList<>();
    private ArrayList<Gasto> GastosRecurrentes = new ArrayList<>();
    private static GastoController gastoController ;


    public static GastoController getInstancia() {
        if (gastoController == null) {
            gastoController = new GastoController();

        }

        return new GastoController();
    }

    public ArrayList<Gasto> getListaGastos(){
        return GastosLista;
    }

    private Gasto gastoToModel(GastoDTO gastoDto){
        Gasto gast = new Gasto(gastoDto.getFecha(),gastoDto.getMonto(),gastoDto.getTipoGasto(),gastoDto.getTipoExpensa(),gastoDto.getRecurrente());
        return gast;

    }
    public void add(Gasto g) {
        GastosLista.add(g);

    }



    public void crearGasto(GastoDTO gdd){
        Gasto gastonuevo = gastoToModel(gdd);
        add(gastonuevo);
    }

    public void initGasto(){
        Gasto gasto1 = new Gasto(new Date(), 150.50, "Luz", TipoExpensa.ORDINARIA, false);
        Gasto gasto2 = new Gasto(new Date(), 25.0, "Limpieza", TipoExpensa.ORDINARIA, true);
        Gasto gasto3 = new Gasto(new Date(), 80.75, "Reparar Terraza", TipoExpensa.EXTRAORDINARIA, false);
        Gasto gasto4 = new Gasto(new Date(), 300.0, "Reparar Ascensor", TipoExpensa.EXTRAORDINARIA, true);
        Gasto gasto5 = new Gasto(new Date(), 50.0, "Lavanderia", TipoExpensa.GASTOS_PARTICULARES, false);
        Gasto gasto6 = new Gasto(new Date(), 100.0, "Mantenimiento", TipoExpensa.GASTOS_PARTICULARES, true);
        Gasto gasto7 = new Gasto(new Date(), 75.25, "Gas", TipoExpensa.ORDINARIA, false);
        Gasto gasto8 = new Gasto(new Date(), 200.0, "Cerrajeria", TipoExpensa.EXTRAORDINARIA, true);
        Gasto gasto9 = new Gasto(new Date(), 120.0, "Pintura", TipoExpensa.GASTOS_PARTICULARES, true);
        Gasto gasto10 = new Gasto(new Date(), 180.0, "Agua", TipoExpensa.ORDINARIA, true);
        GastosLista.add(gasto1);
        GastosLista.add(gasto2);
        GastosLista.add(gasto3);
        GastosLista.add(gasto4);
        GastosLista.add(gasto5);
        GastosLista.add(gasto6);
        GastosLista.add(gasto7);
        GastosLista.add(gasto8);
        GastosLista.add(gasto9);
        GastosLista.add(gasto10);
    }

    public void ejecucionMensual(){
        for(Gasto g : GastosLista){
            if (g.getRecurrente()){
                GastosRecurrentes.add(g);
            }

        }
    }

}