/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Pessoa;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Sala
 */
public class Pessoa {
    
    private int idPessoa;
    private String nomePessoa;
    private String endereco;
    private int numero;
    private String complemento;
    private String CEP;
    private Bairro bairro;
    private Cidade cidade;
    private Estado estado;
    private Pais pais;
    private ArrayList<Telefone> telefone = new ArrayList<Telefone>();
    private String email;
    private String observacoes;
    private Date dataNascimento;
    
    
    
}
