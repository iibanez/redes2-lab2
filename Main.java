import java.util.*;
import java.io.IOException;

public class Main{
	
	public static void main(String[] args) throws IOException {

		//LeerArchivo la = new LeerArchivo("archivo_prueba.txt",32);
		/*la.leerContenido();
		System.out.print(la.get_subtexto());
		System.out.print(la.get_subtexto());*/
		
		//solicitar clave
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese clave de encripatción mayor a  8 caracteres: ");
		String key = sc.nextLine();
		//System.out.println("clave: "+key);
		while(key.length()<8){
			System.out.println("LA CLAVE ES MENOR A 8 CARACTERES");
			System.out.print("Ingrese clave de encripatción mayor a  8 caracteres: ");
			key = sc.nextLine();
		}
		
		///////////////////////////
		//modificar bloques
		//////////////////////////
		int bloques = 100; //corresponde al tamaño del bloque que puede cambiar de 32 hasta 255
						  //considerar que al verdadero valor con el mensaje es de 30 hasta 253
						  //debido a que 2 caracteres son para indicar el valor real del mensaje


		//mensaje
		LeerArchivo la = new LeerArchivo("archivo_prueba.txt",bloques);
		la.leerContenido();

		//codificación
		Codificacion c = new Codificacion(key,la.get_subtexto(), bloques);
		c.codificar();
		//decodificar
		Decodificacion d = new Decodificacion(key,c.get_mensaje(),bloques);
		d.decodificar();
		System.out.print(d.get_criptomensaje());

		while(la.get_salir() == 1){

			//codificación
			c.set_mensaje(la.get_subtexto());
			c.codificar();
			//decodificar
			d.set_criptomensaje(c.get_mensaje());
			d.decodificar();
			//mostrar
			System.out.print(d.get_criptomensaje());
		}
		System.out.println();
	}
	
}
