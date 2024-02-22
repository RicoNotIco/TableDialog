package itiscuneo.frontend;

import javax.swing.*;
import java.awt.*;

public class DialogCespiti extends JDialog {



    private FrameCespiti frameCespiti;
    private JTextField txtFieldCodice;
    private JTextField txtFieldQuantita;
    private JTextField txtFieldDataAcquisto;
    private JButton btnUndo;
    private JButton btnOk;

    public DialogCespiti(FrameCespiti frameCespiti) {
        this.frameCespiti = frameCespiti;
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new GridLayout(4,2));


        this.add(new JLabel("Codice:"));
        txtFieldCodice = new JTextField(10);
        this.add(txtFieldCodice);

        this.add(new JLabel("Quantita:"));
        txtFieldQuantita = new JTextField(10);
        this.add(txtFieldQuantita);

        this.add(new JLabel("DataAcquisto:"));
        txtFieldDataAcquisto = new JTextField(10);
        this.add(txtFieldDataAcquisto);


        btnOk = new JButton("ok");
        btnUndo = new JButton("Annulla");

        this.add(btnUndo);
        this.add(btnOk);

        this.pack();
    }

}
