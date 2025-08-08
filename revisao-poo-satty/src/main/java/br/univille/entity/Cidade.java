package br.univille.entity;

public class Cidade {

    private String nome;

    //CONSTRUTOR ->
    //SERVE PARA INICIALIZAR AS VARIÁVEIS; 
    //OBRIGA A QUEM FOR UTILIZAR O CONSTRUTOR A PASSAR UM PARÂMETRO.
    public Cidade(String nome){ 
        
        //THIS -> SERVE PARA REFERENCIAR A VARIÁVEL DA CLASSE TRABALHADA (Cidade)
        this.nome = nome; //= -> ATRIBUIR OU COMPARAR
    }

    public String getNome(){
        return this.nome;
    }
}
