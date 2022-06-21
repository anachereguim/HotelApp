package com.pizza;

import com.pizza.dao.DatabaseConnection;
import com.pizza.model.Cadastro;
import com.pizza.model.Comum;
import com.pizza.model.Vip;

import java.sql.*;
import java.util.ArrayList;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();

        try {
            Statement createTable = connection.createStatement();
            createTable.execute("CREATE TABLE IF NOT EXISTS COMUM(ID INT, NOME VARCHAR(255), IDADE INT, TELEFONE INT, ENDEREÇO VARCHAR(255), RG INT,TEMPO INT)");
            createTable.execute("CREATE TABLE IF NOT EXISTS VIP(ID INT, NOME VARCHAR(255), IDADE INT, TELEFONE INT, ENDEREÇO VARCHAR(255), RG INT, PROFISSAO VARCHAR(25))");
            Scanner sc = new Scanner(System.in);
            Comum comum = new Comum();
            Vip vip = new Vip();

            ArrayList<Comum> lista = new ArrayList<>();
            ArrayList<Vip> lista2 = new ArrayList<>();
            int opcao;

            Cadastro cadastro = new Cadastro();
            System.out.println("__________________________________________");
            System.out.println("## Escolha uma das opções abaixo ##");
            System.out.println("Opção 1 - Hotel Panamá");
            System.out.println("Opção 2 - Hotel Casa Branca");
            System.out.println("Opção 3 - Hotel Doninhas");

            System.out.println("__________________________________________");

            System.out.print("Digite aqui sua opção: ");
            cadastro.setHotel(sc.nextInt());

            do {
                System.out.println("__________________________________________");
                System.out.println("## Escolha uma das opções abaixo ##");
                System.out.println("Opção 1 - Cadastrar hóspede");
                System.out.println("Opção 2 - Imprime pessoas cadastradas");
                System.out.println("Opção 3 - Ver quartos disponíveis");
                System.out.println("Opção 4 - Apagar registros");
                System.out.println("Opção 0 - Sair do programa");
                System.out.println("__________________________________________");

                System.out.print("Digite aqui sua opção: ");
                opcao = sc.nextInt();


                if (opcao == 1) {


                    System.out.print("\nDigite quantas vezes você veio ao hotel: ");
                    cadastro.setVisitas(sc.nextInt());

                    if (cadastro.getVisitas() < 10) {

                        System.out.println("\n");
                        comum.setId(1);

                        System.out.print("Digite o seu nome: ");
                        sc.nextLine();
                        comum.setNome(sc.nextLine());

                        System.out.print("Digite a idade: ");
                        comum.setIdade(sc.nextInt());

                        System.out.print("Digite o telefone: ");
                        comum.setTelefone(sc.nextInt());

                        System.out.print("Digite o endereço: ");
                        sc.nextLine();
                        comum.setEndereco(sc.nextLine());

                        System.out.print("Digite o rg: ");
                        comum.setRg(sc.nextInt());


                        System.out.print("Digite quantos dias você vai ficar: ");
                        comum.setTempo(sc.nextInt());
                        System.out.println("\n");

                        comum.quarto();
                        comum.quarto("Quarto comum");
                        lista.add(comum);

                        PreparedStatement insertUser = connection.prepareStatement("INSERT INTO COMUM VALUES (?,?,?,?,?,?,?)");
                        insertUser.setInt(1, comum.getId());
                        insertUser.setString(2, comum.getNome());
                        insertUser.setInt(3, comum.getIdade());
                        insertUser.setInt(4, comum.getTelefone());
                        insertUser.setString(5, comum.getEndereco());
                        insertUser.setInt(6, comum.getRg());
                        insertUser.setInt(7,comum.getTempo());
                        insertUser.execute();


                        float a1 = 1000;
                        System.out.println("\n");
                        System.out.println("______________________________________________________________________");
                        System.out.println("## Escolha uma das opções abaixo ##");
                        System.out.println("Opção 1 - Quarto com 1 cama da solteiro");
                        System.out.println("Opção 2 - Quarto com 2 camas de solteiro ou 1 casal");
                        System.out.println("Opção 3 - Quarto com 3 camas de solteiro ou 1 casal e 1 solteiro");
                        System.out.println("______________________________________________________________________");

                        System.out.print("Digite aqui sua opção: ");
                        opcao = sc.nextInt();

                        if (opcao == 1) {
                            comum.setQuarto(1);

                            System.out.println("\nQuarto de solteiro selecionado!\n");
                            System.out.println("R$" + a1);
                            sc.nextLine();
                        } else if (opcao == 2) {
                            comum.setQuarto(2);


                            System.out.println("\nQuarto duplo selecionado!\n");
                            float b1 = a1 + 500;
                            System.out.println("R$" + b1);
                            sc.nextLine();
                        } else {
                            comum.setQuarto(3);
                            System.out.println("\nQuarto triplo selecionado!\n");
                            float c1 = a1 + 1000;
                            System.out.println("R$" + c1);
                            sc.nextLine();
                        }


                    } else {
                        System.out.println("\n");
                        vip.setId(2);
                        System.out.print("Digite o nome: ");
                        sc.nextLine();
                        vip.setNome(sc.nextLine());

                        System.out.print("Digite o endereço: ");
                        vip.setEndereco(sc.nextLine());

                        System.out.print("Digite o telefone: ");
                        vip.setTelefone(sc.nextInt());

                        System.out.print("Digite o rg: ");
                        vip.setRg(sc.nextInt());

                        System.out.print("Digite a idade: ");
                        vip.setIdade(sc.nextInt());

                        System.out.print("Digite sua profissão: ");
                        sc.nextLine();
                        vip.setProfissao(sc.nextLine());

                        System.out.println("\n");

                        vip.quarto();
                        vip.quarto("Quarto VIP");
                        lista2.add(vip);

                        PreparedStatement insertUser = connection.prepareStatement("INSERT INTO VIP VALUES (?,?,?,?,?,?,?)");
                        insertUser.setInt(1, vip.getId());
                        insertUser.setString(2, vip.getNome());
                        insertUser.setInt(3, vip.getIdade());
                        insertUser.setInt(4, vip.getTelefone());
                        insertUser.setString(5, vip.getEndereco());
                        insertUser.setInt(6, vip.getRg());
                        insertUser.setString(7,vip.getProfissao());
                        insertUser.execute();
                        float a = 3000;
                        float b = 2000;
                        float c = 1000;
                        System.out.println("\n");
                        System.out.println("__________________________________________");
                        System.out.println("## Escolha uma das opções abaixo ##");
                        System.out.println("Opção 1 - Quarto presidencial com jacuzi");
                        System.out.println("Opção 2 - Quarto na cobertura");
                        System.out.println("Opção 3 - Quarto Comum + Spa gratuito");
                        System.out.println("__________________________________________");

                        System.out.print("Digite aqui sua opção: ");
                        opcao = sc.nextInt();

                        if (opcao == 1) {
                            vip.setQuarto(1);
                            System.out.println("\nQuarto presidencial com jacuzi!\n");
                            System.out.println("R$" + a);
                            sc.nextLine();
                        } else if (opcao == 2) {
                            vip.setQuarto(2);
                            System.out.println("\nQuarto na cobertura!\n");
                            System.out.println("R$" + b);
                            sc.nextLine();
                        } else {
                            vip.setQuarto(3);
                            System.out.println("______________________________________________________________________");
                            System.out.println("## Escolha uma das opções abaixo ##");
                            System.out.println("Opção 1 - Quarto com 1 cama da solteiro + Spa");
                            System.out.println("Opção 2 - Quarto com 2 camas de solteiro ou 1 casal + Spa");
                            System.out.println("Opção 3 - Quarto com 3 camas de solteiro ou 1 casal e 1 solteiro + Spa");
                            System.out.println("______________________________________________________________________");
                            System.out.print("Digite aqui sua opção: ");
                            opcao = sc.nextInt();

                            if (opcao == 1) {
                                System.out.println("\nSelecionado quarto com 1 cama da solteiro + Spa\n");
                                System.out.println("R$" + c);
                                sc.nextLine();
                            } else if (opcao == 2) {
                                System.out.println("\nSelecionado quarto com 2 camas de solteiro ou 1 casal + Spa\n");
                                float d = c + 500;
                                System.out.println("R$" + d);
                                sc.nextLine();
                            } else if (opcao == 3) {
                                System.out.println("\nSelecionado quarto com 3 camas de solteiro ou 1 casal e 1 solteiro + Spa\n");
                                float d = c + 1000;
                                System.out.println("R$" + d);
                                sc.nextLine();
                            } else {
                                System.out.println("Opção inválida!");
                                break;
                            }

                        }

                    }
                } else if (opcao == 2) {{
                        Statement getAll = connection.createStatement();
                        ResultSet result = getAll.executeQuery("SELECT * FROM COMUM");
                        while (result.next()) {
                            System.out.println("==========");
                            System.out.println("Lista de hóspedes comuns:\n");
                            System.out.println("Id: "+ result.getInt("ID"));
                            System.out.println("Nome: "+result.getString("NOME"));
                            System.out.println("Idade: "+result.getInt("IDADE"));
                            System.out.println("Telefone: "+result.getInt("TELEFONE"));
                            System.out.println("Endereço: "+result.getString("ENDEREÇO"));
                            System.out.println("Rg: "+result.getInt("RG"));
                            System.out.println("Tempo de estadia: "+result.getInt("TEMPO"));
                            System.out.println("==========");
                            result.next();
                        }
                        ResultSet result1 = getAll.executeQuery("SELECT * FROM VIP");
                        while (result1.next()) {
                            System.out.println("==========");
                            System.out.println("Lista de hóspedes vips:\n");
                            System.out.println("Id: "+result1.getInt("ID"));
                            System.out.println("Nome: "+result1.getString("NOME"));
                            System.out.println("Idade: "+result1.getInt("IDADE"));
                            System.out.println("Telefone: "+result1.getInt("TELEFONE"));
                            System.out.println("Endereço: "+result1.getString("ENDEREÇO"));
                            System.out.println("Rg: "+result1.getInt("RG"));
                            System.out.println("Profissão: "+result1.getString("PROFISSAO"));
                            System.out.println("==========");
                            result1.next();
                        }
                        System.out.println("Pressione um tecla para continuar.");
                        sc.nextLine();
                    }
                    sc.nextLine();
                } else if (opcao == 3) {
                    System.out.println("\n");
                    System.out.println("## Bem-vindo funcionário ##");

                    System.out.print("Digite a senha para acessar o sistema: ");
                    opcao = sc.nextInt();
                    if (opcao == 1234) {
                        System.out.println("\n");
                        System.out.println("_______________________________________");
                        System.out.println("## Selecione tipo de hóspede ##");
                        System.out.println("1 - Comum");
                        System.out.println("2 - Vip");
                        System.out.println("_______________________________________");

                        System.out.print("Digite aqui sua opção: ");
                        opcao = sc.nextInt();
                        if (opcao == 1) {
                            System.out.println("\nO hotel disponibiliza 10 quartos comuns, atualmente esses são os cadastrados: \n");
                            Statement getAll = connection.createStatement();
                            ResultSet result = getAll.executeQuery("SELECT * FROM COMUM");
                            while (result.next()) {
                                System.out.println("==========");
                                System.out.println("Lista de hóspedes comuns:\n");
                                System.out.println("Id: "+ result.getInt("ID"));
                                System.out.println("Nome: "+result.getString("NOME"));
                                System.out.println("Idade: "+result.getInt("IDADE"));
                                System.out.println("Telefone: "+result.getInt("TELEFONE"));
                                System.out.println("Endereço: "+result.getString("ENDEREÇO"));
                                System.out.println("Rg: "+result.getInt("RG"));
                                System.out.println("Tempo de estadia: "+result.getInt("TEMPO"));
                                System.out.println("==========");
                                result.next();
                            }
                            sc.nextLine();
                        } else {
                            System.out.println("\nO hotel disponibiliza 5 quartos vips, atualmente esses são os cadastrados: \n");
                            Statement getAll = connection.createStatement();
                            ResultSet result = getAll.executeQuery("SELECT * FROM VIP");
                            while (result.next()) {
                                System.out.println("==========");
                                System.out.println("Lista de hóspedes vips:\n");
                                System.out.println("Id: "+result.getInt("ID"));
                                System.out.println("Nome: "+result.getString("NOME"));
                                System.out.println("Idade: "+result.getInt("IDADE"));
                                System.out.println("Telefone: "+result.getInt("TELEFONE"));
                                System.out.println("Endereço: "+result.getString("ENDEREÇO"));
                                System.out.println("Rg: "+result.getInt("RG"));
                                System.out.println("Profissão: "+result.getString("PROFISSAO"));
                                System.out.println("==========");
                                result.next();
                            }
                            sc.nextLine();
                        }
                    } else {
                        System.out.println("Senha incorreta!");
                        sc.nextLine();
                    }
                }else if (opcao == 4){
                    System.out.println("Digite a senha para continuar");
                    opcao = sc.nextInt();
                    if (opcao == 1234) {
                        connection.createStatement().execute("DELETE FROM COMUM");
                        connection.createStatement().execute("DELETE FROM VIP");

                    } else {
                        System.out.println("Senha incorreta!");
                        sc.nextLine();
                    }
                }
            } while (opcao != 0);

            sc.close();
            System.out.println("\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

