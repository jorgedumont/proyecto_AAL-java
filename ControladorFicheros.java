package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class ControladorFicheros {
	
	String fichero;
	String separador;


	public Vector<Usuario> leerUsuarios() {
		this.fichero = "./data/usuarios2.txt";
		this.separador = ";";
		Vector<Usuario> listaUsuarios = new Vector<Usuario>();

		File f = new File(fichero);
		String line;

		try {
			BufferedReader lector = new BufferedReader(new FileReader(f));
			do {
				line = lector.readLine();
				if (line != null) {
					StringTokenizer st = new StringTokenizer(line, separador);
					Usuario nuevo = new Usuario(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken());
					listaUsuarios.add(nuevo);
				}
			} while (line != null);
			lector.close();
		} catch (Exception e) {
			System.out.println("ERROR:" + e.getMessage());
		}
		return listaUsuarios;
	}
	
	public static int contar_numero_lineas_fichero (String fichero_nombre) throws IOException {
		int contador = 0;
		File fichero = new File (fichero_nombre);
		FileReader fr = new FileReader(fichero);
		BufferedReader br =	new BufferedReader(fr);
		while(br.readLine() != null) {
			contador++;
		}
		br.close();
		return contador;
	}
	
	public static int contar_sexo (String fichero_nombre, String sexo) throws IOException {
		int contador = 0;
		File fichero = new File (fichero_nombre);
		FileReader fr = new FileReader(fichero);
		BufferedReader br =	new BufferedReader(fr);
		String linea;
		while((linea = br.readLine()) != null) {
			String [] campos;
			campos= linea.split(";");
			if(campos[3].equalsIgnoreCase(sexo)){
				contador++;
			}
		}
		br.close();
		return contador;
	}
	public static boolean validarDNI(String DNI) {
		char[] letras = {
				'T','R','W','A','G',
				'M','Y','F','P','D',
				'X','B','N','J','Z',
				'S','Q','V','H','L',
				'C','K', 'E'};
		if (DNI.length() < 2)
			return false;
		
		int numeroDNI=Integer.parseInt(DNI.substring(0, DNI.length()-1));//el substring es coger un trozo de una cadena, en este caso coges todo
		//sin incluir la ultima letra
		char letraDNI=DNI.charAt(DNI.length()-1);//charAt devuelve el caracter en la posicion que le digas
		boolean resultado = false;
		int indice = numeroDNI%23;
		char letraGenerada = letras[indice];
		if (letraGenerada == letraDNI) {
			resultado = true;
		}
		
		return resultado;
	}
	public static void anadirPaciente(String nombre, String apellido, String contrasena, String DNI, String sexo) throws Exception{
		if(nombre.isEmpty()||apellido.isEmpty()||contrasena.isEmpty()||sexo.isEmpty()){
			throw new Exception("Revise algun campo vacio");
		}
		if(validarDNI(DNI)== false){
			throw new Exception("DNI no valido");
		} //lanza las excepciones
		
		File fichero = new File ("./data/usuarios2.txt");
		FileWriter fr = new FileWriter(fichero, true);//ese true es para aniadir sino se borraria el fichero
		//y se escribiria en un fichero vacio
		fr.append("\n"+nombre+apellido+";"+contrasena+";"+"usuario"+";"+sexo);//append escribe al final del fichero y el primero
		//campo es nombre + apellido porque ese es el nombre del usuario
		fr.close();
	}
	
/*	public Vector<Tecnico> leerTecnicos() {
		this.fichero = ".\\data\\Tecnicos.txt";
		this.separador = ";";
		Vector<Tecnico> listaTecnicos = new Vector<Tecnico>();

		File f = new File(fichero);
		String line;

		try {
			BufferedReader lector = new BufferedReader(new FileReader(f));

			do {
				line = lector.readLine();
				if (line != null) {
					StringTokenizer st = new StringTokenizer(line, separador);
					Tecnico nuevo = new Tecnico();
					nuevo.setNick(st.nextToken());
					nuevo.setNombre(st.nextToken());
					nuevo.setApellidos(st.nextToken());
					nuevo.setDni(st.nextToken());
					nuevo.setCiudad(st.nextToken());
					listaTecnicos.add(nuevo);
				}
			} while (line != null);
			lector.close();
		} catch (Exception e) {
			System.out.println("ERROR:" + e.getMessage());
		}
		return listaTecnicos;
	}
	
	public Vector<Medico> leerMedicos() {
		this.fichero = ".\\data\\Medicos.txt";
		this.separador = ";";
		Vector<Medico> listaMedicos = new Vector<Medico>();

		File f = new File(fichero);
		String line;

		try {
			BufferedReader lector = new BufferedReader(new FileReader(f));

			do {
				line = lector.readLine();
				if (line != null) {
					StringTokenizer st = new StringTokenizer(line, separador);
					Medico nuevo = new Medico();;
					nuevo.setNombre(st.nextToken());
					nuevo.setApellidos(st.nextToken());
					nuevo.setDNI(st.nextToken());
					nuevo.setCiudad(st.nextToken());
					listaMedicos.add(nuevo);
				}
			} while (line != null);
			lector.close();
		} catch (Exception e) {
			System.out.println("ERROR:" + e.getMessage());
		}
		return listaMedicos;
	}
	public Vector<Paciente> leerPacTec() {
		this.fichero = ".\\data\\Pacientes.txt";
		this.separador = ";";
		Vector<Paciente> listaPacientes = new Vector<Paciente>();

		File f = new File(fichero);
		String line;

		try {
			BufferedReader lector = new BufferedReader(new FileReader(f));

			do {
				line = lector.readLine();
				if (line != null) {
					StringTokenizer st = new StringTokenizer(line, separador);
					Paciente nuevo = new Paciente(st.nextToken(), st.nextToken(), st.nextToken());
					listaPacientes.add(nuevo);
				}
			} while (line != null);
			lector.close();
		} catch (Exception e) {
			System.out.println("ERROR:" + e.getMessage());
		}
		return listaPacientes;

	}
	
	public Paciente leerPacMed(String fichero) {
		this.fichero = fichero;
		this.separador = ";";

		File f = new File(fichero);
		String line;
		Paciente nuevoPac = new Paciente("1", "2", "3");
		try {
			BufferedReader lector = new BufferedReader(new FileReader(f));
			line = lector.readLine();
			StringTokenizer st = new StringTokenizer(line, separador);
			nuevoPac.setNombre(st.nextToken());
			nuevoPac.setApellidos(st.nextToken());
			nuevoPac.setDNI(st.nextToken());
			nuevoPac.setNumSeguridadSocial(st.nextToken());
			nuevoPac.setCiudad(st.nextToken());
			nuevoPac.setDireccion(st.nextToken());
			line = lector.readLine();
			nuevoPac.setFoto(line);
			line = lector.readLine();
			nuevoPac.setEstado(line);
			line = lector.readLine();
			nuevoPac.setComentarios(line);
			Vector <String> aux = new Vector <String>();
			do {
				line = lector.readLine();
				if (line != null) {
					aux.add(line);
				}
			}
			while (line != null);
			nuevoPac.setLista_ecg(aux);
			lector.close();
		} catch (Exception e) {
			System.out.println("ERROR:" + e.getMessage());
		}
		return nuevoPac;	
	}
	public Medico leerMed(String fichero) {
		this.fichero = fichero;
		this.separador = ";";

		File f = new File(fichero);
		String line;
		Medico nuevoMedico = new Medico();
		try {
			BufferedReader lector = new BufferedReader(new FileReader(f));
			line = lector.readLine();
			StringTokenizer st = new StringTokenizer(line, separador);
			nuevoMedico.setNombre(st.nextToken());
			nuevoMedico.setApellidos(st.nextToken());
			nuevoMedico.setDNI(st.nextToken());
			nuevoMedico.setId_medico(st.nextToken());
			nuevoMedico.setHospital(st.nextToken());
			nuevoMedico.setNumeroTel(st.nextToken());
			Vector <String> aux = new Vector <String>();
			do {
				line = lector.readLine();
				if (line != null) {
					aux.add(line);
				}
			}
			while (line != null);
			nuevoMedico.setListaPacientes(aux);
			lector.close();
		} catch (Exception e) {
			System.out.println("ERROR:" + e.getMessage());
		}
		return nuevoMedico;	

	}

	
	public Ecg cargarEcgMedico(String fichero)  {
		this.fichero = fichero;
		this.separador = ";";
		Ecg ecg = new Ecg();
		File f = new File(fichero);
		double intervalo;
		String[] medicion;
		String comentario;

		try {
			BufferedReader lector = new BufferedReader(new FileReader(f)); 
			intervalo = (1 / Float.parseFloat(lector.readLine()));
			medicion = lector.readLine().split(separador);
			comentario = lector.readLine();
			if (comentario == null) {
				comentario = "Sin Comentario";
			}
			ecg = new Ecg(medicion, intervalo);
			
			lector.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ecg;
	}
	*/
	public static void main (String[] args) throws IOException{
		System.out.println(contar_numero_lineas_fichero("./data/usuarios2.txt"));
		System.out.println(contar_sexo("./data/usuarios2.txt", "hombre"));
		System.out.println(contar_sexo("./data/usuarios2.txt", "mujer"));
		
	}
}


