/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;
import javax.swing.JOptionPane;

public class ListaDoble {
    private Nodo cabecera;//creación de nodo para ordenar los procesos
    public ListaDoble() {
        cabecera = null;
    }

    public boolean esVacio() {
        return (this.cabecera == null);//cuando la lista está vacía
    }

    public int size() {
        int tamano = 0;//calcular tamaño de la lista
        Nodo aux = cabecera;
        if (!esVacio()) {
            tamano++;//si la lista no esta vacía incrementa tamaño

            while (aux.siguiente != null) {
                tamano++;
                aux = aux.siguiente;//recorriendo la lista
            }
        }
        return tamano;
    }

    public void insertarCabecera(Proceso dato) {
        Nodo nuevo = new Nodo(dato);
        if (esVacio()) {
            cabecera = nuevo;//agregar un nuevo nodo cuando la lista está vacia para iniciar
        }
    }
    public void inserta_inicio(Proceso dato){
      if(!esVacio()){
            Nodo nuevo=new Nodo(dato);//si la lista no está vacía crea un nodo con el dato insertado
            if(cabecera.dato.getTiempo()>nuevo.dato.getTiempo()){//ordenando los nodos por tiempo
                nuevo.siguiente=cabecera;//inserta nodo en su posición correcta
                cabecera.anterior=nuevo;
                cabecera=nuevo;
            }else{
                cabecera.siguiente=nuevo;//mueve nodo a su posicion correcta
                nuevo.anterior=cabecera;
            }
        }
        
    }
    public void insertarProcesos_Prioridad(Proceso dato){
        Nodo nuevo=new Nodo(dato);
            Nodo aux=cabecera;//ordenar procesos por prioridad
           if(!esVacio()){
               if(nuevo.dato.getPrioridad()==0){
                   inserta_inicio(dato);
               }else{
                   if(aux.siguiente==null){
                       inserta_inicio(dato);//llenando la lista con los datos insertados
                   }else{
                       while(nuevo.dato.getPrioridad()>aux.dato.getPrioridad()){
                           if(aux.siguiente==null){
                               break;
                           }
                           aux=aux.siguiente;
                       }
                       if(nuevo.dato.getPrioridad()<aux.dato.getPrioridad()){//considerando la prioridad
                            nuevo.siguiente=aux;
                            aux.anterior.siguiente=nuevo;
                            nuevo.anterior=aux.anterior;
                            aux.anterior=nuevo;
                       }else{
                            aux.siguiente=nuevo;//ordeando los nodos
                            nuevo.anterior=aux;
                       }
                   }
               }
           }else{
            cabecera=nuevo;   
           }
    }
    
    public void Prioridad(){
        Nodo aux=cabecera;//definicion de variables para ordenar lista
        Nodo aux2=cabecera;
        if(!esVacio()){
            while(aux2!=null){  
                if(aux.siguiente==null){//si no hay otro elemento después
                    break;
                }
                aux=aux.siguiente;//recorrer lista
                if(aux2.dato.getPrioridad()==0){
                    aux2=aux2.siguiente;
                    aux2.dato.setRafaga(aux2.dato.getRafaga()-1);
                    
                }
                if(aux.dato.getPrioridad()<aux2.dato.getPrioridad()){//para ordenar con prioridades
                    aux2.dato.setRafaga(aux2.dato.getRafaga()-1);
                    Proceso p=new Proceso(aux2.dato.getNombre(), aux2.dato.getRafaga(), aux2.dato.getTiempo(), aux2.dato.getPrioridad(), aux2.dato.getEstado());
                    Nodo nuevo=new Nodo(p);
                    if(aux.siguiente==null){//si no hay otro elemento despues
                            aux.siguiente=nuevo;
                            nuevo.anterior=aux;
                     }else{
                            aux=aux.siguiente;
                            if(nuevo.dato.getPrioridad()<aux.dato.getPrioridad()){//ordenando por prioridad
                                nuevo.siguiente=aux;
                                aux.anterior.siguiente=nuevo;
                                nuevo.anterior=aux.anterior;
                                aux.anterior=nuevo;
                            }else{
                                while(nuevo.dato.getPrioridad()>aux.dato.getPrioridad()){//ordenando por prioridad
                                    if(aux.siguiente==null){
                                        break;
                                    }
                                    aux=aux.siguiente;//definicion de posicion con auxiliar
                                }
                                if(nuevo.dato.getPrioridad()<aux.dato.getPrioridad()){
                                    nuevo.siguiente=aux;//mover nodo de posicion
                                    aux.anterior.siguiente=nuevo;
                                    nuevo.anterior=aux.anterior;
                                    aux.anterior=nuevo;
                                }else{
                                    aux.siguiente=nuevo;//creando nuevos nodos y asignando valores
                                    nuevo.anterior=aux;
                                }
                            }
                        }
                }else{
                    aux2=aux2.siguiente;//asignacion de valor
                    if(aux.siguiente==null){
                        aux=aux2;
                    }
                        
                }
                if(aux2.siguiente==null){
                        break;
                }
                
                
            }

        }
    }
    public void insertarPrincipio(Proceso dato){//inserta al principio de la lista
        Nodo nuevo = new Nodo(dato);
        if(esVacio()){
            insertarCabecera(dato);
        }else{
            insertarInicio(dato);
        }
    }
    public void insertar(int pos,Proceso dato){//acciones de insercion y posicionamiento y datos
        if(!esVacio()){
            Nodo aux=cabecera;
            Nodo nuevo=new Nodo(dato);
            if(aux.siguiente==null){
                inserta_inicio(dato);
            }else if(aux.siguiente.siguiente==null){
                aux.siguiente=nuevo;
                nuevo.siguiente=aux.siguiente;
                nuevo.anterior=aux;
                aux.siguiente.anterior=nuevo;
            }else{
                
            }
        }
    }
    public void insertarInicio(Proceso dato) {//insertar al inicio de la lista
        Nodo nuevo = new Nodo(dato);
        if (!esVacio()) {
            nuevo.siguiente = cabecera;
            cabecera.anterior = nuevo;
            cabecera = nuevo;
        }
    }

    public void insertarFinal(Proceso dato) {//insertar al final
        Nodo aux = cabecera;
        Nodo nuevo = new Nodo(dato);
        if (!esVacio()) {
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
            nuevo.anterior = aux;
        } else {
            insertarCabecera(dato);
        }
    }

    public void insertarPorPosicion(Proceso dato, int posicion) {//insrtar por psoicion de prioridad
        if (!esVacio()) {
            if (posicion == 1) {
                insertarInicio(dato);
            } else {
                if (posicion == size()) {
                    insertarFinal(dato);
                } else {
                    if (posicion > 0 && posicion < size()) {
                        Nodo nuevo = new Nodo(dato);
                        Nodo aux = cabecera;
                        int con = 0;
                        while (con != (posicion - 1)) {
                            aux = aux.siguiente;
                            con++;
                        }
                        Nodo a = aux.siguiente;
                        nuevo.siguiente = aux.siguiente;
                        aux.siguiente = nuevo;
                        nuevo.anterior = aux;
                        a.anterior = nuevo;
                    }
                }

            }

        } else {
            insertarCabecera(dato);
        }
    }

    public void modificar(int pos, Proceso datos) {//definir elementos de la lista
        Nodo auxiliar = cabecera;
        int recorrido = 0;
        if (!esVacio()) {
            if (pos == 0) {
                cabecera.dato = (Proceso) datos;
            } else {
                if (pos == size()) {
                    get(pos).dato = (Proceso) datos;
                } else {
                    if (pos > 0 & pos < size()) {
                        Nodo nuevo = new Nodo(datos);
                        while (recorrido != (pos - 1)) {
                            auxiliar = auxiliar.siguiente;
                            recorrido++;
                        }
                        nuevo.siguiente = auxiliar.siguiente;
                        auxiliar.siguiente.dato = nuevo.dato;
                    } else {
                        JOptionPane.showMessageDialog(null, "EL ELEMENTO ES MAYOR AL TAMAÑO DE LA LISTA");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "LA LISTA ESTA VACIA");
        }

    }

    public Nodo get(int posicion) {//obtener nodo en la posicion
        Nodo aux = cabecera;
        int contador = 0;
        while (contador != posicion) {
            aux = aux.siguiente;
            contador++;
        }
        return aux;
    }

    public void eliminarLista() {//eliminar lista creada
        if (!esVacio()) {
            cabecera.siguiente = null;
            cabecera = null;            
        } else {            
        }
    }

    public void eliminarInicio() {//quitar elemento del inicio
        Nodo aux = cabecera;
        if (cabecera.siguiente != null) {
            cabecera = aux.siguiente;
            cabecera.anterior = null;
            aux.siguiente = null;
        } else {
            cabecera = null;
        }
    }

    public void eliminarFinal() {//quitar elemento del final
        Nodo auxiliar = cabecera;
        Nodo eliminar = auxiliar.siguiente;
        if (!esVacio()) {
            if (cabecera.siguiente != null) {
                while (auxiliar.siguiente.siguiente != null) {
                    auxiliar = auxiliar.siguiente;
                    eliminar = eliminar.siguiente;
                }
            }
            auxiliar.siguiente = null;
            eliminar.anterior = null;
        }
    }

    public void eliminarEntreNodos(int pos) {//eliminar elementos intermedios
        Nodo auxiliar = cabecera;
        int recorrido = 0;
        if (!esVacio()) {
            if (pos == 0) {
                eliminarInicio();
            } else {
                if (pos == size() - 1) {
                    eliminarFinal();
                } else {
                    if (pos > 0 & pos < size()) {
                        Nodo eliminar = auxiliar.siguiente;
                        while (recorrido != (pos - 1)) {
                            auxiliar = auxiliar.siguiente;
                            eliminar = eliminar.siguiente;
                            recorrido++;
                        }
                        auxiliar.siguiente = eliminar.siguiente;
                        eliminar.siguiente.anterior = auxiliar;
                        eliminar.siguiente = null;
                        eliminar.anterior = null;

                    } else {
                        JOptionPane.showMessageDialog(null, "NO EXISTE LA POSICION");

                    }
                }
            }
        }

    }

    public String imprimir() {//imprime nodos insertados y sus datos
        String informacion = "";
        Nodo actual = cabecera;
        System.out.println("DATOS INGRESADOS: ");
        while (actual != null) {
            informacion += actual.dato.toString() + "\n";
            actual = actual.siguiente;
        }
        return informacion;
    }
}
