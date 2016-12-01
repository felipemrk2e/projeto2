
import Interface.Relatorio.PDF;
import dao.ImovelDAO;
import dao.PessoaDAO;
import dao.PessoaFisicaDAO;
import global.model.ConexaoManual;
import imovel.model.Imovel;
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

        ImovelDAO imovelDAO = new ImovelDAO();
        List<Imovel> imoveisAtivos = imovelDAO.ativosPorCidade(8797);

//        for (int i = 0; i < imoveisAtivos.size(); i++) {
//            System.out.println("=============================================================="+imoveisAtivos.get(i).getIdImovel());
//        }
        PDF pdf = new PDF();
        pdf.criaPDF();
        pdf.abrePDF();

        pdf.addTituloPDF("Relatório de Imoveis Ativos na Cidade de " + imoveisAtivos.get(0).getEndereco().getCidade().getNomeCidade());
        pdf.addLinhaPDF("");
        pdf.addLinhaPDF("");
        pdf.addImagemPDF("C:\\Users\\a1502735\\Documents\\NetBeansProjects\\projeto2\\Projeto\\src\\image\\locacao.png");

        pdf.addLinhaPDF("");
        pdf.addLinhaPDF("");
        pdf.addLinhaPDF("Quantidade de Registros: " + imoveisAtivos.size());
        pdf.addLinhaPDF("");
        pdf.addLinhaPDF("\n");
////        for (int i = 0; i < pessoas.size(); i++) {
////            pdf.addLinhaPDF(pessoas.get(i).getNomePessoa());
////        }
        pdf.addTabela(new String[]{"ID","Status", "Ano", "Endereço", "Bairro"});
        for (int i = 0; i < imoveisAtivos.size(); i++) {
            pdf.addTabela(new String[]{Long.toString(imoveisAtivos.get(i).getIdImovel()),imoveisAtivos.get(i).getStatus().getStatus(), Integer.toString(imoveisAtivos.get(i).getAnoConstrucao()), imoveisAtivos.get(i).getEndereco().getNomeEndereco(), imoveisAtivos.get(i).getEndereco().getBairro()});
        }
        pdf.fechaPDF();
        pdf.carregaPDF(null);
//        pdf.imprimePDF(null);
    }
}
