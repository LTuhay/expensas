package Controller;

import Model.UnidadFuncional.*;

import java.util.*;


public class UnidadFuncionalController {

    // Listas de personas para los test:
    private List<Persona> inqUf1 = new ArrayList<>();
    private static List<Persona> propUf1 = new ArrayList<>();
    private static List<Persona> inqUf2 = new ArrayList<>();
    private static List<Persona> propUf2 = new ArrayList<>();
    private static List<Persona> inqUf3 = new ArrayList<>();
    private static List<Persona> propUf3 = new ArrayList<>();
    
    private static UnidadFuncionalController instancia;
    private static List<UnidadFuncional> unidadesFuncionales = new ArrayList<>();


    public static List<UnidadFuncional> getUnidadesFuncionales() {
		return unidadesFuncionales;
	}

	public static void setUnidadesFuncionales(List<UnidadFuncional> unidadesFuncionales) {
		UnidadFuncionalController.unidadesFuncionales = unidadesFuncionales;
	}

	public static synchronized UnidadFuncionalController obtenerInstancia() {
        if (instancia == null) {
            instancia = new UnidadFuncionalController();
        }
        initPersonas();
        initUnidades();
        return instancia;
    }

    private UnidadFuncionalController() {
    }


    private static void initPersonas(){

        Persona p1 = new Persona("Cristina","Aguilera","123456","mail@mail.com", TipoPersona.PROPIETARIO);
        Persona p2 = new Persona("Cristian","Castro","","mail@mail.com", TipoPersona.PROPIETARIO);
        Persona p3 = new Persona("Maria","Becerra","123456","mail@mail.com", TipoPersona.INQUILINO);
        Persona p4 = new Persona("Ricky","Martin","123456","mail@mail.com", TipoPersona.INQUILINO);
        Persona p5 = new Persona("Luis","Miguel","123456","mail@mail.com", TipoPersona.PROPIETARIO);
        Persona p6 = new Persona("Luciano","Pavarotti","123456","mail@mail.com", TipoPersona.INQUILINO);

        propUf1.add(p1);
        propUf2.add(p2);
        propUf2.add(p5);
        propUf3.add(p1);
        inqUf2.add(p3);
        inqUf2.add(p4);
        inqUf3.add(p6);

    }

    private static void initUnidades(){

        UnidadFuncional u1 = new UnidadFuncional("1",0.25,25.0,propUf1, TipoUF.COCHERA,null,initFacturas());
        UnidadFuncional u2 = new UnidadFuncional("2",0.15,150.0,propUf2, TipoUF.DEPARTAMENTO,inqUf2,initFacturas());
        UnidadFuncional u3 = new UnidadFuncional("3",0.60,600.0,propUf3, TipoUF.DEPARTAMENTO,inqUf3,initFacturas());
        unidadesFuncionales.add(u1);
        unidadesFuncionales.add(u2);
        unidadesFuncionales.add(u3);

    }


    private static List<Factura> initFacturas(){
        List<Factura> facturas = new ArrayList<>();
        Factura f1 = new Factura(new Date(), new Date(),20000.00,EstadoFactura.PAGO);
        Factura f2 = new Factura(new Date(), null,1000.00,EstadoFactura.IMPAGO);
        facturas.add(f1);
        facturas.add(f2);
        return facturas;
    }

    public Double calcularDeuda() {
        for (UnidadFuncional unidadFuncional : unidadesFuncionales) {
            return unidadFuncional.calcularDeuda();
        }
        return null;
    }



}