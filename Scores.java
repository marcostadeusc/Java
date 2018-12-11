/**
* Autor  Marcos Tadeu de Sousa Cunha
*/

import java.util.Scanner;

public class Scores {

    // Começo do código
    public static void main(String args[]) {
        int scores[], qtd = 0, option = 1, cont = 0;
        Scanner ler = new Scanner(System.in);
        scores = new int[100];

        // Entrada para o menu do Score
        while (option != 0) {

            System.out.println("1. Adicionar uma pontuação no final da lista de scores;");
            System.out.println("2. Adicionar uma pontuação em uma dada posição na lista de scores;");
            System.out.println("3. Remover uma pontuação de uma dada posição na lista de scores;");
            System.out.println("4. Remover todas as ocorrências de uma pontuação na lista de scores;");
            System.out.println("5. Verificar se uma pontuação está contida na lista de scores;");
            System.out.println("6. Buscar a maior pontuação na lista de scores;");
            System.out.println("7. Calcular a soma total de pontuação na lista de scores;");
            System.out.println("8. Verificar se dado uma pontuação existem duas pontuações na lista de scores que somadas são iguais à posição informada.");
            System.out.println();
            System.out.println("0. Para encerrar a execução do programa.");
            System.out.println();
            System.out.println("Lembre-se, o vetor só aceitará 100 posições.");
            System.out.println();
            System.out.println("Entre com a opção do menu: ");
            option = ler.nextInt();

            // Entrada da primeira opção do menu
            if (option == 1) {
                int score;

                if (scores[qtd] == 0) {
                    System.out.println("Entre com a pontuação a ser adicionada no final da lista de scores: ");
                    score = ler.nextInt();
                    qtd = (option1(scores, qtd, score));
                }
            }

            // Entrada da segunda opção do menu
            else if (option == 2) {
                while (cont < 1) {
                    int pos;
                    System.out.println("Entre com a posição a ser adicionada na lista de scores: ");
                    pos = ler.nextInt();
                    if (pos > qtd) {
                        System.out.println("Entre com uma posição válida.");
                    } else if ((pos < 100) && (scores[pos] == 0)) {
                        System.out.println("Entre com a pontuação a ser adicionada na posição " + pos + " na lista de scores: ");
                        scores[pos] = ler.nextInt();
                        qtd++;
                        cont++;
                    } else {
                        int aux = qtd;
                        while (pos < qtd) {
                            scores[qtd] = scores[qtd - 1];
                            qtd--;
                        }
                        qtd = aux + 1;
                        System.out.println("Entre com a pontuação a ser adicionada na posição " + pos + " na lista de scores: ");
                        scores[pos] = ler.nextInt();
                        cont++;
                    }
                }
                cont = 0;


            }

            // Entrada da terceira opção do menu
            else if (option == 3) {
                int aux = qtd;
                int pos;

                while (qtd == aux) {
                    System.out.println("Entre com a posição a ser removida na lista de scores: ");
                    pos = ler.nextInt();
                    if (pos < qtd) {
                        qtd = option3(scores, qtd, pos);
                    } else {
                        System.out.println("Entre com uma posição válida.");
                    }
                }
            }

            // Entrada da quarta opção do menu
            else if (option == 4) {
                int verificar = 0, pos = 0;
                System.out.println("Entre com a pontuação a ser removida: ");
                verificar = ler.nextInt();

                while (cont < qtd) {
                    if (verificar == scores[cont]) {
                        while (pos < qtd) {
                            scores[pos] = scores[pos + 1];
                            pos++;
                        }
                        qtd--;
                    } else {
                        cont++;
                    }
                    pos = cont;
                }
                cont = 0;

            }

            // Entrada da quinta opção do menu
            else if (option == 5) {
                int pont;
                int ePont = 0;
                int nPont = 0;
                System.out.println("Entre com a pontuação a ser verificada: ");
                pont = ler.nextInt();
                while (cont < qtd) {
                    if (scores[cont] == pont) {
                        ePont++;
                    } else if (scores[cont] != pont) {
                        nPont++;
                    }
                    cont++;
                }
                if (nPont == qtd) {
                    System.out.println("A pontuação não existe.");
                } else if (ePont != 0) {
                    System.out.println("A pontuação existe e ocorre: " + ePont + " veze(s).");
                }
                System.out.println();
                cont = 0;

            }

            // Entrada da sexta opção do menu
            else if (option == 6) {
                int maior;

                //Chamada da função para a opção 6
                maior = option6(scores, qtd);
                System.out.println("A maior pontuação do score é: " + maior);


            }

            // Entrada da sétima opção do menu
            else if (option == 7) {
                int soma = 0;

                //Chamada da função para a opção 7
                soma = option7(scores, qtd);
                System.out.println("Soma das pontuações: " + soma);


            }

            // Entrada da oitava opção do menu
            else if (option == 8) {
                int cont1 = 0, cont2 = 0, verificar;
                System.out.println("Digite um valor que será verificado");
                verificar = ler.nextInt();
                while (cont1 < qtd) {
                    while (cont2 < qtd) {
                        if (scores[cont1] + scores[cont2] == verificar && cont1 < cont2) {
                            System.out.println("Score[" + cont1 + "] + Score[" + cont2 + "] = " + verificar);
                        }
                        cont2++;
                    }
                    cont2 = 0;
                    cont1++;
                }
                cont = 0;
            } else {
                System.out.println("Digite um número entre 0 e 8");
            }
            cont = 0;

            //Saída do vetor
            while (cont < qtd) {
                System.out.println("Score " + cont + ": " + scores[cont]);
                cont++;
            }
            System.out.println();
            cont = 0;
        }

    }

    //Função para a opção 1
    public static int option1(int scores[], int qtd, int score) {
        int cont = 0;

        while (cont < 1) {
            if (scores[qtd] == 0) {
                scores[qtd] = score;
                qtd++;
                cont++;
            }
        }

        return qtd;
    }

    //Função para a opção 3
    public static int option3(int scores[], int qtd, int pos) {
        int aux = qtd;
        while (qtd == aux) {
            if (pos < qtd) {
                while (pos < qtd) {
                    scores[pos] = scores[pos + 1];
                    pos++;
                }
                qtd--;
            }
        }
        return qtd;
    }

    //Função para a opção 6
    public static int option6(int scores[], int qtd) {
        int cont = 0, maior = 0;
        while (cont < qtd) {
            if (scores[cont] > maior) {
                maior = scores[cont];
                cont++;
            } else {
                cont++;
            }

        }
        return maior;
    }

    //Função para a opção 7
    public static int option7(int scores[], int qtd) {
        int cont = 0, soma = 0;
        while (cont < qtd) {
            soma += scores[cont];
            cont++;
        }
        return soma;
    }
}