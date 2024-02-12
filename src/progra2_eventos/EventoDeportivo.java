/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra2_eventos;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Tommy Lee Pon
 */
public class EventoDeportivo extends Eventos{
    private String equipo1;
    private final ArrayList<String> equipo1Team;
    private String equipo2;
    private final ArrayList<String> equipo2Team;
    private TipoDeporte deporte;
    
    public EventoDeportivo(String title, String desc, String realizado, Calendar fecha, double monto, String equipo1, String equipo2, String extra){
        super(title, desc, realizado, fecha, monto);
        this.equipo1=equipo1;
        this.equipo2=equipo2;
        capacidad=20000;
        codigo=generarCodigo();
        deporte=TipoDeporte.valueOf(extra);
        equipo1Team=new ArrayList();
        equipo2Team=new ArrayList();
        cargarIntegrantes();
        guardarIntegrantes();
    }
    
    public void setNameEquipo1(String name){
        equipo1=name;
    }
    
    public void setNameEquipo2(String name){
        equipo2=name;
    }
    public String getEquipo1(){
        return equipo1;
    }
    public String getEquipo2(){
        return equipo2;
    }
    
    public void addIntegrante1(String nombre){
        equipo1Team.add(nombre);
        guardarIntegrantes();
    }
    
    public void addIntegrante2(String nombre){
        equipo2Team.add(nombre);
        guardarIntegrantes();
    }
    public String equipo1ToString(int cero){
        cargarIntegrantes();
        if(equipo1Team != null && cero<equipo1Team.size())
            return equipo1Team.get(cero) + "\n" + equipo1ToString(cero+1);
        return "";
    }
    public String equipo2ToString(int cero){
        cargarIntegrantes();
        if(equipo2Team != null && cero<equipo2Team.size())
            return equipo2Team.get(cero) + "\n" + equipo2ToString(cero+1);
        return "";
    }

    @Override
    public double getSeguroCosts() {
        return 0;
    }
    
    @Override
    public void editEvt(String title, String desc, String realizado, Calendar fecha, double monto, String equipo1, String equipo2){
        titulo=title;
        descripcion=desc;
        fechaRealizacion=fecha;
        this.monto=monto;
        cancelado=false;
        host=realizado;
        this.equipo1=equipo1;
        this.equipo2=equipo2;
    }
    
    
    public void guardarIntegrantes() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("integrantes.ser"))) {
            out.writeObject(equipo1Team);
            out.writeObject(equipo2Team);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarIntegrantes() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("integrantes.ser"))) {
            equipo1Team.clear();
            equipo2Team.clear();
            equipo1Team.addAll((ArrayList<String>) in.readObject());
            equipo2Team.addAll((ArrayList<String>) in.readObject());
        } catch (IOException | ClassNotFoundException e) {
            // Si hay un error al cargar los datos, simplemente continúa con los ArrayList vacíos
            e.printStackTrace();
        }
    }
}
