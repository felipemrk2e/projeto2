/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.pessoa.Departamento;

/**
 *
 * @author jeanbrock
 */
public class DepartamentoTableModel extends AbstractTableModel {

    private List<Departamento> dadosDepartamento;

    private String[] colunas = {"ID", "Nome do Departamento", "Telefone", "Ramal"};

    public DepartamentoTableModel() {
        dadosDepartamento = new ArrayList<Departamento>();
    }

    public DepartamentoTableModel(List<Departamento> dadosDepartamento) {
        this.dadosDepartamento = dadosDepartamento;
    }

    public void addRow(Departamento d) {
        this.dadosDepartamento.add(d);
        this.fireTableDataChanged();
    }

    public String getColumnName(int num) {
        return this.colunas[num];
    }

    @Override
    public int getRowCount() {
        return dadosDepartamento.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return dadosDepartamento.get(linha).getIdDepartamento();
            case 1:
                return dadosDepartamento.get(linha).getNomeDepartamento();
            case 2:
                return dadosDepartamento.get(linha).getTelefoneDepartamento();
            case 3:
                return dadosDepartamento.get(linha).getRamal();
        }
        return null;
    }

    public void removeRow(int linha) {
        this.dadosDepartamento.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

    public Departamento get(int linha) {
        return this.dadosDepartamento.get(linha);
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
                dadosDepartamento.get(linha).setNomeDepartamento((String) valor);
                break;
            case 2:
                dadosDepartamento.get(linha).setTelefoneDepartamento((String) valor);
                break;
            case 3:
                dadosDepartamento.get(linha).setRamal((String) valor);
                break;
        }
        this.fireTableRowsUpdated(linha, linha);
    }
}

