/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Pessoa;

/**
 *
 * @author Sala
 */
public class PessoaFisica extends Pessoa {
    private int idPessoaFisica;
    private String CPF;
    private String RG;
    private char sexo;
    private int idade;
    private EstadoCivil estadoCivil;
    private String cargo;
    private PessoaFisica fiador;
}
