/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbanco;

import java.util.Scanner;

/**
 *
 * @author Victor Medina
 */
public class Main {
    
    public static int buscarNumCuenta(Cuenta cuentas[], int n) {
        int i=0, indice=0;
        boolean encontrado = false;
        
        while ((i<cuentas.length) && encontrado == false) {
            if (cuentas[i].getnCuenta() == n) {
                encontrado = true;
                indice = i;
            }
            i++;
        }
        
        if (encontrado == false) {
            indice = -1;
        }
     return indice;   
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String nombre, apellido;
        int nCuenta, numeroCuentas, op, indiceCuenta;
        double saldo, cedula, cantidad;
        Cuenta cuentas[];
        Cliente cliente;
        
        System.out.println("\t***Programa para manejar las cuentas de un cliente ***");
        System.out.print("Digite el nombre del cliente: ");
        nombre = in.nextLine();
        System.out.print("Digite el apellido del cliente: ");
        apellido = in.nextLine();
        System.out.print("Digite la cedula del cliente: ");
        cedula = in.nextDouble();
        System.out.print("Digite el numero de cuentas del cliente: ");
        numeroCuentas = in.nextInt();
        
        cuentas = new Cuenta[numeroCuentas];
        
        for (int i = 0; i < cuentas.length; i++) {
            System.out.println("Digite los datos de la cuenta "+(i+1)+": ");
            System.out.print("Digite el numero de cuenta: ");
            nCuenta = in.nextInt();
            System.out.print("Digite el saldo de la cuenta: ");
            saldo = in.nextDouble();
            
            cuentas[i] = new Cuenta(nCuenta, saldo);
        }
        
        cliente = new Cliente(nombre, apellido, cedula, cuentas);
        
        do {
            System.out.println("\t *** Menu *** ");
            System.out.println("1. Ingresar dinero en la cuenta");
            System.out.println("2. Retirar dinero en la cuenta");
            System.out.println("3. Consultar saldo de la cuenta");
            System.out.println("4. Salir");
            op = in.nextInt();
            
            switch (op) {
                case 1:
                    System.out.println("\t *** Ingresar dinero ***");
                    System.out.print("Digite el numero de cuenta: ");
                    nCuenta = in.nextInt();
                    indiceCuenta = buscarNumCuenta(cuentas, nCuenta);
                    if (indiceCuenta == -1) {
                        System.out.println("La cuenta ingresada no existe");
                    }else {
                        System.out.print("Digite la cantidad de dinero a ingresar: ");
                        cantidad = in.nextDouble();
                        cliente.ingresarDinero(indiceCuenta, cantidad);
                        System.out.println("Consignacion realizada exitosamente!");
                        System.out.println("Saldo disponible: "+cliente.consultaSaldo(indiceCuenta));
                    }
                    break;
                case 2:
                    System.out.println("\t *** Ingresar dinero ***");
                    System.out.print("Digite el numero de cuenta: ");
                    nCuenta = in.nextInt();
                    indiceCuenta = buscarNumCuenta(cuentas, nCuenta);
                    if (indiceCuenta == -1) {
                        System.out.println("La cuenta ingresada no existe");
                    }else {
                        System.out.print("Digite la cantidad de dinero a retirar: ");
                        cantidad = in.nextDouble();
                        cliente.retirarDinero(indiceCuenta, cantidad);
                        System.out.println("Retiro realizado exitosamente!");
                        System.out.println("Saldo disponible: "+cliente.consultaSaldo(indiceCuenta));
                    }
                    
                    break;
                case 3:
                    System.out.println("\t *** Ingresar dinero ***");
                    System.out.print("Digite el numero de cuenta: ");
                    nCuenta = in.nextInt();
                    indiceCuenta = buscarNumCuenta(cuentas, nCuenta);
                    if (indiceCuenta == -1) {
                        System.out.println("La cuenta ingresada no existe");
                    }else {
                        System.out.println("Saldo disponible: "+cliente.consultaSaldo(indiceCuenta));
                    }
                    break;
                case 4: 
                    System.out.println("Hasta pronto!");
                    break;
                default:
                    System.out.println("Lo sentimos, esta opcion no existe en el menu");
            }          
        }while(op != 4);
    }
}
