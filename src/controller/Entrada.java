package controller;

import service.ConverteDados;

import java.util.Scanner;

public class Entrada {

    Scanner leitura = new Scanner(System.in);
    private ConverteDados conversor = new ConverteDados();

    int opcao = -1;

    String menu = """
            *****************************************
            Bem Vindo ao conversor de moedas!
            
            Escolha uma das opções para conversão:
            
            1 - Dólar --> Peso Argentino
            2 - Peso Argentino --> Dólar
            3 - Dólar --> Real Brasileiro
            4 - Real Brasileiro --> Dólar
            5 - Dólar --> Peso Colombiano
            6 - Peso Colombiano --> Dólar
            
            0 - Sair
            
            *****************************************
            """;

    public void exibeMenu(){
        while (opcao != 0) {
            System.out.println(menu);
            System.out.print("Digite uma opção: ");
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    calcularTudo("USD", "ARS");
                    break;
                case 2:
                    calcularTudo("ARS", "USD");
                    break;
                case 3:
                    calcularTudo("USD", "BRL");
                    break;
                case 4:
                    calcularTudo("BRL", "USD");
                    break;
                case 5:
                    calcularTudo("USD", "COP");
                    break;
                case 6:
                    calcularTudo("COP", "USD");
                    break;
                case 0:
                    System.out.println("Obrigado por participar... até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void calcularTudo(String moedaBase, String moedaConversao) {
        System.out.printf("Digite o valor a ser convertido de %s para %s: %n", moedaBase, moedaConversao);
        double valorConversao = leitura.nextDouble();
        leitura.nextLine();

        conversor.converter(moedaBase, moedaConversao, valorConversao);
    }

}
