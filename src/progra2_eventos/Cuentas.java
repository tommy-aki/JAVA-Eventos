/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra2_eventos;

import java.io.*;
import java.util.Calendar;

/**
 *
 * @author Tommy Lee Pon
 */
public abstract class Cuentas implements Serializable{
    protected String nombre;
    protected String user;
    protected String password;
    protected int edad;
    protected EventosList lista;
    
    
    public Cuentas(String nombre, String contraseña, String nombreCompleto, int edad){
        lista=new EventosList();
        user=nombre;
        password=contraseña;
        this.nombre=nombreCompleto;
        this.edad=edad;
    }
    
    public String getUser(){
        return user;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int getEdad(){
        return edad;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String toString(){
        return "Nombre: " + nombre + "  |  Usuario: " + user +"  |  Edad: " +edad;
    }
    
    public Eventos srcCode(String codigo){
        return lista.searchCode(codigo);
    }
    
    public abstract void AddEvt(String title, String desc, String realizado, Calendar fecha, double monto, int tipo, String equipo1, String equipo2, String extra);
    
    public abstract int getTier();
}
