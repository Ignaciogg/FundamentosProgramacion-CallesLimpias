import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IgnacioGil_AndrésPérez {

	public static int matriz_a_CSV (String[][] inventario, String ruta) {

		int num_lineas = 0;
		try {
			FileWriter fichero = new FileWriter(ruta);

			for(int i = 0; i<inventario.length; i++){
				for(int c = 0; c<inventario[i].length; c++){
					fichero.write(inventario[i][c] + "\n");
					num_lineas  ++;
				}
			}
            fichero.close();

		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("No se puede abrir el fichero");
		}

		return num_lineas;
	}

	public static int menuPrincipal () {
		Scanner teclado = new Scanner(System.in);
		int opcion = 0;

		System.out.print(
				"\n-------- Elija el municipio sobre el que quiere trabajar --------" + "\n" +
				"  0 - Salir" + "\n" +
				"  1 - Agregar Municipio" + "\n" +
				"  2 - Cargar y Editar Municipio" + "\n" +
				"  3 - Eliminar Municipio" + "\n" +
				"  4 - Guardar" + "\n" +

				"Opción: "
		);

		if (teclado.hasNextInt()) {
			opcion = teclado.nextInt();
		}
		else {
			teclado.next();
		}
		return opcion;
	}

	public static int seleccionar_ID(int ID){
		Scanner teclado = new Scanner(System.in);
		boolean valido = false;
		System.out.println("Introduce el ID del municipio con el que quieres trabajar (ej:1): ");
		if (teclado.hasNextInt()) {
			ID = teclado.nextInt();
			//Siempre serán mayores que 0 y el máximo de la CdM son 179 municipios
			if(ID > 0 && ID <= 179){
				valido = true;
			}
		}
		else
			System.out.println("ERROR al introducir el ID");
		if(valido == true){
			System.out.println("Valor del ID válido");
			return ID;
		}
		else{
			System.out.println("ERROR, ID con valor erróneo");
			return 0;
		}
	}

	public static int menuEdicion (int iD) {
		Scanner teclado = new Scanner(System.in);
		int opcion = 0;

		System.out.print(
				"\n-------- Elija la opción --------" + "\n" +
				"  0 - Volver" + "\n" +
				"  1 - Cargar Municipio" + "\n" +
				"  2 - Actualizar Municipio" + "\n" +
				"  3 - Eliminar Municipio" + "\n" +

				"Opción: "
		);

		while (!teclado.hasNextInt()) {
			System.out.println("Opcion incorrecta");
			teclado.next();
		}
		opcion = teclado.nextInt();

		return opcion;
	}

	public static void nuevo_dataframe() {

		Scanner teclado = new Scanner(System.in);
        System.out.println("Nombre del fichero nuevo: ");
        teclado = new Scanner(System.in);
        while (!teclado.hasNext()) {
            System.out.println("Ingresa un nombre correcto!");
            teclado.nextLine();
        }
        String path_dataframe;
        path_dataframe = teclado.nextLine();
        File fichero = new File(path_dataframe);
        boolean resultado;
        try {
            resultado = fichero.createNewFile();
            if (resultado) {
                System.out.println("Se ha creado un nuevo fichero en: " + fichero.getCanonicalPath());
            } else {
                System.out.println("Fichero ya existe!");
            }

        } catch (IOException e) {
            System.out.println("Ha Ocurrido un  Error inesperado");

        }
    }

	// Funcion: Cargar DataFrame existente.
    public static void cargar_fichero(String path_fichero) {

    	Scanner teclado = new Scanner(System.in);
        System.out.println("\nNombre del fichero a cargar: ");
        teclado = new Scanner(System.in);
        while (!teclado.hasNext()) {
            System.out.println("Ingresa un nombre correcto!");
            teclado.nextLine();
        }
        path_fichero = teclado.nextLine();
        File fichero = new File(path_fichero);
        try {
            Scanner leer = new Scanner(fichero);

            while (leer.hasNextLine()) {
                System.out.println(" " + leer.nextLine());
            }
            leer.close();
            System.out.println("Fichero cargado con exito!");

        } catch (IOException e) {
            System.out.println("Error: Fichero no encontrado!");
        }
    }

    // Funcion Auxiliar
    public static void mostrar_matriz(String[][] Matrix) {
        System.out.print("Datos agregados: \n");
        System.out.println(" ");
        for (int t = 0; t < Matrix.length; t++) {
            for (int d = 0; d < Matrix[0].length; d++) {
                System.out.print(Matrix[t][d]);
            }
            System.out.println("");
        }
    }

	private static boolean añadirMunicipio(String[][] municipio1, int cont, boolean calles) {

		Scanner teclado = new Scanner(System.in);
		String nombre = null;
		int codigoPostal = 0;
		int poblacion = 0;
		char answer = 'a';
		boolean continua = true;
		boolean continua2  = true;

		System.out.println("Introduce el nombre del nuevo municipio: ");
		if (teclado.hasNextLine()) {
			nombre = teclado.nextLine();
		}
		else
			System.out.println("ERROR al introducir el nombre");

		System.out.println("Introduce el Código Postal del nuevo municipio: ");
		if (teclado.hasNextInt()) {
			codigoPostal = teclado.nextInt();

		}
		else{
			System.out.println("ERROR al introducir el Código Postal");
			continua = false;
		}

		if(continua == true){
			System.out.println("Introduce la población del nuevo municipio: ");
			if (teclado.hasNextInt()) {
				poblacion = teclado.nextInt();
			}
			else{
				System.out.println("ERROR al introducir la población");
				continua2 = false;
			}

			if(continua2 == true){
				//ESCRIBE EN FICHERO
				BufferedWriter bw = null;
			      try {
			    	  bw = new BufferedWriter(new FileWriter("municipios.csv", true));
			    	  bw.write(cont + "\n" + nombre + "\n" + codigoPostal + "\n" + poblacion );
			    	  bw.newLine();
			    	  bw.flush();
			    	  } catch (IOException ioe) {
			    		  ioe.printStackTrace();
			    		  } finally {
			    			  if (bw != null)
			    				  try {
			    					  bw.close();
			    				  } catch (IOException ioe2) {

			    				  }
			    			  }
			      System.out.println("¿Quiere introducir ahora los datos de las calles de " + nombre + "?\n(S/s= SI, N/n = NO)");
			      answer = teclado.next().charAt(0);
			      if (answer == 's' || answer == 'S' || answer == 'n' || answer == 'N'){
			    	  if(answer == 's' || answer == 'S')
			    		  calles = true;
			      }
			      else
			    	  System.out.println("Letra incorrecta");
			}
		}
		return calles;
	}

	public static void main(String[] args) {
		int opcion = -1;
		int opcion2 = -1;
		int cont = 0;
		int ID = 0;
		boolean calles = false;

		String [][] municipios = {{}};
		matriz_a_CSV(municipios, "municipios.csv");

		System.out.println("Bienvenido al Proyecto de Programación nº3: Calles limpias de nieve");
		while (opcion != 0) {
			opcion = menuPrincipal();
			switch (opcion) {
			case 1: //AÑADIR MUNICIPIO
				cont ++;
				añadirMunicipio(municipios, cont, calles);
				if(calles == true)
					System.out.println("continuar");
				break;
			case 2:
				seleccionar_ID(ID);
				while (opcion2 != 0) {
					opcion2 = menuEdicion(ID);
					switch(opcion2){
					case 1:
						break;
					case 2:
						break;
					}
				}

				break;
			case 3:
				cont--;

				break;
			case 4:

				break;
			case 0:
				System.out.println("¡Hasta Pronto!");
				break;
			default:
				System.out.println("Opción incorrecta!");
			}
		}
	}


}
