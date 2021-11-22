package projeto.mvc.view;

import java.util.Scanner;

import projeto.mvc.dao.FilmeDao;
import projeto.mvc.model.Filme;

public class FilmeView {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner (System.in);
		
		System.out.print("O que você deseja fazer?");
		System.out.println("\n |1 - incluir novo filme"+
						   "\n |2 - consultar file existente"+
						   "\n |3 - alterar os dados de um filme"+
						   "\n |4 - deletar o cadastro de um filme");
		int opcao = input.nextInt();
		
		switch(opcao) {
		case 1: {			
			Filme filme = new Filme();
			
			System.out.print("Insira o nome do filme: ");
			filme.setNome(input.next());
			System.out.print("Insira o genero do filme: ");
			filme.setGenero(input.next());
			
			FilmeDao filmeDao = new FilmeDao();
			filmeDao.cadastrarFilme(filme);
		}
		}
	}
}
