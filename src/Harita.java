
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ONUR
 */
public class Harita extends javax.swing.JFrame implements ActionListener{
    
    int [][] gidilenplaka = new int [5][81];
    int toplamil[];
    int tümpixel[][] = {{1221,877},{1600,740},{610,584},{2180,378},{1274,284},{890,387},{615,884},{2001,160},{256,712},{282,421},{549,356},{1870,545},{2084,608},{753,267},{569,747},{436,344},{107,328},{1000,295},{1164,302},{417,735},{1846,703},{146,81},{1706,587},{1730,412},{1954,368},{615,418},{1487,858},{1593,234},{1723,297},{2309,717},{1332,1004},{603,741},{1133,906},{432,205},{171,606},{2171,235},{1019,170},{1232,594},{224,76},{1067,529},{547,251},{856,738},{542,472},{1598,648},{210,583},{1427,772},{1926,796},{315,817},{1999,559},{1136,616},{1136,719},{1525,227},{1842,199},{604,253},{1330,180},{2069,684},{1182,63},{1423,423},{249,201},{1365,336},{1740,209},{1746,513},{1666,840},{462,587},{2242,571},{1145,423},{783,156},{1051,653},{1817,320},{951,851},{990,420},{1966,700},{2142,742},{845,124},{2112,160},{2297,332},{462,274},{883,197},{1456,915},{1342,868},{697,253}};
    int genel=0;
    ImageIcon resim = new ImageIcon("C:\\Users\\ONUR\\Desktop\\türkiyeSiyasiHaritasi.png");
    
    static JButton[] btn = new JButton[150];
    
    
    public Harita() {
        initComponents();
    }
    public Harita(int [][] sontut,int [] öyle){
        initComponents();
        gidilenplaka=sontut;
        toplamil=öyle;
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

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(3000, 1500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Bir sonraki yol için tıkla");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 0, 170, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Harita2 yeni = new Harita2(toplamil,tümpixel,gidilenplaka);
        yeni.setVisible(true);
        /* int sayac=0;
        int [] bul = new int[toplamil[genel]];
        int [] tut = new int[toplamil[genel]];
        if(genel>=4){
            jButton1.setVisible(false);
        }
        if(genel>=1){
            for(int k=0;k<toplamil[genel-1];k++){
                btn[k].setVisible(false);
            }
        }
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
            for(int j=0;j<toplamil[genel];j++){
                for(int a=0;a<81;a++){
                    if(a==gidilenplaka[genel][j]){
                        if(tut[j]==1){
                        btn[sayac]= new JButton((j+1)+"");
                        btn[sayac].setBounds(tümpixel[a][0]-110, tümpixel[a][1]-80,50, 50);
                        getContentPane().add(btn[sayac]);
                        getContentPane().repaint();
                        btn[sayac].setBackground(Color.red);
                        sayac++;
                        }
                        else{
                            btn[sayac]= new JButton((j+1)+"");
                            btn[sayac].setBounds(tümpixel[a][0]-110, tümpixel[a][1]-30,50, 50);
                            getContentPane().add(btn[sayac]);
                            getContentPane().repaint();
                            btn[sayac].setBackground(Color.red);
                            sayac++;
                        }
                    }
                }
            }
       genel++;*/
       
    }//GEN-LAST:event_jButton1ActionPerformed
   
     
   
    
    /* public void paint(Graphics graphics){
        graphics.drawImage(resim.getImage(),-90,0,2470,1262,null);
    }*/
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
            java.util.logging.Logger.getLogger(Harita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Harita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Harita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Harita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Harita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
    
    
    /* public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D)g;

        g2.setPaint(Color.red);

        Line2D l=new Line2D.Double(100,100,500,500);

        g2.draw(l);
        for(int i =0;i<5;i++){
            for(int j=0;j<toplamil[i];j++){
                for(int a=0;a<81;a++){
                    if(a==gidilenplaka[i][j]){
                        Graphics2D g2 = (Graphics2D)g;
                        if(i==0)
                        g2.setPaint(Color.MAGENTA);
                        else if(i==1)
                        g2.setPaint(Color.BLACK);
                        else if(i==2)
                        g2.setPaint(Color.CYAN);
                        else if(i==3)
                        g2.setPaint(Color.blue);
                        else if(i==4)
                        g2.setPaint(Color.red);
                        Line2D l=new Line2D.Double(tümpixel[a][0]+20,tümpixel[a][1]+20,tümpixel[gidilenplaka[i][j+1]][0]+20,tümpixel[gidilenplaka[i][j+1]][1]+20);
                        g2.draw(l);
                    }
                }
            }

    }
    }*/
    

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
