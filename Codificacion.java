import java.lang.*;

public class Codificacion{
	
	private char array_key[];
	private char array_mensaje[];
	private int p_trasposicion  = 0;
	
	public Codificacion(String key, String mensaje){
		this.array_key = key.toCharArray();
		this.array_mensaje = mensaje.toCharArray();
	}
	
	public void set_mensaje(String mensaje){
		this.array_mensaje = mensaje.toCharArray();
	}
	
	public String get_mensaje(){
		return String.valueOf(array_mensaje);
	}
	
	private void sustitucion(char letra){
		
		for(int i=0;i<array_mensaje.length;i++){
			this.array_mensaje[i] = (char)(this.array_mensaje[i] + letra);
		}
		
	}
	
	private void transposicion(){
		
		//Se genera la manera de hacer la trasnpociion
		int[] ordenar = new int[8];
		if((this.p_trasposicion+8)>array_key.length){
			this.p_trasposicion = 0;
		}
		int p = 0;
		for(int i=p_trasposicion;i<(8+p_trasposicion);i++){
			ordenar[p] = (int)array_key[i]; 
			p++;
		}
		this.p_trasposicion++;
		
		//se coloca el mensaje en la matriz de transposicion
		char[][] matriz = new char[4][8];
		p = 0;
		for(int i=0;i<4;i++){
			for(int j=0;j<8;j++){
				matriz[i][j] = this.array_mensaje[p];
				p++;
			}
		}
		
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
			this.array_mensaje[m] = matriz[0][p];
			m++;
			this.array_mensaje[m] = matriz[1][p];
			m++;
			this.array_mensaje[m] = matriz[2][p];
			m++;
			this.array_mensaje[m] = matriz[3][p]; 
			m++;
		}
		
		
		
	}
	
	public void codificar(){
		
		int productos = 0;
		
		while(productos<8){
			
			sustitucion(array_key[productos]);
			transposicion();
			productos++;
		
		}
	}
}	
