package ordenarImg;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ordenarImg.Ruta.*;

public class Archivo {
	
	Ruta pathOrigen;
	Ruta pathDestino;
	List<File> archivos;
	
	private Archivo(Ruta pathOrigen, Ruta pathDestino) {
		this.pathOrigen = pathOrigen;
		this.pathDestino = pathDestino;
		this.archivos = this.archivos();
	}
	
	public List<File> archivos (){
		//retorna una List de objetos File
		File carpeta = new File(pathOrigen.getRuta());	
		return Arrays.asList(carpeta.listFiles());  
	}
	
	public List<String> pathArchivos() {
		//retornar una lista con el path del archivo
		List<String> rutaArchivos = new ArrayList<>();
		archivos.forEach(archivo -> {
			rutaArchivos.add(archivo.getAbsolutePath());});
		return rutaArchivos;
	}
	
	public void impArchivos() {
		//Imprime todo los archivos de la carpeta
		archivos.forEach(archivo -> System.out.println(archivo.getName()));
	}
	
	public void impPathArchivos() {
		//Imprime el path completo de la lista de archivos
		archivos.forEach(archivo -> System.out.println(archivo.getAbsolutePath()));
	}
	
	public String getAnioArchivo(File archivo) {
		//retorna el año de la imagen
		return archivo.getName().substring(4, 8);
	}

	public String getMesArchivo(File archivo) {
		//retorna el mes de la imagen
		return archivo.getName().substring(8, 10);
	}
	
	public String getDiaArchivo(File archivo) {
		//retorna el dia de la imagen
		return archivo.getName().substring(10, 12);
	}
	
	public String getFormato(File archivo) {
		//retorna el formato del archivo
		return archivo.getName().substring(archivo.getName().indexOf('.'), archivo.getName().length());
	}
	
	public String nombreCarpetaDestino(File archivo) {
		//retorna el nombre de la carpeta donde se guardaran las img
		return getAnioArchivo(archivo)+"_"+mesAmesNombre(getMesArchivo(archivo));
	}
	

	public String mesAmesNombre(String mes) {
		//toma el numero del mes y lo retorna como nombre
		String nombreMes = "";
		switch(mes) {
		case "01": nombreMes = "Enero"; break;
		case "02": nombreMes = "Frebrero"; break;
		case "03": nombreMes = "Marzo"; break;
		case "04": nombreMes = "Abril"; break;
		case "05": nombreMes = "Mayo"; break;
		case "06": nombreMes = "Junio"; break;
		case "07": nombreMes = "Julio"; break;
		case "08": nombreMes = "Agosto"; break;
		case "09": nombreMes = "Septiembre"; break;
		case "10": nombreMes = "Octubre"; break;
		case "11": nombreMes = "Noviembre"; break;
		case "12": nombreMes = "Diciembre"; break;
		}
		return nombreMes;		
	}
	

	public String pathArchivoDestino(String pathDestino, File archivo) {
		//retorna el path de la carpeta destino completo
		return pathDestino + "\\" + nombreCarpetaDestino(archivo);
	}
	
	public void crearCarpeta(String pathArchivoDestino) {
		//crea una carpeta con el nombre del archivo que se alocara.
		//si ya existe la carpeta no la crea.
		File dir = new File(pathArchivoDestino);
        if (!dir.exists()) {
            if (dir.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
        else {
        	System.out.println("Uno o mas directorios ya existen");
        }
	}
	
}
