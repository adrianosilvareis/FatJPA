package form.util;

import br.entidade.Convenio;
import br.entidade.sft.SftInputAten;
import br.entidade.sft.SftInputNcon;
import br.entidade.sft.SftInputStat;
import br.entidade.sft.SftInputUnid;
import br.entidade.sft.SftOutputInco;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel{
    private static final long serialVersionUID = 1L;
    
    private List<SftOutputInco> list;
    private String[] column = {"Usuario", "Data", "Numero OS", "Unidade", "Atendente","Convenio", "Não Conformidade", "Observação", "Status"};
    
    
    public TableModel() {
        this.list = new ArrayList<>();
    }

    public TableModel(String[] column) {
        this.list = new ArrayList<>();
        this.column = column;
    }
    
    public void addRow(SftOutputInco s){
        this.list.add(s);
        fireTableDataChanged();
    }
    
    public void removeRow(int rowIndex){
        this.list.remove(rowIndex);
        fireTableDataChanged();
    }
    
    public SftOutputInco getRow(int rowIndex){
        return this.list.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return this.list.size();
    }

    @Override
    public int getColumnCount() {
        return this.column.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        SftOutputInco sftInco = this.list.get(rowIndex);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        switch (columnIndex) {
            case 0:return sftInco.getSftCtrlHistoricoList().get(0).getUsuariosId().getLogin();
            case 1:return formato.format(sftInco.getIncoDtRegis());
            case 2:return sftInco.getIncoOsNumos();               
            case 3:return ((sftInco.getFkUnid() != null) ? sftInco.getFkUnid()
                            .getUnidNmNmunid() : null);
            case 4:return ((sftInco.getFkAten() != null) ? sftInco.getFkAten()
                            .getAtenNmNmaten() : null);
            case 5:return ((sftInco.getFkConv() != null) ? sftInco.getFkConv()
                            .getMascaraConvenioId().getDescricao() : null);
            case 6:return ((sftInco.getFkNcon() != null) ? sftInco.getFkNcon()
                            .getNconNmNmncon() : null);
            case 7:return this.list.get(rowIndex).getIncoObObsinco();
            case 8:return ((sftInco.getFkStat() !=null) ? sftInco.getFkStat()
                            .getStatusNmDescricao() : null);
            default:return sftInco;
        }
    }
    
    @Override        
      public void setValueAt(Object value, int row, int col) {  
          SftOutputInco dado = list.get(row);
          switch (col){  
              case 2: dado.setIncoOsNumos((String)value);break;
              case 3: dado.setFkUnid((SftInputUnid)value);break;
              case 4: dado.setFkAten((SftInputAten)value);break;
              case 5: dado.setFkConv((Convenio)value);break;
              case 6: dado.setFkNcon((SftInputNcon)value);break;
              case 7: dado.setIncoObObsinco((String)value);break;
              case 8: dado.setFkStat((SftInputStat)value);break;
              default: dado = (SftOutputInco) value;
          }  
          fireTableCellUpdated(row, col);  
       } 
      
    @Override
    public String getColumnName(int columnIndex){
        return this.column[columnIndex];
    }
}
