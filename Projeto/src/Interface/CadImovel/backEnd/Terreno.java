
package Interface.CadImovel.backEnd;

public class Terreno {
    
    private int idTerreno;
    private String metrosConstruidos;
    private String medidasTerreno;
    private String metrosQuadrados;
    private String situacaoEscritura;
    private Imovel imovel;
    
    public int getIdTerreno() {
        return idTerreno;
    }

    public void setIdTerreno(int idTerreno) {
        this.idTerreno = idTerreno;
    }

    public String getMetrosConstruidos() {
        return metrosConstruidos;
    }

    public void setMetrosConstruidos(String metrosConstruidos) {
        this.metrosConstruidos = metrosConstruidos;
    }

    public String getMedidasTerreno() {
        return medidasTerreno;
    }

    public void setMedidasTerreno(String medidasTerreno) {
        this.medidasTerreno = medidasTerreno;
    }

    public String getMetrosQuadrados() {
        return metrosQuadrados;
    }

    public void setMetrosQuadrados(String metrosQuadrados) {
        this.metrosQuadrados = metrosQuadrados;
    }

    public String getSituacaoEscritura() {
        return situacaoEscritura;
    }

    public void setSituacaoEscritura(String situacaoEscritura) {
        this.situacaoEscritura = situacaoEscritura;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }
    
    
    
}
