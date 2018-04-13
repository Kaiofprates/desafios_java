import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


public class main {

    public static void main(String[] args) throws Exception {
    	
    	//Scanner pegar = new Scanner(System.in);
    	//String art, mus;
    	//System.out.printf("\nArtista...: ");
    	//art = pegar.nextLine();
    	//System.out.printf("\nMúsica...: ");
    	//mus = pegar.nextLine();
String art = JOptionPane.showInputDialog("Artista:");
String mus = JOptionPane.showInputDialog("música:");

    	
        URL letra = new URL("https://api.vagalume.com.br/search.php?apikey=f86df64c617743ad212ce779f8c5a4e8&art=" + art +"&mus=" + mus);
        URLConnection yc = letra.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        ArrayList<String> lista = new ArrayList<String>();
        String inputLine;
        while ((inputLine = in.readLine()) != null) 
            //System.out.println(inputLine);
            lista.add(inputLine);
        in.close();
     
        String nome;
        nome = art + "_"+ mus+".txt";
        FileWriter arq = new FileWriter(nome);
        PrintWriter gravarArq = new PrintWriter(arq);
     
        for ( String s : lista ) {
        	gravarArq.printf(s);
        	System.out.println(s);
        	}
        arq.close();
	//System.out.println(Arrays.toString(lista.toArray()));
        
    }

}
