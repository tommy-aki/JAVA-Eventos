/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra2_eventos;

import java.util.Calendar;

/**
 *
 * @author Tommy Lee Pon
 */
public class CuentaLimitada extends Cuentas {
    private final int tier;
    
    public CuentaLimitada(String nombre, String contraseña, String nombreCompleto, int edad){
        super(nombre, contraseña, nombreCompleto, edad);
        tier=2;
    }
    
    @Override
    public int getTier(){
        return tier;
    }
    
    @Override
    public String toString(){
        return super.toString() + "  |  Tipo: Limitada";
    }
    
    @Override
    public void AddEvt(String title, String desc, String realizado, Calendar fecha, double monto, int tipo, String equipo1, String equipo2, String extra){
        
    }
}
