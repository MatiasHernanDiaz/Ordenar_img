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
		Path destino = FileSystems.getDefault().getPath(path);
		
		TratamientoImg ti = new TratamientoImg(origen, destino);
		
		System.out.println("lista de archivos");
		ti.impArchivos();
		System.out.println("path de imagenes");
		ti.impPathArchivos();
		System.out.println("nombre de carpeta destino");
		System.out.println(ti.nombreCarpetaDestino(ti.archivos().get(0))) ;
		
		System.out.println("Lista de nombres de carpeta");
		ti.nombresCarpetasDestinos();
		ti.impNombresCapetasDestinos();
		
	}

}
