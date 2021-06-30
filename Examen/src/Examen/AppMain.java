package Examen;

import java.util.ArrayList;

public class AppMain extends Entrada {

	public void ImrimirMenu() {

		System.out.println();
		System.out.println("=SISTEMA SINSA CONSOLE=");
		System.out.println("1. Productos");
		System.out.println("2. Comprar");
		System.out.println("3. Cambiar ruta");
		System.out.println("4. Salir");

	}

	public void SubMenuCompraVenta() {

		System.out.println();
		System.out.println("=PRODUCTOS=");
		System.out.println("1. INGRESAR/COMPRAR");
		System.out.println("2. LISTAR");
		System.out.println("3. ELIMINAR");
		System.out.println("4. MODIFICAR");
		System.out.println("5. VENDER");
		System.out.println("6. SALIR");
	}

	public static void main(String[] args) {

		AppMain a = new AppMain();

		
		ArrayList<Producto> Aproduct = new ArrayList<Producto>();

		Producto p = new Producto();
		int sub = 0;
		int cantidad = 0;
		int vender = 0;

		System.out.println("Antes de iniciar el programa debe elegir la ruta donde estaran todos los archivos: ");
		System.out.println("Puede cambiar esto más tarde");
		
		//Guardamos la ruta
		a.RutaArchivo();

		do {
			
			a.ImrimirMenu();
			a.ComprobarEntero("Opcion");

			switch (a.ComprobarEntero()) {

			case 1:

				do {
					a.SubMenuCompraVenta();
					sub = a.ComprobarEntero("Opcion");

					switch (sub) {

					
					
					case 1:
						Aproduct.clear();

						System.out.print("Ingrese el codigo del producto: ");
						p.setCodigo(a.ComprobarString("Codigo"));
						System.out.println();

						System.out.print("Ingrese el nombre del producto: ");
						p.setNombre(a.ComprobarString("Nombre"));
						System.out.println();
						p.setCantidad(0);

						System.out.print("Ingrese el precio del producto: ");
						p.setPrecio(a.ComprobarDouble("Precio"));
						System.out.println();

						System.out.print("Ingrese la existencia minima: ");
						p.setExistencia(a.ComprobarEntero("Existencia"));
						System.out.println();

						Aproduct.add(p);

						a.GuardarArchivo(a.RutaArchivoFinal(), Aproduct);

						break;

					case 2:
						if (a.ComprobarArchivo(a.RutaArchivoFinal()) == 0) {

							Aproduct.clear();
							a.LeerArchivo(a.RutaArchivoFinal(), Aproduct);
						}
						break;

					case 3:
						if (a.ComprobarArchivo(a.RutaArchivoFinal()) == 0) {

							Aproduct.clear();
							a.LeerArchivo(a.RutaArchivoFinal(), Aproduct);
							System.out.println("Seleccione la que desea eliminar: ");
							a.ComprobarEntero("Opcion a eliminar");
					
						 if(a.Contador()<a.ComprobarEntero()) {
								System.out.println("Ingrese una de las opciones disponibles");
							}else if(a.DeseaContinuar("Esta seguro que desea eliminar?") == 1 ) {
								a.Eliminar(a.ComprobarEntero(), a.RutaArchivoFinal(), Aproduct);

							}
						}
						break;

					case 4:

						if (a.ComprobarArchivo(a.RutaArchivoFinal()) == 0) {

							Aproduct.clear();
							a.LeerArchivo(a.RutaArchivoFinal(), Aproduct);
							System.out.println("Seleccione el que desea modificar: ");
							a.ComprobarEntero("Opcion a modificar");
							
							
							 if(a.Contador()<a.ComprobarEntero()) {
									System.out.println("Ingrese una de las opciones disponibles");
								}else if(a.DeseaContinuar("Esta seguro que desea modificar?") == 1) {
									a.Modificar(a.ComprobarEntero(), a.RutaArchivoFinal(), Aproduct);

								}

						}

						break;

					case 5:

						if (a.ComprobarArchivo(a.RutaArchivoFinal()) == 0) {

							Aproduct.clear();
							a.LeerArchivo(a.RutaArchivoFinal(), Aproduct);
							System.out.println("Seleccione el que desea vender: ");
							vender = a.ComprobarEntero("Opcion a vender");
							
							
							 if(a.Contador()<vender) {
									System.out.println("Ingrese una de las opciones disponibles");
								}else{
									System.out.println("Seleccione la cantidad a vender: ");
									cantidad = a.ComprobarEntero("Cantidad a vender");
									a.Vender(cantidad, vender, a.RutaArchivoFinal(), Aproduct);
									a.GuardarArchivoVenta(cantidad, vender, a.RutaArchivoFinal(), Aproduct);
								}

							
							

						}
						break;

					default:
						break;
					}

				} while (sub != 6);

				break;

			case 2:

				if (a.ComprobarArchivo(a.RutaArchivoFinal()) == 0) {

					Aproduct.clear();
					a.LeerArchivo(a.RutaArchivoFinal(), Aproduct);
					System.out.println("Seleccione el que desea comprar: ");
					int compra = a.ComprobarEntero("Opcion a vender");
					
					 if(a.Contador()<compra) {
							System.out.println("Ingrese una de las opciones disponibles");
						}else{
							System.out.println("Seleccione la cantidad a comprar: ");
							cantidad = a.ComprobarEntero("Cantidad a comprar");
							a.Compra(cantidad, compra, a.RutaArchivoFinal(), Aproduct);
							a.GuardarArchivoCompra(cantidad, compra, a.RutaArchivoFinal(), Aproduct);
								}

			
					
					
				}

				break;

			case 3:
				a.RutaArchivo();

				break;

			default:
				break;
			}

		} while (a.ComprobarEntero() != 4);

		System.out.println("Gracias por usar mi programa <3");

	}

}
