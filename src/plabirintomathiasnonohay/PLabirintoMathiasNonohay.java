package plabirintomathiasnonohay;

import java.util.Scanner;

public class PLabirintoMathiasNonohay {

    static String labirinto[][] = {
        {"1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1"},
        {"1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "_", "_", "1"},
        {"_", "_", "_", "_", "_", "_", "_", "1", "1", "1", "1", "1", "_", "1", "1"},
        {"1", "1", "_", "1", "1", "1", "1", "1", "1", "1", "1", "1", "_", "1", "1"},
        {"1", "1", "_", "_", "_", "_", "1", "1", "1", "1", "1", "1", "_", "1", "1"},
        {"1", "1", "1", "1", "1", "_", "1", "1", "1", "1", "_", "_", "_", "_", "1"},
        {"1", "1", "1", "1", "1", "_", "1", "1", "1", "_", "_", "1", "1", "_", "1"},
        {"1", "1", "1", "1", "1", "_", "1", "1", "_", "_", "1", "1", "_", "_", "1"},
        {"1", "1", "1", "1", "1", "_", "1", "1", "_", "1", "1", "1", "_", "1", "1"},
        {"1", "1", "1", "1", "1", "_", "_", "_", "_", "_", "1", "1", "_", "_", "_"},
        {"1", "1", "1", "1", "_", "_", "1", "1", "1", "_", "1", "1", "1", "_", "1"},
        {"1", "_", "_", "_", "_", "1", "1", "1", "1", "_", "1", "1", "1", "_", "1"},
        {"1", "_", "1", "1", "1", "1", "1", "1", "1", "_", "1", "1", "1", "_", "1"},
        {"_", "_", "1", "1", "1", "1", "1", "1", "1", "_", "_", "_", "_", "_", "1"},
        {"1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1"}
    };

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int escolha, linha = 0, coluna = 0;
        String opcao;

        do {
            System.out.print(" =====MENU====="
                    + "\n |1 - Jogar   |"
                    + "\n |2 - Extra   |"
                    + "\n |0 - Sair    |"
                    + "\n =============="
                    + "\n Escolher -> ");
            escolha = ler.nextInt();
            switch (escolha) {
                case 1:
                    do {
                        System.out.print("Como jogar:"
                                + "\n 8 - Para CIMA"
                                + "\n 4 - Para ESQUERDA"
                                + "\n 6 - Para DIREITA"
                                + "\n 2 - Para BAIXO"
                                + "\n Continuar? (S/N)"
                                + "\n Escolher -> ");
                        opcao = ler.next();
                        switch (opcao) {
                            case "s":
                                System.out.println("");
                                linha = randomStart();
                                mostrarTela(linha, coluna);
                                System.out.println("");
                                break;
                            case "8":
                                System.out.println("");
                                linha = moveCima(linha, coluna);
                                mostrarTela(linha, coluna);
                                System.out.println("");
                                break;
                            case "4":
                                System.out.println("");
                                coluna = moveEsquerda(linha, coluna);
                                mostrarTela(linha, coluna);
                                System.out.println("");
                                break;
                            case "6":
                                System.out.println("");
                                coluna = moveDireita(linha, coluna, opcao);
                                opcao = verificarGanhar(coluna, opcao);
                                if (!"n".equals(opcao)) {
                                mostrarTela(linha, coluna);
                                }
                                System.out.println("");
                                break;
                            case "2":
                                System.out.println("");
                                linha = moveBaixo(linha, coluna);
                                mostrarTela(linha, coluna);
                                System.out.println("");
                                break;
                            case "n":
                                System.out.println("");
                                System.out.println("Saindo...");
                                System.out.println("");
                                break;
                            default:
                                System.out.println("Por favor, selecionar uma opção válida!");
                                break;
                        }
                    } while (!"N".equalsIgnoreCase(opcao));
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("Boas férias professor!");
                    System.out.println("");
                    break;
                case 0:
                    System.out.println("Até mais!");
                    break;
                default:
                    System.out.println("Por favor, selecionar uma opção válida!");
                    break;
            }
        } while (escolha != 0);
    }

    public static int randomStart() {
        int comeco = (int) (Math.random() * 10);

        if (comeco > 5) {
            labirinto[2][0] = "X";
            return 2;
        } else {
            labirinto[13][0] = "X";
            return 13;
        }
    }

    public static void mostrarTela(int linha, int coluna) {
        int lInicio, lFinal, cInicio, cFinal;
        lInicio = linha - 1;
        cInicio = coluna - 1;
        lFinal = linha + 1;
        cFinal = coluna + 1;
        if (lInicio < 0) {
            lInicio = 0;
        }
        if (cInicio < 0) {
            cInicio = 0;
        }
        if (lFinal > 14) {
            lFinal = 14;
        }
        if (cFinal > 14) {
            cFinal = 14;
        }
        System.out.println("Labirinto: ");
        System.out.println("Linha: " + linha);
        System.out.println("Coluna: " + coluna);
        for (int i = lInicio; i <= lFinal; i++) {
            for (int j = cInicio; j <= cFinal; j++) {
                System.out.print(labirinto[i][j] + "|");
            }
            System.out.println("");
        }

    }

    public static int moveDireita(int linha, int coluna, String opcao) {
        if (coluna + 1 == 14 && "_".equals(labirinto[linha][coluna + 1])) {
            labirinto[linha][coluna] = "_";
            labirinto[linha][coluna + 1] = "X";
            System.out.println("Parabéns!!! "
                    + "\n Você chegou no final!"
                    + "\n");
            coluna++;
        } else if ("_".equals(labirinto[linha][coluna + 1])) {
            labirinto[linha][coluna] = "_";
            labirinto[linha][coluna + 1] = "X";
            coluna++;
        }
        return coluna;
    }

    public static int moveEsquerda(int linha, int coluna) {
        if ("_".equals(labirinto[linha][coluna - 1])) {
            labirinto[linha][coluna] = "_";
            labirinto[linha][coluna - 1] = "X";
            coluna--;
        }
        return coluna;
    }

    public static int moveCima(int linha, int coluna) {
        if ("_".equals(labirinto[linha - 1][coluna])) {
            labirinto[linha][coluna] = "_";
            labirinto[linha - 1][coluna] = "X";
            linha--;
        }
        return linha;
    }

    public static int moveBaixo(int linha, int coluna) {
        if ("_".equals(labirinto[linha + 1][coluna])) {
            labirinto[linha][coluna] = "_";
            labirinto[linha + 1][coluna] = "X";
            linha++;
        }
        return linha;
    }

    public static String verificarGanhar(int coluna, String opcao) {
        if (coluna == 14) {
            opcao = "n";
        }
        return opcao;
    }
}
