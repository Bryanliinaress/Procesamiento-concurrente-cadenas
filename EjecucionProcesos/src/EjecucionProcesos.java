import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class EjecucionProcesos {
    public static Object timeThread;

    public static void main(String[] args) throws Exception {

        System.out.println("Bienvenido al sistema de ejecución de procesos. ");
        System.out.println("Dime cuantas instancias del generador de textos quieres ejecutar: ");
        int numInstancias = Integer.parseInt(System.console().readLine());
        while (numInstancias > 10) {
            System.out.println("El número máximo de instancias permitidas es 10.Vuelve a intentarlo: ");
            numInstancias = Integer.parseInt(System.console().readLine());
        }
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

        System.out.println("Proceso ejecutor de procesos.");
        System.out.println("=============================");
        String[] comando;
        try {
            for (int i = 0; i < numInstancias; i++) {
                System.out.println("Ejecutando instancia " + (i + 1) + " de los procesos.");
                System.out.println("----------------------------------------------");
                System.out.println("Generador de textos -> Contador de caracteres -> Contador de vocales");
                System.out.println();
                System.out.println();
                String comandoString = "cmd /c java -jar ./GeneradorTextos/GeneradorTextos.jar | java -jar ./ContadorCaracteres/ContadorCaracteres.jar | java -jar ./ContadorVocales/ContadorVocales.jar";
                comando = comandoString.split(" ");
                Runtime.getRuntime().exec(comando);
                timeThread = new Thread();
                Thread.sleep(2000); // Esperamos 5 segundos entre la ejecución de cada proceso
            }
        } catch (SecurityException ex) {
            System.err.println(
                    "Ha ocurrido un error de Seguridad." +
                            "No se ha podido crear el proceso por falta de permisos.");
        }

    }

}
