package itiscuneo.frontend;

import itiscuneo.backend.CespitiFile;
import itiscuneo.backend.ElencoCespiti;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameCespiti extends JFrame implements ActionListener {
    public ElencoCespiti getElencoCespiti() {
        return elencoCespiti;
    }

    private final ElencoCespiti elencoCespiti;
    private JButton btnNuovo;
    private DefaultTableModel dtmCespiti;
    private JTable tableCespiti;
    private JMenuItem menuItemJson;
    private JMenuItem menuItemCsv;


    public FrameCespiti() throws HeadlessException{
        super("gestioni cespiti");
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            elencoCespiti = new ElencoCespiti();
            initComponents();
            //tracing(vedere l'avanzamento del codice line to lin)
            // and whatches(vedere lo stato degli oggetti) quando metto un breakpoint e controllo variabili, oggetti ecc...

            //step into e step over,
            //step into

    }

    private void initComponents() {
        this.setLayout(new BorderLayout());

        JPanel panelTable = new JPanel();

        String[] aHeaderTableCespiti = {"codice","quantita","dataAcquisto"};

        dtmCespiti = new DefaultTableModel(aHeaderTableCespiti,0);

        tableCespiti = new JTable(dtmCespiti);
        panelTable.add(new JScrollPane(tableCespiti));

        JPanel panelCmd = new JPanel();

        btnNuovo=new JButton("Nuovo");
        btnNuovo.addActionListener(this);
        panelCmd.add(btnNuovo);

        this.add(panelTable, BorderLayout.CENTER);
        this.add(panelCmd, BorderLayout.EAST);

        JMenuBar menuBar= initMenu();
        this.setJMenuBar(menuBar);
    }

    private JMenuBar initMenu() {
        JMenuBar menuBar= new JMenuBar();
        JMenu menuFile = new JMenu("File");
        menuItemJson = new JMenuItem("Esporta json");
        menuItemCsv = new JMenuItem("Esporta csv");
        menuBar.add(menuFile);
        menuFile.add(menuItemJson);
        menuFile.add(menuItemCsv);

        menuItemCsv.addActionListener(this);
        menuItemJson.addActionListener(this);

        return menuBar;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnNuovo){
            new DialogCespiti(this).setVisible(true);
        }
        if(e.getSource()==menuItemCsv){
            CespitiFile cespitiFile = new CespitiFile();
            cespitiFile.scriviCsv(elencoCespiti);
        }
        if(e.getSource()==menuItemJson){

        }
    }

    public static void main(String[] args) {
        new FrameCespiti().setVisible(true);
    }

}
