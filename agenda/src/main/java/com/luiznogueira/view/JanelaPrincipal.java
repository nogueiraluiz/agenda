package com.luiznogueira.view;

import javax.swing.JFrame;

public class JanelaPrincipal extends JFrame {

    public JanelaPrincipal() {
        super("Agenda");
        setSize(900, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        add(new PainelListaContatos());
    }

    public static void main(String[] args) {
        new JanelaPrincipal();
    }

}
