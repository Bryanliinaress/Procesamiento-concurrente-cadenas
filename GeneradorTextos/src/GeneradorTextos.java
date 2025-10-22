
import java.io.OutputStream;
import java.io.PrintWriter;

public class GeneradorTextos {
    public static void main(String[] args) throws Exception {
        OutputStream outStream = System.out;
        PrintWriter printWriter = new PrintWriter(outStream, true);

        printWriter.println("Hola");
    }
}
