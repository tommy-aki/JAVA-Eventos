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
public class CuentaAdministrador extends Cuentas{
    private final int tier;
    private EventosList eventos;
    
    public CuentaAdministrador(String nombre, String contraseña, String nombreCompleto, int edad){
        super(nombre, contraseña, nombreCompleto, edad);
        tier=0;
        eventos = new EventosList();
    }
    
    @Override
    public int getTier(){
        return tier;
    }
    
    @Override
    public String toString(){
        return super.toString() + "  |  Tipo: Administrador";
    }
    
    
    public boolean addAcc(String name, String passw, String nombreCompleto, int edad, int tier){
        int index=0;
        if(Usuarios.firstNullIndex(0)<Usuarios.registro.length){
            index=Usuarios.firstNullIndex(0);
            switch(tier){
                case 0:
                    Usuarios.registro[index]=new CuentaAdministrador(name, passw, nombreCompleto, edad);
                    break;
                case 2:
                    Usuarios.registro[index]=new CuentaLimitada(name, passw, nombreCompleto, edad);
                    break;
                case 1:
                    Usuarios.registro[index]=new CuentaContenidos(name, passw, nombreCompleto, edad);
                    break;
            }
            Usuarios.updateSer();
            return true;
        }
        return false;
    }
    
    public boolean borrarAcc(String nick){
        for(int i=0;i<Usuarios.registro.length;i++){
            if(Usuarios.registro[i]!=null && Usuarios.registro[i].getUser().equals(nick)){
                Usuarios.registro[i]=null;
                Usuarios.updateSer();
                return true;
            }
        }
        return false;
    }
    
    public boolean editAcc(String nick, String passw, String nombreCompleto, int edad,int tier){
        for(int i=0;i<Usuarios.registro.length;i++){
            if(Usuarios.registro[i]!=null && Usuarios.registro[i].getUser().equals(nick)){
                switch(tier){
                    case 0:
                        Usuarios.registro[i]=new CuentaAdministrador(nick, passw, nombreCompleto, edad);
                        break;
                    case 1:
                        Usuarios.registro[i]=new CuentaContenidos(nick, passw, nombreCompleto, edad);
                        break;
                    case 2:
                        Usuarios.registro[i]=new CuentaLimitada(nick, passw, nombreCompleto, edad);
                        break;
                }
                Usuarios.updateSer();
                return true;
            }
        }
        return false;
    }
    
    public String printList(int cero){
        if(cero<Usuarios.registro.length){
            if(Usuarios.registro[cero]!=null)
                return Usuarios.registro[cero].toString()+"\n" + printList(cero+1);
            return "" + printList(cero+1);
        }
        return "";
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
