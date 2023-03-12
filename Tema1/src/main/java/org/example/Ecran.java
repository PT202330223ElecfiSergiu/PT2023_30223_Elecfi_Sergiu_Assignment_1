package org.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ecran implements ActionListener {
    JFrame frame = new JFrame("Calculator de polinoame");
    JButton adunare = new JButton();
    JButton scadere = new JButton();
    JButton inmultire = new JButton();
    JButton impartire = new JButton();
    JButton integrare = new JButton();
    JButton derivare = new JButton();

    JTextField chenar1 = new JTextField();
    JTextField chenar2 = new JTextField();

    JTextArea rezultat = new JTextArea();

    JLabel polinom1 = new JLabel();
    JLabel polinom2 = new JLabel();
    JLabel titlu = new JLabel();
    JLabel nume = new JLabel();
    JLabel grupa = new JLabel();

    JPanel panel = new JPanel();

    //declaratii pentru polinom


    public void labels() {
        polinom1.setBounds(40, 150, 200, 30);
        polinom1.setText("Polinomul 1:");
        polinom1.setBackground(new Color(0,225,225));
        polinom1.setFont(new Font("Times new roman", Font.ITALIC,20));

        polinom2.setBounds(40,190,200,30);
        polinom2.setText("Polinomul 2:");
        polinom2.setBackground(new Color(0,225,225));
        polinom2.setFont(new Font("times new roman", Font.ITALIC,20));

        titlu.setBounds(200,40,410,80);
        titlu.setText("Calculator de polinoame");
        titlu.setBackground(new Color(0,225,225));
        titlu.setFont(new Font("Times new roman", Font.ITALIC,40));

        nume.setBounds(600,700,200,30);
        nume.setText("Elecfi Sergiu-Andrei");
        nume.setBackground(new Color(0,225,225));
        nume.setFont(new Font("times new roman", Font.ITALIC,20));

        grupa.setBounds(600,730,200,30);
        grupa.setText("Grupa 30223");
        grupa.setBackground(new Color(0,225,225));
        grupa.setFont(new Font("times new roman", Font.ITALIC,20));

        panel.add(grupa);
        panel.add(nume);
        panel.add(titlu);
        panel.add(polinom1);
        panel.add(polinom2);
    }

    public void textFields() {
        chenar1.setBounds(150,150,250,30);
        chenar1.setText("Introduceti primul polinom");
        chenar1.setFont(new Font("times new roman",Font.ITALIC,20));
        panel.add(chenar1);

        chenar2.setBounds(150,190,250,30);
        chenar2.setText("Introduceti al doilea polinom");
        chenar2.setFont(new Font("times new roman",Font.ITALIC,20));
        panel.add(chenar2);
    }

    public void butoane() {
        adunare.setBounds(50,250,200,50);
        adunare.setText("Adunare polinoame");
        adunare.setBackground(new Color(224,176,255));
        adunare.setFont(new Font("times new roman", Font.ITALIC,20));
        panel.add(adunare);

        scadere.setBounds(270,250,200,50);
        scadere.setText("Scadere polinoame");
        scadere.setBackground(new Color(224,176,255));
        scadere.setFont(new Font("times new roman", Font.ITALIC,20));
        panel.add(scadere);

        inmultire.setBounds(490,250,220,50);
        inmultire.setText("Inmultire polinoame");
        inmultire.setBackground(new Color(224,176,255));
        inmultire.setFont(new Font("times new roman", Font.ITALIC,20));
        panel.add(inmultire);

        impartire.setBounds(490,320,220,50);
        impartire.setText("Impartire polinoame");
        impartire.setBackground(new Color(224,176,255));
        impartire.setFont(new Font("times new roman", Font.ITALIC,20));
        panel.add(impartire);

        integrare.setBounds(270,320,200,50);
        integrare.setText("Integrare polinom");
        integrare.setBackground(new Color(224,176,255));
        integrare.setFont(new Font("times new roman", Font.ITALIC,20));
        panel.add(integrare);

        derivare.setBounds(50,320,200,50);
        derivare.setText("Derivare polinom");
        derivare.setBackground(new Color(224,176,255));
        derivare.setFont(new Font("times new roman", Font.ITALIC,20));
        panel.add(derivare);
    }

    public void textArea() {
        rezultat.setBounds(50,400,660,100);
        rezultat.setText("Rezultatul va aparea aici");
        rezultat.setFont(new Font("times new roman", Font.ITALIC,25));
        panel.add(rezultat);
    }

    public Ecran() {
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);

        frame.getContentPane().add(panel,BorderLayout.CENTER);
        panel.setBackground(new Color(0,225,225));
        panel.setLayout(null);

        labels();
        textFields();
        butoane();
        textArea();
        frame.add(panel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
