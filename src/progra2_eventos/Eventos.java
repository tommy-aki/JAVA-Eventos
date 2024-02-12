/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra2_eventos;

import java.io.*;
import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author Tommy Lee Pon
 */
public abstract class Eventos implements Serializable{
    private static final long serialVersionUID = 2824429602876360225L;
    protected String titulo;
    protected String descripcion;
    protected String host;
    protected Calendar fechaRealizacion;
    protected double monto;
    protected int capacidad;
    protected String codigo;
    protected boolean cancelado;
    protected double multa;
    
    public Eventos(String title, String desc, String realizado, Calendar fecha, double monto){
        titulo=title;
        descripcion=desc;
        fechaRealizacion=fecha;
        this.monto=monto;
        cancelado=false;
        host=realizado;
        multa=0;
    }
    
    public String getTitle(){
        return titulo;
    }
    public String getDesc(){
        return descripcion;
    }    
    public Calendar getFecha(){
        return fechaRealizacion;
    }
    public double getMonto(){
        return monto;
    }
    public int getCapacidad(){
        return capacidad;
    }
    public String getHost(){
        return host;
    }
    
    public abstract void editEvt(String title, String desc, String realizado, Calendar fecha, double monto, String equipo1, String equipo2);
    /*{
        
    }*/
    public String generarCodigo(){
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder codigo = new StringBuilder();
        Random rnd = new Random();
        while (codigo.length() < 8) { // Puedes ajustar la longitud del código aquí
            int index = (int) (rnd.nextFloat() * caracteres.length());
            codigo.append(caracteres.charAt(index));
        }
        return codigo.toString();
    }
    public String getCodigo(){
        return codigo;
    }
    public double getMulta(){
        return multa;
    }
    public void cancelar(boolean pagaMulta){
        cancelado=true;
        if (pagaMulta){
            multa=monto*0.50;
        }
    }
    public boolean isCancelado(){
        return cancelado;
    }
    public abstract double getSeguroCosts();
}
