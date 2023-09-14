package ordenarImg;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import ordenarImg.TratamientoImg;

public class principal {
	
	public static void main(String[] args) {
		
		String path = "C:\\Users\\diazm\\Documents\\Matias\\EducacionIT\\Java\\programas_java\\ordenarImagenes\\img";
		String pathDestino = "C:\\Users\\diazm\\Desktop";
		
		Path origen = FileSystems.getDefault().getPath(path);
		Path destino = FileSystems.getDefault().getPath(pathDestino);
		
		TratamientoImg ti = new TratamientoImg(origen, destino);
		
		System.out.println("lista de archivos");
		ti.impArchivos();
		System.out.println("path de imagenes");
		ti.impPathArchivos();
		System.out.println("nombre de carpeta destino");
		System.out.println(ti.nombreCarpetaDestino(ti.archivos().get(0)));
		
		System.out.println("Lista de nombres de carpeta");
		ti.nombresCarpetasDestinos();
		ti.impNombresCapetasDestinos();
		
		System.out.println("Ruta completa destino");
		Path nameFileDest = ti.pathArchivoDestino(ti.nombreCarpetaDestino(ti.archivos().get(0)));
		System.out.println(nameFileDest);
		
		System.out.println("Lista de rutas destino");
		ti.listaPathArchivosDestinos();
		ti.impListaPathArchivosDestino();
		
		System.out.println("Crear una carpeta");
		ti.crearCarpeta(nameFileDest);
		
		System.out.println("Crear carpetas");
		ti.crearCarpetas();
		
		System.out.println("Moviendo archivo");
		File archivito = ti.archivos().get(0);
		ti.moverArchivo(archivito, nameFileDest);
		
		System.out.println("Moviendo archivosss");
		ti.moverArchivos();
	}

}
