/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.TableModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.pessoa.Pessoa;
import model.pessoa.PessoaFisica;
import model.pessoa.PessoaJuridica;

/**
 *
 * @author jeanbrock
 */
public class PessoaJuridicaTableModel extends AbstractTableModel {

    private List<PessoaJuridica> dadosPessoas;

    private String[] colunas = {"ID", "Nome", "CNPJ", "Inscrição Estadual", "Cadastro Ativo", "Nome Responsável", "Email", "Data de Nascimento", "Telefone", "Endereço", "Número"};

    public PessoaJuridicaTableModel() {
        dadosPessoas = new ArrayList<PessoaJuridica>();
    }

    public PessoaJuridicaTableModel(List<PessoaJuridica> dadosPessoas) {
        this.dadosPessoas = dadosPessoas;
    }

    public void addRow(PessoaJuridica p) {
        this.dadosPessoas.add(p);
        this.fireTableDataChanged();
    }

    public String getColumnName(int num) {
        return this.colunas[num];
    }

    @Override
    public int getRowCount() {
        return dadosPessoas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return dadosPessoas.get(linha).getIdPessoa();
            case 1:
                return dadosPessoas.get(linha).getNomePessoa();
            case 2:
                return dadosPessoas.get(linha).getCnpj();
            case 3:
                return dadosPessoas.get(linha).getInscricaoEstadual();
            case 4:
                if(dadosPessoas.get(linha).isCadastroAtivo()){
                    return "Sim";
                }
                else{
                    return "Não";
                }
            case 5:
                return dadosPessoas.get(linha).getNomeResponsavel();
            case 6:
                return dadosPessoas.get(linha).getEmail();
            case 7:
                return dadosPessoas.get(linha).getDataNascimento();
            case 8:
                return dadosPessoas.get(linha).getTelefone().get(0).getNumero();
            case 9:
                return dadosPessoas.get(linha).getEndereco().getNomeEndereco();
            case 10:
                return dadosPessoas.get(linha).getEndereco().getNumero();
        }
        return null;
    }

    public void removeRow(int linha) {
        this.dadosPessoas.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

    public PessoaJuridica get(int linha) {
        return this.dadosPessoas.get(linha);
    }

    public boolean isCellEditable(int linha, int coluna) {
        return true;
    }

    public void setValueAt(Object valor, int linha, int coluna) {
        if (valor == null) {
            return;
        }
        switch (coluna) {
            case 1:
                dadosPessoas.get(linha).setNomePessoa((String) valor);
                break;
            case 2:
                dadosPessoas.get(linha).setEmail((String) valor);
                break;
            case 3:
                dadosPessoas.get(linha).setDataNascimento((Date) valor);
                break;
        }
        this.fireTableRowsUpdated(linha, linha);
    }
}

