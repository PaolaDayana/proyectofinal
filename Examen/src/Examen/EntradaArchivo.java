package Examen;

/*
 * En esta clase creamos y editamos archivos
 * 
 * */

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JFileChooser;

public class EntradaArchivo {

	private JFileChooser chooser = new JFileChooser();
	private FileWriter fichero = null;
	private PrintWriter pw = null;
	private File archivo = null;
	private int contador = 0;
	private String fullPath;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
	private String fechaActual = sdf.format(new Date());
	private int Contador=0;
	
	public int Contador() {
		
		return Contador;
	}
	public void GuardarArchivo(String ruta, ArrayList<Producto> a) {

		try {
			archivo = new File(ruta + "/producto.day");
			// fichero = new FileWriter(archivo);

			if (!archivo.exists()) {
				fichero = new FileWriter(archivo);
				pw = new PrintWriter(fichero);

				for (int i = 0; i < a.size(); i++) {
					pw.println(i + ". ====");
					pw.println("Codigo: " + a.get(i).getCodigo());
					pw.println("Nombre: " + a.get(i).getNombre());
					pw.println("Cantidad: " + a.get(i).getCantidad());
					pw.println("Precio: " + a.get(i).getPrecio());
					pw.println("Existencia: " + a.get(i).getExistencia());
					pw.println("====");

				}
			} else {

				fichero = new FileWriter(archivo, true);

				pw = new PrintWriter(fichero);

				for (int i = 0; i < a.size(); i++) {
					pw.println(i + ". ====");
					pw.println("Codigo: " + a.get(i).getCodigo());
					pw.println("Nombre: " + a.get(i).getNombre());
					pw.println("Cantidad: " + a.get(i).getCantidad());
					pw.println("Precio: " + a.get(i).getPrecio());
					pw.println("Existencia: " + a.get(i).getExistencia());
					pw.println("====");

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero)
					fichero.close();
				System.out.println("Guardado con exito!");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public String RutaArchivo() {

		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int a = chooser.showOpenDialog(chooser);

		if (a == 0) {
			File file = chooser.getSelectedFile();
			fullPath = file.getAbsolutePath();
			return fullPath;

		} else {
			System.out.println("DEBE SELECCIONAR UNA RUTA PARA CONTINUAR");
			return "Cancelar";
		}

	}

	// Lo unico que hace es devolver la ruta obtenida más arriba
	public String RutaArchivoFinal() {

		return fullPath;

	}

	public void LeerArchivo(String ruta, ArrayList<Producto> a) {

		Producto p = new Producto();
		File file = new File(ruta + "/producto.day");

		contador = 0;
		if (!file.exists()) {
			System.out.println(file.getAbsolutePath());
			System.out.println("No existe ningun archivo en este directorio uwu");
		} else {

			try {

				Scanner sc = new Scanner(file);
Contador=0;
				while (sc.hasNextLine()) {

					String i = sc.nextLine();

					if (i.substring(0, 2).equals("Co")) {

						p.setCodigo(i.substring(8,i.length()));

					} else if (i.substring(0, 2).equals("No")) {

						p.setNombre(i.substring(8,i.length()));

					} else if (i.substring(0, 2).equals("Ca")) {

						p.setCantidad(Integer.parseInt(i.substring(10, i.length())));

					} else if (i.substring(0, 2).equals("Pr")) {

						p.setPrecio(Double.parseDouble(i.substring(8, i.length())));

					} else if (i.substring(0, 2).equals("Ex")) {

						p.setExistencia(Integer.parseInt(i.substring(12, i.length())));
						contador++;
						Contador++;
						a.add(p);
						p = new Producto();

					}

				}

				for (int i = 0; i < a.size(); i++) {
					System.out.println("=====" + (i + 1) + "=====");
					System.out.println("Codigo: " + a.get(i).getCodigo());
					System.out.println("Nombre: " + a.get(i).getNombre());
					System.out.println("Cantidad: " + a.get(i).getCantidad());
					System.out.println("Precio: " + a.get(i).getPrecio());
					System.out.println("Existencia: " + a.get(i).getExistencia());
					System.out.println();
				}

				sc.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}
	}

	public void Eliminar(int num, String ruta, ArrayList<Producto> a) {

		Producto p = new Producto();
		File file = new File(ruta + "/producto.day");
		a.clear();
		contador = 0;
		if (!file.exists()) {
			System.out.println(file.getAbsolutePath());
			System.out.println("No existe ningun archivo en este directorio uwu");
		} else {

			try {

				Scanner sc = new Scanner(file);

				while (sc.hasNextLine()) {

					String i = sc.nextLine();

					if (i.substring(0, 2).equals("Co")) {

						p.setCodigo(i.substring(8,i.length()));

					} else if (i.substring(0, 2).equals("No")) {

						p.setNombre(i.substring(8, i.length()));

					} else if (i.substring(0, 2).equals("Ca")) {

						p.setCantidad(Integer.parseInt(i.substring(10, i.length())));

					} else if (i.substring(0, 2).equals("Pr")) {

						p.setPrecio(Double.parseDouble(i.substring(8, i.length())));

					} else if (i.substring(0, 2).equals("Ex")) {

						p.setExistencia(Integer.parseInt(i.substring(12, i.length())));
						contador++;
						a.add(p);
						p = new Producto();
					}

				}
				sc.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			file.delete();

			// Parte que elimina
			a.remove(num - 1);
			GuardarArchivo(ruta, a);

			for (int i = 0; i < a.size(); i++) {
				System.out.println("=====" + (i + 1) + "=====");
				System.out.println("Codigo: " + a.get(i).getCodigo());
				System.out.println("Nombre: " + a.get(i).getNombre());
				System.out.println("Cantidad: " + a.get(i).getCantidad());
				System.out.println("Precio: " + a.get(i).getPrecio());
				System.out.println("Existencia: " + a.get(i).getExistencia());
				System.out.println();
			}
		}

	}

	public void Modificar(int num, String ruta, ArrayList<Producto> a) {

		Producto p = new Producto();
		File file = new File(ruta + "/producto.day");
		a.clear();
		contador = 0;
		if (!file.exists()) {
			System.out.println(file.getAbsolutePath());
			System.out.println("No existe ningun archivo en este directorio uwu");
		} else {

			try {

				Scanner sc = new Scanner(file);

				while (sc.hasNextLine()) {

					String i = sc.nextLine();

					if (i.substring(0, 2).equals("Co")) {

						p.setCodigo(i);

					} else if (i.substring(0, 2).equals("No")) {

						p.setNombre(i);

					} else if (i.substring(0, 2).equals("Ca")) {

						p.setCantidad(Integer.parseInt(i.substring(10, i.length())));

					} else if (i.substring(0, 2).equals("Pr")) {

						p.setPrecio(Double.parseDouble(i.substring(8, i.length())));

					} else if (i.substring(0, 2).equals("Ex")) {

						p.setExistencia(Integer.parseInt(i.substring(12, i.length())));
						contador++;
						a.add(p);
						p = new Producto();
					}

				}
				sc.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			file.delete();

			// Parte que modifica
			System.out.print("Ingrese el codigo: ");
			a.get(num - 1).setCodigo(p.ComprobarString("Codigo"));

			System.out.print("Ingrese el nombre: ");
			a.get(num - 1).setNombre(p.ComprobarString("Nombre"));

			System.out.print("Ingrese la cantidad: ");
			a.get(num - 1).setCantidad(p.ComprobarEntero("Cantidad"));

			System.out.print("Ingrese el nuevo precio: ");
			a.get(num - 1).setPrecio(p.ComprobarDouble("Precio"));

			System.out.print("Ingrese la nueva existencia: ");
			a.get(num - 1).setExistencia(p.ComprobarEntero("Existencia"));

			GuardarArchivo(ruta, a);

			for (int i = 0; i < a.size(); i++) {
				System.out.println("=====" + (i + 1) + "=====");
				System.out.println("Codigo: " + a.get(i).getCodigo());
				System.out.println("Nombre: " + a.get(i).getNombre());
				System.out.println("Cantidad: " + a.get(i).getCantidad());
				System.out.println("Precio: " + a.get(i).getPrecio());
				System.out.println("Existencia: " + a.get(i).getExistencia());
				System.out.println();
			}
		}

	}

	public void Vender(int cantidad, int num, String ruta, ArrayList<Producto> a) {

		Producto p = new Producto();
		File file = new File(ruta + "/producto.day");
		a.clear();
		contador = 0;
		if (!file.exists()) {
			System.out.println(file.getAbsolutePath());
			System.out.println("No existe ningun archivo en este directorio uwu");
		} else {

			try {

				Scanner sc = new Scanner(file);

				while (sc.hasNextLine()) {

					String i = sc.nextLine();

					if (i.substring(0, 2).equals("Co")) {

						p.setCodigo(i);

					} else if (i.substring(0, 2).equals("No")) {

						p.setNombre(i);

					} else if (i.substring(0, 2).equals("Ca")) {

						p.setCantidad(Integer.parseInt(i.substring(10, i.length())));

					} else if (i.substring(0, 2).equals("Pr")) {

						p.setPrecio(Double.parseDouble(i.substring(8, i.length())));

					} else if (i.substring(0, 2).equals("Ex")) {

						p.setExistencia(Integer.parseInt(i.substring(12, i.length())));
						contador++;
						a.add(p);
						p = new Producto();
					}

				}
				sc.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			// Parte que vende

			if ((a.get(num - 1).getCantidad() - cantidad) < 0) {
				System.out.println("NO HAY EN EXISTENCIA, COMPRE OTRA COSA");
			} else {

				a.get(num - 1).setCantidad(a.get(num - 1).getCantidad() - cantidad);

				GuardarArchivo(ruta, a);

				for (int i = 0; i < a.size(); i++) {
					System.out.println("=====" + (i + 1) + "=====");
					System.out.println("Codigo: " + a.get(i).getCodigo());
					System.out.println("Nombre: " + a.get(i).getNombre());
					System.out.println("Cantidad: " + a.get(i).getCantidad());
					System.out.println("Precio: " + a.get(i).getPrecio());
					System.out.println("Existencia: " + a.get(i).getExistencia());
					System.out.println();
				}
			}

		}

	}

	public void GuardarArchivoVenta(int cantidad, int num, String ruta, ArrayList<Producto> a) {

		try {
			archivo = new File(ruta + "/venta.day");
			// fichero = new FileWriter(archivo);

			if (!archivo.exists()) {
				fichero = new FileWriter(archivo);
				pw = new PrintWriter(fichero);

				pw.println(fechaActual + ". ====");
				pw.println("Codigo: " + a.get(num - 1).getCodigo());
				pw.println("Nombre: " + a.get(num - 1).getNombre());
				pw.println("Cantidad: " + a.get(num - 1).getCantidad());
				pw.println("Precio: " + a.get(num - 1).getPrecio());
				pw.println("Existencia: " + a.get(num - 1).getExistencia());
				pw.println("Total: " + (a.get(num - 1).getPrecio() * cantidad));
				pw.println("====");

			} else {

				fichero = new FileWriter(archivo, true);

				pw = new PrintWriter(fichero);

				pw.println(fechaActual + ". ====");
				pw.println("Codigo: " + a.get(num - 1).getCodigo());
				pw.println("Nombre: " + a.get(num - 1).getNombre());
				pw.println("Cantidad: " + a.get(num - 1).getCantidad());
				pw.println("Precio: " + a.get(num - 1).getPrecio());
				pw.println("Existencia: " + a.get(num - 1).getExistencia());
				pw.println("====");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero)
					fichero.close();
				System.out.println("Guardado con exito!");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

//comprar productos para luego venderlos
	public void Compra(int cantidad, int num, String ruta, ArrayList<Producto> a) {

		Producto p = new Producto();
		File file = new File(ruta + "/producto.day");
		a.clear();
		contador = 0;
		if (!file.exists()) {
			System.out.println(file.getAbsolutePath());
			System.out.println("No existe ningun archivo en este directorio uwu");
		} else {

			try {

				Scanner sc = new Scanner(file);

				while (sc.hasNextLine()) {

					String i = sc.nextLine();

					if (i.substring(0, 2).equals("Co")) {

						p.setCodigo(i.substring(8, i.length()));

					} else if (i.substring(0, 2).equals("No")) {

						p.setNombre(i.substring(8, i.length()));

					} else if (i.substring(0, 2).equals("Ca")) {

						p.setCantidad(Integer.parseInt(i.substring(10, i.length())));

					} else if (i.substring(0, 2).equals("Pr")) {

						p.setPrecio(Double.parseDouble(i.substring(8, i.length())));

					} else if (i.substring(0, 2).equals("Ex")) {

						p.setExistencia(Integer.parseInt(i.substring(12, i.length())));
						contador++;
						a.add(p);
						p = new Producto();
					}

				}
				sc.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			file.delete();
			// Parte que compra

			a.get(num - 1).setCantidad(a.get(num - 1).getCantidad() + cantidad);

			GuardarArchivo(ruta, a);

			for (int i = 0; i < a.size(); i++) {
				System.out.println("=====" + (i + 1) + "=====");
				System.out.println("Codigo: " + a.get(i).getCodigo());
				System.out.println("Nombre: " + a.get(i).getNombre());
				System.out.println("Cantidad: " + a.get(i).getCantidad());
				System.out.println("Precio: " + a.get(i).getPrecio());
				System.out.println("Existencia: " + a.get(i).getExistencia());
				System.out.println();
			}

		}

	}

	public void GuardarArchivoCompra(int cantidad, int num, String ruta, ArrayList<Producto> a) {

		try {
			archivo = new File(ruta + "/Compra.day");
			// fichero = new FileWriter(archivo);

			if (!archivo.exists()) {
				fichero = new FileWriter(archivo);
				pw = new PrintWriter(fichero);

				pw.println(fechaActual + ". ====");
				pw.println("Codigo: " + a.get(num - 1).getCodigo());
				pw.println("Nombre: " + a.get(num - 1).getNombre());
				pw.println("Cantidad: " + a.get(num - 1).getCantidad());
				pw.println("Precio: " + a.get(num - 1).getPrecio());
				pw.println("Existencia: " + a.get(num - 1).getExistencia());
				pw.println("Gasto Total: " + (a.get(num - 1).getPrecio() * cantidad));
				pw.println("====");

			} else {

				fichero = new FileWriter(archivo, true);

				pw = new PrintWriter(fichero);

				pw.println(fechaActual + ". ====");
				pw.println("Codigo: " + a.get(num - 1).getCodigo());
				pw.println("Nombre: " + a.get(num - 1).getNombre());
				pw.println("Cantidad: " + a.get(num - 1).getCantidad());
				pw.println("Precio: " + a.get(num - 1).getPrecio());
				pw.println("Existencia: " + a.get(num - 1).getExistencia());
				pw.println("====");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero)
					fichero.close();
				System.out.println("Guardado con exito!");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public int ComprobarArchivo(String ruta) {

		archivo = new File(ruta + "/producto.day");

		if (!archivo.exists()) {
			System.out.println("No existen productos! Ingrese primero!");
			return 1;
		} else {
			return 0;
		}

	}
}
