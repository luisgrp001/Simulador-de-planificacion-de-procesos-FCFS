/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import Frame.Graficos;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;

/**
 *
 * @author diego
 */
public class Threader extends Thread{//procesar todos los elemento definidos de forma simultanea
    JScrollPane graficos;//crear contexto de gráficos
    ListaDoble listaDoble=new ListaDoble();//crear una lista doble de nodos
    public Threader(JScrollPane graficos,ListaDoble listaDoble){//inicializando variables
        this.graficos=graficos;
        this.listaDoble=listaDoble;
    }
    public void vuelta(){//comenzar a procesar nodos
        
        try {
            graficos.setViewportView(new Graficos(listaDoble.size(), listaDoble));//mostrar graficos
            Thread.sleep(5000);//espera para ejecucion
        } catch (InterruptedException ex) {
            Logger.getLogger(Threader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
