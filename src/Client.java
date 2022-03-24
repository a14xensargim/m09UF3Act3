import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
    public static void main(String[] args){
        iniciPrograma();
    }

    public static void iniciPrograma() {
        boolean bool = true;
        InputStream lector = null;
        ProcessBuilder proces = new ProcessBuilder();
        proces.command("java", "-jar", "JAR/m09UF3Act3.jar");

        try {
            Process b = proces.start();
            PrintWriter escritura = new PrintWriter(b.getOutputStream());
            lector = b.getInputStream();
            BufferedReader entrada = new BufferedReader(new InputStreamReader(lector));

            do {
                // Hora, minut i segon del sistema.
                long tempsMiliSegons = System.currentTimeMillis();
                SimpleDateFormat formatData = new SimpleDateFormat("HH:mm:ss");
                Date resultdate = new Date(tempsMiliSegons);

                //
                escritura.println(formatData.format(resultdate) + " - Hola");
                escritura.flush();

                sortidaConsola(entrada);

                Thread.sleep(1000);

            }while (bool);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            try {
                lector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Mètode que llegeix la línia
     * @param entrada
     * @throws IOException
     */
    public static void sortidaConsola(BufferedReader entrada) throws IOException {
        String linia = "";
        linia = entrada.readLine();

        System.out.println(linia);
    }
}
