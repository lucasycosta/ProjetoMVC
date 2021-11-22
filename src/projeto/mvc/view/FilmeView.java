package projeto.mvc.view;

import java.util.Scanner;

import projeto.mvc.dao.FilmeDao;
import projeto.mvc.model.Filme;

public class FilmeView {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner (System.in);
		char resp;
		do {
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
					
					break;
				}
				case 2:{
					System.out.print("Digite o id do filme: ");
					int id = input.nextInt();
					
					FilmeDao filmeDao = new FilmeDao();
					for(Filme f : filmeDao.getFilme(id)) {
						System.out.println("ID: " + f.getId());
						System.out.println("Nome: " + f.getNome());
						System.out.println("Genero: " + f.getGenero());
					}
					break;
				}
				case 3:{
					FilmeDao filmeDao = new FilmeDao();
					System.out.print("Insira o id do filme: ");
					int id = input.nextInt();

					Filme f1 = new Filme();
					f1.setId(id);
					System.out.println("Insira o novo nome: ");
					System.out.println("Insira o novo genero: ");
					
					filmeDao.atualizar(f1);
					
					break;
				}
				case 4: {
					FilmeDao filmeDao = new FilmeDao();
					System.out.println("Insira o id do filme que sera excluido");
					int id = input.nextInt();
					filmeDao.deletarFilme(id);
					
					break;
				}
			}
			
			System.out.println("Deseja continuar? <s> para sim e <n> para não");
			resp = input.next().charAt(0);
			
		} while(resp != 'n');
		
		if(resp == 'n') {
			System.out.println("Fim da operação!!!");
		}
		input.close();
	}
}
