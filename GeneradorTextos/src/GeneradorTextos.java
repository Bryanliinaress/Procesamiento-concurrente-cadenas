
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class GeneradorTextos {
    public static void main(String[] args) throws Exception {
        String abecedario = "abcdefghijklmnopqrstuvwxyz";
        OutputStream os = System.out;
        PrintWriter pw = new PrintWriter(os, true);
        
        /*Aquí cojo el codigo de CrearMúltiplesAccesos.java para redirigir las salidas al fichero javalog.txt
        y ver como va funcionando el programa.
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

        
        System.out.println("Proceso generador de texto");
        System.out.println("=========================");
        System.out.println("Generando texto aleatorio...");
        for (int i = 0; i < 15; i++) {
            // variable para hacer que el texto sea de minimo 5 caracteres y maximo 15
            int longitudPalabra = (int) (Math.random() * 11) + 5; // Longitud entre 5 y 15
            StringBuilder palabraGenerada = new StringBuilder();
            for (int j = 0; j < longitudPalabra; j++) {
                int indiceAleatorio = (int) (Math.random() * abecedario.length());
                char letraAleatoria = abecedario.charAt(indiceAleatorio);
                palabraGenerada.append(letraAleatoria);
            }
            System.out.println(palabraGenerada.toString());
            pw.println(palabraGenerada.toString());
        }
        System.out.println();
        System.out.println("Textos aleatorios generados.");
        System.out.println();
        System.out.println();
    }
}
