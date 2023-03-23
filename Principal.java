import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author MARINA
 * MODELO DE PARAFARMACIA ONLINE QUE DISPONE DE DISTINTOS PRODUCTOS LOS CUALES
 * SE PUEDEN CONSULTAR EL PRECIO Y LA FARMACIA QUE LO ENVÍA O DONDE SE ENCUENTRA
 * ADEMÁS DE AÑADIR O MODIFICAR PRODUCTOS AL CARRITO PRODUCTOS DISPONIBLES PARA AÑADIR AL CARRITO
 * REALIZAMOS UN SWITCH PARA PODER ELEGIR LAS DISTINTAS OPCIONES
 * QUE SON MÉTODOS PROPUESTOS LLAMADOS DESDE LA PARTE DE OPERACIONES
 *
 */

public class Principal {

	private static final String String = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// MODELO DE PARAFARMACIA ONLINE QUE DISPONE DE DISTINTOS PRODUCTOS LOS CUALES
		// SE PUEDEN
		// CONSULTAR EL PRECIO Y LA FARMACIA QUE LO ENVÍA O DONDE SE ENCUENTRA
		// ADEMÁS DE AÑADIR O MODIFICAR PRODUCTOS AL CARRITO

		// PRODUCTOS DISPONIBLES PARA AÑADIR AL CARRITO
		// REALIZAMOS UN SWITCH PARA PODER ELEGIR LAS DISTINTAS OPCIONES
		// QUE SON MÉTODOS PROPUESTOS LLAMADOS DESDE LA PARTE DE OPERACIONES

		int opcion;
		
		/**
		 * @param 
		 */

		do {
			System.out.println("Elige una de las siguientes opciones\n");
			System.out.println("[1]Añadir\n");
			System.out.println("[2]Modificar\n");
			System.out.println("[3]Borrar el contenido\n");
			System.out.println("[4]Buscar producto\n");
			System.out.println("[5]Salir\n");
			Scanner lector = new Scanner(System.in);
			opcion = lector.nextInt();
			lector.nextLine();
			switch (opcion) {
			case 1:
				Operaciones.anadir(String, String);
				break;
			case 2:
				Operaciones.modificar(String);
				break;
			case 3:
				Operaciones.borrarProducto();
				break;
			case 4:
				Operaciones.buscarProducto();
				break;
			case 5:
				Operaciones.salir();
				break;
			}
		} while (opcion > 5 && opcion < 1);
		
		/**
		 * Método que nos devuelve el menu con todas las opciones
		 * @return La opcion escogida
		 */
	}

	public static String[] visualizarproducto() {

		// PRODUCTOS DISPONIBLES PARA AÑADIR AL CARRITO
		// HE REALIZADO UN MÉTODO POR CADA LISTA DE OBJETOS PARA QUE A LA HORA DE
		// ESCRIBIR CÓDIGO
		// SEA MÁS SENCILLO
		
		/**
		 * @param producto Tenemos los distintos productos que se pueden añadir al carrito
		 */

		String[] producto = { "gel", "crema", "serum", "contorno de ojos", "rimel", "pintalabios", "tonico",
				"limpiador", "agua micelar", "agua termal", "bronceador", "base de maquillaje", "prebase", "colorete",
				"lapiz de ojos", "crema solar cara", "crema solar cuerpo" };

		return producto;
	}

	public static int[] visualizarprecio() {

		// PRECIO DE LOS PRODUCTOS
		int[] precio = { 10, 12, 20, 15, 7, 13, 11, 9, 16, 14, 19, 18, 5, 6, 21, 25, 22, 23, 25, 24 };

		return precio;

	}

	public static String[] visualizarfarmacia() {

		// FARMACIA EN LA QUE SE ENCUENTRA EL PRODUCTO
		String[] farmacia = { "farmacia trebol", "farmacia Alcorcon", "farmacia Alcobendas", "farmacia Alcorcon",
				"farmacia sol", "farmacia Alcobendas", "farmacia trebol", "farmacia trebol", "farmacia sol",
				"farmacia trebol", "farmacia Alcobendas", "farmacia Alcobendas", "farmacia sol", "farmacia Alcorcon",
				"farmacia Alcorcon", "farmacia Alcobendas", "farmacia sol", "farmacia Alcobendas",
				"farmacia Alcobendas" };

		return farmacia;

	}

	public static void inicializar(String datoproducto, int datoprecio, String datofarmacia) {

		// SE REALIZA ESTE MÉTODO PARA PODER LLEVARLO A CADA UNO DE LOS MÉTODOS QUE SE
		// REALIZA
		// YA QUE INICIALIZAR ES UNA BUENA PRÁCTICA
		
		/**
		 * Método que inicializa todos los array (precio, producto y farmacia)
		 */

		String[] producto;
		producto = visualizarproducto();

		int[] precio;
		precio = visualizarprecio();

		String[] farmacia;
		farmacia = visualizarfarmacia();

		for (int i = 0; i < producto.length; i++) {
			producto[i] = datoproducto;
		}
		for (int i = 0; i < precio.length; i++) {
			precio[i] = datoprecio;
		}
		for (int i = 0; i < farmacia.length; i++) {
			farmacia[i] = datofarmacia;
		}

	}
}
