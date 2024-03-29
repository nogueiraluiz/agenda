package com.luiznogueira.entidades;

public class Contato implements Comparable<Contato> {
    
    private String nome;
    private String email;
    private Telefone telefone;
    private MesAno aniversario;

    private class Telefone {
        private String numero;
        private int ddd;
    }

    public Contato(String nome, String email, Telefone telefone, MesAno aniversario) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.aniversario = aniversario;
    }

    public Contato(String nome, String email, String numero, int ddd, int dia, int mes) {
        this.nome = nome;
        this.email = email;
        this.telefone = new Telefone();
        this.telefone.numero = numero;
        this.telefone.ddd = ddd;
        this.aniversario = new MesAno(dia, mes);
    }

    public Contato(String nome, String email, String numero, int dia, int mes) {
        this.nome = nome;
        this.email = email;
        this.telefone = new Telefone();
        this.telefone.numero = numero;
        this.aniversario = new MesAno(dia, mes);
    }

    @Override
    public int compareTo(Contato contato) {
        return this.nome.compareTo(contato.nome);
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nEmail: " + email + "\nTelefone: (" + telefone.ddd + ") " + telefone.numero + "\nAniversário: " + aniversario.getDia() + "/" + aniversario.getMes();
    }

}
