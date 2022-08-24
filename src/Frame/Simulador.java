/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Planificador.Planning;
import Planificador.Prioridad;
//import Controlador.RoundRobyn;
//import Controlador.SJFApropiativo;
//import Controlador.SJFNoApropiativo;
import Componentes.Threader;
import Componentes.ListaDoble;
import Componentes.Proceso;
import java.awt.Color;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diego
 */
public class Simulador extends javax.swing.JFrame {

    /**
     * Creates new form Procesos
     */
    
    
    
    DefaultTableModel m;
    DefaultTableModel aux;
    Vector<Object>listaAlgoritmos;
    ListaDoble listaDoble=new ListaDoble();
    public Simulador() {
        initComponents();
        getContentPane().setBackground(Color.ORANGE);
        listaAlgoritmos=new Vector<Object>();
        tabla();

        tablaResultados();
//        bloqueo_cajas_texto();
//        bloqueo_botones();
        setLocationRelativeTo(this);

    }
    Planning f=new Planning(listaDoble);
     public void tabla(){//crear tabla de inserción de procesos
         String cabecera[]={"Proceso","Rafa CPU", "Tiempo de LLegada","Estado"};
         m=new DefaultTableModel(null,cabecera);
         tblProcesos.setModel(m);
         
     }
     public void bloqueo_cajas_texto(){
         txtProceso.setEnabled(false);//deshabilitar cajas de texto
         txtRafaga.setEnabled(false);
         txtTiempo.setEnabled(false);
     }
     public void bloqueo_botones(){//deshabilitar botones de jframe
         btnPrepararProceso.setEnabled(false);
         btnEjecutarProcesos.setEnabled(false);
         btnEjecutarProcesos.setEnabled(false);
     }
     public void limpiar_cajas_texto(){//limpiar text field
         txtProceso.setText(null);
         txtRafaga.setText(null);
         txtTiempo.setText(null);
     }
     public void tablaResultados(){//crear una tabla de resultados
         String cabecera[]={"Proceso","Tiempo Espera", "Tiempo Retorno","Tiempo de Respuesta","Estado"};
         aux=new DefaultTableModel(null,cabecera);
         tblResultados.setModel(aux);
     } 
     
     int CPU;
     int tiempo;
     int prioridad;
     int numeroProcesos=0;
     void fifo(){
         
         CPU=Integer.parseInt(txtRafaga.getText());
         tiempo=Integer.parseInt(txtTiempo.getText());

         String estado="Preparado";//asignacion de valores para preparar los procesos
         String Datos[]= new String[5];
         Datos[0]=txtProceso.getText();
         Datos[1]=String.valueOf(CPU);
         Datos[2]=String.valueOf(tiempo);
         Datos[3]=String.valueOf(estado);
         m.addRow(Datos);
         Proceso p=new Proceso(txtProceso.getText(), CPU, tiempo, prioridad, estado);
         listaDoble.insertarPrincipio(p);//crear lista con lo datos insertados
         
         jspGraficos.setViewportView(new Graficos(listaDoble.size(), listaDoble));
     }
    
    
     public void eleccion(){//ordenar procesos en el gráfico
        Threader h=new Threader(jspGraficos, listaDoble);
        h.vuelta();
     }
     
     public void tiempoProcesos_FIFO(){//calcular los tiempos correspondientes a cada proceso
          double t = 0;
        int tiempoespera=0;
        int tiemporespuesta=0;
        int tiemporetorno=0;
        String Datos[]= new String[5]; 
        for(int i=0;i<listaDoble.size();i++){
             
             Datos[0]=listaDoble.get(i).dato.getNombre();
             if(i==0){
                  tiempoespera+=listaDoble.get(i).dato.getRafaga()+listaDoble.get(i).dato.getTiempo();
                  t=listaDoble.get(i).dato.getTiempo();
                  Datos[1]=String.valueOf(t);
                }else{
                    t=tiempoespera-listaDoble.get(i).dato.getTiempo();
                    tiempoespera+=listaDoble.get(i).dato.getRafaga();
                    Datos[1]=String.valueOf(t);
                }  
            if(i==0){
                  tiemporetorno+=listaDoble.get(i).dato.getRafaga()+listaDoble.get(i).dato.getTiempo();
                  t=listaDoble.get(i).dato.getTiempo()+listaDoble.get(i).dato.getRafaga();
                  Datos[2]=String.valueOf(t);
                }else{
                    t=tiemporetorno+listaDoble.get(i).dato.getRafaga();
                    tiemporetorno+=listaDoble.get(i).dato.getRafaga();
                    Datos[2]=String.valueOf(t);
                }  
             if(i==0){
                  tiemporespuesta+=listaDoble.get(i).dato.getRafaga()+listaDoble.get(i).dato.getTiempo();
                  t=listaDoble.get(i).dato.getTiempo();
                  t=t+listaDoble.get(i).dato.getRafaga();
                  Datos[3]=String.valueOf(t);
                }else{
                    t=tiemporespuesta-listaDoble.get(i).dato.getTiempo();
                    t=t+listaDoble.get(i).dato.getRafaga();
                    tiemporespuesta+=listaDoble.get(i).dato.getRafaga();
                    Datos[3]=String.valueOf(t);
                }   
             Datos[4]=String.valueOf("Procesado");
             aux.addRow(Datos);
          }
     }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtProceso = new javax.swing.JTextField();
        txtRafaga = new javax.swing.JTextField();
        txtTiempo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProcesos = new javax.swing.JTable();
        btnEjecutarProcesos = new javax.swing.JButton();
        btnPrepararProceso = new javax.swing.JButton();
        jspGraficos = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblTPResp = new javax.swing.JLabel();
        lblTPE = new javax.swing.JLabel();
        lblTPRet = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 255));
        setForeground(new java.awt.Color(51, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("WenQuanYi Micro Hei", 1, 36)); // NOI18N
        jLabel1.setText("SIMULADOR FCFS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("RÁFAGA CPU:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("TIEMPO DE  LLEGADA:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));
        getContentPane().add(txtProceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 100, -1));
        getContentPane().add(txtRafaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 100, -1));
        getContentPane().add(txtTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 100, -1));

        tblProcesos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblProcesos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 660, 200));

        btnEjecutarProcesos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEjecutarProcesos.setText("EJECUTAR PROCESOS");
        btnEjecutarProcesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarProcesosActionPerformed(evt);
            }
        });
        getContentPane().add(btnEjecutarProcesos, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 540, 220, -1));

        btnPrepararProceso.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPrepararProceso.setText("AGREGAR PROCESO");
        btnPrepararProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrepararProcesoActionPerformed(evt);
            }
        });
        getContentPane().add(btnPrepararProceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, -1, -1));
        getContentPane().add(jspGraficos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 1040, 200));

        tblResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblResultados);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, 870, 120));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("HOME");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 760, 90, -1));

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel7.setText("TIEMPOS PROMEDIO:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 620, -1, -1));

        lblTPResp.setBackground(new java.awt.Color(153, 255, 153));
        lblTPResp.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        getContentPane().add(lblTPResp, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 710, 80, 20));

        lblTPE.setBackground(new java.awt.Color(153, 255, 153));
        lblTPE.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        getContentPane().add(lblTPE, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 650, 80, 20));

        lblTPRet.setBackground(new java.awt.Color(153, 255, 153));
        lblTPRet.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        getContentPane().add(lblTPRet, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 680, 80, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("FIRST COME, FIRST SERVED");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("NOMBRE DEL PROCESO:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("TABLA DE PROCESOS");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("CÁLCULOS DE PROCESOS");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 600, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("TIEMPO DE ESPERA:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 650, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("TIEMPO DE FIN:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 680, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("TIEMPO SISTEMA:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 710, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEjecutarProcesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarProcesosActionPerformed
        // TODO add your handling code
            Planning f=new Planning(listaDoble);
            f.FCSC();
            jspGraficos.setViewportView(new Threads(listaDoble.size(), listaDoble));
            tiempoProcesos_FIFO();//mostrar tabla de resultados
            bloqueo_botones();
            bloqueo_cajas_texto();
            f.FCSC();
            lblTPE.setText(String.valueOf(f.tiempoEspera()));//calcular promedios y mostrar
            lblTPRet.setText(String.valueOf(f.tiempoRetorno()));
            lblTPResp.setText(String.valueOf(f.tiempoRespuesta()));
            /*
            String cadena="";
            int suma,num=0;
            for(int i=0;i<tblResultados.getRowCount();i++){
                   System.out.println("\nobteniendo el dato de la fila "+ (i+1));
                   System.out.println("tiempo de retorno:"+tblResultados.getValueAt(i, 2));
                   System.out.println("tipo: "+((Object)tblResultados.getValueAt(i, 2)).getClass().getSimpleName());
                   cadena=(String) tblResultados.getValueAt(i, 2);
                   cadena = cadena.replace(".0", "");
                   System.out.println("Tiempo corregido. "+cadena);
                   num=Integer.parseInt(cadena);
                   suma=2*num;
                   System.out.println(suma);
            }*/
            
            
            
    }//GEN-LAST:event_btnEjecutarProcesosActionPerformed

    private void btnPrepararProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrepararProcesoActionPerformed
        // TODO add your handling code here:
            if((txtProceso.getText().equals(""))||(txtRafaga.getText().equals(""))||(txtTiempo.getText().equals(""))){
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            }else{
                fifo();
                limpiar_cajas_texto();
            }
        
    }//GEN-LAST:event_btnPrepararProcesoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Home m=new Home();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Simulador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Simulador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Simulador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Simulador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Simulador().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEjecutarProcesos;
    private javax.swing.JButton btnPrepararProceso;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jspGraficos;
    private javax.swing.JLabel lblTPE;
    private javax.swing.JLabel lblTPResp;
    private javax.swing.JLabel lblTPRet;
    private javax.swing.JTable tblProcesos;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextField txtProceso;
    private javax.swing.JTextField txtRafaga;
    private javax.swing.JTextField txtTiempo;
    // End of variables declaration//GEN-END:variables
}
