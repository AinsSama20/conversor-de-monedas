import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApiMoneda apiMoneda = new ApiMoneda();
        Scanner scanner = new Scanner(System.in);
        CodigoMonedaRecord codigoMonedaRecord = apiMoneda.consultaCodigosMoneda();
        ArrayList<String> listaHistorial= new ArrayList<>();
        int opcion = 1;
        while (opcion>0){
            System.out.println("********************************************************************************************************");
            System.out.println("Codigos de moneda: ");
            System.out.println("********************************************************************************************************");
            System.out.println("NUMERO - CODIGO - NOMBRE");
            for (int i = 0; i < codigoMonedaRecord.supported_codes().size(); i++) {
                ArrayList listaCodigosMoneda = (ArrayList) codigoMonedaRecord.supported_codes().get(i);
                System.out.println((i+1)+" - "+listaCodigosMoneda.get(0)+" - "+listaCodigosMoneda.get(1));
            }
            System.out.println("********************************************************************************************************");
            System.out.print("Código de moneda local: ");
            var monedaLocal = scanner.nextLine();
            System.out.println("********************************************************************************************************");
            System.out.print("Código de moneda a convertir: ");
            var monedaConvertir = scanner.nextLine();
            System.out.println("********************************************************************************************************");
            System.out.print("Monto a convertir: ");
            var montoDeMoneda = scanner.nextDouble();
            System.out.println("********************************************************************************************************");
            scanner.nextLine();
            MonedaRecord monedaRecord = apiMoneda.consultaCambioMoneda(monedaLocal, monedaConvertir, montoDeMoneda);
            System.out.println(monedaRecord);
            GenerarArchivo generarArchivo = new GenerarArchivo();
            generarArchivo.generarArchivo(monedaRecord);
            listaHistorial.add(String.valueOf(monedaRecord));
            System.out.println("********************************************************************************************************");
            System.out.print("Ingrese 0 para salir, 1 para continuar o 2 para mostrar su historial de conversiones: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            if (opcion == 0){
                System.out.println("********************************************************************************************************");
                System.out.println("PROGRAMA FINALIZADO");
                System.out.println("********************************************************************************************************");
                break;
            }else if (opcion==2){
                for (int i = 0; i < listaHistorial.size(); i++) {
                    System.out.println(listaHistorial.get(i));
                }
                System.out.println("********************************************************************************************************");
                System.out.print("Ingrese 0 para salir, 1 para continuar o 2 para mostrar su historial de conversiones: ");
                opcion = scanner.nextInt();
                scanner.nextLine();
            }else{
                opcion = 1;
            }
        }
    }
}