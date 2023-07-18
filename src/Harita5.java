
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ONUR
 */
public class Harita5 extends javax.swing.JFrame {

    int [][] gidilenplaka = new int [5][81];
    int toplamil[];
    int genel=4;
    int [][]tümpixel;
    ImageIcon resim = new ImageIcon("C:\\Users\\ONUR\\Desktop\\türkiyeSiyasiHaritasi.png");
    public Harita5() {
        initComponents();
    }
    public Harita5(int []toplamil5,int[][] tümpixel5,int [][] gidilenplaka5) {
        initComponents();
        toplamil=toplamil5;
        tümpixel=tümpixel5;
        gidilenplaka=gidilenplaka5;
    }
    
    
    @Override
    public void paint(Graphics g) { 
                int [] bul = new int[toplamil[genel]];
        int [] tut = new int[toplamil[genel]];
        for(int j=0;j<toplamil[genel];j++){
            for(int a=0;a<81;a++){
                if(a==gidilenplaka[genel][j]){
                    bul[j]=a;
                }
            }
        }
        for(int i=0;i<toplamil[genel]-1;i++){
            for(int j = i+1;j<toplamil[genel];j++){
                if(bul[i]==bul[j]){
                    tut[j] = 1;
                }
            }
        }
        g.drawImage(resim.getImage(),-90,0,2470,1262,null);
            for(int j=0;j<toplamil[genel]-1;j++){
                for(int a=0;a<81;a++){
                    if(a==gidilenplaka[genel][j]){     
                        if(tut[j]==1){
                        Graphics2D g2 = (Graphics2D)g;
                        g2.setPaint(Color.red);                        
                        g2.drawString((j+1)+"", tümpixel[a][0]-85,tümpixel[a][1]-30);
                        g2.setStroke(new BasicStroke(10));
                        Line2D l=new Line2D.Double(tümpixel[a][0]-85,tümpixel[a][1]+5,tümpixel[gidilenplaka[genel][j+1]][0]-85,tümpixel[gidilenplaka[genel][j+1]][1]+5);
                        g2.draw(l);    
                        }
                        else{
                        Graphics2D g2 = (Graphics2D)g;
                        g2.setPaint(Color.red);                        
                        g2.drawString((j+1)+"", tümpixel[a][0]-85,tümpixel[a][1]-10);
                        g2.setStroke(new BasicStroke(10));
                        Line2D l=new Line2D.Double(tümpixel[a][0]-85,tümpixel[a][1]+5,tümpixel[gidilenplaka[genel][j+1]][0]-85,tümpixel[gidilenplaka[genel][j+1]][1]+5);
                        g2.draw(l);
                        }
                        }                    
                    }
                }
                }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(2470, 1262));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Harita5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Harita5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Harita5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Harita5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Harita5().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
