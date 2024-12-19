package Ejecutar_Programa;



import Cheques.SolicitarCheque;
import Cheques.SolicitarChequeUsuario;
import java.util.Scanner;

public class Main_Ejecutar {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean programa = true;
        while(programa == true){
            System.out.println("--------Bienvenid@ a UNION_BANK---------");
            System.out.println("----------------------------------------");
            System.out.println("---Ingresa|1| para solicitar un cheque--");
            System.out.println("---Ingresa|2| para ver mis cheques------");
            System.out.println("---Ingresa|0| para salir del banco------");
            System.out.println("----------------------------------------");
            System.out.print("--Ingresa tu elección: ");
            int menu = scan.nextInt();
            
            switch(menu){
                case 0 -> programa = false;
                case 1 -> SolicitarCheque.solicitar_cheque();
                case 2 -> SolicitarChequeUsuario.solicitar_cheque_usuario();
            }
            
        }
        
    }
}
