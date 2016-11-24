/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import dao.CidadeDAO;
import dao.EstadoDAO;
import dao.ImovelDAO;
import dao.StatusDAO;
import dao.TipoContratoDAO;
import dao.TipoImovelDAO;
import global.model.Cidade;
import global.model.Endereco;
import global.model.Estado;
import global.model.Status;
import imovel.model.Documentacao;
import imovel.model.Imovel;
import imovel.model.Terreno;
import imovel.model.TipoContrato;
import imovel.model.TipoImovel;
import java.util.List;

/**
 *
 * @author a1502719
 */
public class PersistirAtualizado {

    /**
     * Esta é a primeira opção para persistir o Imovel.
     * Trata-se da forma mais adequada.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Criação do ImovelDAO e da classe Imovel
        ImovelDAO dao = new ImovelDAO();
        Imovel imovel = new Imovel();
        
        //Preenchimento básico dos atributos do Imovel
        imovel.setQtdQuartos(2);
        imovel.setAtivo(true);
        imovel.setQtdSuites(2);
        imovel.setQtdSalas(1);
        imovel.setQtdBanheiros(2);
        imovel.setQtdPisos(2);
        imovel.setLavanderia(1);
        imovel.setVagasGaragem(2);
        imovel.setAreaServico(1);
        imovel.setPiscina(1);
        imovel.setLavabos(2);
        imovel.setDepEmpregados(1);
        imovel.setAnoConstrucao(1990);
        imovel.setDescImovel("Descricao do meu Imovel");
        imovel.setChaves("As chaves estao em posse do dono.");
        imovel.setTipoMobilia(2);
        imovel.setValorIptu(100.0);
        
        //Instanciando um TipoImovelDAO e criando uma lista de TipoImovel
        TipoImovelDAO tipoImovelDao = new TipoImovelDAO();
        List<TipoImovel> tiposimoveis = tipoImovelDao.getAll();
        
        //relacionando o OBJETO da lista TipoImovel com o Imovel
        imovel.setTipoImovel(tiposimoveis.get(0));
        
        
        //Criando e preenchendo um novo Endereco para o Imovel
        Endereco end = new Endereco();
        end.setNomeEndereco("Casa do Carvalho");
        end.setNumero(666);
        end.setCep("117812");
        end.setBairro("Bairro XYZ");
        //Istancia de CidadeDAO
        CidadeDAO cidadeDao = new CidadeDAO();
        //Pegando a cidade CAragua pelo ID
        Cidade caragua = cidadeDao.getById(Long.parseLong("8797"));
        //relacionando o bairro ao endereco
        end.setCidade(caragua);
        
        //Caso a cidade ja exista, mas o bairro nao, voce deve puxar a cidade do banco, criar
        //um novo bairro e associa-lo a esta cidade. Ai é só associar o bairro ao endereco
        
        //atribuindo todo o endereco ao Imovel
        imovel.setEndereco(end);
        
        
        //Criando Documentacao do Imovel
        Documentacao doc = new Documentacao();
        doc.setNumMatricula("123123123");
        doc.setNumContaAgua("abc-123-43");
        doc.setNumContaLuz("luz-1234");
        doc.setNumIptu("ptu-1230");
        doc.setNumContrato("0000001");
        doc.setCartorio("Cartorio Municipal XPTO");
        
        //atribuindo todo a documentacao ao Imovel
        imovel.setDocumentacao(doc);
        
        
        //Criando o Terredo do Imovel
        Terreno ter = new Terreno();
        ter.setComprimento(10);
        ter.setLargura(10);
        ter.setSituacaoEscritura("Terreno devidamente escriturado,");
        
        //atribuindo todo o Terreno ao Imovel
        imovel.setTerreno(ter);
        
        
        //Instancia do TipoContratoDAO e criando lista de TipoContrato
        TipoContratoDAO tipoCDao = new TipoContratoDAO();
        List<TipoContrato> tiposC = tipoCDao.getAll();
        //pegando dois objetos TipoContrato da lista
        TipoContrato tipoCont = tiposC.get(0);
        TipoContrato tipoContdois = tiposC.get(1);
        //estabelendo relacao de Imovel e TipoContrato
        //nesta relacao existe o atributo Valor
        imovel.addTipoContrato(tipoCont, 200);
        imovel.addTipoContrato(tipoContdois, 300);
        //tambem seria possivel passar os objetos pelo indicce da lista
//        imovel.addTipoContrato(tiposC.get(0), 200);
//        imovel.addTipoContrato(tiposC.get(1), 300);
        
        
        
        //instancia de StatusDAO e lista de Status
        StatusDAO statusdao = new StatusDAO();
        List<Status> status = statusdao.getAll();
        
        //atribuindo um objeto status ao Imovel
        imovel.setStatus(status.get(0));
        
        
        //persistindo tudo
        dao.persist(imovel);
        
    }
    
}
