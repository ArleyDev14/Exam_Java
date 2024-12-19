package Cheques;

import Usuarios.VerificarCuenta;
import java.util.Scanner;

public class SolicitarCheque {
    
    public static void solicitar_cheque(){
        Scanner scan = new Scanner(System.in);
        System.out.println("----------------------------------------");
        System.out.println("--------Solicitador de cheques ---------");
        System.out.println("----------------------------------------");
        System.out.print("---Ingresa tu documento: ");
        String documento = scan.nextLine();
        System.out.print("---Ingresa el Identificador de tu cuenta: ");
        int id_cuenta = scan.nextInt();
        System.out.print("---Ingresa el monto: ");
        float cantidad = scan.nextFloat();
        System.out.println("---Ingresa el nombre del beneficiario");
        String nombre = scan.nextLine();
        System.out.println("----------------------------------------");
        System.out.println("---------------Prioridades--------------");
        System.out.println("----------------------------------------");
        System.out.println("---Ingresa|1| para 'Alta'---------------");
        System.out.println("---Ingresa|2| para 'Media'--------------");
        System.out.println("---Ingresa|3| para 'Baja'---------------");
        System.out.println("----------------------------------------");
        System.out.print("---Ingresa tu prioridad: ");
        int eleccion = scan.nextInt();
        String prioridad = "";
        System.out.println("----------------------------------------");
        System.out.print("---Ingresa tu firma Digital: ");
        String firma_digital = scan.next(); 
        
        
        switch(eleccion){
            case 1 -> prioridad = "Alta";
            case 2 -> prioridad = "Media";
            case 3 -> prioridad = "Baja";
        }
        
        boolean puedeObtenerCheque = VerificarCuenta.verificar_cuenta(documento,cantidad,id_cuenta);
        
        if(puedeObtenerCheque){
            CrearCheque.crear_cheque(id_cuenta,nombre,cantidad,"Monto_letras", prioridad,firma_digital);
            RestarMonto.restar_monto(cantidad,documento);
        }
        
        
        
    }
    
}
