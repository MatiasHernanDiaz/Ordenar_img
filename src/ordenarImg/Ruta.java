package ordenarImg;

import java.io.File;
import java.nio.file.FileSystems;
import java.util.Arrays;
import java.util.List;
import ordenarImg.Archivo.*;

public class Ruta {
	String path;
	
	private Ruta(String ruta) {
		this.path = ruta;
	}
	
	public String getRuta() {
		FileSystems.getDefault().getPath(path);
		return path;
	}
	
}
