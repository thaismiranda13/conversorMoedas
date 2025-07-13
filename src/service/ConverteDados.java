package service;

import modelo.ExchangeResponse;

public class ConverteDados {

    private ConsumoApi consumoApi = new ConsumoApi();
    private final String API_KEY = System.getenv("API_KEY");

    public void converter(String moedaBase, String moedaConversao, double valor){
        String enderecoUrl = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + moedaBase + "/"
                + moedaConversao + "/" + valor;

        ExchangeResponse exchangeResponse = consumoApi.obterDados(enderecoUrl);

        double resultado = exchangeResponse.getConversion_result();
        System.out.printf("Resultado da conversão: %.2f %s = %.2f %s%n", valor, moedaBase, resultado, moedaConversao);
    }
}
