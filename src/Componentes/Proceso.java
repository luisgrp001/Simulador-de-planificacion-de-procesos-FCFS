/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;


public class Proceso {
    private String nombre;
    private int rafaga;
    private int tiempo;
    private int prioridad;
    private String estado;
    private int tiempoespera;
    private int rafagaaux;
    private int tiemporetorno;
    private int tiemporespuesta;
    public Proceso() {
    }   

    public Proceso(String nombre, int rafaga, int tiempo, int prioridad, String estado) {//propiedades del objeto proceso
        this.nombre = nombre;
        this.rafaga = rafaga;
        this.tiempo = tiempo;
        this.prioridad = prioridad;
        this.estado = estado;
    }
    
    public String getNombre() {//obtener nombre del proceso
        return nombre;
    }

    public int getRafagaaux() {//obtener tiempo de rafaga
        return rafagaaux;
    }

    public int getTiemporespuesta() {//obtener tiempo de respuesta
        return tiemporespuesta;
    }

    public void setTiemporespuesta(int tiemporespuesta) {//insertar tiempo de respuesta
        this.tiemporespuesta = tiemporespuesta;
    }

    public int getTiemporetorno() {//obtener tiempo de retorno
        return tiemporetorno;
    }

    public void setTiemporetorno(int tiemporetorno) {//insertar tiempo de retorno
        this.tiemporetorno = tiemporetorno;
    }

    public void setRafagaaux(int rafagaaux) {//insertar tiempo de rafaga
        this.rafagaaux = rafagaaux;
    }

    public void setNombre(String nombre) {//insertar nombre de proceso
        this.nombre = nombre;
    }

     public int getRafaga() {//obtener tiempo de rafaga
        return rafaga;
    }

    public void setRafaga(int rafaga) {//insertar tiempo de rafaga
        this.rafaga = rafaga;
    }

    public int getTiempo() {//obtener tiempo
        return tiempo;
    }

    public void setTiempo(int tiempo) {//insertar tiempo
        this.tiempo = tiempo;
    }

    public int getPrioridad() {//obtener prioridad
        return prioridad;
    }

    public void setPrioridad(int prioridad) {//asignar una prioridad
        this.prioridad = prioridad;
    }
    public String getEstado() {//obtener estado de proceso
        return estado;
    }

    public void setEstado(String estado) {//*insertar estado de proceso
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return getNombre();
    }  

    public int getTiempoespera() {//obtener tiempo de espera
        return tiempoespera;
    }

    public void setTiempoespera(int tiempoespera) {//asignar tiempo de espera
        this.tiempoespera = tiempoespera;
    }
}
