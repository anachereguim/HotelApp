package com.pizza.model;



public class Vip extends Cadastro implements Quarto{

    private String profissao;

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Vip(){}

    public Vip(String profissao, Integer id, String nome, Integer idade, Integer telefone, String endereco, Integer rg, Integer visitas){
        super(id, nome, idade, telefone, endereco, rg, visitas);
        this.profissao = profissao;
    }


    public String toString() {
        return "\n\nQUARTO VIP: \n" +
                "profissao: " + profissao + super.toString();
    }


    public void quarto() {
        System.out.println("Você é um hóspede regular, por isso é vip.");
    }
    public void quarto(String type) {
        System.out.println("O seu quarto é: "+ type);
    }


}
