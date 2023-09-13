package ordenarImg;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class TratamientoImg {
	
	private Path pathOrigen;
	private Path pathDestino;
	private List<File> archivos;
	private ArrayList<String> listaDenombresCarpetasDestinos = new ArrayList<String>();
	private ArrayList<Path> rutasDestino = new ArrayList<Path>();
	
	public TratamientoImg(Path pathOrigen, Path pathDestino) {
		this.pathOrigen = pathOrigen;
		this.pathDestino = pathDestino;
		this.archivos = this.archivos();
	}
	
	public List<File> archivos (){
		//retorna una List de objetos File
		File carpeta = new File(pathOrigen.toString());	
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
	
	public String mesNumeroAMesNombre(String mes) {
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
	
	public String nombreCarpetaDestino(File archivo) {
		//retorna el nombre de la carpeta donde se guardaran las img
		return getAnioArchivo(archivo)+"_"+ mesNumeroAMesNombre(getMesArchivo(archivo));
	}
	
	public ArrayList<String> nombresCarpetasDestinos(){
		archivos.forEach(arch -> 		
			listaDenombresCarpetasDestinos.add(nombreCarpetaDestino(arch)));
		return listaDenombresCarpetasDestinos;
	}
	
	public void impNombresCapetasDestinos() {
		listaDenombresCarpetasDestinos.forEach(nombreCarpeta -> System.out.println(nombreCarpeta));
	}
	
	
	public Path pathArchivoDestino(String carpeta) {
		//retorna el path de la carpeta destino completo
		return FileSystems.getDefault().getPath(pathDestino.toString() + "\\" + carpeta);
	}
	
	public ArrayList listaPathArchivosDestinos() {
		listaDenombresCarpetasDestinos.forEach(carpeta -> 
			rutasDestino.add(pathArchivoDestino(carpeta)));
		return rutasDestino;
	}
	
	public void impListaPathArchivosDestino() {
		rutasDestino.forEach(path -> System.out.println(path.toString()));
	}
	
	
	public void moverArchivo(File archivo, Path carpetaDestino){
	   
	    try {
	    	Path carpetaArchivo = FileSystems.getDefault().getPath(carpetaDestino.toString() + "\\" +archivo.getName());
	    	Files.move(archivo.toPath(), carpetaArchivo, StandardCopyOption.REPLACE_EXISTING);
	    } catch (IOException e) {
	        System.err.println(e);
	    }
	}
	
	
	public void crearCarpeta(Path pathCarpeta) {
		//crea una carpeta con el nombre del archivo que se alocara.
		//si ya existe la carpeta no la crea.
		File dir = new File(pathCarpeta.toString());
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
	
	public void crearCarpetas() {
		rutasDestino.forEach(pathCarpeta -> crearCarpeta(pathCarpeta));
	}
	
	}
