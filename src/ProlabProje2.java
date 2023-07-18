import java.awt.RenderingHints;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ProlabProje2 {
    
    
    
        
     public static int sehirGirme(String[] sehirlerİsim) {
        Scanner key = new Scanner(System.in);
        System.out.println("Lutfen sehri giriniz:");
        String sehir = key.nextLine();
        
        int plaka = plakaBulma(sehirlerİsim, sehir);
        return plaka;   
    }
    
    
    public static int plakaBulma(String[] sehirlerİsim,String sehir){//İsimleri girilen sehirlerimizin plaka numaralarini girdik!!!
        int i=0;
        
        while(i<81){
            if(sehirlerİsim[i].equals(sehir)){
                return (i);
            }
            i++;
        }
        return 0;    
    }

    public static void main(String[] args) {
        
        String str = "";
        String[] dizi = new String[81];
        String[][] dizi2 = new String[81][81];
        int[][] uzakliklar = new int[82][82];
        
    
        try {
            FileInputStream fStream = new FileInputStream("u2.txt");
            DataInputStream dStream = new DataInputStream(fStream);
            BufferedReader bReader = new BufferedReader(new InputStreamReader(dStream));
            
            int i = 0;
            while((str = bReader.readLine()) != null){
                 
                
                 dizi[i] = str;
                 i++;
                
            } 
            dStream.close();
        } catch (Exception e) {
            
            System.out.println("Hata : "+e.getMessage());
        }
        
        int a = 0;
        for(int j = 0;j<81;j++){//olusturdugumuz dizi2 ye verilerimiz tek tek ayirip koyduk...
           
                dizi2[j] = dizi[a].split(" ");//bosluk gordugunde bir diger indexe attı.
            
            a++;    
        }
        //System.out.println(dizi2[80][80]);
        
        /*for(int i = 0;i<81;i++){
            System.out.println(i+":"+uzakliklar[i].length);
        }*/
        
        for(int e=0;e<81;e++){//String dizimizle aldigimiz degerleri integer veri tipine döüstrümüs olduk bundan sonra uzakliklar dizimizi kullanacagiz.
            for(int t=0;t<80;t++){
                
                uzakliklar[e][t] = Integer.parseInt(dizi2[e][t]);
            }
        }
        
        
        String[] sehirlerİsim = new String[81];
        try {//Sehirlerin isimlerine ait bir dizi ayarladik ve sehir isimlerini diziye attık.
            FileInputStream fStream = new FileInputStream("sehirler.txt");
            DataInputStream dStream = new DataInputStream(fStream);
            BufferedReader bReader = new BufferedReader(new InputStreamReader(dStream));
            
            int i = 0;
            while((str = bReader.readLine()) != null){
                 
                
                 sehirlerİsim[i] = str;
                 i++;
                
            }
            
            dStream.close();
        } catch (Exception e) {
            
            System.out.println("Hata : "+e.getMessage());
            
        }
        
        
        int plaka1;
        String c;
        
        //denemelik açtım burada sehir dizisini
        System.out.println("Kac sehir girilecek:");
        Scanner scan = new Scanner(System.in);
        int sehirsayısı= scan.nextInt();
        scan.nextLine();
        int [] sehirler = new int[sehirsayısı+1];
        System.out.println("Sehirlerin plakaları neler:");
        sehirler[0]=41-1;
        if(sehirsayısı==1){
            
            c = scan.nextLine();
            plaka1 = plakaBulma(sehirlerİsim, c);
            sehirler[1] = plaka1;
            
        }
        else if(sehirsayısı==2){
            for(int q=1;q<3;q++){
                c = scan.nextLine();
                plaka1 = plakaBulma(sehirlerİsim, c);
                sehirler[q]=plaka1;
            }
        }
        else if(sehirsayısı==3){
            for(int q=1;q<4;q++){
                c = scan.nextLine();
                plaka1 = plakaBulma(sehirlerİsim, c);
                sehirler[q]=plaka1;
            }
        }
        else if(sehirsayısı==4){
            for(int q=1;q<5;q++){
                c = scan.nextLine();
                plaka1 = plakaBulma(sehirlerİsim, c);
                sehirler[q]=plaka1;
            }
        }
        else if(sehirsayısı==5){
            for(int q=1;q<6;q++){
                c = scan.nextLine();
                plaka1 = plakaBulma(sehirlerİsim, c);
                sehirler[q]=plaka1;
            }
        }
        else if(sehirsayısı==6){
            for(int q=1;q<7;q++){
                c = scan.nextLine();
                plaka1 = plakaBulma(sehirlerİsim, c);
                sehirler[q]=plaka1;
            }
        }
        else if(sehirsayısı==7){
            for(int q=1;q<8;q++){
                c = scan.nextLine();
                plaka1 = plakaBulma(sehirlerİsim, c);
                sehirler[q]=plaka1;
            }
        }
        else if(sehirsayısı==8){
            for(int q=1;q<9;q++){
                c = scan.nextLine();
                plaka1 = plakaBulma(sehirlerİsim, c);
                sehirler[q]=plaka1;
            }
        }
        else if(sehirsayısı==9){
            for(int q=1;q<10;q++){
                c = scan.nextLine();
                plaka1 = plakaBulma(sehirlerİsim, c);
                sehirler[q]=plaka1;
            }
        }
        else if(sehirsayısı==10){
            for(int q=1;q<11;q++){
                c = scan.nextLine();
                plaka1 = plakaBulma(sehirlerİsim, c);
                sehirler[q]=plaka1;
            }
        }
        
        for(int i=0;i<sehirler.length;i++)
        {
            System.out.println(sehirler[i]);
        }
        
    
        EnKısaYol Güzergah = new EnKısaYol(); 
        
        Güzergah.gidilecekSehirler(uzakliklar,sehirlerİsim,sehirler);
     
        
    }
    
}