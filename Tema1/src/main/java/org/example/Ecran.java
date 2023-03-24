package org.example;


import java.util.*;
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

public class Ecran {
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
    JLabel reguli = new JLabel();
    JLabel regula1 = new JLabel();
    JLabel regula2 = new JLabel();
    JLabel regula3 = new JLabel();

    JPanel panel = new JPanel();

    String p1;
    String p2;

    Map<Integer, Integer> poli1 = new HashMap<>();
    Map<Integer, Integer> poli2= new HashMap<>();
    Map<Integer, Integer> poli3 = new HashMap<>();

    Operatii op = new Operatii();

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
        adunare.addActionListener(e->{
            p1 = chenar1.getText();
            p2 = chenar2.getText();
            poli1 = op.conversion(p1);
            poli2 = op.conversion(p2);
            poli3 = op.adunare(poli1, poli2);
            System.out.println(poli3);
            SortedMap<Integer, Integer> reversedMap = new TreeMap<>(Collections.reverseOrder());
            reversedMap.putAll(poli3);
            String x = "";
            for (Map.Entry<Integer, Integer> term : reversedMap.entrySet()) {
                int power = term.getKey();
                int coef = term.getValue();
                Polinom polinom1 = new Polinom(power,coef);
                if(x == "")
                    x = polinom1.toString();
                else
                    x = x + " + " + polinom1.toString();
            }
            rezultat.setText(x);
        });
        panel.add(adunare);

        scadere.setBounds(270,250,200,50);
        scadere.setText("Scadere polinoame");
        scadere.setBackground(new Color(224,176,255));
        scadere.setFont(new Font("times new roman", Font.ITALIC,20));
        scadere.addActionListener(e->{
            p1 = chenar1.getText();
            p2 = chenar2.getText();
            poli1 = op.conversion(p1);
            poli2 = op.conversion(p2);
            poli3 = op.scadere(poli1, poli2);
            System.out.println(poli3);
            SortedMap<Integer, Integer> reversedMap = new TreeMap<>(Collections.reverseOrder());
            reversedMap.putAll(poli3);
            String x = "";
            for (Map.Entry<Integer, Integer> term : reversedMap.entrySet()) {
                int power = term.getKey();
                int coef = term.getValue();
                Polinom polinom1 = new Polinom(power,coef);
                if(x == "")
                    x = polinom1.toString();
                else
                    x = x + " + " + polinom1.toString();
            }
            rezultat.setText(x);
        });
        panel.add(scadere);

        inmultire.setBounds(490,250,220,50);
        inmultire.setText("Inmultire polinoame");
        inmultire.setBackground(new Color(224,176,255));
        inmultire.setFont(new Font("times new roman", Font.ITALIC,20));
        inmultire.addActionListener(e->{
            p1 = chenar1.getText();
            p2 = chenar2.getText();
            poli1 = op.conversion(p1);
            poli2 = op.conversion(p2);
            poli3 = op.inmultire(poli1, poli2);
            System.out.println(poli3);
            SortedMap<Integer, Integer> reversedMap = new TreeMap<>(Collections.reverseOrder());
            reversedMap.putAll(poli3);
            String x = "";
            for (Map.Entry<Integer, Integer> term : reversedMap.entrySet()) {
                int power = term.getKey();
                int coef = term.getValue();
                Polinom polinom1 = new Polinom(power,coef);
                if(x == "")
                    x = polinom1.toString();
                else
                    x = x + " + " + polinom1.toString();
            }
            rezultat.setText(x);
        });
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

        reguli.setBounds(50,500,200,50);
        reguli.setText("Reguli!!");
        reguli.setBackground(new Color(224,176,255));
        reguli.setFont(new Font("times new roman", Font.ITALIC,30));
        panel.add(reguli);

        regula1.setBounds(50,550,300,30);
        regula1.setText("1.Spatiu dupa si inainte de +");
        regula1.setBackground(new Color(224,176,255));
        regula1.setFont(new Font("times new roman", Font.ITALIC,20));
        panel.add(regula1);

        regula2.setBounds(50,590,300,30);
        regula2.setText("2.Coeficientul 1 trebuie pus");
        regula2.setBackground(new Color(224,176,255));
        regula2.setFont(new Font("times new roman", Font.ITALIC,20));
        panel.add(regula2);

        regula3.setBounds(50,630,400,30);
        regula3.setText("3.Trebuie pus + chiar daca coeficientul este cu -");
        regula3.setBackground(new Color(224,176,255));
        regula3.setFont(new Font("times new roman", Font.ITALIC,20));
        panel.add(regula3);
    }

    public void textArea() {
        rezultat.setBounds(50,400,660,40);
        rezultat.setText("Rezultatul va aparea aici");
        rezultat.setFont(new Font("times new roman", Font.ITALIC,25));
        panel.add(rezultat);
    }

    public Ecran() {
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
        frame.setVisible(true);

    }


}

