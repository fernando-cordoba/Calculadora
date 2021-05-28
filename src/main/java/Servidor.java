/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.HeadlessException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;
/**
 *
 * @author legion
 */
public class Servidor {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            Registry r = java.rmi.registry.LocateRegistry.createRegistry(1099);
                r.rebind("Claculadora", new RMI());
                JOptionPane.showMessageDialog(null, "servidor conectado");
        }catch(HeadlessException | RemoteException e){
            JOptionPane.showMessageDialog(null, "servidor no concectado"+ e);
        }
                
                
    }
    
}