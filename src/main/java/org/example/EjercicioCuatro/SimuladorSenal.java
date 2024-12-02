package org.example.EjercicioCuatro;

public class SimuladorSenal {
    public static void main(String[] args) {
        GestorSenal gestorSenal=new GestorSenal();

        Runnable runnable=()->{

            String nombre=Thread.currentThread().getName();

            try {
                gestorSenal.recibirNotificacion(nombre);
                Thread.sleep(2000);
                gestorSenal.notificar(nombre);
            } catch (InterruptedException e) {
                System.out.println("Error: " + e);
            }
        };

        Thread hilo1=new Thread(runnable,"hilo1");
        Thread hilo2=new Thread(runnable,"hilo2");
        Thread hilo3=new Thread(runnable,"hilo3");

        hilo1.start();
        hilo2.start();
        hilo3.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }
    }
}
