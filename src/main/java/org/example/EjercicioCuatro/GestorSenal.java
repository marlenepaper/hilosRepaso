package org.example.EjercicioCuatro;

public class GestorSenal {

    private final int CAPACIDAD=3;
    private int capacidadUsada=0;


    public synchronized void notificar(String nombre) {
        this.capacidadUsada--;
        System.out.println(nombre+" ha salido. Capacidad usada: "+this.capacidadUsada);
        notify();
    }

    public synchronized void recibirNotificacion(String nombre) throws InterruptedException{
        while (this.capacidadUsada==this.CAPACIDAD){
            System.out.println(nombre+" esta esperando...");
            wait();
        }
        capacidadUsada++;
        System.out.println(nombre+" ha entrado. Capacidad usada: "+this.capacidadUsada);
        notify();

        if (capacidadUsada==this.CAPACIDAD){
            System.out.println("Capacidad usada: "+ capacidadUsada+ " estacionamiento cerrado");
        }
    }
}
