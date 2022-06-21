package com.pizza.model;

import java.util.Scanner;

public class Cadastro {

    private static int count = 1;
    private Integer id;
    private String nome;
    private Integer idade;
    private Integer telefone;
    private String endereco;
    private Integer rg;
    private Integer visitas;
    private Integer quarto;
    private Integer hotel;

    public Cadastro(){}

    public Cadastro(Integer id,String nome, Integer idade, Integer telefone, String endereço, Integer rg, Integer visitas){
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
        this.endereco = endereço;
        this.rg = rg;
        this.visitas = visitas;
        setId(++count);
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {

        return nome;
    }


    public void setNome(String nome) {

        if (!nome.matches("[a-zA-Z]+")){
            System.out.println("Apenas letras!");
        }else this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getTelefone() {

        return telefone;
    }

    public void setTelefone(Integer telefone) {
            this.telefone = telefone;

    }

    public String getEndereco() {

        return endereco;
    }

    public void setEndereco(String endereco) {

        this.endereco = endereco;
    }

    public Integer getRg() {

        return rg;
    }

    public void setRg(Integer rg) {

        this.rg = rg;
    }

    public Integer getVisitas() {
        return visitas;
    }

    public void setVisitas(Integer visitas) {
            this.visitas = visitas;
    }

    public Integer getQuarto() {
        return quarto;
    }

    public void setQuarto(Integer quarto) {
        this.quarto = quarto;
    }

    public Integer getHotel() {
        return hotel;
    }

    public void setHotel(Integer hotel) {
        if (hotel == 1){
            System.out.println("\n\n\t#### Bem- vindo ao Hotel Panamá! ###\n");
        }else if (hotel == 2){
            System.out.println("\n\n\t#### Bem- vindo ao Hotel Casa Branca! ###\n");
        }else if(hotel == 3){
            System.out.println("\n\n\t#### Bem- vindo ao Hotel Doninhas! ###\n");
        }
        this.hotel = hotel;
    }

    public String toString() {
        return "\nID: "+id+ " , "+ "\nNome: " + nome + " , "+
                "\nIdade: " + idade + " , "+
                "\nTelefone: " + telefone + " , "+
                "\nEndereço: " + endereco + " , "+
                "\nRg: " + rg + ", "+ "\nQuarto: "+ quarto;
    }
}
