import java.util.Scanner;
import java.text.DecimalFormat;
/**
 * Autor Marcos Tadeu de Sousa Cunha
 */
public class Nlogonia01 {

    public static void main(String[] args) {
        // Declaração das variáveis

        int K, N, M, X, Y, cont = 0, farX, farY, nearX, nearY, residenceDistance, farDistance, nearDistance;
        double northwest = 0, northeast = 0, southwest = 0, southeast = 0, border = 0;
        // Variável que define quantas casas decimais haverão após o número
        DecimalFormat df = new DecimalFormat ("0");
        Scanner ler = new Scanner(System.in);

        // Entrada de dados e iniciação das variáveis
        // Entrada da quantidade de residências a serem consultadas
        System.out.println("Entre com a quantidade de residências a serem consultadas: ");
        K = ler.nextInt();

        // Entrada do ponto divisor
        System.out.println("Entre com a coordenada X do ponto divisor: ");
        // Entrada do ponto divisor na linha de X
        N = ler.nextInt();
        System.out.println("Entre com a coordenada Y do ponto divisor: ");
        // Entrada do ponto divisor na linha de Y
        M = ler.nextInt();

        // Entrada das variáveis para maior e menor distância
        farX = N;
        farY = M;
        nearX = N;
        nearY = M;

        // Tratativas para a base da conta da menor e maior distância 
        nearDistance = (int) Math.sqrt(Math.pow(N - nearX, 2) + (Math.pow(M - nearY, 2)));
        farDistance = (int) Math.sqrt(Math.pow(N - farX, 2) + (Math.pow(M - farY, 2)));

        // Entrada da repetição
        while (cont < K) {
            // Entrada das coordenadas da residência
            System.out.println("Entre com a coordenada X da residência: ");
            // Entrada do ponto da residência na linha de X
            X = ler.nextInt();
            System.out.println("Entre com a coordenada Y da residência: ");
            // Entrada do ponto da residência na linha de Y
            Y = ler.nextInt();

            residenceDistance = (int) Math.sqrt(Math.pow(N - X, 2) + (Math.pow(M - Y, 2)));

            // Tratativas para verificar maior e menor distância
            // Condição que verifica menor distância
            if ((residenceDistance < nearDistance) || (cont == 0)) {
                nearX = X;
                nearY = Y;
                nearDistance = residenceDistance;
            }

            // Condição que verifica maior distância
            if (residenceDistance > farDistance) {
                farX = X;
                farY = Y;
                farDistance = residenceDistance;
            }

            // Tratativas para verificar em qual região se localiza a residência
            // 1ª condição verifica se a residência está a esquerda do ponto divisor
            // 2ª condição verifica se a residência está acima do ponto divisor
            if ((X < N) && (Y > M)) {
                System.out.println("A residência encontra-se na região Noroeste");
                northwest++;
            }
            // 1ª condição verifica se a residência está a direita do ponto divisor
            // 2ª codição verifica se a residência está acima do ponto divisor
            if ((X > N) && (Y > M)) {
                System.out.println("A residência encontra-se na região Nordeste");
                northeast++;
            }
            // 1ª condição verifica se a residência está a esquerda do ponto divisor
            // 2ª condição verifica se a residência está abaixo do ponto divisor
            if ((X < N) && (Y < M)) {
                System.out.println("A residência encontra-se na região Sudoeste");
                southwest++;
            }
            // 1ª condição verifica se a residência está a direita do ponto divisor
            // 2ª condição verifica se a residência está abaixo do ponto divisor
            if ((X > N) && (Y < M)) {
                System.out.println("A residência encontra-se na região Sudeste");
                southeast++;
            }
            // 1ª e 2ª condições verificam se uma das coordenadas da residência  
            // correspondem as coordenadas do ponto divisor
            if ((X == N) || (Y == M)) {
                System.out.println("A residência encontra-se na região da Divisa");
                border++;
            }
            cont++;
        }
        // Tratativas para analisar porcentagem de cada região
        northwest = (northwest/K)*100;
        northeast = (northeast/K)*100;
        southwest = (southwest/K)*100;
        southeast = (southeast/K)*100;
        border = (border/K)*100;
        
        // Saída das coordenadas de menor e maior distância e suas respectivas distâncias e percentual da quantidade de residências de cada região
        System.out.println("A residência mais próxima do ponto divisor é: " + nearDistance + "\nCoordenadas (X,Y): " + nearX + "," + nearY);
        System.out.println("A residência mais longe do ponto divisor é: " + farDistance + "\nCoordenadas (X,Y): " + farX + "," + farY);
        System.out.println("Residências na região Noroeste: " + df.format(northwest) + "%");
        System.out.println("Residências na região Nordeste: " + df.format(northeast) + "%");
        System.out.println("Residências na região Sudoeste: " + df.format(southwest) + "%");
        System.out.println("Residências na região Sudeste: " + df.format(southeast) + "%");
        System.out.println("Residências na região da Divisa: " + df.format(border) + "%");
    }

}