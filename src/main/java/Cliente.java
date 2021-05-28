/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.HeadlessException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;
/**
 *
 * @author legion
 */
public class Cliente {
    public static void main(String[] args){
       
        String Ip = new String();
        JOptionPane.showMessageDialog(null,"****Arrancando el servidor****\n");
        Ip =  JOptionPane.showInputDialog("Igrese lA DIRECCION IP DE SU SERVIDOR\n");
        
   
        try{
            
            Registry miRegistro = LocateRegistry.getRegistry(Ip, 1099);

            Claculadora c = (Claculadora) Naming.lookup("//"+Ip+"/Claculadora");
            boolean Seguir = true;
            while (Seguir){
               String menu = JOptionPane.showInputDialog("Calculadora de Prueba RMI\n"
                       + "Suma...[1]\n"
                       + "Resta..[2]\n"
                       + "Multiplicacion...[3]\n"
                       + "Division...[4]\n"
                       + "Cancelar para salir");
               switch(menu){
                   case "1":{
                       try
                       {
                           int x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer numero"));
                        int y = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero"));
                                JOptionPane.showMessageDialog(null,"La suma es: " +c.sum(x, y));    
                       
                       }
                       catch(NumberFormatException e)
                       {
                           JOptionPane.showMessageDialog(null,"Los DATOS no estan correctos"+ e.getMessage());
                       }
                       
                             break;
                                
                   }
                   case "2":{
                       try
                       {
                           int x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer numero"));
                         int y = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero"));
                                JOptionPane.showMessageDialog(null,"La resta es: " +c.res(x, y));   
                           
                       }
                       catch(NumberFormatException e)
                       {
                           JOptionPane.showMessageDialog(null, "lOS datos ingresados no son correctos: "+e.getMessage());
                       }
                         
                                break;
                   }
                   case "3":{
                       try
                       {
                            int x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer numero"));
                            int y = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero"));
                                JOptionPane.showMessageDialog(null,"La Multiplicacion es: " +c.mul(x, y));
                       }
                       catch(NumberFormatException e)
                       {
                           JOptionPane.showMessageDialog(null, "lOS datos ingresados no son correctos: "+e.getMessage());
                       }
                         
                                break;
                   }
                   case "4":{

                        try{
                             int x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer numero"));
                            int y = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero"));
                           int resul =  c.div(x, y);
                           if (resul ==0) 
                           {

                             JOptionPane.showMessageDialog(null,"No se pudo realizar la Division");
                           }
                           else
                           {
                              JOptionPane.showMessageDialog(null,"La Division es: " +resul);
                            }

                           
                         }catch (NumberFormatException e) {
                          JOptionPane.showMessageDialog(null,"Ocurrio un erro al procesar la operacion:\n"+e.getMessage());
                          
                        }
                         
                                
                        break;
                   
               }

                   case "cancelar":{
                      
                       JOptionPane.showMessageDialog(null,"CERRANDO LA CALCULADORA...\n"); 
                       
                       Seguir = false;
                       
                   }
            }
            }
            
        }catch(HeadlessException | MalformedURLException | NotBoundException | RemoteException e){
            JOptionPane.showMessageDialog(null, "servidor no conectado");
        }
    }
}