/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.pessoa.Cargo;
import model.pessoa.Departamento;

/**
 *
 * @author jeanbrock
 */
public class CargoTableModel extends AbstractTableModel {

    private List<Cargo> dadosCargos;

    private String[] colunas = {"ID", "Nome do Cargo", "Descrição", "Departamento"};

    public CargoTableModel() {
        dadosCargos = new ArrayList<Cargo>();
    }

    public CargoTableModel(List<Cargo> dadosCargos) {
        this.dadosCargos = dadosCargos;
    }

    public void addRow(Cargo c) {
        this.dadosCargos.add(c);
        this.fireTableDataChanged();
    }

    public String getColumnName(int num) {
        return this.colunas[num];
    }

    @Override
    public int getRowCount() {
        return dadosCargos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return dadosCargos.get(linha).getIdCargo();
            case 1:
                return dadosCargos.get(linha).getNomeCargo();
            case 2:
                return dadosCargos.get(linha).getDescricaoCargo();
            case 3:
                return dadosCargos.get(linha).getDepartamento().getNomeDepartamento();            
        }
        return null;
    }

    public void removeRow(int linha) {
        this.dadosCargos.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

    public Cargo get(int linha) {
        return this.dadosCargos.get(linha);
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
                dadosCargos.get(linha).setNomeCargo((String) valor);
                break;
            case 2:
                dadosCargos.get(linha).setDescricaoCargo((String) valor);
                break;
            case 3:
                dadosCargos.get(linha).setDepartamento((Departamento) valor);
                break;
        }
        this.fireTableRowsUpdated(linha, linha);
    }
}

