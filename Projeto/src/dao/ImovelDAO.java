package dao;

import imovel.model.Imovel;
import java.util.List;

public class ImovelDAO extends DAO<Imovel>{

	@Override
	public Imovel getById(Long id) {
		Imovel imovel = null;
		try{
			imovel = entityManager.find(Imovel.class, id);
		}catch(Exception e){
			System.out.println("Erro na consulta do Imovel: "+e);
		}
		return imovel;
	}

	@Override
	public boolean removeById(Long id) {
		Imovel imovel = null;
                try{
                    imovel = this.getById(id);
                    entityManager.getTransaction().begin();
                    entityManager.remove(imovel);
                    entityManager.getTransaction().commit();
                    return true;
                }catch(Exception e){
                    entityManager.getTransaction().rollback();
                    System.out.println("Erro na exclusão do Imovel: "+e);
                }
		return false;
	}

    @Override
    public List<Imovel> getAll() {
        return entityManager.createQuery("FROM Imovel").getResultList();
    }
    
    /**
        * Retorna uma lista de Imoveis de acordo com a pesquisa.
        * @param  idsTiposImovel Lista contendo os ids da tabela TipoImovel
        * @param rua rua da tabela Endereco relacionado ao Imovel
        * @param bairro bairro da tabela Endereco relacionado ao Imovel
        * @param idCidade id da Cidade da tabela Endereco relacionado ao Imovel
        * @param qtdQuartos quantidade de quartos do Imovel
        * @param garagem quantidade de vagas da garagem em Imovel
        * @return      lista de Imoveis ativos com base nas condições de pesquisa
        */
    public List<Imovel> searchImovel(List<Long> idsTiposImovel, String rua, String bairro, long idCidade, int qtdQuartos, int garagem){
        String query = "";
        String or = "";
        if(idsTiposImovel.size() > 0){
            for (int i = 0; i < idsTiposImovel.size(); i++) {
                if(i==1){
                    or = " or ";
                }
                query += or+"im.tipoImovel.idTipoImovel = "+idsTiposImovel.get(i);
            }
            or = " or ";
        }
        if(rua != ""){
            query += or+"im.endereco.nomeEndereco LIKE '%"+rua+"%'";
            or = " or ";
        }
        if(bairro != ""){
            query += or+"im.endereco.bairro LIKE '%"+bairro+"%'";
            or = " or ";
        }
        if(idCidade > 0){
            query += or+"im.endereco.cidade.idCidade = "+idCidade;
            or = " or ";
        }
        if(qtdQuartos > 0){
            query += or+"im.qtdQuartos >= "+qtdQuartos;
            or = " or ";
        }
        if(garagem > 0){
            query += or+"im.vagasGaragem >= "+garagem;
            or = " or ";
        }
        return entityManager.createQuery("FROM Imovel im WHERE "+query+" and im.ativo = 1").getResultList();
    }
    
    /**
        * Retorna apenas Imoveis que estejam ativos.
        * @return      lista de Imoveis ativos
    */
    public List<Imovel> getAtivos(){
        return entityManager.createQuery("FROM Imovel im WHERE im.ativo = 1").getResultList();
    }
    
    /**
        * Retorna apenas Imoveis que estejam inativos.
        * @return      lista de Imoveis inativos
    */
    public List<Imovel> getInativos(){
        return entityManager.createQuery("FROM Imovel im WHERE im.ativo = 0").getResultList();
    }

}
