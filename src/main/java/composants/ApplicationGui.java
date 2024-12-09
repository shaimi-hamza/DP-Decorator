package composants;

import decorateurs.Caramel;
import decorateurs.Chocolat;

import javax.swing.*;
import java.awt.*;


public class ApplicationGui {
    private Boisson boisson; // La boisson actuelle
    final JTextArea affichage; // Zone pour afficher la description et le coût

    public ApplicationGui() {

        // Initialiser l'interface graphique
        JFrame frame = new JFrame("Café Personnalisé");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);
        frame.setLayout(new BorderLayout());


        // Ajouter une zone pour afficher la description et le coût
        affichage = new JTextArea();
        affichage.setEditable(false);
        affichage.setFont(new Font("Arial", Font.PLAIN, 14));
        frame.add(new JScrollPane(affichage), BorderLayout.CENTER);

        // Ajouter des boutons pour les boissons et les décorateurs
        JPanel boutonPanel = new JPanel();
        boutonPanel.setLayout(new GridLayout(2, 3, 10, 10));
        // Boutons pour choisir les boissons de base
        JButton boutonSumatra = new JButton("Sumatra");
        boutonSumatra.addActionListener(e -> choisirBoisson(new Sumatra()));

        JButton boutonEspresso = new JButton("Espresso");
        boutonEspresso.addActionListener(e -> choisirBoisson(new Espresso()));

        JButton boutonDeca = new JButton("Deca");
        boutonDeca.addActionListener(e -> choisirBoisson(new Deca()));

        // Boutons pour ajouter des décorateurs
        JButton boutonChocolat = new JButton("Ajouter Chocolat");
        boutonChocolat.addActionListener(e -> ajouterDecorateur(new Chocolat(boisson)));

        JButton boutonCaramel = new JButton("Ajouter Caramel");
        boutonCaramel.addActionListener(e -> ajouterDecorateur(new Caramel(boisson)));
        // Ajouter les boutons au panneau
        boutonPanel.add(boutonSumatra);
        boutonPanel.add(boutonEspresso);
        boutonPanel.add(boutonDeca);
        boutonPanel.add(boutonChocolat);
        boutonPanel.add(boutonCaramel);

        frame.add(boutonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void choisirBoisson(Boisson boisson) {
        this.boisson = boisson;
        mettreAJourAffichage();
    }

    private void ajouterDecorateur(Boisson decorateur) {
        if (boisson == null) {
            JOptionPane.showMessageDialog(null, "Veuillez d'abord choisir une boisson !");
        } else {
            boisson = decorateur;
            mettreAJourAffichage();

        }
    }

    private void mettreAJourAffichage() {
        if (boisson != null) {
            affichage.setText("Description: " + boisson.getDescription() + "\nCoût: " + boisson.cout() + "€");
        }
    }

        public static void main (String[]args){
            new ApplicationGui();
    }
}