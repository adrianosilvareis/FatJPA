package form.util;

public class LeData {
    
    public static java.sql.Date LeBrasil(String data, String divisor) {
        String[] split = data.split(divisor);
        int dia = Integer.parseInt(split[0]);
        int mes = Integer.parseInt(split[1]) - 1;
        int ano = Integer.parseInt(split[2]) - 1900;

        java.sql.Date date = new java.sql.Date(ano, mes, dia);
        return date;
    }
}
