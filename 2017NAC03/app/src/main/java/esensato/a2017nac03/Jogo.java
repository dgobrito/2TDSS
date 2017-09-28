package esensato.a2017nac03;

import android.util.Log;

import java.util.Random;

public class Jogo {

    private static final String cores[] = {"AZUL", "AMARELO", "VERMELHO", "VERDE"};

    private static String corSorteada;

    private static int totalSorteio;

    private static int totalChance;

    private static boolean fim;

    public static void iniciar(int nroChance) {

        fim = false;
        totalSorteio = 0;
        totalChance = nroChance;
    }

    public static void sortearCor() {


        Random r = new Random();
        int nova = r.nextInt(cores.length);
        corSorteada = cores[nova];

        Log.i("SORTEIO", "Cor = " + corSorteada + " - Tentativas = " + totalSorteio);

        if (totalSorteio == totalChance)
            fim = true;

    }

    public static String corSorteada() {
        totalSorteio++;
        return corSorteada;
    }

    public static boolean fim() {
        return fim;
    }

}
