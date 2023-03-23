import java.util.Arrays;
import java.util.Scanner;

public class Operaciones {

	public static void anadir(String nuevoProducto, String productos) {

		String[] producto;
		producto = Principal.visualizarproducto();
		String[] anadidos = new String[3];
		Scanner lector = new Scanner(System.in);
		int longitudA = producto.length;
		int longitudB = anadidos.length;
		String[] listaproductos = new String[longitudA + longitudB];
		int[] precio;
		precio = Principal.visualizarprecio();
		int suma = 0;
		int p = 0;

		Principal.inicializar(nuevoProducto, p, productos);


		// se crea otro array de 3 posiciones para añadir los 3 productos para que el
		// total
		// de productos sea 20. Se llenan las posiciones almacenando los 3 productos
		// elegidos
		// por pantalla. Se Utiliza el buble for para añadir los 3 productos que pide
		System.out.println("Solo puede añadir 3 productos más al carrito");
		for (int i = 0; i < anadidos.length; i++) {
			System.out.println("Escoja producto");
			nuevoProducto = lector.nextLine();
			anadidos[i] = nuevoProducto;

			System.out.println(Arrays.toString(anadidos));
			System.out.println(Arrays.toString(producto));

		}

		// una vez se tienen los dos arrays completos, se procede a unirlos mediante un
		// bucle for
		// se une de tal forma para que los nuevos productos queden en las primeras
		// posiciones
		// del nuevo array con todos los productos y no se cambien por posiciones del
		// array original

		for (int i = 0; i < anadidos.length; i++) {
			listaproductos[p] = anadidos[i];
			p++;
		}

		for (int i = 0; i < producto.length; i++) {
			listaproductos[p] = producto[i];
			p++;
		}

		System.out.println("Lista Llena, no puede introducir más productos");

		System.out.println("Los productos de su carrito son: ");

		System.out.println(Arrays.toString(listaproductos));

		// como aportación extra devuelve el precio de todos los productos, haciendo la
		// suma de todos
		// a través de un bucle for
		for (int i = 0; i < precio.length; i++) {
			suma = suma + precio[i];
		}
		System.out.println("El precio total de su compra es = " + suma + " euros");

	}

	public static void modificar(String nuevodato) {

		String[] producto;
		producto = Principal.visualizarproducto();
		int contador = 0;
		boolean encontrado = true;
		String productoAntiguo = "XX";
		String productoNuevo = "XX";
		String[] datoNuevo = new String[1];
		datoNuevo[0] = nuevodato;

		Principal.inicializar(productoAntiguo, contador, productoNuevo);

		System.out.println("Ingrese el producto que desea modificar");
		Scanner lector = new Scanner(System.in);
		productoAntiguo = lector.nextLine();

		// primero se busca con un buble while la posición del producto que quiero que
		// ya no esté
		// (productoAntiguo) en la lista de productos introduciendo un valor de XX
		while (contador < producto.length) {
			if (producto[contador].equals(productoAntiguo)) {
				encontrado = true;
				producto[contador] = productoNuevo;

				System.out.println("Ingrese el nuevo producto");
				for (int i = 0; i < datoNuevo.length; i++) {
					System.out.println("Escoja producto");
					nuevodato = lector.nextLine();
					datoNuevo[0] = nuevodato;
					System.out.println(Arrays.toString(datoNuevo));

				}

				for (int i = 0; i < producto.length; i++) {
					if (producto[i].equals("XX")) {
						producto[i] = datoNuevo[0];
					}
				}
				System.out.println(Arrays.toString(producto));

			} else {
				encontrado = false;

			}
			contador++;
		}

	}

	public static void borrarProducto() {

		String[] producto;
		producto = Principal.visualizarproducto();
		String productoEliminado = "";
		int contador = 0;
		boolean encontrado = false;
		int longitud = producto.length;

		Principal.inicializar(productoEliminado, longitud, productoEliminado);

		// pedirmos por pantalla el producto que deseamos eliminar
		System.out.println("Ingrese el producto a eliminar");
		Scanner lector = new Scanner(System.in);
		productoEliminado = lector.nextLine();

		// necesitamos que un bucle que itere hasta que haya encontrado la posición
		// buscada
		// y para ello hacemos uso del bucle while, una vez que lo encuentra no recorre
		// más
		// el array, en este caso he eliminado el producto poniendo una posición vacía
		// ya
		// que no se puede borrar un elemento de un array

		do {
			if (producto[contador].equals(productoEliminado)) {
				producto[contador] = " ";
				encontrado = true;
			}
			contador++;

		} while (contador < longitud && !encontrado);

		System.out.println(Arrays.toString(producto));
	}

	public static void buscarProducto() {

		int opcionbusqueda = 0;

		// bucle do while con estructura switch para elegir una opción y que resuelva
		// solo lo que
		// pedimos

		do {
			System.out.println("Elija el criterio de búsqueda");
			System.out.println("[1]Buscar por producto\n");
			System.out.println("[2]Filtrar precios\n");
			System.out.println("[3]Buscar por farmacia\n");
			Scanner lector = new Scanner(System.in);
			opcionbusqueda = lector.nextInt();
			lector.nextLine();
			switch (opcionbusqueda) {
			case 1:
				buscarelproducto();
				break;
			case 2:
				buscarporprecio();
				break;
			case 3:
				buscarporfarmacia();
				break;
			}
		} while (opcionbusqueda > 4 && opcionbusqueda < 1);

	}

	public static void buscarelproducto() {

		String[] producto;
		producto = Principal.visualizarproducto();

		int[] precio;
		precio = Principal.visualizarprecio();

		String[] farmacia;
		farmacia = Principal.visualizarfarmacia();

		String buscarProducto;
		boolean encontrado = false;
		int contador = 0;
		int longitud;

		longitud = producto.length;

		System.out.println("Ingrese un producto a buscar: ");
		Scanner lector = new Scanner(System.in);
		buscarProducto = lector.nextLine();
		// bucle do while para buscar el producto comparandolo con su nombre, una vez
		// que lo
		// encuentra también nos imprime por pantalla el precio y la farmacia
		do {
			if (producto[contador].equals(buscarProducto)) {
				System.out.println("el precio es de " + precio[contador] + " euros y la farmacia disponible es  "
						+ farmacia[contador] + "");
				encontrado = true;
			}
			contador++;
		} while (contador < longitud && !encontrado);

	}

	public static void buscarporprecio() {

		String[] producto;
		producto = Principal.visualizarproducto();

		int[] precio;
		precio = Principal.visualizarprecio();

		String[] farmacia;
		farmacia = Principal.visualizarfarmacia();

		int buscarprecio;
		boolean encontrado = false;
		int opcionbusqueda;

		for (int i = 0; i < precio.length; i++) {

		}
		// for dentro de Switch no sé si será una buena práctica pero es lo único que se
		// me ha ocurrido para que el
		// usuario pueda filtrar en base a un rango de precios
		// para ello se tiene que recorrer todo el array de precios y el contador
		// que resulte con ese criterio de rango de precios es igual al precio y se
		// imprime
		// también a qué producto pertenece y su precio. Podría haberlo hecho sin
		// opciones
		// para teclear y con un bucle for y la estructura else if mostrando todos los
		// precios
		// con sus productos

		do {
			System.out.println("Escoja el rango de precios");
			System.out.println("[1]Entre 5 y 10 euros");
			System.out.println("[2]Entre 10 y 15 euros");
			System.out.println("[3]Entre 15 y 20 euros");
			System.out.println("[4]Entre 20 y 25 euros");
			Scanner lector = new Scanner(System.in);
			buscarprecio = lector.nextInt();
			lector.nextLine();
			switch (buscarprecio) {
			case 1:
				for (int i = 0; i < precio.length; i++) {
					if (precio[i] > (4) && precio[i] < (11)) {
						System.out.println("el precio disponeble es de " + precio[i] + " euros y su producto es<< "
								+ producto[i] + ">>situado en la farmacia " + farmacia[i]);
					}
				}
				break;
			case 2:
				for (int i = 0; i < precio.length; i++) {
					if (precio[i] > (11) && precio[i] < (16)) {
						System.out.println("el precio disponeble es de " + precio[i] + " euros y su producto es<< "
								+ producto[i] + ">>situado en la farmacia " + farmacia[i]);
					}
				}
				break;
			case 3:
				for (int i = 0; i < precio.length; i++) {
					if (precio[i] > (16) && precio[i] < (21)) {
						System.out.println("el precio disponeble es de " + precio[i] + " euros y su producto es<<"
								+ producto[i] + ">>situado en la farmacia " + farmacia[i]);
					}
				}
				break;
			case 4:
				for (int i = 0; i < precio.length; i++) {
					if (precio[i] > (21) && precio[i] < (26)) {
						System.out.println("el precio disponeble es de " + precio[i] + " euros y su producto es<< "
								+ producto[i] + ">>situado en la farmacia " + farmacia[i]);
					}
				}
				break;
			}
		} while (buscarprecio > 5 && buscarprecio < 1);

	}

	public static void buscarporfarmacia() {

		// para simplificar la búsqueda se ha realizado un menú de opciones y se ha
		// creado
		// un método para cada farmacia

		int opcion = 0;
		do {
			System.out.println("Escoga la farmacia para buscar sus productos");
			System.out.println("[1]Farmacia Trebol");
			System.out.println("[2]Farmacia Alcobendas");
			System.out.println("[3]Farmacia Alcorcon");
			System.out.println("[4]Farmacia Sol");
			Scanner lector = new Scanner(System.in);
			opcion = lector.nextInt();
			lector.nextLine();
			switch (opcion) {
			case 1:
				buscarfarmaciaTrebol();
				break;
			case 2:
				buscarfarmaciaAlcobendas();
				break;
			case 3:
				buscarfarmaciaAlcorcon();
			case 4:
				buscarfarmaciaSol();
				break;
			}
		} while (opcion > 4 && opcion < 1);
	}

	public static void buscarfarmaciaTrebol() {

		String[] producto;
		producto = Principal.visualizarproducto();

		String[] farmacia;
		farmacia = Principal.visualizarfarmacia();

		String[] farmaciaTrebol = new String[17];
		String productos = "";

		System.out.println("Productos que hay en la farmacia trebol");

		// buscamos con el bucle for ya que recorre todo el array y nos muestra todos
		// los
		// productos que tiene dicha farmacia
		// Igual para el resto de farmacias

		for (int i = 0; i < producto.length; i++) {

		}

		// buscamos comparandolo con su mismo dato string
		for (int i = 0; i < farmacia.length; i++) {
			if (farmacia[i].equals("farmacia trebol")) {
				farmacia[i] = producto[i];
			}
		}
		// después buscamos comparando el contador del anterior bucle con el contador
		// del producto de dicha farmacia
		for (int i = 0; i < producto.length; i++) {
			if (farmacia[i] == producto[i]) {
				farmaciaTrebol[i] = producto[i];
			} else {
				farmaciaTrebol[i] = productos;
			}

		}

		System.out.println(Arrays.toString(farmaciaTrebol));
	}

	public static void buscarfarmaciaAlcobendas() {

		String[] producto;
		producto = Principal.visualizarproducto();

		String[] farmacia;
		farmacia = Principal.visualizarfarmacia();

		String[] farmaciaAlcobendas = new String[17];
		String productos = "";

		System.out.println("Productos que hay en la farmacia Alcobendas");

		for (int i = 0; i < producto.length; i++) {

		}

		for (int i = 0; i < farmacia.length; i++) {
			if (farmacia[i].equals("farmacia Alcobendas")) {
				farmacia[i] = producto[i];
			}
		}
		for (int i = 0; i < producto.length; i++) {
			if (farmacia[i] == producto[i]) {
				farmaciaAlcobendas[i] = producto[i];
			} else {
				farmaciaAlcobendas[i] = productos;
			}

		}

		System.out.println(Arrays.toString(farmaciaAlcobendas));
	}

	public static void buscarfarmaciaAlcorcon() {

		String[] producto;
		producto = Principal.visualizarproducto();

		String[] farmacia;
		farmacia = Principal.visualizarfarmacia();

		String[] farmaciaAlcorcon = new String[17];
		String productos = "";

		System.out.println("Productos que hay en la farmacia Alcorcon");

		for (int i = 0; i < producto.length; i++) {

		}

		for (int i = 0; i < farmacia.length; i++) {
			if (farmacia[i].equals("farmacia Alcorcon")) {
				farmacia[i] = producto[i];
			}
		}
		for (int i = 0; i < producto.length; i++) {
			if (farmacia[i] == producto[i]) {
				farmaciaAlcorcon[i] = producto[i];
			} else {
				farmaciaAlcorcon[i] = productos;
			}

		}

		System.out.println(Arrays.toString(farmaciaAlcorcon));
	}

	public static void buscarfarmaciaSol() {

		String[] producto;
		producto = Principal.visualizarproducto();

		String[] farmacia;
		farmacia = Principal.visualizarfarmacia();

		String[] farmaciaSol = new String[17];
		String productos = "";

		System.out.println("Productos que hay en la farmacia Sol");

		for (int i = 0; i < producto.length; i++) {

		}

		for (int i = 0; i < farmacia.length; i++) {
			if (farmacia[i].equals("farmacia sol")) {
				farmacia[i] = producto[i];
			}
		}
		for (int i = 0; i < producto.length; i++) {
			if (farmacia[i] == producto[i]) {
				farmaciaSol[i] = producto[i];
			} else {
				farmaciaSol[i] = productos;
			}

		}

		System.out.println(Arrays.toString(farmaciaSol));
	}

	public static void salir() {

		System.out.println("Gracias por su compra");
	}

}
