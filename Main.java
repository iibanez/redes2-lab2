import java.util.*;

public class Main{
	
	public static void main(String[] args){
		//solicitar clave
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese clave de encripatción mayor a  8 caracteres: ");
		String key = sc.nextLine();
		System.out.println("clave: "+key);
		while(key.length()<8){
			System.out.println("LA CLAVE ES MENOR A 8 CARACTERES");
			System.out.print("Ingrese clave de encripatción mayor a  8 caracteres: ");
			key = sc.nextLine();
		}
		
		///////////////////////////
		//modificar bloques
		//////////////////////////
		int bloques = 32; //incluye 2 bit para indicar tamaño bloque  puede ser de 32 a 255
		
		//mensaje
		String mensaje = "hola como";
		System.out.println("Mensaje: " + mensaje);
		
		//codificación
		Codificacion c = new Codificacion(key,mensaje,bloques);
		c.codificar();
		//mostrar mensaje codificado
		System.out.println("Mensaje codificado: " + c.get_mensaje());
		//decodificar
		Decodificacion d = new Decodificacion(key,c.get_mensaje(),bloques);
		d.decodificar();
		//mostrar mensaje decodificado
		System.out.println("Mensaje decodificado: " + d.get_criptomensaje());
	}
	
}
