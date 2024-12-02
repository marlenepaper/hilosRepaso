package org.example.EjercicioDos;

public class GestorSenal {

    private boolean enviada=false;

    public synchronized void notificar() {
        System.out.println("El hilo principal ha enviado la señal");
        this.enviada=true;
        notifyAll();

    }
    public synchronized void recibirNotificacion(String nombreHilo) throws InterruptedException{
        while (!this.enviada){
            System.out.println(nombreHilo+" esta esperando la señal");
            wait();
        }
        System.out.println(nombreHilo+" ha recibido la señal");
    }
}

