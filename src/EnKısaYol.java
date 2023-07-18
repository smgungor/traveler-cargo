/*import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;*/
import java.util.ArrayList;


public class EnKısaYol {
    
    public int toplamYol = 0 ;
    public int mesafeler[] = new int[5];
    public int a = 0;
    
    ArrayList<Integer> ugrananSehir = new ArrayList<Integer>();
    
    ArrayList<Integer> ugrananSehir2 = new ArrayList<Integer>();
     
    ArrayList<ArrayList<Integer>> yol = new ArrayList<ArrayList<Integer>>();
    
    int []öyle={0,0,0,0,0};
    static final int S = 81; 
    
    int mesafe(int uzaklik[], Boolean sptSet[]) 
    { 
        
        int min = Integer.MAX_VALUE; 
        int minimum_i = -1; 
  
        for (int i = 0; i < S; i++) 
            
            if (sptSet[i] == false && uzaklik[i] <= min) { 
                min = uzaklik[i]; 
                minimum_i = i; 
            } 
  
        return minimum_i;
        
    } 
   
  
     
  
    void gidilecekSehirler(int graf[][],String[] sehirlerIsım,int[] sehir){
        int [][] sontutucu = new int[5][81];
        int[][] uzakliklar2 = new int[81][81];
        int[] sehir2 = new int[sehir.length];
        int sayac =0;
        
        for(int i = 0;i<81;i++){
            yol.add(new ArrayList<Integer>());
        }
        
        int kontrol;                      
        ///5 yol bulmamızı saglıyor!!!
        while(sayac<5){
            yol.get(a).add(sehir[0]);
            int src;
            int gidilecekSehir;
            int i;
            ///İlk uc yolu bulmamızı sağlıyor!!!
            if(sayac<3){
                
                //ugrananSehir2 listemizle islem yapacagimiz icin sehir dizimizdeki sehirleri listeye attik...
                for(int say2=0;say2<sehir.length;say2++){
                        ugrananSehir2.add(sehir[say2]);
                    }
                
                //Sehirlerden herhangi birine ugramis miyiz ona baktık ki daha sonra bos yere ugramayalim...
                for(i = 0;i<ugrananSehir2.size();i++){ 
                    kontrol = ugrananSehir2.size();                                             
                    for(int j = i;j<ugrananSehir2.size();j++){                        
                        for(int say = 0;say<ugrananSehir.size();say++){
                            if(ugrananSehir2.get(j) == ugrananSehir.get(say)){
                                ugrananSehir2.remove(j);
                                if(j==kontrol-1){
                                    break;
                                }
                            }
                        }
                    }
                    
                    if(i == ugrananSehir2.size()-1){
                        break;
                    }
                    
                    int a = i+1;
                    src = ugrananSehir2.get(i);
                    gidilecekSehir = ugrananSehir2.get(a);
                
                
               
                    dijkstra(graf, sehirlerIsım, src, gidilecekSehir);
                    //Tekrardan sehirlerden herhangi birine ugramis miyiz ona baktık ki daha sonra bos yere ugramayalim...
                    kontrol = ugrananSehir2.size();
                    for(int j = i;j<ugrananSehir2.size();j++){
                        for(int say = 0;say<ugrananSehir.size();say++){
                            if(ugrananSehir2.get(j) == ugrananSehir.get(say)){
                                ugrananSehir2.remove(j);
                                if(j==kontrol-1){
                                    break;
                                }
                            }
                        }
                    }
                }
            
                int sayac2, sayac3=0;
                src = ugrananSehir2.get(i);
                gidilecekSehir = ugrananSehir2.get(0);
            
            
                dijkstra(graf, sehirlerIsım, src, gidilecekSehir);
            
            
                System.out.println("Toplam alinan yol:"+toplamYol+"\n\n");
                mesafeler[sayac]=toplamYol;
            
            
                //Sehirlerimizi karıştırdık düzenli bir şekilde...
                int j;
                for(j = 0;j<sehir.length-1;j++){
                    
                    if(j==0){                       
                       int t = sehir[0];
                       sehir2[0] = t;
                       sehir2[sehir.length-1] = sehir[1];     
                    }
                
                    else if (j>0){                      
                        int f = sehir[j+1];
                        sehir2[j] = f;
                    } 
                    
                }
                
            
                for(j=0;j<sehir.length;j++){                    
                    sehir[j] = sehir2[j];
                }
            
                sayac++;
                toplamYol = 0;
            }
            
            ///elseden sonrasi 3. ve 4. yolları bulmamıza yarıyor!!!
            else{     
                //Sayac = 3 icin buraya girdi ve son iki sehiri yer degistirmis oldu...
                if(sayac==3){                   
                    int tut = sehir[sehir.length-2];
                    sehir[sehir.length-2] = sehir[sehir.length-1];
                    sehir[sehir.length-1] = tut;
                    
                    for(int say2=0;say2<sehir.length;say2++){
                        ugrananSehir2.add(sehir[say2]);
                    }                    
                }
                
                else{
                    //ugrananSehir2 listemize sehir dizimizdeki sehirlerimiz atmis olduk...
                    for(int say2=0;say2<sehir.length;say2++){
                        ugrananSehir2.add(sehir[say2]);
                    }
                    
                }
                for(i = 0;i<ugrananSehir2.size();i++){
                    //ugranan sehirlerin arasinde ugrnacak sehir varsa o sehri cikardik ki bos yere tekrar ugramasin...
                    kontrol = ugrananSehir2.size();
                    for(int j = i;j<ugrananSehir2.size();j++){
                        for(int say = 0;say<ugrananSehir.size();say++){
                            if(ugrananSehir2.get(j) == ugrananSehir.get(say)){
                                ugrananSehir2.remove(j);
                                if(j==kontrol-1){
                                    break;
                                }
                            }
                        }
                    }
                    
                    if(i == ugrananSehir2.size()-1){
                        break;
                    }
                    
                    int a = i+1;
                    src = ugrananSehir2.get(i);
                    gidilecekSehir = ugrananSehir2.get(a);

                    dijkstra(graf, sehirlerIsım, src, gidilecekSehir);
                    kontrol = ugrananSehir2.size();
                    for(int j = i;j<ugrananSehir2.size();j++){
                        for(int say = 0;say<ugrananSehir.size();say++){
                            if(ugrananSehir2.get(j) == ugrananSehir.get(say)){
                                ugrananSehir2.remove(j);
                                if(j==kontrol-1){
                                    break;
                                }
                            }
                        }
                    }
            
                }
            
                int sayac2, sayac3=0;
                src = ugrananSehir2.get(i);
                gidilecekSehir = ugrananSehir2.get(0);
            
            
                dijkstra(graf, sehirlerIsım, src, gidilecekSehir);
            
            
                System.out.println("Toplam alinan yol:"+toplamYol+"\n\n");
        
                int j;
                for(j = 0;j<sehir.length-1;j++){
                    if(j==0){                       
                        int t = sehir[0];
                        sehir2[0] = t;
                        sehir2[sehir.length-1] = sehir[1];                    
                    }
                
                    else if (j>0){                        
                        int f = sehir[j+1];
                        sehir2[j] = f;
                    }    
                }
                
            
                for(j=0;j<sehir.length;j++){
                    sehir[j] = sehir2[j];
                }
            
                sayac++;
                toplamYol = 0;
            }
            ugrananSehir.clear();
            ugrananSehir2.clear();
            
            for(int deger = 0;deger<yol.get(a).size();deger++){
                System.out.print(yol.get(a).get(deger)+" ");
            }
            for(int deger = 0;deger<yol.get(a).size();deger++){
                sontutucu[a][deger]=yol.get(a).get(deger);
                öyle[a]=öyle[a]+1;
            }          
            System.out.println("\n");
            a++;
            
           if(sayac==5){
               for(int q=0;q<4;q++){
                for(int w = 0;w<4-q;w++){
                    if(mesafeler[w]>mesafeler[w+1]){
                           int [] tmp = sontutucu[w];
                           sontutucu[w] = sontutucu[w+1];
                           sontutucu[w+1]=tmp;
                           int tmp2 = öyle[w];
                           öyle[w]=öyle[w+1];
                           öyle[w+1]=tmp2;
                           int tmp3 = mesafeler[w];
                           mesafeler[w]=mesafeler[w+1];
                           mesafeler[w+1]=tmp3;
                       }
                }
            }
               
            Harita h = new Harita(sontutucu,öyle);
            h.setVisible(true);
           } 
      
        }
       
        
    }
    
    
    void dijkstra(int graf[][], String[] sehirlerIsım,int search,int gidilecekSehirPlaka) 
    {        
        ArrayList<ArrayList<Integer>> liste = new ArrayList<ArrayList<Integer>>();
        Boolean kontrol2[] = new Boolean[S];
        
        for(int i = 0;i<81;i++){
            liste.add(new ArrayList<Integer>());
        }
        
        for(int i = 0;i<81;i++){
            liste.get(i).add(i);            
        }
        int uzaklik[] = new int[S];
        
         
  
        
        for (int i = 0; i < S; i++) { 
            uzaklik[i] = Integer.MAX_VALUE; 
            kontrol2[i] = false; 
        } 
  
        
        uzaklik[search] = 0; 
  
        
        for (int miktar = 0; miktar < S - 1; miktar++) { 
            
            int a = mesafe(uzaklik, kontrol2); 
  
           
            kontrol2[a] = true; 
  
             
            for (int j = 0; j < S; j++) 
  
                 //Gittiği yolları bu sekilde cekebilmiş oldum!!!
                if (!kontrol2[j] && graf[a][j] != 0 &&  
                   uzaklik[a] != Integer.MAX_VALUE && uzaklik[a] + graf[a][j] < uzaklik[j]){
                    uzaklik[j] = uzaklik[a] + graf[a][j];
                    
                    if(liste.get(a).size() == 1){
                        liste.get(j).add(a);
                    }
                    else{
                        for(int sayac = 0;sayac<liste.get(a).size();sayac++){ 
                            liste.get(j).add(liste.get(a).get(sayac));
                        }
                    }
                    
                } 
                     
        } 
        
        
        //her satırdaki ilk aranan plaka hangi sütunda onları diziye attım!!!
        int[] dizi = new int[81];
        for(int i = 0;i<81;i++){
            for(int j =0;j<liste.get(i).size();j++){
                if(liste.get(i).get(j)==search){
                    dizi[i] = j;
                    break;
                }
            }
        }
        
       
        
        //yukaridaki kodda bulduğum ilk plakalardan sonraki plakalari remove etmiş oldum!!!
        for(int i =0 ;i<81;i++){
            int deger = liste.get(i).size();
            for(int t = dizi[i]+1;t<deger;t+=1){
                liste.get(i).remove(dizi[i]);
            }
        }
        
        
        for(int i = 1;i<liste.get(gidilecekSehirPlaka).size()-1;i++){
            ugrananSehir.add(liste.get(gidilecekSehirPlaka).get(i));
        }
        
        for(int i = 0;i<liste.get(gidilecekSehirPlaka).size();i++){
            System.out.print(sehirlerIsım[liste.get(gidilecekSehirPlaka).get(i)]+" ");
        } 
        
        System.out.println("\n");
        
        for(int i = liste.get(gidilecekSehirPlaka).size()-2;i>=0;i--){
            yol.get(a).add(liste.get(gidilecekSehirPlaka).get(i));
        }
  
        toplamYol = toplamYol + uzaklik[gidilecekSehirPlaka];
         
    }
 
}