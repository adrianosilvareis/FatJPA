
package superior.entrada;

import br.entidade.sft.SftOutputGlos;
import br.entidade.sft.SftOutputInco;
import br.entidade.sft.SftOutputPart;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Tradutor{
    
    private static Tradutor instance;
    private List<String[]> lista = new ArrayList<>();
    
    public Tradutor() {
    }
    
    public static Tradutor getInstance() {
        if(instance == null){
            instance = new Tradutor();
        }
        return instance;
    }
    
    /**
     *
     * @param type
     * @param url
     * @return
     * @throws IOException
     */
    public List<String[]> getResultList(Class type, String url) throws IOException{
        
        BufferedReader texto = new LerEntrada().getEntrada(url);
        lista.clear();
        
        if(type == SftOutputInco.class){
            lista = getUploadInco(texto);
        }
        
        if(type == SftOutputGlos.class){
            lista = getUploadGlos(texto);
        }
        
        if(type == SftOutputPart.class){
            lista = getUploadPart(texto);
        }
        
        if(type == null){
            lista = getLogin(texto);
        }
//        
//        if(type == SftOutputDescontos.class){
//            lista = getUploadDesc(texto);
//        }
//        
//        if(type == SftOutputCortesias.class){
//            lista = getUploadCort(texto);
//        }
           
        return lista;
    }

    private List<String[]> getUploadInco(BufferedReader texto) throws IOException {
        String linha = texto.readLine();
        while (linha != null) {
            String[] column = linha.split("\t");
            lista.add(column);
            linha = texto.readLine();
        }
        return lista;
    }
    
    private List<String[]> getUploadGlos(BufferedReader texto) throws IOException {
        String linha = texto.readLine();
        while (linha != null) {
            String[] column = linha.split("\t");
            lista.add(column);
            linha = texto.readLine();
        }
        return lista;
    }
    
    private List<String[]> getUploadPart(BufferedReader texto) throws IOException {
        String linha = texto.readLine();
        while (linha != null) {
            String[] column = linha.split(";");
            lista.add(column);
            linha = texto.readLine();
        }
        return lista;
    }

    private List<String[]> getUploadDesc(BufferedReader texto) {
        return lista;
    }

    private List<String[]> getUploadCort(BufferedReader texto) {
        return lista;
    }
    
    private List<String[]> getLogin(BufferedReader texto) throws IOException{
        String linha = texto.readLine();
        while (linha !=null) {
            String[] column = linha.split("\"");
            lista.add(column);
            linha = texto.readLine();
        }
        return lista;
    }
}
