//CODÍGO POJO
//ESCONDER DENTRO DO OBJETO SUAS CARACTERÍSTICAS -> ENCAPSULAMENTO

package br.univille.entity;
import java.util.ArrayList;

public class Cliente {
    private String nome; //COMEÇA COM LETRA MAISCULA -> OBJETO
    private int idade;
    private float peso;

    //ASSOCIAÇÃO 01
    private Cidade cidade; //SERIA COMO A CHAVE ESTRANGEIRA ASSOCIANDO COM Cidade.java
    private ArrayList<Pokemon> listaPokemon =
        new ArrayList<Pokemon>();
    
    public ArrayList<Pokemon> getListaPokemon() {
        return listaPokemon;
    }
    public void setListaPokemon(ArrayList<Pokemon> listaPokemon) {
        this.listaPokemon = listaPokemon;
    }

    public Cidade getCidade() {
        return cidade;
    }
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
    
}
