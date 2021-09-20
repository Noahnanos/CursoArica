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
			System.out.println("MENU PRINCIPAL");
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
                	eliminarAlumnoRut(datos);
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
	
	public static void eliminarAlumnoRut(String datos[][]){
		boolean existe = false;
		int i, j;
		String respuesta = "-1";
		Scanner s = new Scanner(System.in);
		
		do {
			System.out.println("Ingrese el rut del alumno que desea eliminar para volver presione 0: ");
			respuesta = s.nextLine();
			
			for (i=0;i<=19;i++) {
				if (respuesta.equals(datos[i][0])) {
					for (j=0;j<=12;j++) {
						datos[i][j] = "";
						existe = true;
					}
					System.out.println("-------------------------------------------------");
					System.out.println("El alumno se elimino correctamentamente");
					System.out.println("-------------------------------------------------");
				}
			}
				
			if (existe==false) {
				System.out.println("-------------------------------------------------");
				System.out.println("El rut ingresado no esta registrado en el sistema");
				System.out.println("-------------------------------------------------");
			}
			if (respuesta.equals("0")) {
				System.out.println(""); 
			}
		} while (!respuesta.equals("0") && !existe);
	
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
				ingresarNotas(datos);
				break;
			case 3:
				System.out.println("Reporte");
				break;
			case 4:
				eliminarAlumno(datos, alumno);
				break;
			case 5:
				System.out.println("");
				break;
			}
		} while (n!=5);
	}
	
	public static void eliminarAlumno(String datos[][],int alumno) {
		int n = 0, i , j;
		String respuesta="0";
		
		Scanner s = new Scanner(System.in);
		System.out.println("************************************************");
		System.out.println("");
		System.out.println("¿Seguro que desea eliminar el alumno?");
		System.out.println("");
		do {
			System.out.println("************************************************");
			System.out.println("1. SI");
			System.out.println("2. NO");
			System.out.print("Elige una opción.....");
			respuesta = s.nextLine();
			if ((esNumero(respuesta)==false)) {
				System.out.println("");
				System.out.println("La respuesta ingresada es incorrecta por favor vuelve a intentarlo");
				System.out.println("");
			} else {
				n = Integer.parseInt(respuesta);
			}
			if(n==1) {
				for (j=0;j<=12;j++) {
					datos[alumno][j] = "";
				}
				System.out.println("-------------------------------------------------");
				System.out.println("El alumno se elimino correctamentamente");
				System.out.println("-------------------------------------------------");
				n = 2;
			}
		} while (n!=2);
		
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
	
	public static void ingresarNotas(String datos[][]) {
  		double acumuladoColumnas;
  		int alumno;
  		int j;
  		int n;
  		String nuevaNota;
  		String respuesta;
  		String respuestaNN;
  		acumuladoColumnas = 0;
  		alumno = 0;
  		respuesta = "0";
  		n = 0;
  		nuevaNota = "0";
  		j = 7;
  		respuestaNN = "S";
  		Scanner snn = new Scanner(System.in);
  		boolean otraNota = false;
  		
  		do {
  			System.out.println("Presione 1 para ingresar nueva nota ");
  			// captura opcion
  			System.out.println("Presione 2 para volver a menú principal");
  			System.out.println("Presione 3 para obtener Promedio de notas del alumno");
  			respuesta = snn.nextLine();
  			
  			if ((esNumero(respuesta)==false)) {
  				System.out.println("La respuesta ingresada es incorrecta");
  			} else {
  				n = Integer.parseInt(respuesta);
  				if (n==1) {
  					// creaR LA FUNCI
  					// Mientras j <= 12 & respuestaNN = "S" Hacer
  					//System.out.println("mensaje de j "+j+"respuesta nn "+respuestaNN);
  					for (j=7;j<=12;j++) {
  							if(j == 12) {
  								otraNota = true;
  							}
  							if (datos[alumno][j].equals("")) {
  								//for contador1 = 0 ; contador1=6 ; contador1 ++ {
  								//	contadorNN = contador1; 
  							
  							System.out.println("Ingresa la nueva nota" );
  							nuevaNota = snn.nextLine();
  							
  							if(esNumero(nuevaNota) == false) {
  								System.out.println("La respuesta ingresada es incorrecta");
  								
  							}else {
  								datos[alumno][j] = nuevaNota;
  	  							System.out.println("¿Quieres ingresar nueva nota? (Ingresa S para continuar o N para salir)  ");
  	  							respuestaNN = snn.nextLine();
  	  							if (!respuestaNN.toUpperCase().equals("S")) {
  	  								j = 13;
  	  							}
  							}
  							
  						}
  					}
  					if (otraNota) {
						System.out.println("El Alumno ha excedido cantidad de notas permitidas");
					}
  					//j = 7;
  					// j<- j+1;
  					// FinMientras
  				}
  				if (n==3) {
  					if (j==13) {
  						 
  							for (j=7;j<=12;j++) {
  								System.out.println ("algo me tiene que llegar" + datos[alumno][j]);
  								acumuladoColumnas = acumuladoColumnas+ Double.parseDouble(datos[alumno][j]);
  							}
  						
  						System.out.println("El Promedio es ; "+acumuladoColumnas/6);
  					} else {
  						System.out.println("El alumno no tiene las notas suficientes para obtener su promedio");
  					}
  				}
  			}
  			if (n==2) {
  				System.out.println(""); 
  			}
  		} while (n!=2);
  	}


	private static void mostrarDatos(String[][] datos, int i) {
		// TODO Auto-generated method stub
		System.out.println("Datos del Alumno");
		System.out.println("");
		System.out.println("Rut: "+datos[i][0]);
		System.out.println("Nombre: "+datos[i][1]);
		System.out.println("Apellido Paterno: "+datos[i][2]);
		System.out.println("Apellido Materno: "+datos[i][3]);
		System.out.println("Número de Contacto: "+datos[i][4]);
		System.out.println("Correo: "+datos[i][5]);
		System.out.println("Fecha de Nac: "+datos[i][6]);
		System.out.println("");
	}


	// Validaciones
	public static boolean esNumero(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	
	private static boolean validarRut(String rut) {
		// TODO Auto-generated method stub
		boolean banderaFormatoCuerpo,banderaFormatoDv,banderaInDv, retorno ;
		int contadorEsNumero,contadorPara,contadorInDv;
		
		String cuerpo, cuerpoNumero, dv, numeroR, restoAux, subRut;
	
		int multiplicador, multiplicar, numer, restaResto, resto;
	
		int sumaMultiplicacion,variableParaMultiplicacion, variableParaValidar;
	
		// Declaracion de variables
		// Variables globales
		banderaInDv = false;
		banderaFormatoDv = false;
		banderaFormatoCuerpo = true;
		dv = "";
		cuerpo = "";
		cuerpoNumero = "";
		contadorInDv = -1;
		
		for (contadorPara=0;contadorPara<=rut.length()-1;contadorPara++) {
			subRut = rut.substring(contadorPara,contadorPara+1);
			if ((subRut.equals("-") || banderaInDv==true)) {
				contadorInDv = contadorInDv+1;
				banderaInDv = true;
				if ((esdv(subRut)==true)) {
					dv = dv.concat(subRut);
				}
			}
			if ((banderaInDv==false)) {
				if ((escuerpo(subRut)==true)) {
					cuerpo = cuerpo.concat(subRut);
				} else {
					banderaFormatoCuerpo = false;
				}
			}
		}
		// Validacion Cuerpo
		if (banderaFormatoCuerpo==true) {
			contadorEsNumero = 0;
			for (variableParaValidar=cuerpo.length()-1;variableParaValidar>=0;variableParaValidar--) {
				numeroR = cuerpo.substring(variableParaValidar,variableParaValidar+1);
				if ((esNumero(numeroR)==true)) {
					contadorEsNumero = contadorEsNumero+1;
					cuerpoNumero = cuerpoNumero.concat(numeroR);
				} else {
					contadorEsNumero = contadorEsNumero+1;
					if (contadorEsNumero==4 && variableParaValidar>1) {
						contadorEsNumero = 0;
					} else {
						banderaFormatoCuerpo = false;
						variableParaValidar = 0;
					}
				}
			}
		} else {
		}
		// Validacion DV
		if (contadorInDv==1 && !dv.equals("")) {
			banderaFormatoDv = true;
		}
		if (banderaFormatoCuerpo==true && banderaFormatoDv==true) {
			multiplicador = 2;
			sumaMultiplicacion = 0;
			resto = 0;
			
			for (variableParaMultiplicacion=0;variableParaMultiplicacion<=cuerpoNumero.length()-1;variableParaMultiplicacion++) {
				
				numer = Integer.parseInt(cuerpoNumero.substring(variableParaMultiplicacion,variableParaMultiplicacion+1));
				
				multiplicar = numer*multiplicador;
				// El resultado de las multiplicaciones se suman
				sumaMultiplicacion = sumaMultiplicacion+multiplicar;
				multiplicador = multiplicador+1;
				if (multiplicador>7) {
					multiplicador = 2;
				}
			}
			// Sacamos el resto de la suma, de la division en 11
			resto = sumaMultiplicacion%11;
			// Restar 11 al resultado del paso anterior (generar excepciones para 11 y 10)
			restaResto = 11-resto;
			switch (restaResto) {
			case 10:
				restoAux = "K";
				break;
			case 11:
				restoAux = "0";
				break;
			default:
				restoAux = Integer.toString(restaResto);
			}
			// Comparar el resultado del paso anterior con DV
			if (dv.toUpperCase().equals(restoAux.toUpperCase())) {
				System.out.println("RUT/RUN valido");
				retorno = true;
			} else {
				System.out.println("RUT/RUN invalido");
				retorno = false;
				
			}
		} else {
			System.out.println("RUT/RUN invalido");
			retorno = false;
		}
		return retorno;
		
	}
	
	
	public static boolean esdv(String letra) {
		boolean variableRetorno;
		if (letra.equals("0") || letra.equals("1") || letra.equals("2") || letra.equals("3") || letra.equals("4") || letra.equals("5") || letra.equals("6") || letra.equals("7") || letra.equals("8") || letra.equals("9") || letra.equals("K") || letra.equals("k")) {
			variableRetorno = true;
		} else {
			variableRetorno = false;
		}
		return variableRetorno;
	}

	public static boolean escuerpo(String letra) {
		boolean variableRetorno;
		if (letra.equals("0") || letra.equals("1") || letra.equals("2") || letra.equals("3") || letra.equals("4") || letra.equals("5") || letra.equals("6") || letra.equals("7") || letra.equals("8") || letra.equals("9") || letra.equals(".")) {
			variableRetorno = true;
		} else {
			variableRetorno = false;
		}
		return variableRetorno;
	}

	private static boolean validarCelular(String num) {
		// TODO Auto-generated method stub
		int cont;
		String digitos;
		boolean esvalido;
		int i;
		int j;
		
		boolean retorno;
		digitos = "0123456789";
		esvalido = true;
		i = 0;
		cont = 0;
		while ((esvalido==true && i<digitos.length())) {
			for (j=0;j<=num.length()-1;j++) {
				if (num.substring(j,j+1).equals(digitos.substring(i,i+1))) {
					cont = cont+1;
				}
			}
			i = i+1;
		}
		if ((cont!=num.length() || !num.substring(0,1).equals("9")|num.length()!=9)) {
			
			esvalido = false;
		}
		retorno = esvalido;
		return retorno;
	}


	private static boolean verificarEmail(String email) {
		// TODO Auto-generated method stub
		int arrobas;
		int cont;
		String cortado;
		boolean esvalido;
		int i;
		
		boolean retorno;
		cortado = "";
		arrobas = 0;
		cont = 0;
		esvalido = false;
		for (i=0;i<=email.length()-1;i++) {
			if (email.substring(i,i+1).equals("@")) {
				esvalido = true;
				arrobas = arrobas+1;
				cortado = email.substring(i+1,email.length());
				
			}
		}
		if (arrobas>1) {
			esvalido = false;
		} else {
			for (i=0;i<=cortado.length()-1;i++) {
				if ((cortado.substring(i,i+1).equals("."))) {
					cont = cortado.substring(0,i).length();
					cortado = cortado.substring(i+1,cortado.length()).toLowerCase();
				}
			}
		}
		if ((cortado.equals("com") || cortado.equals("cl") && cont>2)) {
			esvalido = true;
		} else {
			esvalido = false;
		}
		retorno = esvalido;
		return retorno;
	}


	private static boolean validarPalabra(String palabra) {
		// TODO Auto-generated method stub
		String consonantes;
		int cont;
		boolean existe;
		int i;
		int j;
	
		boolean retorno;
		existe = true;
		i = 0;
		cont = 0;
		consonantes = "abcdefghijklmnñopqrstuvwxyz";
		while ((existe==true && i<consonantes.length())) {
			for (j=0;j<=palabra.length()-1;j++) {
				if ((palabra.substring(j,j+1).equals(consonantes.substring(i,i+1)))) {
					cont = cont+1;
				}
			}
			i = i+1;
		}
		if ((palabra.length()!=cont)) {
			existe = false;
		}
		retorno = existe;
		return retorno;
	}
	
	
}


