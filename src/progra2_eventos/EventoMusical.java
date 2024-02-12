/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra2_eventos;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Tommy Lee Pon
 */
public class EventoMusical extends Eventos{
    private TipoMusica tipo;
    private final double TASA_SEGURO = 0.30;
    private final double COBRO_SEGURO = monto*TASA_SEGURO;
    private ArrayList<String> empleados;
    
    public EventoMusical(String title, String desc, String realizado, Calendar fecha, double monto, String extra){
        super(title, desc, realizado, fecha, monto);
        capacidad=25000;
        codigo=generarCodigo();
        tipo=TipoMusica.valueOf(extra);
        empleados=new ArrayList();
    }
    
    public double getSeguroCosts(){
        return COBRO_SEGURO;
    }
    
    public void addEmpleado(String nombre){
        empleados.add(nombre);
    }
    public String empleadosToString(int cero){
        if(empleados != null && cero<empleados.size())
            return empleados.get(cero) + "\n" + empleadosToString(cero+1);
        return "";
    }
}
