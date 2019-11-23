/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import java.util.Scanner;

/**
 *
 * @author PC
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
