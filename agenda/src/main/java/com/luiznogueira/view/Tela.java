package com.luiznogueira.view;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.luiznogueira.entidades.Contato;

import javax.swing.JLabel;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

@Slf4j
public class Tela {

    private void renderizaTela() {
        JFrame frame = new JFrame("Agenda");
        frame.setSize(450, 450);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);
        JScrollPane panel = new JScrollPane(getListaContatos());
        JLabel titulo = new JLabel("Contatos");
        panel.add(titulo);
        frame.add(panel);
        frame.setVisible(true);
    }
    
    public static List<Contato> getListaContatosStub() {
        List<Contato> lista = new ArrayList<>();
        lista.add(new Contato("José", "jose@abc.com", "12345", 1, 1));
        lista.add(new Contato("João", "joao@abc.com", "12346", 2, 2));
        lista.add(new Contato("Joana", "joana@abc.com", "12347", 3, 3));
        lista.add(new Contato("Julia", "julia@abc.com", "12348", 4, 4));
        lista.add(new Contato("José", "abc@abc.com", "12345", 1, 1));
        return lista;
    }

    private JList<Contato> getListaContatos() {
        DefaultListModel<Contato> dlm = new DefaultListModel<>();
        for (Contato contato : getListaContatosStub()) {
            dlm.addElement(contato);
        }
        JList<Contato> lista = new JList<>(dlm);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        return lista;
    }
    
    public static void main(String[] args) {
        Tela tela = new Tela();
        tela.renderizaTela();
    }
}
