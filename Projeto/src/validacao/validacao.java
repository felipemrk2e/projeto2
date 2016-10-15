/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validacao;

import Interface.CadImovel.cadastroImovel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author user
 */
public class validacao {
    

    
    
    
    
    
    

    public static boolean validaNumeros(String numero) {

        try {

            double teste = Double.valueOf(numero);

        } catch (NumberFormatException e) {
            return false;
        }
        
        return true;

    }

    public static boolean validaLetras(String Nome) {
       String regex = "^([a-zA-ZáéíóúàâêôãõüçÁÉÍÓÚÀÂÊÔÃÕÜÇ ]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Nome);
        if (matcher.find() && matcher.group().equals(Nome)) {
            return true;
        } else {
           return false;
        }
    }
    
    public static void Verificar(String [] textField) {
        
        
    }
   
        
    
    
}
