import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GaraCavalli {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Inserisci la lunghezza del percorso della gara (in metri):");
        int distanzaTotale = scanner.nextInt();


        System.out.println("Inserisci il numero di cavalli:");
        int numeroCavalli = scanner.nextInt();

        List<Thread> cavalli = new ArrayList<>();


        for (int i = 0; i < numeroCavalli; i++) {
            System.out.println("Inserisci il nome del cavallo " + (i + 1) + ":");
            String nome = scanner.next();
            Cavallo cavallo = new Cavallo(nome, distanzaTotale);
            Thread threadCavallo = new Thread(cavallo);
            cavalli.add(threadCavallo);
        }

        System.out.println("I cavalli sono pronti. La gara inizia!");


        for (Thread cavallo : cavalli) {
            cavallo.start();
        }


        for (Thread cavallo : cavalli) {
            try {
                cavallo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("La gara è finita!");
    }
}