import java.util.*;

public class Main{
	
	public static void main(String[] args){
		//solicitar clave
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese clave de encripatción mayor a  8 caracteres: ");
		String key = sc.nextLine();
		System.out.println(key);
		while(key.length()<8){
			System.out.println("LA CLAVE ES MENOR A 8 CARACTERES");
			System.out.print("Ingrese clave de encripatción mayor a  8 caracteres: ");
			key = sc.nextLine();
		}
		//mensaje
		String mensaje = "hola como estas compadre";
		//codificación
		
		//mostrar mensaje codificado
		
		//decodificar
		
		//mostrar mensaje decodificado
		
	}
	
}
