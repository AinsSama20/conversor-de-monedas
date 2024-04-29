public record MonedaRecord( String base_code, String target_code, double conversion_rate, double conversion_result) {
    @Override
    public String toString() {
        return  "MONEDA LOCAL = "+base_code+" - "+
                "MONEDA A CONVERTIR = "+target_code+" - "+
                "VALOR REAL = "+(conversion_result/conversion_rate())+" - "+
                "VALOR DE CONVERSION = "+ conversion_rate+" - "+
                "MONTO CONVERTIDO = "+ conversion_result;
    }
}