////o usuario entra com 2 pontos x,y que definem um retangulo, o usuario entao lista
//uma serie de pontos e o programa checa se estes pontos estao fora ou dentro do 
//retangulo e retorna a palavra "teste" seguida do numero de pontos dentro do retangulo.

//restricoes : o numero de meteoros de entrada esta entre 0 e 10, o universo de pontos x e y esta em um plano cartesiano de limite maximo 10 e minimo 0.
import java.util.Scanner;

public class Meteoros {	
	
	public static void main(String[] args) {
		//Declaracao de variaveis
		//arrays x,y e um buffer pra troca de valores.
		int[] ponto1 = new int[2];
		int[] ponto2 = new int[2];
		int[] buffer = new int[2];
		//para facilitar a leitura dos vetores xy.
		int x =0;
		int y =1;
		//2d array para os meteoros:10 linhas 2 colunas;
		int[][] meteoros = new int [10][2];
		//declaracao de scanner;
		Scanner scanner = new Scanner(System.in);
		int colisoes=0;
		//coletando entradas:
		do {
			System.out.println(" Qual o tamanho da fazenda? determine dois pontos. X1 e X2 nao podem ser identicos,\n menores que zero ou maiores que dez. O mesmo se aplica para Y1 e Y2.");
			do {
				System.out.println(" Digite um valor para X1, este numero precisa estar entre 0 e 10");
				ponto1[x]=scanner.nextInt();
			} while (ponto1[x]<0||ponto1[x]>10);		
			
			do {
				System.out.println(" Digite um valor para Y1, este numero precisa estar entre 0 e 10");
				ponto1[y]=scanner.nextInt();
			} while (ponto1[y]<0||ponto2[y]>10);
			do {
				System.out.println(" Digite um valor para X2, este numero precisa estar entre 0 e 10");
				ponto2[x]=scanner.nextInt();
			} while (ponto2[x]<0||ponto2[x]>10);
			
			do {
				System.out.println(" Digite um valor para Y2, este numero precisa estar entre 0 e 10");
				ponto2[y]=scanner.nextInt();
			} while (ponto2[y]<0||ponto2[y]>10);
			
			//se x1== x2 ou y1==x2 nao ha retangulo. repita
		} while (ponto1[x]==ponto2[x]||ponto1[y]==ponto2[y]);		
				
		System.out.println(" Agora, digite os pontos de impacto dos meteoros digite numeros entre 0 e 10");
		for (int i = 0; i < meteoros.length; i++) {
			
			do {				
				System.out.println(" Digite um valor para x, numeros inteiros entre 0 e 10");
				meteoros[i][x]= scanner.nextInt();
				} 
			while (meteoros[i][x]>10||meteoros[i][x]<0);
			do {				
				System.out.println(" Digite um valor para y, numeros inteiros entre 0 e 10");
				meteoros[i][y]= scanner.nextInt();
				} 
			while (meteoros[i][y]>10||meteoros[i][y]<0);			
		}
		//Organizando as entradas do usuario em formato ponto1={xMin,yMin} e ponto2={xMax,yMax};
		if(ponto1[x]>ponto2[x]) {
			buffer[x]=ponto2[x];
			ponto2[x]=ponto1[x];
			ponto1[x]=buffer[x];
		}
		if(ponto1[y]>ponto2[y]) {
			buffer[y]=ponto2[y];
			ponto2[y]=ponto1[y];	
			ponto1[y]=buffer[y];
		}
		System.out.println(" Os limites da fazenda são(valores minimos e maximos dos pontos) :\nponto1: "+ ponto1[x]+","+ ponto1[y]+"\nponto2: "+ ponto2[x]+","+ ponto2[y]);
		System.out.println(" Os pontos de impacto são:");
		for (int i = 0; i < meteoros.length; i++) {
			System.out.print(meteoros[i][x]+","+meteoros[i][y]+" ");
			//checando colisoes.
			if(meteoros[i][x]>=ponto1[x] && meteoros[i][x]<=ponto2[x] && meteoros[i][y]>=ponto1[y] &&  meteoros[i][y]<=ponto2[y]) ++colisoes;
		}
		System.out.println("\nteste");
		System.out.println(colisoes);
	}
}
