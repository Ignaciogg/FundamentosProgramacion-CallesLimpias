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
				"Bienvenido al Proyecto de Programación nº3: Calles limpias de nieve \n"+
				"\n-------- Elija el municipio sobre el que quiere trabajar --------" + "\n" +
				"  0 - Salir" + "\n" +
				"  1 - Agregar Municipio" + "\n" +
				"  2 - Cargar y Editar Municipio" + "\n" +
				"  3 - Eliminar Municipio" + "\n" +

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

	public static int menuEdicion () {
		Scanner teclado = new Scanner(System.in);
		int opcion = 0;

		System.out.print(
				"\n-------- Elija la opción --------" + "\n" +
				"  0 - Salir" + "\n" +
				"  1 - Agregar Municipio" + "\n" +
				"  2 - Cargar y Editar Municipio" + "\n" +
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

	public static void main(String[] args) {
		int opcion = -1;

		while (opcion != 0) {
			opcion = menuPrincipal();
			switch (opcion) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 0:
				break;
			default:
				System.out.println("Opción incorrecta!");
			}
		}
	}

}
