package Sistema;

import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;

public class MainMenu {
	
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		int campos, i , j, opcion, totalAlumnos;
		String datos[][];
		String nombreUsuario= "";
		boolean salir = false;
		Scanner sn = new Scanner(System.in);
		
		totalAlumnos = 19;
		campos = 12;
		datos = new String[20][13];
		
		
		for (i=0; i <= totalAlumnos; i++) {
			for (j=0; j <= campos; j++) {
				datos[i][j] = "";
			}
		}
		
		System.out.println("BIENVENIDO A SISTEMA DE REGISTRO DE ALUMNOS");
		//Thread.sleep(1*1000);
		System.out.println("");
		
		/*
		System.out.println("Ingrese su nombre:");
		nombreUsuario = sn.nextLine();
		System.out.println("");
		Thread.sleep(1*1000);
		*/
		
		while (!salir) {
			System.out.println("************************************************");
			System.out.println("");
			System.out.println("1.- NUEVO ALUMNO");
			System.out.println("2.- BUSCAR ALUMNO");
			System.out.println("3.- MODIFICAR DATOS DE ALUMNO");
			System.out.println("4.- ELIMINAR UN ALUMNO");
			System.out.println("");
			System.out.println("5.- SALIR");
			System.out.println("");
			System.out.println("************************************************");
			try {
			System.out.println("INTRODUCE UN NUMERO PARA NAVEGAR...");
			
			opcion = sn.nextInt();
			
			
			
			switch(opcion) {
			
			    case 1:
			    	ingresarAlumno(datos);
				    break;
				 
                case 2:
                	buscarAlumno(datos);
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
			System.out.println();
			System.out.println("1.- INGRESAR NUEVO ALUMNO");
			// captura opcion
			System.out.println("2.- VOLVER AL MENU PRINCIPAL");
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
				System.out.println(""); 
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
		boolean datoVerificador = false, verificador = false;
		int i = 0, j = 0;
		Scanner s = new Scanner(System.in);
		
		System.out.println("Recuerda que si te equivocas puedes editar el\n"
				+ "alumno o elimininarlo\n");
		
		while ((verificador==false && i<20)) {
			if (datos[i][0].equals("")) {
				while ((verificador==false && j<=6)) {
					switch (j) {
						case 0:
							while ((datoVerificador==false)) {
								System.out.println("Ingrese rut de alumno");
								dato = s.nextLine();
								datoVerificador = validarRut(dato);
								if (datoVerificador) {
									datos[i][j] = dato;
								}
							}
							break;
						case 1:
							while ((datoVerificador==false)) {
								System.out.println("Ingrese el nombre del alumno");
								dato = s.nextLine();
								datoVerificador = validarPalabra(dato.toLowerCase());
								if (datoVerificador) {
									datos[i][j] = dato;
								} else {
									System.out.println("El nombre ingresado es incorrecto, no puede tener\n "
											+ "numeros ni caracteres extraños.");
									System.out.println("");
								}
								
							}
							break;
						case 2:
							while ((datoVerificador==false)) {
								System.out.println("Ingrese apellido paterno del alumno");
								dato = s.nextLine();
								datoVerificador = validarPalabra(dato.toLowerCase());
								if (datoVerificador) {
									datos[i][j] = dato;
								} else {
									System.out.println("El apellido ingresado es incorrecto, no puede tener numeros ni caracteres extraños.");
									System.out.println("");
								}
							}
							break;
						case 3:
							while ((datoVerificador==false)) {
								System.out.println("Ingrese apellido materno del alumno");
								dato = s.nextLine();
								datoVerificador = validarPalabra(dato.toLowerCase());
								if (datoVerificador) {
									datos[i][j] = dato;
								} else {
									System.out.println("El apellido ingresado es incorrecto, no puede tener numeros ni caracteres extraños.");
									System.out.println("");
								}
							}
							break;
						case 4:
							while ((datoVerificador==false)) {
								System.out.println("Ingrese numero de contacto del alumno con el siguente formato: 958631452");
								dato = s.nextLine();
								datoVerificador = validarCelular(dato);
								if (datoVerificador) {
									datos[i][j] = dato;
								} else {
									System.out.println("El numero ingresado es incorrecto, no puede tener letras ni caracteres extraños y debe tener 9 digitos.");
									System.out.println("");
								}
							}
							break;
						case 5:
							while ((datoVerificador==false)) {
								System.out.println("Ingrese email del alumno");
								dato = s.nextLine();
								datoVerificador = verificarEmail(dato);
								if (datoVerificador) {
									datos[i][j] = dato;
								} else {
									System.out.println("El correo ingresado es incorrecto");
									System.out.println("");
								}
							}
							break;
						case 6:
							System.out.println("Ingrese fecha de nacimiento del alumno");
							datos[i][j] = s.nextLine();
							break;
						default:
						}
					datoVerificador = false;
					j = j+1;
				}
				verificador = true;
			} 
			i++;
		}
		//mostrardatos(datos,i);
	}
	
	public static void buscarAlumno(String datos[][]){
		int n;
		String respuesta;
		Scanner s = new Scanner(System.in);
		n = 0;
		respuesta = "0";
		do {
			System.out.println("************************************************");
			System.out.println("");
			System.out.println("1. BUSCAR ALUMNO POR RUT");
			System.out.println("2. BUSCAR ALUMNO POR NOMBRE");
			System.out.println("3. MOSTRAR LISTA DE ALUMNOS");
			System.out.println("4. VOLVER AL MENU PRINCIPAL\n");
			System.out.print("Elige una opción.....");
			respuesta = s.nextLine();
			if ((esNumero(respuesta)==false)) {
				System.out.println("");
				System.out.println("La respuesta ingresada es incorrecta por favor vuelve a intentarlo");
				System.out.println("");
			} else {
				n = Integer.parseInt(respuesta);
			}
			switch (n) {
			case 1:
				buscarporRut(datos);
				break;
			case 2:
				buscarporNombre(datos);
				break;
			case 3:
				listarAlumnos(datos);
				break;
			case 4:
				System.out.println("");
				break;
			}
		} while (n!=4);
	}
	
	private static void listarAlumnos(String datos[][]) {
		// TODO Auto-generated method stub
		
	}


	private static void buscarporNombre(String datos[][]) {
		// TODO Auto-generated method stub
		
	}


	private static void buscarporRut(String datos[][]) {
		int cont = 0, i, alumno = 0;
		String respuesta;
		respuesta = "0";
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("");
		System.out.println("Ingrese el RUT del alumno a buscar");
		respuesta = s.nextLine();
		for (i=0;i<=19;i++) {
			if (datos[i][0].equals(respuesta)) {
				alumno = i;
				cont = cont+1;
			}
		}
		if (cont==0) {
			System.out.println("No se encontro ningun rut que concuerde al ingresado.");
		} else {
			opcionesAlumno(datos, alumno);
		}
	}


	private static void opcionesAlumno(String[][] datos, int alumno) {
		// TODO Auto-generated method stub
		int n = 0;
		String respuesta="0";
		
		Scanner s = new Scanner(System.in);
		System.out.println("************************************************");
		System.out.println("");
		System.out.println("El alumno se encontro satisfactoriamente, ¿Que desea hacer?");
		System.out.println("");
		do {
			mostrarDatos(datos,alumno);
			System.out.println("************************************************");
			System.out.println("1. EDITAR ALUMNO");
			System.out.println("2. INGRESAR NOTAS");
			System.out.println("3. GENERAR REPORTE");
			System.out.println("4. ELIMINAR ALUMNO");
			System.out.println("5. VOLVER AL MENU PRINCIPAL\n");
			System.out.print("Elige una opción.....");
			respuesta = s.nextLine();
			if ((esNumero(respuesta)==false)) {
				System.out.println("");
				System.out.println("La respuesta ingresada es incorrecta por favor vuelve a intentarlo");
				System.out.println("");
			} else {
				n = Integer.parseInt(respuesta);
			}
			switch (n) {
			case 1:
				editarAlumno(datos, alumno);
				break;
			case 2:
				System.out.println("Ingresar notas");
				break;
			case 3:
				System.out.println("Reporte");
				break;
			case 4:
				System.out.println("Eliminar");
				break;
			case 5:
				System.out.println("");
				break;
			}
		} while (n!=5);
	}
	
	public static void editarAlumno(String[][] datos, int alumno) {
		String respuesta="0", dato;
		int n = 0;
		boolean datoVerificador = false;
		Scanner s = new Scanner(System.in);
		
		do {
			System.out.println("************************************************");
			System.out.println("¿Que desea editar?\n");
			System.out.println("1. EDITAR RUT");
			System.out.println("2. EDITAR NOMBRE");
			System.out.println("3. EDITAR APELLIDO PATERNO");
			System.out.println("4. EDITAR APELLIDO MATERNO");
			System.out.println("5. EDITAR NUMERO DE CONTACTO");
			System.out.println("6. EDITAR CORREO");
			System.out.println("7. EDITAR FECHA DE NACIMIENTO");
			System.out.println("8. SALIR\n");
			System.out.print("Elige una opción.....");
			respuesta = s.nextLine();
			
			if ((esNumero(respuesta)==false)) {
				System.out.println("");
				System.out.println("La respuesta ingresada es incorrecta por favor vuelve a intentarlo");
				System.out.println("");
			} else {
				n = Integer.parseInt(respuesta);
			}
			
			
			switch(n) {
			
			    case 1:
			    	System.out.println("Ingrese rut de alumno");
					dato = s.nextLine();
					datoVerificador = validarRut(dato);
					if (datoVerificador) {
						datos[alumno][0] = dato;
					}
				    break;
				 
	            case 2:
	            	System.out.println("Ingrese el nombre del alumno");
					dato = s.nextLine();
					datoVerificador = validarPalabra(dato.toLowerCase());
					if (datoVerificador) {
						datos[alumno][1] = dato;
					} else {
						System.out.println("El nombre ingresado es incorrecto, no puede tener\n "
								+ "numeros ni caracteres extraños.");
						System.out.println("");
					}
					break;
				
	            case 3:
	            	System.out.println("Ingrese apellido paterno del alumno");
					dato = s.nextLine();
					datoVerificador = validarPalabra(dato.toLowerCase());
					if (datoVerificador) {
						datos[alumno][2] = dato;
					} else {
						System.out.println("El apellido ingresado es incorrecto, no puede tener numeros ni caracteres extraños.");
						System.out.println("");
					}
					break;
	            
	            case 4:
	            	System.out.println("Ingrese apellido materno del alumno");
					dato = s.nextLine();
					datoVerificador = validarPalabra(dato.toLowerCase());
					if (datoVerificador) {
						datos[alumno][3] = dato;
					} else {
						System.out.println("El apellido ingresado es incorrecto, no puede tener numeros ni caracteres extraños.");
						System.out.println("");
					}
					break;	
	            case 5:
	            	System.out.println("Ingrese numero de contacto del alumno con el siguente formato: 958631452");
					dato = s.nextLine();
					datoVerificador = validarCelular(dato);
					if (datoVerificador) {
						datos[alumno][4] = dato;
					} else {
						System.out.println("El numero ingresado es incorrecto, no puede tener letras ni caracteres extraños y debe tener 9 digitos.");
						System.out.println("");
					}
	            	break;
	            case 6:
	            	System.out.println("Ingrese email del alumno");
					dato = s.nextLine();
					datoVerificador = verificarEmail(dato);
					if (datoVerificador) {
						datos[alumno][5] = dato;
					} else {
						System.out.println("El correo ingresado es incorrecto");
						System.out.println("");
					}
	            	break;
	            case 7:
	            	System.out.println("Ingrese email del alumno");
					dato = s.nextLine();
					datoVerificador = verificarEmail(dato);
					if (datoVerificador) {
						datos[alumno][6] = dato;
					} else {
						System.out.println("El correo ingresado es incorrecto");
						System.out.println("");
					}
	            	break;
	            case 8 :
	            	break;
	            default:
	            	System.out.println("Las opciones son entre 1 y 8");
       
			}
			
			
		} while(n!=8);
		
	}


	private static void mostrarDatos(String[][] datos, int i) {
		// TODO Auto-generated method stub
		System.out.println("datos del alumno");
		System.out.println(datos[i][0]);
		System.out.println(datos[i][1]);
	}


	// Validaciones
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


