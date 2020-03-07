/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personaje;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

/**
 *
 * @author david
 */
public class frmpersonaje extends javax.swing.JFrame implements KeyListener {

    /**
     * Creates new form frmpersonaje
     */
    public frmpersonaje() {
        initComponents();
        addKeyListener(this);
        this.getContentPane().setBackground(Color.white);
    }
    int filas;
    int columnas;
    int movizquierda=-1;
    int movderecha=1;
    int mov;
    int posx=140;
    int sentido;
    int contadorclick;
    int m1m2;
    int salto;
    int elevacion;
    public static int r=new Color(255,0,0).getRGB(); /** rojo*/
    public static int n=new Color(0,0,0).getRGB();   /**negro*/
    public static int o=new Color(243,211,243).getRGB(); /**rosado*/
    public static int b=new Color(255,255,255).getRGB(); /**blanco*/
    /**
     * Creates new form FrmMario
     */
    Timer temporizador = new Timer(300, new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            repaint();
            
        }

            
    });
        public void paint(Graphics g)
    {
        int mario[][]={{b,b,b,n,n,n,n,n,n,b,b,b},
                       {b,b,n,r,r,r,r,r,r,n,n,b},
                       {b,n,r,r,r,r,r,r,r,r,r,n},
                       {b,n,n,n,o,o,n,o,n,n,n,b},
                       {n,o,o,n,n,o,n,o,o,o,o,n},
                       {n,o,o,n,n,o,o,n,o,o,o,n},
                       {b,n,n,o,o,o,n,n,n,n,n,b},
                       {b,b,n,n,o,o,o,o,o,n,b,b},
                       {b,n,r,r,n,n,r,r,n,b,b,b},
                       {n,r,r,r,r,n,n,r,r,n,b,b},
                       {n,r,r,r,r,n,n,n,n,n,b,b},
                       {b,n,o,o,o,n,n,o,n,n,b,b},
                       {b,n,o,o,r,r,r,n,n,n,b,b},
                       {b,b,n,r,r,r,r,r,n,b,b,b},
                       {b,b,n,n,n,n,n,n,n,b,b,b},
                       

            
        };
    int blanquear[][]={{b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b},
                       {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b},
                       {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b},
                       {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b},
                       {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b},
                       {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b},
                       {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b},
                       {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b},
                       {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b},
                       {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b},
                       {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b},
                       {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b},
                       {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b},
                       {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b},
                       {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b},
                       {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b},                       
                       {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b},
            
        };
       int mariocamina[][]={{b,b,b,b,b,n,n,n,n,n,n,b,b,b,b,b},
                            {b,b,b,b,n,r,r,r,r,r,r,n,n,b,b,b},
                            {b,b,b,n,r,r,r,r,r,r,r,r,r,n,b,b},
                            {b,b,b,n,n,n,o,o,n,o,n,n,n,b,b,b},
                            {b,b,n,o,o,n,n,o,n,o,o,o,o,n,b,b},
                            {b,b,n,o,o,n,n,o,o,n,o,o,o,n,b,b},
                            {b,b,b,n,n,o,o,o,n,n,n,n,n,b,b,b},
                            {b,b,b,n,n,n,o,o,o,o,o,n,b,b,b,b},
                            {b,n,n,r,r,r,n,n,r,r,n,n,n,b,b,b},
                            {n,o,o,r,r,r,r,n,n,r,r,n,r,n,b,b},
                            {n,o,o,o,r,r,n,n,n,n,n,n,r,o,n,b},
                            {b,n,o,o,n,n,n,n,n,b,n,b,n,o,n,b},
                            {b,b,n,n,n,n,n,n,n,n,n,r,r,n,b,b},
                            {b,n,r,r,n,n,n,n,n,n,r,r,r,n,b,b},
                            {b,n,r,r,r,n,b,b,n,r,r,r,n,b,b,b},
                            {b,b,n,n,n,b,b,b,b,n,n,n,b,b,b,b},
                            
            
        };
        int mariosalta[][]={{b,b,b,b,b,n,n,n,n,n,n,b,b,n,n,n,b},
                            {b,b,b,b,n,r,r,r,r,r,r,n,n,o,o,o,n},
                            {b,b,b,n,r,r,r,r,r,r,r,r,r,n,o,o,n},
                            {b,b,b,n,n,n,o,o,n,o,n,n,n,n,r,n,b},
                            {b,b,n,o,o,n,n,o,n,o,o,o,o,o,r,n,b},
                            {b,b,n,o,o,n,n,o,o,n,o,o,o,o,r,n,b},
                            {b,b,b,n,n,o,o,o,n,n,n,n,n,n,n,b,b},
                            {b,b,b,b,n,n,o,o,o,o,o,o,o,r,n,b,b},
                            {b,b,n,r,r,r,n,r,r,r,n,r,r,n,b,b,b},
                            {b,n,n,n,r,r,r,n,r,r,r,n,n,n,n,n,b},
                            {n,o,o,o,n,r,r,n,o,n,n,o,n,n,r,r,n},
                            {n,o,o,o,n,r,n,n,n,n,n,n,n,r,r,r,n},
                            {b,n,r,n,n,n,n,n,n,n,n,n,n,r,r,n,b},
                            {n,r,r,r,n,n,n,n,n,n,n,n,n,r,r,n,b},
                            {n,r,r,n,n,n,n,n,n,b,b,b,b,n,n,b,b},
                            {b,n,n,b,n,n,n,b,b,b,b,b,b,b,b,b,b},
            
                            
                            
            
        };
        super.paint(g);
        m1m2=contadorclick%2;
        if(m1m2==0)
        {
            for(filas=0;filas<15*5;filas++)
            {
                for(columnas=0;columnas<12*5;columnas++)
                {
                    g.setColor(new Color(mario[filas/5][columnas/5]));
                    mov=posx-(columnas*sentido);
                    g.drawRect(mov,200+filas,1,1);

                }
            }  
        }
        else
        {
            for(filas=0;filas<16*5;filas++)
            {
                for(columnas=0;columnas<16*5;columnas++)
                {
                    g.setColor(new Color(mariocamina[filas/5][columnas/5]));
                    mov=posx-(columnas*sentido);
                    g.drawRect(mov,200+filas,1,1);

                }
            }           
            
        }
          if(salto==1)
          {
//            for(filas=0;filas<15*5;filas++)
//            {
//                for(columnas=0;columnas<12*5;columnas++)
//                {
//                    g.setColor(new Color(mario[filas/5][columnas/5]));
//                    mov=posx-(columnas*sentido);
//                    g.drawRect(mov,200+filas,1,1);
//
//                }
//            } 
            for(filas=0;filas<17*5;filas++)
            {
                for(columnas=0;columnas<16*5;columnas++)
                {
                    g.setColor(new Color(blanquear[filas/5][columnas/5]));
                    mov=posx-(columnas*sentido);
                    g.drawRect(mov,200+filas,1,1);

                }
            } 
            for(filas=0;filas<16*5;filas++)
            {
                for(columnas=0;columnas<17*5;columnas++)
                {
                    g.setColor(new Color(mariosalta[filas/5][columnas/5]));
                    mov=posx-(columnas*sentido);
                    g.drawRect(mov,100+filas,1,1);

                }
            } 

            salto=0;
                
          }
              

       
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(frmpersonaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmpersonaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmpersonaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmpersonaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmpersonaje().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        temporizador.start();
        if(e.getKeyCode()==39)
        {
            contadorclick++;
            posx=posx+5;
            sentido=-1;
            
        }
        if(e.getKeyCode()==37)
        {
            contadorclick++;    
            posx=posx-5;
            sentido=1;
            
            
        }
        if(e.getKeyCode()==38)
        {
            
            salto=1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
