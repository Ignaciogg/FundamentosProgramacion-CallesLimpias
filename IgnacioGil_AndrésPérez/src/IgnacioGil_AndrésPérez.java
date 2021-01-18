import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IgnacioGil_AndrésPérez {

	public static int matriz_a_CSV (String[][] inventario, String ruta) {

		//COMMIT DE PRUEBA
		System.out.println("No se puede abrir el fichero");
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

	public static int imprimir_menu () {
		int opcion = 0;
		Scanner teclado = new Scanner(System.in);

		System.out.print(
				"Bienvenido al Proyecto de Programación nº3: Calles limpias de nieve \n"+
				"\n-------- Elija el municipio sobre el que quiere trabajar --------" + "\n" +
				"  0 - Salir" + "\n" +
				"  1 - Madrid centro" + "\n" +
				"  2 - Villaviciosa de Odón" + "\n" +
				"  3 - Las Rozas" + "\n" +
				"  4 - Las Matas" + "\n" +
				"  5 - Torrelodones" + "\n" +
				"  6 - Borrar item" + "\n" +
				"  7 - Guardar datos actuales en inventario.csv" + "\n"+

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

	public static void main(String[] args) {
		int opcion = -1;

		while (opcion != 0) {
			opcion = imprimir_menu();
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
