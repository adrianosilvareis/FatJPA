package superior.mensagens;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ErroMensagens {
    
    private static boolean enable;
    private static List<String[]> erros;
    
    private ErroMensagens() {
    }

    public static ErroMensagens getInstancia() {
        return ErroMensagensHolder.INSTANCE;
    }
    
    private static class ErroMensagensHolder {
        private static final ErroMensagens INSTANCE = new ErroMensagens();
    }
    
    public void AtencaoMensagem(String mensagem){
        Errado();
        JOptionPane.showMessageDialog(null, mensagem,"Atenção", JOptionPane.INFORMATION_MESSAGE);        
    }
    
    public void ErroMensagem(String mensagem){
        Errado();
        JOptionPane.showMessageDialog(null, mensagem,"Erro", JOptionPane.ERROR_MESSAGE);
    }

    public void PerigoMensagem(String mensagem) {
        Errado();
        JOptionPane.showMessageDialog(null, mensagem,"Atenção", JOptionPane.WARNING_MESSAGE);
    }

    public void InformacaoMensagem(String mensagem) {
        Errado();
        JOptionPane.showMessageDialog(null, mensagem,"Informação", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void FatalMensagem(String mensagem){
        Errado();
        JOptionPane.showMessageDialog(null, mensagem,"Fatal Erro", JOptionPane.WARNING_MESSAGE);
    }
    
    public boolean confirmMessenger(String mensagem) {
        Errado();
        if (JOptionPane.showConfirmDialog(null, mensagem, "Atenção", JOptionPane.OK_OPTION) != 0) {
            return false;
        }
        return true;
    }
    
    public void Erros(String identificação, String informação, String objeto){
        if(erros == null){
            erros = new ArrayList<>();
        }
        String[] erro = new String[]{identificação, informação, objeto};
        erros.add(erro);
        Errado();
    }
    
    public List<String[]> getErros(){
        return erros;
    }
    
    public void ErrosClear(){
        erros.clear();
    }
    
    public boolean isErroEnable(){
        return enable;
    }
    
    public void close(){
        enable = false;
    }
    
    public void Errado(){
        enable = true;
    }
}
