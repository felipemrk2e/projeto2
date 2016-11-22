/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.TableModel;

import imovel.model.Imovel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author a1502891
 */
public class ImovelTableModel2 extends AbstractTableModel {

    private List<Imovel> dadosImovel;
    private String[] colunas = {"ID", "Tipo do Imovel", "Descrição do imovel", "Valor Aluguel", "Qtd Quartos", "Vagas Garagem", "Piscina", "Status", "Bairro", "Cidade", "UF", "ativo"};

    public ImovelTableModel2() {
        dadosImovel = new ArrayList<Imovel>();

    }

    public ImovelTableModel2(List<Imovel> imovelList) {
        dadosImovel = imovelList;

    }

    public void addRow(Imovel p) {
        this.dadosImovel.add(p);
        this.fireTableDataChanged();
    }

    public boolean isCellEditable(int linha, int coluna) {
        return true;
    }

    public String getColumnName(int num) {
        return this.colunas[num];
    }

    @Override
    public int getRowCount() {
        return dadosImovel.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    public void removeRow(int linha) {
        this.dadosImovel.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

    public Imovel get(int linha) {
        return this.dadosImovel.get(linha);
    }

    @Override
    public Object getValueAt(int linha, int colunas) {

        switch (colunas) {
            case 0:
                return dadosImovel.get(linha).getIdImovel();
            case 1:
                return dadosImovel.get(linha).getTipoImovel().getTipo();

            case 2:
                return dadosImovel.get(linha).getDescImovel();
            case 3:

                if (dadosImovel.get(linha).getTiposContratos() != null) {

                    for (int i = 0; i < dadosImovel.get(linha).getTiposContratos().size(); i++) {
                        if (dadosImovel.get(linha).getTiposContratos().get(i).getTipoContrato().getIdTipoContrato() == 1) {
                            return dadosImovel.get(linha).getTiposContratos().get(0).getValor();
                        }
                        return "Não Cadastrado";

                    }
                }

            case 4:
                return dadosImovel.get(linha).getQtdQuartos();
            case 5:
                return dadosImovel.get(linha).getVagasGaragem();

            case 6:
                if (dadosImovel.get(linha).getPiscina() >= 1) {
                    return "Sim";
                }
                return "Não";

            case 7:
                return dadosImovel.get(linha).getStatus().getStatus();
            case 8:
                return dadosImovel.get(linha).getEndereco().getBairro();
            case 9:
                return dadosImovel.get(linha).getEndereco().getCidade().getNomeCidade();
            case 10:
                return dadosImovel.get(linha).getEndereco().getCidade().getEstado().getSigla();
            case 11:
                if (dadosImovel.get(linha).getAtivo()) {
                    return "Sim";
                } else {
                    return "Não";
                }

        }
        return null;
    }
}
