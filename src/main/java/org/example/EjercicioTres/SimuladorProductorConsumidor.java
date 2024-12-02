package org.example.EjercicioTres;

public class SimuladorProductorConsumidor {
    public static void main(String[] args) {

        GestorRecurso gestorRecurso=new GestorRecurso();

        Thread productor=new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    gestorRecurso.producirRecurso();
                    Thread.sleep(500);

                } catch (InterruptedException e) {
                    System.out.println("Error: " + e);
                }
            }
        });
        Thread consumidor=new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    gestorRecurso.consumirRecurso();
                    Thread.sleep(500);

                } catch (InterruptedException e) {
                    System.out.println("Error: " + e);
                }
            }
        });

        productor.start();
        consumidor.start();
    }


}
