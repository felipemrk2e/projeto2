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
public class Cidade {
  private int idCidade;
  private String nomeCidade;
  private Estado estado;
  private ArrayList<Bairro> bairro = new ArrayList<Bairro>();
}
