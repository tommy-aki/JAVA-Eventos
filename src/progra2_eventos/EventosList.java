/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra2_eventos;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Tommy Lee Pon
 */
public class EventosList implements Serializable {
    public static final long serialVersionUID = 1L;
    public ArrayList<Eventos> lista;
    
    public EventosList(){
        lista = new ArrayList();
        loadSer();
        updateSer();
        debugPrint();
    }
    
    public final void updateSer(){
        try {
            FileOutputStream fileOut = new FileOutputStream("eventos.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(lista);
            out.close();
            fileOut.close();
            System.out.println("La lista de eventos ha sido serializada en eventos.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public final void loadSer(){
        try {
            File file = new File("eventos.ser");
            if (file.exists()) {
                FileInputStream fileIn = new FileInputStream(file);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                lista = (ArrayList<Eventos>) in.readObject();
                in.close();
                fileIn.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public Eventos searchCode(String code){
        loadSer();
        for(Eventos evento:lista)
            if (evento!=null && evento.getCodigo().equals(code))
                return evento;
        return null;
    }
    
    public void addEvento(Eventos evento){
        lista.add(evento);
        JOptionPane.showMessageDialog(null, "Codigo del evento: " + evento.getCodigo());
        updateSer();
    }
    
    public void debugPrint(){
        for(Eventos evento:lista)
            System.out.println(evento.getCodigo() + " - " + evento.getTitle() + " - " + evento.getMonto() + " - " + evento.getHost());
    }
    
    
}
