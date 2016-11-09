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
import model.pessoa.Funcionario;
import model.pessoa.Pessoa;
import model.pessoa.PessoaFisica;

/**
 *
 * @author jeanbrock
 */
public class FuncionarioTableModel extends AbstractTableModel {

    private List<Funcionario> dadosPessoas;

    private String[] colunas = {"ID", "Nome", "CPF", "RG", "Sexo", "Estado Civil", "Email", "Data de Nascimento", "Telefone", "Endereço", "Número", "Data Admissão", "Salário", "Cargo", "Banco", "Conta", "Agência"};

    public FuncionarioTableModel() {
        dadosPessoas = new ArrayList<Funcionario>();
    }

    public FuncionarioTableModel(List<Funcionario> dadosPessoas) {
        this.dadosPessoas = dadosPessoas;
    }

    public void addRow(Funcionario p) {
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
                return dadosPessoas.get(linha).getCPF();
            case 3:
                return dadosPessoas.get(linha).getRG();
            case 4:
                return dadosPessoas.get(linha).getSexo();
            case 5:
                return dadosPessoas.get(linha).getEstadoCivil().getNomeEstadoCivil();
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
            case 11:
                return dadosPessoas.get(linha).getDataAdmissao();
            case 12:
                return dadosPessoas.get(linha).getSalario();
            case 13:
                return dadosPessoas.get(linha).getCargo().getNomeCargo();
            case 14:
                return dadosPessoas.get(linha).getBanco();
            case 15:
                return dadosPessoas.get(linha).getConta();
            case 16:
                return dadosPessoas.get(linha).getAgencia();
        }
        return null;
    }

    public void removeRow(int linha) {
        this.dadosPessoas.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

    public Funcionario get(int linha) {
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
