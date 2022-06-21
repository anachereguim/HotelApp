package com.pizza.model;



public class Comum extends Cadastro implements Quarto{

    private Integer tempo;

    public Integer getTempo() {
        return tempo;
    }

    public void setTempo(Integer tempo) {
        this.tempo = tempo;
    }

    public Comum() {}

    public Comum(String profissao,Integer id, String nome, Integer idade, Integer telefone, String endereco, Integer rg, Integer visitas){
        super( id ,nome, idade, telefone, endereco, rg, visitas);
       this.tempo = tempo;
    }


    public String toString() {
        return "\n\nQUARTO COMUM:\n" +
                "tempo: " + tempo +"dias"+super.toString();
    }

    public void quarto() {
        System.out.println("Bem-vindo ao hotel, visto que você não é um cliente regular, ainda não tem direito aos quartos vips.");
    }
    public void quarto(String type) {
        System.out.println("O seu quarto é: "+ type);
    }


}
