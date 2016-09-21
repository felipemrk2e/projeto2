/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Pessoa;

import java.util.ArrayList;

/**
 *
 * @author Sala
 */
public class Estado {
    private int idEstado;
    private String nomeEstado;
    private String ufEstado;
    private Pais pais;
    private ArrayList<Cidade> cidade = new ArrayList<Cidade>();
}
