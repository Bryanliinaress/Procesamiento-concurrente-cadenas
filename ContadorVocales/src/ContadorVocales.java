import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ContadorVocales {
    public static void main(String[] args) throws Exception {
        ArrayList<Character> letras = new ArrayList<>();
        OutputStream os = System.out;
        PrintWriter pw = new PrintWriter(os, true);
        String lineaTeclado = null;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(isr);

        /*
         * Aquí cojo el codigo de CrearMúltiplesAccesos.java para redirigir las salidas
         * al fichero javalog.txt
         * y ver como va funcionando el programa.
         */
        // Redirigir salidas a javalog.txt
        try {
            // Redirigimos salida estándar y de error a un fichero
            PrintStream ps = new PrintStream(
                    new BufferedOutputStream(
                            new FileOutputStream(new File("javalog.txt"), true)),
                    true);
            System.setOut(ps);
            System.setErr(ps);
        } catch (Exception e) {
            System.err.println("Error al redirigir las salidas");
            System.err.println(e.toString());
        }

        try {
            Thread.sleep(1000); 
            System.out.println("Proceso contador de vocales");
            System.out.println("=========================");
            System.out.println("Contando vocales...");
            while ((lineaTeclado = bf.readLine()) != null) {
                // Aqui leemos solo las lineas que tienen entre 5 y 18 caracteres para admitir
                // la "," y el numero
                if (lineaTeclado.length() >= 5 && lineaTeclado.length() <= 18) {
                    int contadorVocales = 0;
                    for (int i = 0; i < lineaTeclado.length(); i++) {
                        char letraActual = lineaTeclado.charAt(i);
                        if (letraActual == 'a' || letraActual == 'e' || letraActual == 'i' || letraActual == 'o'
                                || letraActual == 'u') {
                            contadorVocales++;
                            letras.add(letraActual);
                        }
                    }
                    System.out.println("Número de vocales leídas: " + contadorVocales);
                    String[] separarFrase = lineaTeclado.split(",");
                    System.out.println(lineaTeclado + "," + contadorVocales + "," + letras.toString());
                    System.out.println();
                    pw.println("Texto leído: " + azul + separarFrase[0] + reset + ". Número de Caracteres: " + azul
                            + separarFrase[1] + reset + ". Número de vocales: " + rojo + contadorVocales + reset
                            + ". Vocales leídas: " + rojo + letras + reset + ".");
                    pw.println();
                    letras.clear();
                }
            }
        } catch (IOException ex) {
            System.err.println("Se ha producido un error de E/S.");
            System.err.println(ex.toString());
        }
    }

    // color azul
    static final String azul = "\u001B[34m";
    // color rojo
    static final String rojo = "\u001B[31m";
    // color reset
    static final String reset = "\u001B[0m";
}
