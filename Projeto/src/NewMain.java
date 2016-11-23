
import Interface.Relatorio.PDF;
import dao.PessoaDAO;
import dao.PessoaFisicaDAO;
import global.model.ConexaoManual;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.pessoa.Pessoa;
import model.pessoa.PessoaFisica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jeanbrock
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        PessoaDAO pessoaDAO = new PessoaDAO();
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas = pessoaDAO.getAll();
        
        
        PDF pdf = new PDF();
        pdf.criaPDF();
        pdf.addTituloPDF("Meu Primeiro PDF!");
        for (int i = 0; i < pessoas.size(); i++) {
            pdf.addLinhaPDF(pessoas.get(i).getNomePessoa());
        }
        pdf.fechaPDF(); 
        pdf.carregaPDF(null);
        pdf.imprimePDF(null);
    }
    
    

}
