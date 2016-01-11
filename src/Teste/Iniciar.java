package Teste;

import br.data.bancodedados.CriaConexao;
import javax.persistence.EntityManager;


public class Iniciar {

    public static void main(String[] args) {
        CriaConexao.getInstance().setNomeUnidadePersistencia("FatJPA");
        EntityManager em = CriaConexao.getInstance().getEntityManager();
        String propriedade = "{javax.persistence.jdbc.driver=com.mysql.jdbc.Driver, "
                + "javax.persistence.jdbc.password=root, "
                + "javax.persistence.schema-generation.database.action=create, "
                + "javax.persistence.jdbc.url=jdbc:mysql://192.168.0.2:3306/faturamento?zeroDateTimeBehavior=convertToNull, "
                + "javax.persistence.jdbc.user=root}";  
        System.out.println(" 1 " + em.getProperties());
        em.setProperty(propriedade, null);
        System.out.println(" 2 " + em.getProperties());
    }
}
