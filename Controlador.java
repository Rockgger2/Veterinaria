/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Mascotas;
import modelo.Paciente;
import vista.interfaz;
import vista.operaciones;


/**
 *
 * @author pancl
 */
public class Controlador implements ActionListener{
   Paciente pa;
   Mascotas ma;
   interfaz in;
    operaciones op;
    
    public Controlador(Paciente pa, Mascotas ma, interfaz in,operaciones op) {
        this.pa = pa;
        this.ma = ma;
        this.in = in;
        this.op=op;
    }
   public Controlador() { 
        this.pa = new Paciente();
        this.ma = new Mascotas();
        this.in = new interfaz();
        this.op = new operaciones();
        
        in.getBtnAgregar().addActionListener(this);
        in.getBtnBuscar().addActionListener(this);
        in.getBtnEditar().addActionListener(this);
        in.getBtnEliminar().addActionListener(this);
        op.getBtnAgregar().addActionListener(this);
        
        
        in.setVisible(true);
   }

    public void iniciar(){
       in.setVisible(true); 
        }
    @Override
    public void actionPerformed(ActionEvent e) {
       
        
        if(in.getBtnAgregar()==e.getSource()){
          
               pa.setId(in.getTxtId().getText());
               pa.setNombre(in.getTxtNombre().getText());
               pa.setSexo(in.getjComboBoxSexo().getSelectedItem().toString());
               pa.setEspecie(in.getjComboBoxEspecie().getSelectedItem().toString());
               pa.setTipo(in.getjComboBoxTipo().getSelectedItem().toString());
               pa.setDescripcion(in.getTxtDescripcion().getText());
               pa.setVeterinario(in.getjComboBoxVeterinario().getSelectedItem().toString());
               ma.getListaV().add(pa);
               registrar();
                this.pa = new Paciente();
                
                  limpiar();
        }
        if(in.getBtnEditar()== e.getSource()){
               editar();
              limpiartabla();
                Llenar();
        }
        if(op.getBtnAgregar()==e.getSource()){
              
            if(pa.getId().equals(op.getId().getText())){
               pa.setId(op.getId().getText());
               pa.setNombre(op.getNom().getText());
               pa.setSexo(op.getSex().getSelectedItem().toString());
               pa.setEspecie(op.getEspecie().getSelectedItem().toString());
               pa.setTipo(op.getServicio().getSelectedItem().toString());
               pa.setDescripcion(op.getConsulta().getText());
               pa.setVeterinario(op.getVeterinario().getSelectedItem().toString());
               ma.getListaV().add(pa);
               op.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null,"Id no encontrado, verifique el id");
            }
        
        }
        if(in.getBtnEliminar()== e.getSource()){
                borrar();
                limpiartabla();
                Llenar();
        }
        if(in.getBtnBuscar()== e.getSource()){
            buscar();
        }
        }
    
   
     public void registrar(){
        if(!ma.getListaV().isEmpty()){
            DefaultTableModel registros = (DefaultTableModel) in.getTablaDatos().getModel();
            int cantP = ma.getListaV().size();
            Object[] Datos = {ma.getListaV().get(cantP-1).getId(),
            ma.getListaV().get(cantP -1).getNombre(),
            ma.getListaV().get(cantP -1).getSexo(),
            ma.getListaV().get(cantP -1).getEspecie(),
            ma.getListaV().get(cantP -1).getTipo(),
            ma.getListaV().get(cantP -1).getDescripcion(),
            ma.getListaV().get(cantP -1).getVeterinario()
                    
            };
            
           registros.addRow(Datos); 
        }else{
            
            
         for(int i=0;i<ma.getListaV().size();i++){
            if(in.getTxtId().getText().equals(ma.getListaV().get(i).getId()))
            {
               JOptionPane.showMessageDialog(null,"Id repetido por favor rectifique");
               break;
            }else{
             DefaultTableModel registros = (DefaultTableModel) in.getTablaDatos().getModel();
            int cantP = ma.getListaV().size();
            Object[] Datos = {ma.getListaV().get(cantP-1).getId(),
            ma.getListaV().get(cantP -1).getNombre(),
            ma.getListaV().get(cantP -1).getSexo(),
            ma.getListaV().get(cantP -1).getEspecie(),
            ma.getListaV().get(cantP -1).getTipo(),
            ma.getListaV().get(cantP -1).getDescripcion(),
            ma.getListaV().get(cantP -1).getVeterinario()
                    
            };
            
           registros.addRow(Datos); 
            }
                
          }  
        }
     }   
      public void editar(){
          if(!ma.getListaV().isEmpty()){
               for(int i=0;i<ma.getListaV().size();i++){
                 if(in.getTxtId().getText().equals(ma.getListaV().get(i).getId())){
                    borrar();
                    pa.setId(op.getId().getText());
                    pa.setNombre(op.getNom().getText());
                    pa.setSexo(op.getSex().getSelectedItem().toString());
                    pa.setEspecie(op.getEspecie().getSelectedItem().toString());
                    pa.setTipo(op.getServicio().getSelectedItem().toString());
                    pa.setDescripcion(op.getConsulta().getText());
                    pa.setVeterinario(op.getVeterinario().getSelectedItem().toString());
               
                    ma.getListaV().add(pa);
                   JOptionPane.showMessageDialog(null, "Id actualizado");
                 }}
          }else{
               JOptionPane.showMessageDialog(null, "Lista Vacia");
          }
      }
     public void borrar(){
       
             for(int i=0;i<ma.getListaV().size();i++){
                 if(!ma.getListaV().isEmpty()){
                 if(in.getTxtId().getText().equals(ma.getListaV().get(i).getId())){
                     System.out.println(i); 
                     ma.getListaV().remove(i);
                 }else{
                     JOptionPane.showMessageDialog(null, "No se puede borrar mas datos");
                 }
                 
                 }
             }
            System.out.println(ma.datosMascotas());
             
     }
     
     
     
     public void buscar(){
         if(!ma.getListaV().isEmpty()){
          for(int i=0;i<ma.getListaV().size();i++){
                 if(in.getTxtId().getText().equals(ma.getListaV().get(i).getId())){
                   in.getTxtNombre().setText(ma.getListaV().get(i).getNombre());
                   in.getTxtDescripcion().setText(ma.getListaV().get(i).getDescripcion());
                   in.getjComboBoxEspecie().setSelectedItem(ma.getListaV().get(i).getEspecie());;
                   in.getjComboBoxSexo().setSelectedItem(ma.getListaV().get(i).getSexo());
                   in.getjComboBoxTipo().setSelectedItem(ma.getListaV().get(i).getTipo());
                   in.getjComboBoxVeterinario().setSelectedItem(ma.getListaV().get(i).getVeterinario()); 
                   JOptionPane.showMessageDialog(null, "Id Encontrado, consulte las casillas");
                 }
                 else {
                     JOptionPane.showMessageDialog(null, "Id no encontrado verifique");
                 }
          
         }}else{
             JOptionPane.showMessageDialog(null, "Lista Vacia");
                     
         }
                    
             
     }
        public void Llenar(){
       DefaultTableModel registros = (DefaultTableModel) in.getTablaDatos().getModel();
      for(int i=0;i<ma.getListaV().size();i++){
        
            Object[] Datos = {ma.getListaV().get(i).getId(),
            ma.getListaV().get(i ).getNombre(),
            ma.getListaV().get(i ).getSexo(),
            ma.getListaV().get(i).getEspecie(),
            ma.getListaV().get(i ).getTipo(),
            ma.getListaV().get(i ).getDescripcion(),
            ma.getListaV().get(i ).getVeterinario()
            };
           registros.addRow(Datos); 
        
        }}
        public void limpiartabla(){
            DefaultTableModel registros = (DefaultTableModel) in.getTablaDatos().getModel();
            registros.setRowCount(0);
        }
   public void limpiar(){
          for (int i = 0; in.getjPanel1().getComponents().length > i; i++) {
            if (in.getjPanel1().getComponents()[i] instanceof JTextField) {
                ((JTextField) in.getjPanel1().getComponents()[i]).setText("");

            }
        }
   }
}
