package com.ti2cc;

import java.util.Scanner;

public class Principal {
	
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		int x = 0;
		int z = 0;
		int y = 0;
		String str = null;
		String str2 = null;
		
		dao.conectar();
       
	
		
		System.out.println("O que você deseja fazer ?");
		System.out.println("1- Listar");
		System.out.println("2- Inserir");
		System.out.println("3- Excluir");
		System.out.println("4- Atualizar");
		System.out.println("5- Sair");
	   
		x = sc.nextInt();
		
		while(x != 5) {
		if(x == 1)
		{
			//Mostrar carros
			Fipe[] carros = dao.getCarros();
			System.out.println("==== Mostrar carros === ");		
			for(int i = 0; i < carros.length; i++) {
				System.out.println(carros[i].toString());
			}
		}
		
		if(x == 2)
		{
			//Inserir um elemento na tabela
			System.out.println("Qual o codigo do carro?");
			z = sc.nextInt();
			System.out.println("Qual a marca do carro");
			str = sc.nextLine();
			System.out.println("Qual o modelo do carro?");
			str2 = sc.nextLine();
			System.out.println("Qual o ano do carro?");
			y = sc.nextInt();
			Fipe carro = new Fipe(z, str, str2, y);
			if(dao.inserirCarro(carro) == true) {
				System.out.println("Inserção com sucesso -> " + carro.toString());
			}
			
		}
		
		if(x == 3)
		{
			System.out.println("Qual o codigo do carro que deseja excluir ?");
			z = sc.nextInt();
			dao.excluirCarro(z);
		}
		
		if(x == 4)
		{
			//Atualizar carro
            Fipe carro = new Fipe();
            System.out.println("Qual o codigo do carro?");
            z = sc.nextInt();
            System.out.println("Qual a marca do carro?");
			str = sc.nextLine();
			System.out.println("Qual o modelo do carro?");
			str2 = sc.nextLine();
			System.out.println("Qual o ano do carro?");
			y = sc.nextInt();
            carro.setCodigo(z);
			carro.setMarca(str);
			carro.setModelo(str2);
			carro.setAno(y);
			dao.atualizarCarro(carro);
		}
	  
      
		System.out.println("O que você deseja fazer ?");
		System.out.println("1- Listar");
		System.out.println("2- Inserir");
		System.out.println("3- Excluir");
		System.out.println("4- Atualizar");
		System.out.println("5- Sair");
		
		x = sc.nextInt();
	  }
		dao.close();
		}
}
