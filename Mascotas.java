
package modelo;

import java.util.ArrayList;
import java.util.Iterator;


public class Mascotas {
    private ArrayList<Paciente> ListaV;

    public Mascotas(ArrayList<Paciente> ListaV) {
        this.ListaV = ListaV;
    }
    public Mascotas() {
        this.ListaV = new ArrayList<Paciente>();
    }
    public String toString() {
        return "Lista de Mascotas=" +datosMascotas();
    }
     public String datosMascotas(){
        String datos=" ";
    for (int i = 0; i < ListaV.size(); i++) {
        datos+=ListaV.get(i).toString()+"\n";
    }
    return datos;
}
    
    public ArrayList<Paciente> getListaV() {
        return ListaV;
    }

    public void setListaV(ArrayList<Paciente> ListaV) {
}        

    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
