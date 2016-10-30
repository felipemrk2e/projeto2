/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.TelaPrincipal;

import model.pessoa.Login;

/**
 *
 * @author Rafael Brock
 */
public class Sessao{
   private static Sessao instance = null;
   private Login usuario;
   private Sessao(){
   }
   public void setUsuario(Login usuario){
      this.usuario = usuario;
   }
   public Login getUsuario(){
       return usuario;
   }
   public static Sessao getInstance(){
         if(instance == null){
               instance = new Sessao();
         }
        return instance;
   }
}
