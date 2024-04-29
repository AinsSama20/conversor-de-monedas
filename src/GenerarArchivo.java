import java.io.FileReader;
import java.io.FileWriter;
import java.time.Instant;

public class GenerarArchivo {
    void generarArchivo(MonedaRecord monedaRecord){
        try {
            FileWriter fileWriter = new FileWriter("log.txt",true);
            fileWriter.write(Instant.now()+" : "+String.valueOf(monedaRecord)+"\n");
            fileWriter.close();
        }catch (Exception e){
            System.out.printf(String.valueOf(e));
        }
    }
}
