/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package form.util;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Adriano
 */
public class TableRenderer {
    private static TableRenderer instancia;

    public TableRenderer() {
    }

    public static TableRenderer getInstancia() {
        if(instancia == null){
            instancia = new TableRenderer();
        }
        return instancia;
    }
    
    public DefaultTableCellRenderer cadastra = new DefaultTableCellRenderer() {
        
        public void setValue(Object value) {
            setBackground(new Color(255,51,0));
            setForeground(Color.BLACK);
            setHorizontalAlignment(JLabel.CENTER);

            //outras alterações entram aqui...
            super.setValue(value);
        }
    };
    
    public DefaultTableCellRenderer producao = new DefaultTableCellRenderer() {

        public void setValue(Object value) {
            setBackground(new Color(0,204,51));
            setForeground(Color.BLACK);
            setHorizontalAlignment(JLabel.CENTER);

            //outras alterações entram aqui...
            super.setValue(value);
        }
    };
    
    public DefaultTableCellRenderer administrador = new DefaultTableCellRenderer() {

        public void setValue(Object value) {
            setBackground(new Color(255,204,0));
            setForeground(Color.BLACK);
            setHorizontalAlignment(JLabel.CENTER);

            //outras alterações entram aqui...
            super.setValue(value);
        }
    };
    
    public DefaultTableCellRenderer upload = new DefaultTableCellRenderer() {

        public void setValue(Object value) {
            setBackground(new Color(255,0,255));
            setForeground(Color.BLACK);
            setHorizontalAlignment(JLabel.CENTER);

            //outras alterações entram aqui...
            super.setValue(value);
        }
    };
}
