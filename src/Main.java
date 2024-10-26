import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


class Cavallo implements Runnable {
    private String nome;
    private int distanzaPercorsa;
    private int distanzaTotale;

    public Cavallo(String nome, int distanzaTotale) {
        this.nome = nome;
        this.distanzaPercorsa = 0;
        this.distanzaTotale = distanzaTotale;
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    @Override
    public void run() {
        Random random = new Random();
        while (distanzaPercorsa < distanzaTotale) {
            int avanzamento = random.nextInt(10) + 1;
            distanzaPercorsa += avanzamento;


            if (distanzaPercorsa > distanzaTotale) {
                distanzaPercorsa = distanzaTotale;
            }


            System.out.println(nome + " ha percorso " + distanzaPercorsa + " metri.");
            clearScreen();


            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(nome + " è stato interrotto!");
            }
        }

        System.out.println(nome + " ha terminato la gara!");
    }
}

