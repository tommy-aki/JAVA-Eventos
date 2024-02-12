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
public class EventoReligioso extends Eventos{
    private final double COBRO_SEGURO=2000;
    
    public EventoReligioso(String title, String desc, String realizado, Calendar fecha, double monto){
        super(title, desc, realizado, fecha, monto);
        capacidad=30000;
        codigo=generarCodigo();
    }

    @Override
    public double getSeguroCosts() {
        return COBRO_SEGURO;
    }
    
    @Override
    public void editEvt(String title, String desc, String realizado, Calendar fecha, double monto, String equipo1, String equipo2){
        titulo=title;
        descripcion=desc;
        fechaRealizacion=fecha;
        this.monto=monto;
        cancelado=false;
        host=realizado;
    }
    
    
}
