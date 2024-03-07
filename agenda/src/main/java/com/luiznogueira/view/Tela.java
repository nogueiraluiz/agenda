package com.luiznogueira.view;

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

    private static void renderizaTela() {
        JFrame frame = new JFrame("Agenda");
        frame.setSize(450, 450);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);
        JScrollPane panel = new JScrollPane();
        JLabel titulo = new JLabel("Contatos");
        panel.add(titulo);
        renderizaListaContatos(frame, panel);
        frame.setVisible(true); // TODO deixar por último
    }
    
    public static Contato[] getListaContatosStub() {
        List<Contato> lista = new ArrayList<>();
        lista.add(new Contato("José", "jose@abc.com", "12345", 1, 1));
        lista.add(new Contato("João", "joao@abc.com", "12346", 2, 2));
        lista.add(new Contato("Joana", "joana@abc.com", "12347", 3, 3));
        lista.add(new Contato("Julia", "julia@abc.com", "12348", 4, 4));
        lista.add(new Contato("José", "abc@abc.com", "12345", 1, 1));
        return lista.toArray(new Contato[0]);
    }

    private static void renderizaListaContatos(JFrame frame, JScrollPane panel) {
        JList<Contato> lista = new JList<>(getListaContatosStub());
        lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        panel.add(lista);
        frame.add(panel);
    }
    
    public static void main(String[] args) {
        renderizaTela();
    }
}
