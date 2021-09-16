package Sistema;

import java.util.Scanner;
import java.util.InputMismatchException;

public class MainMenu {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int campos, i , j;
		String datos[][];
		String op;
		int totalalumnos;
		totalalumnos = 19;
		campos = 12;
		datos = new String[20][13];
		for (i=0;i<=totalalumnos;i++) {
			for (j=0;j<=campos;j++) {
				datos[i][j] = "";
			}
		}
		
		Scanner sn = new Scanner(System.in);
		boolean salir = false;
		int opcion;
		String nombreUsuario= "";
		
		System.out.println("BIENVENIDO A SISTEMA DE REGISTRO DE ALUMNOS");
		Thread.sleep(1*1000);
		System.out.println("");
		
		System.out.println("Ingrese su nombre:");
		nombreUsuario = sn.nextLine();
		System.out.println("");
		Thread.sleep(1*1000);
		
		
		while (!salir) {
			
			System.out.println("1.- NUEVO ALUMNO");
			System.out.println("2.- BUSCAR ALUMNO");
			System.out.println("3.- MODIFICAR DATOS DE ALUMNO");
			System.out.println("4.- ELIMINAR UN ALUMNO");
			System.out.println("");
			System.out.println("5.- SALIR");
			System.out.println("");
			try {
			System.out.println("INTRODUCE UN NUMERO PARA NAVEGAR...");
			opcion = sn.nextInt();
			
			
			
			switch(opcion) {
			
			    case 1:
			    	System.out.println("este es el menu de NUEVO");
			    	ingresarAlumno(datos);
				    break;
				 
                case 2:
                	System.out.println("este es el menu de BUSCAR");
    				break;
    			
                case 3:
                	System.out.println("este es el menu de MODIFICAR");
    				break;
                
                case 4:
                	System.out.println("este es el menu de ELIMINAR");
    				break;	
                case 5:
                	salir = true;
                	break;
                default:
                	System.out.println("Las opciones son entre 1 y 5");
           
			}
			
		}catch(InputMismatchException e) {
			System.out.println("Debes introducir una opcion válida!!");
			sn.next();
		}
			
		
	}
	System.out.println("Hasta Pronto " +nombreUsuario + " !");
		
	}
	
	
	public static void ingresarAlumno(String datos[][]){
		int n;
		String respuesta;
		respuesta = "0";
		n = 0;
		do {
			System.out.println("Presione 1 para ingresar un nuevo alumno");
			// captura opcion
			System.out.println("Presione 2 para volver a menú principal");
			Scanner s = new Scanner(System.in);
			respuesta = s.nextLine();
			if ( esNumero(respuesta)==false) {
				System.out.println("La respuesta ingresada es incorrecta");
			} else {
				n = Integer.parseInt(respuesta);
				if (n==1) {
					ingresarDatos(datos);
				}
			}
			if (n==2) {
				System.out.println(""); // no hay forma directa de borrar la consola en Java
			}
		} while (n!=2);
	}
	
	public static boolean esNumero(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	
	public static void ingresarDatos(String datos[][]) {
		String dato;
		boolean datoverificador = false, verificador = false;
		int i = -1, j = 0;
		
		Scanner s = new Scanner(System.in);
		
		while ((verificador==false && i<20)) {
			i = i+1;
			if (datos[i][0].equals("")) {
				while ((verificador==false && j<=6)) {
					
					switch (j) {
						case 0:
							while ((datoverificador==false)) {
								System.out.println("Ingrese rut de alumno ingresado o cancelar ingresando 0: ");
								dato = s.nextLine();
								datoverificador = validarRut(dato);
								if (datoverificador) {
									datos[i][j] = dato;
								}
								if (esNumero(dato)) {
									if (Integer.parseInt(dato)==0) {
										datoverificador = true;
										verificador = true;
									}
								}
							}
							break;
						case 1:
							while ((datoverificador==false)) {
								System.out.println("Ingrese el nombre del alumno");
								dato = s.nextLine();
								datoverificador = validarPalabra(dato.toLowerCase());
								if (datoverificador) {
									datos[i][j] = dato;
								} else {
									System.out.println("El nombre ingresado es incorrecto, no puede tener "
											+ "numeros ni caracteres extraños.");
									System.out.println("");
								}
								
								if (esNumero(dato)) {
									if (Integer.parseInt(dato)==0) {
										datoverificador = true;
										verificador = true;
									}
								}
							}
							break;
						case 2:
							while ((datoverificador==false)) {
								System.out.println("Ingrese apellido paterno del alumno");
								dato = s.nextLine();
								datoverificador = validarPalabra(dato.toLowerCase());
								if (datoverificador) {
									datos[i][j] = dato;
								} else {
									System.out.println("El apellido ingresado es incorrecto, no puede tener numeros ni caracteres extraños.");
									System.out.println("");
								}
								if (esNumero(dato)) {
									if (Integer.parseInt(dato)==0) {
										datoverificador = true;
										verificador = true;
									}
								}
							}
							break;
						case 3:
							while ((datoverificador==false)) {
								System.out.println("Ingrese apellido materno del alumno");
								dato = s.nextLine();
								datoverificador = validarPalabra(dato.toLowerCase());
								if (datoverificador) {
									datos[i][j] = dato;
								} else {
									System.out.println("El apellido ingresado es incorrecto, no puede tener numeros ni caracteres extraños.");
									System.out.println("");
								}
								if (esNumero(dato)) {
									if (Integer.parseInt(dato)==0) {
										datoverificador = true;
										verificador = true;
									}
								}
							}
							break;
						case 4:
							while ((datoverificador==false)) {
								System.out.println("Ingrese numero de contacto del alumno con el siguente formato: 958631452");
								dato = s.nextLine();
								datoverificador = validarCelular(dato);
								if (datoverificador) {
									datos[i][j] = dato;
								} else {
									System.out.println("El numero ingresado es incorrecto, no puede tener letras ni caracteres extraños y debe tener 9 digitos.");
									System.out.println("");
								}
								if (esNumero(dato)) {
									if (Integer.parseInt(dato)==0) {
										datoverificador = true;
										verificador = true;
									}
								}
							}
							break;
						case 5:
							while ((datoverificador==false)) {
								System.out.println("Ingrese email del alumno");
								dato = s.nextLine();
								datoverificador = verificarEmail(dato);
								if (datoverificador) {
									datos[i][j] = dato;
								} else {
									System.out.println("El correo ingresado es incorrecto");
									System.out.println("");
								}
								if (esNumero(dato)) {
									if (Integer.parseInt(dato)==0) {
										datoverificador = true;
										verificador = true;
									}
								}
							}
							break;
						case 6:
							System.out.println("Ingrese fecha de nacimiento del alumno");
							datos[i][j] = s.nextLine();
							break;
						default:
						}
					datoverificador = false;
					j = j+1;
				}
				verificador = true;
			} else {
			}
		}
		//mostrardatos(datos,i);
	}


	private static boolean validarRut(String dato) {
		// TODO Auto-generated method stub
		return true;
	}


	private static boolean validarCelular(String dato) {
		// TODO Auto-generated method stub
		return true;
	}


	private static boolean verificarEmail(String dato) {
		// TODO Auto-generated method stub
		return true;
	}


	private static boolean validarPalabra(String lowerCase) {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}


