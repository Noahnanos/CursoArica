package Sistema;

import java.util.Scanner;
import java.util.InputMismatchException;

public class MainMenu {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sn = new Scanner(System.in);
		Scanner sNombre = new Scanner(System.in);
		boolean salir = false;
		int opcion;
		String nombreUsuario= "";
		
		System.out.println("BIENVENIDO A SISTEMA DE REGISTRO DE ALUMNOS");
		System.out.println("");
		
		System.out.println("Ingrese su nombre:");
		nombreUsuario = sNombre.nextLine();
		System.out.println("");
		
		
		while (!salir) {
			
			System.out.println("1.- NUEVO ALUMNO");
			System.out.println("2.- PERFIL ALUMNO");
			System.out.println("3.- BUSCAR ALUMNO");
			System.out.println("4.- MODIFICAR DATOS DE ALUMNO");
			System.out.println("5.- ELIMINAR UN ALUMNO");
			System.out.println("");
			System.out.println("6.- SALIR");
			System.out.println("");
			try {
			System.out.println("INTRODUCE UN NUMERO PARA NAVEGAR...");
			opcion = sn.nextInt();
			
			
			
			switch(opcion) {
			
			    case 1:
			    	System.out.println("este es el menu de NUEVO");
				    break;
				
                case 2:
                	System.out.println("Este es el menu de PERFIL");
				    break;
				 
                case 3:
                	System.out.println("este es el menu de BUSCAR");
    				break;
    			
                case 4:
                	System.out.println("este es el menu de MODIFICAR");
    				break;
                
                case 5:
                	System.out.println("este es el menu de ELIMINAR");
    				break;	
                case 6:
                	salir = true;
                	break;
                default:
                	System.out.println("Las opciones son entre 1 y 6");
           
			}
			
		}catch(InputMismatchException e) {
			System.out.println("Debes introducir una opcion válida!!");
			sn.next();
			
		}
			
		
	}
		System.out.println("Hasta Pronto " +nombreUsuario + " !");
		
		
		
		

	}
	
}


