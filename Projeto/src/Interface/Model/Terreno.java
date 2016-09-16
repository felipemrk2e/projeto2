
package Interface.Model;

public class Terreno {
    
    private int idTerreno;
    private Double comprimento;
    private Double largura;
    private String situacaoEscritura;
    
    private Imovel imovel;
    
    public int getIdTerreno() {
        return idTerreno;
    }

    public void setIdTerreno(int idTerreno) {
        this.idTerreno = idTerreno;
    }

    public Double getComprimento() {
        return comprimento;
    }

    public void setComprimento(Double comprimento) {
        this.comprimento = comprimento;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }
    
    public double metrosQuadrados(){
        double metrosQuadrados = largura * comprimento;
        return metrosQuadrados;
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
