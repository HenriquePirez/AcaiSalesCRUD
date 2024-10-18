/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import viwer.DialogCadAcai;
import viwer.JDialogCadCliente;
import viwer.JDialogCadEntregador;
import viwer.JDialogCadVenda;
import viwer.JanelaPrincipal;
import viwer.jDialogTeste;

/**
 *
 * @author henri
 */
public class GerenciadorInterGrafica {
    private JanelaPrincipal janelaPrincipal = null;
    private JDialogCadCliente janelaCadCliente = null;
    private JDialogCadEntregador janelaCadEntregador = null;
    private DialogCadAcai janelaCadAcai = null;
    private JDialogCadVenda janelaCadVenda = null;
    private jDialogTeste janela = null;
    
    private static GerenciadorInterGrafica myInstance = new GerenciadorInterGrafica();
    private GerenciadorDominio gerDom;   
    
    private GerenciadorInterGrafica() {
        gerDom = new GerenciadorDominio();
    }
    
    public static GerenciadorInterGrafica getInstance() {
        return myInstance;       
    }
    
    public GerenciadorDominio getGerenciadorDominio() {
        return gerDom;       
    }
    
    private JDialog abrirJanela(java.awt.Frame parent, JDialog dlg, Class classe) {
        if (dlg == null){     
            try {
                dlg = (JDialog) classe.getConstructor(Frame.class, boolean.class).newInstance(parent,true);
            } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                JOptionPane.showMessageDialog(parent, "Erro ao abrir a janela " + classe.getName() + ". " + ex.getMessage() );
            } 
        }        
        dlg.setVisible(true); 
        return dlg;
    }
        
    
    public void abrirJanelaPrincipal() {
        if ( janelaPrincipal == null ) {
            janelaPrincipal = new JanelaPrincipal();
        }
        janelaPrincipal.setVisible(true);
    }
    
    public void abrirCadEntregador() {
        janelaCadEntregador = (JDialogCadEntregador) abrirJanela(janelaPrincipal, janelaCadEntregador, JDialogCadEntregador.class  );
    }
    
    public void abrirCadAcai() {
        janelaCadAcai = (DialogCadAcai) abrirJanela(janelaPrincipal, janelaCadAcai, DialogCadAcai.class  );
    }
    
    public void abrirCadVenda() {
        janelaCadVenda = (JDialogCadVenda) abrirJanela(janelaPrincipal, janelaCadVenda, JDialogCadVenda.class  );
    }
    
    public void abrirCadCliente(){
        janelaCadCliente = (JDialogCadCliente) abrirJanela(janelaPrincipal, janelaCadCliente, JDialogCadCliente.class  );
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        GerenciadorInterGrafica gerIG = new GerenciadorInterGrafica();
        gerIG.abrirJanelaPrincipal();
    }
}
