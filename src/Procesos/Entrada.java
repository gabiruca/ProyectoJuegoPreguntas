/*
 Clase entrada de  datos
 */
package Procesos;

import java.util.Scanner;

/**
 *
 * @author WalterGonzalez
 */
public class Entrada {
    
    public int Entera(String msj){
        Scanner snc=new Scanner(System.in);
        System.out.print(msj);
        int num=snc.nextInt();
        return num;
    }
    
    public String Cadena(String msj){
        Scanner snc=new Scanner(System.in);
        System.out.print(msj);
        String cad=snc.nextLine();
        return cad;
    }
}
