/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package global.model;

/**
 *
 * @author a1502735
 */
import java.security.*;
import java.math.*;

public class MD5 {

    public String gerarMD5(String senha) throws Exception {
        {
            MessageDigest m;

            try {
                m = MessageDigest.getInstance("MD5");
                m.update(senha.getBytes(), 0, senha.length());
                BigInteger i = new BigInteger(1, m.digest());
                senha = String.format("%1$032X", i);
                
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return senha;
    }
}
