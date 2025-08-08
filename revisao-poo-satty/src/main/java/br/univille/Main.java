package br.univille;

import br.univille.entity.Cidade;
import br.univille.entity.Cliente;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");

        var cliente = new Cliente();
        cliente.setNome("kush"); //OBJETO
        cliente.setIdade(20); //PRIMITIVO
        cliente.setPeso(78); //PRIMITO
        
        Cidade cidade = new Cidade("Xique-Xique");

        cliente.setCidade(cidade); //ASSOCIAÇÃO 01

    }
}