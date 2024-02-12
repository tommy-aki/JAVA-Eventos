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
public class CuentaContenidos extends Cuentas {
    private final int tier;
    private EventosList eventos;
    
    public CuentaContenidos(String nombre, String contraseña, String nombreCompleto, int edad){
        super(nombre, contraseña, nombreCompleto, edad);
        tier=1;
        eventos=new EventosList();
    }
    
    @Override
    public int getTier(){
        return tier;
    }
    
    @Override
    public String toString(){
        return super.toString() + "  |  Tipo: Contenidos";
    }
    
    @Override
    public void AddEvt(String title, String desc, String realizado, Calendar fecha, double monto, int tipo, String equipo1, String equipo2, String extra) {
        switch(tipo){
            case 0:
                eventos.addEvento(new EventoDeportivo(title, desc, realizado, fecha, monto, equipo1, equipo2, extra));
                break;
            case 1:
                eventos.addEvento(new EventoMusical(title, desc, realizado, fecha, monto, extra));
                break;
            case 2:
                eventos.addEvento(new EventoReligioso(title, desc, realizado, fecha, monto));
                break;
        }
    }
}
