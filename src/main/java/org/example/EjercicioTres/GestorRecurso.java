package org.example.EjercicioTres;

public class GestorRecurso {

    private boolean disponible=false;

    public synchronized void producirRecurso() throws InterruptedException{
        while (disponible){
            wait();
        }
        System.out.println("PING");
        disponible=true;
        notify();
    }
    public synchronized void consumirRecurso() throws InterruptedException{
        while (!disponible){
            wait();
        }
        System.out.println("PONG");
        disponible=false;
        notify();
    }


}
