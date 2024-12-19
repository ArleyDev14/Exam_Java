package Cheques;

import Usuarios.ObtenerCheque;
import java.util.List;
import java.util.Scanner;

public class SolicitarChequeUsuario {
    
    public static void solicitar_cheque_usuario(){
        Scanner scan = new Scanner(System.in);
        System.out.println("----------------------------------------");
        System.out.println("--------Solicitador de cheques ---------");
        System.out.println("----------------------------------------");
        System.out.print("---Ingresa tu documento: ");
        String documento = scan.nextLine();
        
        List<String[]> cheque = ObtenerCheque.getCheques(documento);
        
        for(String[] row : cheque){
            System.out.println("------------UNION_BANK A.S--------------");
            System.out.println("----------------------------------------");
            System.out.println("Cliente emisor: " + row[0]);
            System.out.println("Beneficiario: " + row[1]);
            System.out.println("----------------------------------------");
            System.out.println("Monto: " + row[2]);
            System.out.println("Prioridad: " + row[3]);
            System.out.println("----------------------------------------");
        }
        
        
    }
   
}
