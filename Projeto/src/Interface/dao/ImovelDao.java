package Interface.dao;

import Interface.Database.Database;
import Interface.Model.Imovel;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ImovelDao extends DAO<Imovel>{

    public ImovelDao(Database database) {
        super(database);
        database.connect();
    }

    @Override
    public boolean insert(Imovel imovel) {
        String sql = "INSERT INTO "
                + "IMOVEL(qtdQuartos, qtdSuites, qtdSalas, qtdBanheiros, qtdPisos, lavanderia, vagasGaragem, "
                + "areaServico, piscina, lavabos, depEmpregados, areaExterna, dataConstrucao, acabamento, "
                + "outrosItens, descricaoImovel, observacoes, chaves, valorIptu, valorCondominio, idMobilia, idTipoImovel) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getQtdQuartos()));
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getQtdSuites()));
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getQtdSalas()));
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getQtdBanheiros()));
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getQtdPisos()));
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getLavanderia()));
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getVagasGaragem()));
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getAreaServico()));
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getPiscina()));
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getLavabos()));
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getQtdQuartos()));
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getDepEmpregados()));
        sql = sql.replaceFirst("\\?", "\"" + imovel.getAreaExterna() + "\"");
        sql = sql.replaceFirst("\\?", "\"" + imovel.getDataConstrucao() + "\"");
        sql = sql.replaceFirst("\\?", "\"" + imovel.getAcabamento() + "\"");
        sql = sql.replaceFirst("\\?", "\"" + imovel.getOutrosItens() + "\"");
        sql = sql.replaceFirst("\\?", "\"" + imovel.getDescricaoImovel() + "\"");
        sql = sql.replaceFirst("\\?", "\"" + imovel.getObservacoes() + "\"");
        sql = sql.replaceFirst("\\?", "\"" + imovel.getChaves() + "\"");
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getValorIptu()));
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getValorCondominio()));
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getMobilia().getIdMobilia()));
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getTipoImovel().getIdTipoImovel()));
        return database.insert(sql);
    }

    @Override
    public boolean update(Imovel imovel) {
        String sql = "UPDATE Imovel SET qtdQuartos = ?, "
                + "qtdSuites = ?, "
                + "qtdSalas = ?, "
                + "qtdBanheiros = ?, "
                + "qtdPisos = ?, "
                + "lavanderia = ?, "
                + "vagasGaragem = ?, "
                + "areaServico = ?, "
                + "piscina = ?, "
                + "lavabos = ?, "
                + "depEmpregados = ?, "
                + "areaExterna = ?, "
                + "dataConstrucao = ?, "
                + "acabamento = ?, "
                + "outrosItens = ?, "
                + "descricaoImovel = ?, "
                + "observacoes = ?, "
                + "chaves = ?, "
                + "valorIptu = ?, "
                + "valorCondominio = ?, "
                + "idMobilia = ?, "
                + "idTipoImovel = ?";
        
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getQtdQuartos()));
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getQtdSuites()));
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getQtdSalas()));
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getQtdBanheiros()));
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getQtdPisos()));
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getLavanderia()));
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getVagasGaragem()));
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getAreaServico()));
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getPiscina()));
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getLavabos()));
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getQtdQuartos()));
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getDepEmpregados()));
        sql = sql.replaceFirst("\\?", "\"" + imovel.getAreaExterna() + "\"");
        sql = sql.replaceFirst("\\?", "\"" + imovel.getDataConstrucao() + "\"");
        sql = sql.replaceFirst("\\?", "\"" + imovel.getAcabamento() + "\"");
        sql = sql.replaceFirst("\\?", "\"" + imovel.getOutrosItens() + "\"");
        sql = sql.replaceFirst("\\?", "\"" + imovel.getDescricaoImovel() + "\"");
        sql = sql.replaceFirst("\\?", "\"" + imovel.getObservacoes() + "\"");
        sql = sql.replaceFirst("\\?", "\"" + imovel.getChaves() + "\"");
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getValorIptu()));
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getValorCondominio()));
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getMobilia().getIdMobilia()));
        sql = sql.replaceFirst("\\?", String.valueOf(imovel.getTipoImovel().getIdTipoImovel()));
                
        
        return database.update(sql);
        
    }

    @Override
    public boolean delete(Imovel object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Imovel> listAll() {
        List<Imovel> list = new ArrayList<Imovel>();
        
        String sql = "Select * from Imovel";
        
        ResultSet rs = database.query(sql);
        
        try{
            while(rs.next()){
                Imovel i = new Imovel();
                
                i.setQtdQuartos(rs.getInt("qtdQuartos"));
                i.setQtdSuites(rs.getInt("qtdSuites"));
                i.setQtdSalas(rs.getInt("qtdSalas"));
                i.setQtdBanheiros(rs.getInt("qtdBanheiros"));
                i.setQtdPisos(rs.getInt("qtdPisos"));
                i.setLavanderia(rs.getInt("lavanderia"));
                i.setVagasGaragem(rs.getInt("vagasGaragem"));
                i.setAreaServico(rs.getInt("areaServico"));
                i.setPiscina(rs.getInt("piscina"));
                i.setLavabos(rs.getInt("lavabos"));
                i.setDepEmpregados(rs.getInt("depEmpregados"));
                i.setAreaExterna(rs.getString("areaExterna"));
                i.setDataConstrucao(rs.getDate("dataConstucao"));
                i.setAcabamento(rs.getString("acabamento"));
                i.setOutrosItens(rs.getString("outrosItens"));
                i.setDescricaoImovel(rs.getString("descricaoImovel"));
                i.setObservacoes(rs.getString("observacoes"));
                i.setChaves(rs.getString("chaves"));
                i.setValorIptu(rs.getFloat("valorIptu"));
                
                /*
                i.setMobilia(rs.getInt("qtdQuartos"));
                i.setTipoImovel(rs.getInt("qtdQuartos"));
                */

                list.add(i);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }
    
    
    
}
