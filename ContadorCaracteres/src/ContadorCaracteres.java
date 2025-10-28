import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class ContadorCaracteres {
    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(isr);
        // Obtenemos el stream de lectura de la entrada estándar
        // utilizamos un lector con Buffered, para no perder ningún dato

        OutputStream os = System.out;
        PrintWriter pw = new PrintWriter(os, true);
        String lineaTeclado = null;
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

        System.out.println("Proceso contador de caracteres");
        System.out.println("==============================");
        try {
            // Mostramos que el proceso que está escribiendo es el que está
            // leyendo los datos.
            
            while ((lineaTeclado = bf.readLine()) != null) {
                //Aqui leemos solo las lineas que tienen entre 5 y 15 caracteres
                if (lineaTeclado.length()>=5 && lineaTeclado.length()<=15) {
                System.out.println("Número de caracteres leídos: " + lineaTeclado.length());
                System.out.println(lineaTeclado + "," + lineaTeclado.length());
                pw.println(lineaTeclado+"," + lineaTeclado.length());
                }
            }
        } catch (IOException ex) {
            System.err.println("Se ha producido un error de E/S.");
            System.err.println(ex.toString());
        }

        System.out.println();
        System.out.println("Proceso contador de caracteres finalizado.");
        System.out.println();
        System.out.println();
    }
}
