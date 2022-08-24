/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;


public class Nodo {
    public Proceso dato; 
    public Nodo siguiente;
    public Nodo anterior;
    public Nodo(Proceso dato) {//creando un nodo con los datos y definiendo sus propiedades
        this.dato = dato;
        this.siguiente=null;
        this.anterior=null;
    } 

    public Proceso getDato() {//obtener dato del nodo
        return dato;
    }

    public void setDato(Proceso dato) {//insertar dato al nodo
        this.dato = dato;
    }
    
    public Nodo getAnterior() {//obtener un nodo anterior
        return anterior;
    }

    public void setAnterior(Nodo anterior) {//insertar un nodo anterior
        this.anterior = anterior;
    }
}
