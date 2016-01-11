package form.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class Documents {

    private static Documents instance;
    
    public Documents() {
    }
    
    public static Documents getDocuments(){
        if(instance == null){
            instance = new Documents();
        }
        return instance;
    }
    
    public DigitaDouble DigitaDouble() {
        return new DigitaDouble();
    }

    public DigitaNumero DigitaNumero() {
        return new DigitaNumero();
    }

    public DigitaOS DigitaOS() {
        return new DigitaOS();
    }
    
    public class DigitaNumero extends PlainDocument {

        @Override
        public void insertString(int i, String string, AttributeSet as) throws BadLocationException {
            super.insertString(i, string.replaceAll("[^0-9]", ""), as);
        }

        @Override
        public void replace(int i, int i1, String string, AttributeSet as) throws BadLocationException {
            super.replace(i, i1, string.replaceAll("[^0-9]", ""), as);
        }
    }

    public class DigitaOS extends PlainDocument {

        @Override
        public void insertString(int i, String string, AttributeSet as) throws BadLocationException {
            super.insertString(i, string.replaceAll("[^0-9|^-]", ""), as);
        }

        @Override
        public void replace(int i, int i1, String string, AttributeSet as) throws BadLocationException {
            super.replace(i, i1, string.replaceAll("[^0-9|^-]", ""), as);
        }
    }

    public class DigitaDouble extends PlainDocument {
        @Override
        public void insertString(int i, String string, AttributeSet as) throws BadLocationException {
            super.insertString(i, string.replaceAll("[^0-9|^.]", ""), as);
        }

        @Override
        public void replace(int i, int i1, String string, AttributeSet as) throws BadLocationException {
            super.replace(i, i1, string.replaceAll("[^0-9|^.]", ""), as);
        }
    }

}
