import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Autor: Marcos Tadeu de Sousa Cunha 
 */
public class KVizinhos {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner ler = new Scanner(System.in);
        // instanciando objeto para receber o arquivo.txt
        FileReader archive;
        archive = new FileReader("archive.txt");

        // instanciando objeto para ler o arquivo
        BufferedReader archBuffered;
        archBuffered = new BufferedReader(archive);

        // instanciando o tamanho do vetor de objetos
        String length = archBuffered.readLine();
        int tamanho = Integer.parseInt(length);

        // instanciando vetor de objetos do tipo Ponto
        Ponto vetPoint[] = new Ponto[tamanho], point;
        // instanciando vetor que irá receber os pontos (x,y)
        String vetString[];
        for (int i = 0; i < vetPoint.length; i++) {
            // o objeto lê as linhas do arquivo, uma a uma e as passa para a variável string
            String linha = archBuffered.readLine();
            // passando os valores da linha (x,y) 
            // uma a uma para o vetor instanciando para receber os pontos
            vetString = linha.split(" ");
            // o objeto do tipo Ponto instanciado recebe os pontos com os valores (x,y)
            point = new Ponto(Double.parseDouble(vetString[0]), Double.parseDouble(vetString[1]));
            // o vetor de objetos recebe os valores (x,y) do objeto Ponto
            vetPoint[i] = point;
        }
        System.out.println("Digite a coordenada de referência da sua busca: ");
        int coordRef = ler.nextInt();
        System.out.println("Digite a quantidade de pontos vizinhos a serem buscados (k): ");
        int K = ler.nextInt();

        for(int i = 0; i < vetPoint.length; i++){
            vetPoint[coordRef].distance(vetPoint[i]);
        }
        
        // chamada da função do metódo bolha para ordenação do vetor de objetos
        bolha(vetPoint);
        
        for(int i = 1; i < K + 1; i++){
            System.out.println(vetPoint[i].toString());
        }
    }
    
    public static Ponto[] bolha(Ponto [] vetPoint){
        // variável auxiliar do metódo bolha que irá receber o valor que irá ser substituído
        Ponto aux = new Ponto(0,0);
        // metódo bolha para ordenar o vetor de objetos
        for(int i = 0; i < vetPoint.length; i++ ){
            for(int j = i + 1; j < vetPoint.length; j++ ){ // sempre 1 elemento à frente
                // se o (x > (x+1)) então o x passa pra frente (ordem crescente)
                if (vetPoint[i].semaior(vetPoint[j])){
                    aux = vetPoint[i];
                    vetPoint[i] = vetPoint[j];
                    vetPoint[j] = aux;
                }
            }
        }
        return vetPoint;
    }
}