/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validacao;

import dao.LoginDAO;
import java.util.ArrayList;
import java.util.List;
import model.pessoa.Login;

/**
 *
 * @author jeanbrock
 */
public class criaLogin {

    public String gerarNovaSenha() {
        String[] carct = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
            "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};

        String senha = "";

        for (int x = 0; x < 10; x++) {
            int j = (int) (Math.random() * carct.length);
            senha += carct[j];

        }
        return senha;
    }

    public String geraNovoUsuario(String nomeCompleto) {
        int aux = 1;
        int j = 0;
        String[] carct;
        String login = "";

        String sobrenome = nomeCompleto.split(" ")[nomeCompleto.split(" ").length - 1];
        String primeiroNome = nomeCompleto.split(" ")[0];
        login = (primeiroNome + "." + sobrenome);

        LoginDAO loginDAO = new LoginDAO();
        List<Login> logins = new ArrayList<Login>();
        logins = loginDAO.getAll();
        String novoLogin = login;
        String tempLogin = login;

        while (tempLogin.equalsIgnoreCase(logins.get(j).getNomeUsuario())) {
            for (int i = 0; i < logins.size(); i++) {
                if (tempLogin.equalsIgnoreCase(logins.get(i).getNomeUsuario())) {
                    novoLogin = (login + aux);
                    tempLogin = novoLogin;
                    j++;
                }
                novoLogin = login;
            }
            if (j >= logins.size()) {
                j = 0;
            }

        }
        return tempLogin.toLowerCase();
    }

}
