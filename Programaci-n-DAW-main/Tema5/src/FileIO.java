import java.io.*;
class FileIO{
public static void main(String [] args)
 throws FileNotFoundException, IOException{
 FileInputStream in = new FileInputStream("./Tema5/heroes.json");
 FileOutputStream out = new FileOutputStream("./Tema5/heroes.json");
 int n=0,c;
 System.out.print ("\nCopiando ...");
 while( (c = in.read()) != -1){
 out.write(c);
 n++;
 }
 in.close();
 out.close();
 System.out.print ("\nSe han copiado "+n+" Bytes\n");
}}
