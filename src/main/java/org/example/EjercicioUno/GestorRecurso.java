package org.example.EjercicioUno;

public class GestorRecurso {

    private int recurso;
    private boolean disponible=false;

    public synchronized void producirRecurso() throws InterruptedException{
        while (disponible){
            wait();
        }
        this.recurso=(int)(Math.random()*100);
        System.out.println("Se ha generado un recurso");
        this.disponible=true;
        notify();
    }

    public synchronized void consumirRecurso() throws InterruptedException{
        while (!disponible){
            wait();
        }
        System.out.println("El recurso generado es: "+recurso);
        this.disponible=false;
        notify();
    }

}
