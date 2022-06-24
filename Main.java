import javax.swing.*;    
import java.text.*;  
import java.util.*;  
public class Main implements Runnable{  
JFrame f;  
Thread t=null;  
int godzina=0, minuta=0, sekunda=0;  
String Czas = ""; // string wyświetlający czas 
JButton b;  
  
Main(){  
    f=new JFrame();  //Utworzenie nowej Ramki
      
    t = new Thread(this); //Tworzenie nowego wątku o iterowanej nazwie 
        t.start();  
      //wymiary Zegara umieszczonego na przycisku
    b=new JButton();  
        b.setBounds(25,20,100,50); 
  // b.setBounds(odl. od lewej,odl. od góry,wymiar X,Wymiar Y);


  // Wymiary okna
    f.add(b);  
    f.setSize(150,120);  
    f.setLayout(null);  
    f.setVisible(true);  
}  
  
 public void run() {  
      try {  
         while (true) {  
  
            Calendar cal = Calendar.getInstance();  
            godzina = cal.get( Calendar.HOUR_OF_DAY );  
            if ( godzina > 12 ) godzina -= 12;  
            minuta = cal.get( Calendar.MINUTE );  
            sekunda = cal.get( Calendar.SECOND );  
  
            SimpleDateFormat formatter = new 
            SimpleDateFormat("hh:mm:ss");  //import java.text.*; //Zwraca czas w formacie 12 godzinnym :(
            Date date = cal.getTime();  
            Czas = formatter.format( date );  
  
            printTime();  
  
            t.sleep( 1000 );  // opóźnienie o sekunde ale zegar będzię się rozjedżał z czasem, zależy to od szybkości kodu  
         }  
      }  
      catch (Exception e) { }  
 }  
  
public void printTime(){  
b.setText(Czas);  
}  
  
public static void main(String[] args) {  
    new Main();  
          
  
}  
}  