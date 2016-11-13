import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerArchivo{

	private String nombre_archivo;
	private String texto = "";
	private int inicio = 0;
	private int fin  = 0;
	private int bloques;
	private int salir = 1;

	public LeerArchivo(String nombre, int bloques){
		this.bloques = bloques - 2;
		this.nombre_archivo =  nombre;
	}

	public void leerContenido() throws FileNotFoundException, IOException {
    	String cadena;
    	FileReader f = new FileReader(this.nombre_archivo);
    	BufferedReader b = new BufferedReader(f);
    	int i = 0;
    	while((cadena = b.readLine())!=null) {
    		if(texto!=""){
    			this.texto = this.texto +"\n"+ cadena;
    		}else{
    			this.texto = cadena;
    		}
    	}
      	b.close();
      	this.fin = this.texto.length();
	}

	public String get_subtexto(){
		int sacar = inicio + this.bloques;
		if(sacar>this.fin){
			this.salir = 0;
			return this.texto.substring(this.inicio,this.fin);
		}
		String mensaje = this.texto.substring(this.inicio,sacar);
		this.inicio = sacar;
		return mensaje;
	}

	public int get_salir(){
		return this.salir;
	}

}

/*
fichero = new FileWriter("c:/prueba.txt");
            pw = new PrintWriter(fichero);

            for (int i = 0; i < 10; i++)
                pw.println("Linea " + i);
                fichero.close();
*/

