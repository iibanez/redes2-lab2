import java.lang.*;

public class Decodificacion{
	
	private char array_key[];
	private char array_criptomensaje[];
	private int p_trasposicion  = 0;
	private int bloques;
	
	public Decodificacion(String key, String mensaje, int bloques){
		this.bloques = bloques;
		this.array_key = completar_clave(key);
		this.array_criptomensaje = mensaje.toCharArray();
	}
	
	public void set_criptomensaje(String mensaje){
		this.array_criptomensaje = mensaje.toCharArray();
	}
	
	public String get_criptomensaje(){
		String hex = new String(this.array_criptomensaje, (this.bloques-3), 2);
		int n = (int) Long.parseLong(hex, 16);
		String m = new String(this.array_criptomensaje,0,n);
		return m;
	}
	
	private char[] completar_clave(String key){
		//duplicar clave
		int i = 0;
		int largo = key.length();
		while(key.length()<32){
			key = key + key.charAt(i);
			i++;
			if(key.length()<i){
				i=0;
			}
		}
		
		return key.toCharArray();
	}
	
	private void sustitucion(){
		
		for(int i=0;i<this.array_criptomensaje.length;i++){
			this.array_criptomensaje[i] = (char)(this.array_criptomensaje[i] - this.array_key[i]);
		}
		
	}
	
	private void transposicion(){
		
		//Se genera la manera de hacer la trasnpociion
		if(this.p_trasposicion == -1){
			this.p_trasposicion = array_key.length-8;
		}
		
		int p = 0;
		int[] ordenar = new int[8];
		for(int i=p_trasposicion;i<(8+p_trasposicion);i++){
			ordenar[p] = (int)array_key[i]; 
			p++;
		}
		this.p_trasposicion--;
		
		char[][] matriz = new char[4][8]; //matriz de transposicion
		
		//realizar la transposicion del mensaje
		p = 0;
		int m = 0;
		for(int j=0; j<8;j++){
			for(int i=0;i<8;i++){
				if((ordenar[p] > ordenar[i] && ordenar[i]!=-1) || (ordenar[p]==-1 && ordenar[i]!=-1)){
					p = i;
				}
			}
			ordenar[p] = -1;
			matriz[0][p] = this.array_criptomensaje[m];
			m++;
			matriz[1][p] = this.array_criptomensaje[m];
			m++;
			matriz[2][p] = this.array_criptomensaje[m];
			m++;
			matriz[3][p] = this.array_criptomensaje[m];
			m++;
		}
		
		//se coloca el mensaje en la matriz de transposicion
		p = 0;
		for(int i=0;i<4;i++){
			for(int j=0;j<8;j++){
				this.array_criptomensaje[p] = matriz[i][j];
				p++;
			}
		}
		
		
		
	}
	
	public void decodificar(){
	
		/*int productos = 0;
 		//se busca la ultima posición en la cual se quedo para realizar la transposición
 		while(productos<8){
 			if((this.p_trasposicion+8)>array_key.length){
 				this.p_trasposicion = 0;
 			}
 			p_trasposicion++;
 			productos++;
 		}
 		p_trasposicion--;
		
		productos = this.array_key.length-1;*/
		
		this.p_trasposicion = 6;
		int productos = this.array_key.length-1;
		
		while(productos>=0){
			
			transposicion();
			sustitucion();
			productos--;
		
		}
	}
}	
