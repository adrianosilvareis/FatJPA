
package superior.entrada;

import superior.mensagens.ErroMensagens;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class LerEntrada {

    public LerEntrada() {
    }
    
    public BufferedReader getEntrada(String endereco) throws UnsupportedEncodingException {

        try {
            //"ISO-8859-1"
            //"UTF-8"
            BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(endereco), "ISO-8859-1"));

            return buff;
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException");
            ErroMensagens.getInstancia().FatalMensagem("Arquivo não encontrado!");
        }
        return null;
    }
}
