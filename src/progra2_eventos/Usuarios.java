/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra2_eventos;

import java.io.*;

/**
 *
 * @author Tommy Lee Pon
 */
public final class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    public static Cuentas[] registro=new Cuentas[50];
    
    public Usuarios(int cantidad){
        try {
            FileInputStream fileIn = new FileInputStream("usuarios.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            registro = (Cuentas[]) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Lista de usuarios recuperada:");
            for (Cuentas usuario : registro) {
                if(usuario!=null)
                    System.out.println(usuario);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        registro[0]=new CuentaAdministrador("admin", "supersecreto", "Administrador", 0);

        updateSer();
    }

    public static int firstNullIndex(int cero){
        if(cero<Usuarios.registro.length){
            if(Usuarios.registro[cero]==null){
                return cero;
            }
            return firstNullIndex(cero+1);
        }
        return cero;
    }
    
    public static Cuentas buscar(String name){
        for(Cuentas acc:Usuarios.registro){
            if (acc!=null && acc.getUser().equals(name))
                return acc;
        }
        return null;
    }
    
    public static boolean logIn(String name, String passw){
        if(buscar(name)!=null && buscar(name).getPassword().equals(passw)){
            return true;
        }
        return false;
    }
    
    public static void updateSer(){
        try {
            FileOutputStream fileOut = new FileOutputStream("usuarios.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(registro);
            out.close();
            fileOut.close();
            System.out.println("La lista de usuarios ha sido guardada en usuarios.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
