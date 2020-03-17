package presentation;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.table.DefaultTableModel;


public class View extends JFrame {
	private final JButton buton1;
	private final JButton buton2;
	public JTable table;
	public JTable table2;

	public static DefaultTableModel tableModel = new DefaultTableModel();
	public static DefaultTableModel tableModel2 = new DefaultTableModel();

	private JLabel l1 = new JLabel("Gestionare clienti");
	private JLabel l2 = new JLabel("Gestionare produse");
	String sText1 = "        COMANDA:";
	String sText2 = "<html> " + "  -selectati un client existent <br/>  -selectati un produs existent " + "</html>";
	String sText3 = "<html>  -intoduceti cantitatea dorita <br/>" + "  -incercati validarea comenzii</html>";
	private JLabel l3 = new JLabel();
	private JButton b3 = new JButton("Salvare editare");
	private JButton b4 = new JButton("Stergere");
	private JButton b5 = new JButton("Adaugare client:");
	private JLabel l4 = new JLabel("ID:", SwingConstants.CENTER);
	private JLabel l5 = new JLabel("NUME:", SwingConstants.CENTER);
	private JLabel l6 = new JLabel("CREDIT:", SwingConstants.CENTER);
	private JTextField t1 = new JTextField();
	private JTextField t2 = new JTextField();
	private JTextField t3 = new JTextField();
	private JButton b6 = new JButton("Validare ");
	private JTextField t4 = new JTextField();
	private JTextField t5 = new JTextField();
	private JButton b7 = new JButton("Salvare editare");
	private JButton b8 = new JButton("Stergere");
	private JButton b9 = new JButton("Adaugare produs:");
	private JLabel l7 = new JLabel("ID:", SwingConstants.CENTER);
	private JLabel l8 = new JLabel("DENUMIRE:", SwingConstants.CENTER);
	private JLabel l9 = new JLabel("CANTITATE:", SwingConstants.CENTER);
	private JLabel l10 = new JLabel("PRET:", SwingConstants.CENTER);
	private JTextField t6 = new JTextField();
	private JTextField t7 = new JTextField();
	private JTextField t8 = new JTextField();
	private JTextField t9 = new JTextField();
	private JTextField t10 = new JTextField();
	private JTextField t11 = new JTextField();
	private JButton b10 = new JButton("Validare ");
	private JLabel l11 = new JLabel("CANTITATE DORITA:");
	private JTextField t12 = new JTextField();
	private JButton b11 = new JButton("ADAUGARE COMANDA");

	public View() {
		//bl = b;
		table = new JTable(tableModel);
		table2 = new JTable(tableModel2);

		// add(new JScrollPane(table),BorderLayout.CENTER);
		// add(new JScrollPane(table2),BorderLayout.AFTER_LAST_LINE);
		buton1 = new JButton("Afisare clienti");

		buton2 = new JButton("Afisare produse");

		// PANEL MARE
		JPanel panelM = new JPanel();
		panelM.setLayout(new GridLayout(1, 4));

		// PANEL SUS
		// JPanel panels =new JPanel();
		// panels.setLayout(new GridLayout(1,4));

		JPanel panels1 = new JPanel();
		panels1.setLayout(new GridLayout(1, 2));

		JPanel panels1fara = new JPanel();
		panels1fara.setLayout(new GridLayout(16, 1));
		panels1fara.setBackground(Color.decode("#ABEEB5"));
		panels1fara.add(l1);
		panels1fara.add(buton1);
		panels1fara.add(b3);
		panels1fara.add(b4);
		panels1fara.add(new JLabel());
		panels1fara.add(new JLabel());
		panels1fara.add(new JLabel());
		panels1fara.add(new JLabel());
		panels1fara.add(b5);
		b5.setBackground(Color.decode("#C9F2C5"));
		panels1fara.add(new JLabel());
		panels1fara.add(new JLabel());
		panels1fara.add(new JLabel());
		panels1fara.add(new JLabel());
		JLabel ajutor1 = new JLabel();
		ajutor1.setText(sText1);
		ajutor1.setBackground(Color.decode("#F8C0B7"));
		ajutor1.setFont(new Font("TimesRoman", Font.PLAIN | Font.BOLD | Font.CENTER_BASELINE, 15));
		ajutor1.setOpaque(true);
		panels1fara.add(ajutor1);
		// panels1fara.add(new JLabel());
		// comanda
		l3.setBackground(Color.decode("#F8C0B7"));
		// l3.setForeground(Color.decode("#D0F5B1"));
		l3.setOpaque(true);
		l3.setText(sText2);
		l3.setFont(new Font("Sitka Banner ", Font.BOLD | Font.ITALIC, 15));
		panels1fara.add(l3);
		JLabel ajutor = new JLabel();
		ajutor.setText(sText3);
		ajutor.setFont(new Font("Sitka Banner ", Font.BOLD | Font.ITALIC, 15));
		ajutor.setBackground(Color.decode("#F8C0B7"));
		ajutor.setOpaque(true);
		panels1fara.add(ajutor);
		// panels1.add(new JScrollPane(table));

		JPanel panels1cu = new JPanel();
		panels1cu.setLayout(new GridLayout(2, 1));
		table.setBackground(Color.decode("#ABEEB5"));

		JPanel panels1cutabel = new JPanel();
		panels1cutabel.setLayout(new GridLayout(1, 1));
		panels1cutabel.add(new JScrollPane(table));

		JPanel panels1cufara = new JPanel();
		panels1cufara.setLayout(new GridLayout(8, 2));
		panels1cufara.setBackground(Color.decode("#C9F2C5"));
		panels1cufara.add(l4);
		panels1cufara.add(t1);
		panels1cufara.add(l5);
		panels1cufara.add(t2);
		panels1cufara.add(l6);
		panels1cufara.add(t3);
		panels1cufara.add(b6);
		panels1cufara.add(new JLabel());
		panels1cufara.add(new JLabel());
		panels1cufara.add(new JLabel());
		JLabel ajutor3 = new JLabel("ID client:");
		ajutor3.setBackground(Color.decode("#F8C0B7"));
		ajutor3.setOpaque(true);
		panels1cufara.add(ajutor3);
		// panels1cufara.add(new JLabel());
		JLabel ajutor2 = new JLabel("Nume:");
		ajutor2.setBackground(Color.decode("#F8C0B7"));
		ajutor2.setOpaque(true);
		panels1cufara.add(ajutor2);
		// panels1cufara.add(new JLabel());
		panels1cufara.add(t4);
		panels1cufara.add(t5);
		t4.setBackground(Color.decode("#F8C0B7"));
		t5.setBackground(Color.decode("#F8C0B7"));
		JLabel ajutor4 = new JLabel();
		ajutor4.setBackground(Color.decode("#F8C0B7"));
		ajutor4.setOpaque(true);
		panels1cufara.add(ajutor4);
		JLabel ajutor5 = new JLabel();
		ajutor5.setBackground(Color.decode("#F8C0B7"));
		ajutor5.setOpaque(true);
		panels1cufara.add(ajutor5);
		// panels1cufara.add(new JLabel());
		// panels1cufara.add(new JLabel());

		b5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				panels1cufara.add(l4);
				panels1cufara.add(t1);
				panels1cufara.add(l5);
				panels1cufara.add(t2);
				panels1cufara.add(l6);
				panels1cufara.add(t3);
				panels1cufara.add(b6);

			}

		});

		panels1cu.add(panels1cutabel);
		panels1cu.add(panels1cufara);

		panels1.add(panels1fara);
		panels1.add(panels1cu);

		JPanel panels2 = new JPanel();
		panels2.setLayout(new GridLayout(1, 2));

		JPanel panels2fara = new JPanel();
		panels2fara.setLayout(new GridLayout(16, 1));
		panels2fara.setBackground(Color.decode("#F7FBC2"));
		panels2fara.add(l2);
		panels2fara.add(buton2);
		panels2fara.add(b7);
		panels2fara.add(b8);
		panels2fara.add(new JLabel());
		panels2fara.add(new JLabel());
		panels2fara.add(new JLabel());
		panels2fara.add(new JLabel());
		panels2fara.add(b9);
		b9.setBackground(Color.decode("#F0F981"));
		panels2fara.add(new JLabel());
		panels2fara.add(new JLabel());
		panels2fara.add(new JLabel());
		panels2fara.add(new JLabel());
		// panels2fara.add(new JLabel());

		l11.setBackground(Color.decode("#F8C0B7"));
		l11.setOpaque(true);
		panels2fara.add(l11);
		panels2fara.add(t12);
		// t12.setBackground(Color.decode("#F8C0B7"));
		panels2fara.add(b11);

		// panels2.add(new JScrollPane(table2));

		JPanel panels2cu = new JPanel();
		panels2cu.setLayout(new GridLayout(2, 1));
		panels2cu.setBackground(Color.decode("#F7FBC2"));
		table2.setBackground(Color.decode("#F7FBC2"));

		JPanel panels2cutabel = new JPanel();
		panels2cutabel.setLayout(new GridLayout(1, 1));
		panels2cutabel.add(new JScrollPane(table2));

		JPanel panels2cufara = new JPanel();
		panels2cufara.setLayout(new GridLayout(8, 2));
		panels2cufara.setBackground(Color.decode("#F0F981"));
		panels2cufara.add(l7);
		panels2cufara.add(t6);
		panels2cufara.add(l8);
		panels2cufara.add(t7);
		panels2cufara.add(l9);
		panels2cufara.add(t8);
		panels2cufara.add(l10);
		panels2cufara.add(t9);
		panels2cufara.add(b10);
		panels2cufara.add(new JLabel());
		JLabel ajutor8 = new JLabel("ID produs:");
		ajutor8.setBackground(Color.decode("#F8C0B7"));
		ajutor8.setOpaque(true);
		panels2cufara.add(ajutor8);
		JLabel ajutor9 = new JLabel("Cantitate disponibila:");
		ajutor9.setBackground(Color.decode("#F8C0B7"));
		ajutor9.setOpaque(true);
		panels2cufara.add(ajutor9);
		// panels2cufara.add(new JLabel());
		// panels2cufara.add(new JLabel());
		panels2cufara.add(t10);
		panels2cufara.add(t11);
		t10.setBackground(Color.decode("#F8C0B7"));
		t11.setBackground(Color.decode("#F8C0B7"));
		JLabel ajutor6 = new JLabel();
		ajutor6.setBackground(Color.decode("#F8C0B7"));
		ajutor6.setOpaque(true);
		panels2cufara.add(ajutor6);
		JLabel ajutor7 = new JLabel();
		ajutor7.setBackground(Color.decode("#F8C0B7"));
		ajutor7.setOpaque(true);
		panels2cufara.add(ajutor7);

		panels2cu.add(panels2cutabel);
		panels2cu.add(panels2cufara);
		// panels2.setPreferredSize(new Dimension(40, 80));
		panels2.add(panels2fara);
		// panels2.add(panels2int);
		panels2.add(panels2cu);

		t1.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		t2.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		t3.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		t4.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		t5.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		t6.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		t7.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		t8.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		t9.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		t10.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		t11.setFont(new Font("Sitka Banner", Font.PLAIN, 16));
		t12.setFont(new Font("Sitka Banner", Font.PLAIN, 20));

		l1.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 16));
		l2.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 16));
		// l3.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 16));
		l4.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 16));
		l5.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 16));
		l6.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 16));
		l7.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 16));
		l8.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 16));
		l9.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 16));
		l10.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 16));
		l11.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 16));

		buton1.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 16));
		buton2.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 16));
		b3.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 16));
		b4.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 16));
		b5.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 16));
		b6.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 16));
		b7.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 16));
		b8.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 16));
		b9.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 16));
		b10.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 16));
		b11.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 16));

		// add(buton1,BorderLayout.PAGE_START);
		// add(buton2,BorderLayout.AFTER_LAST_LINE);
		panelM.add(panels1);
		panelM.add(panels2);

		this.setContentPane(panelM);
		this.setTitle("ORDER MANAGEMENT");
		this.setSize(1500, 600);
		this.setLocation(30, 150);
		// this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void addClientiListener(ActionListener adauga) {
		buton1.addActionListener(adauga);
	}

	public void addProduseListener(ActionListener adauga) {
		buton2.addActionListener(adauga);
	}

	public void addComandaListener(ActionListener adauga) {
		b11.addActionListener(adauga);
	}

	public void adaugareClientListener(ActionListener adauga) {
		b6.addActionListener(adauga);
	}

	public void adaugareProdusListener(ActionListener adauga) {
		b10.addActionListener(adauga);
	}

	public void editareClientListener(ActionListener adauga) {
		b3.addActionListener(adauga);
	}

	public void editareProdusListener(ActionListener adauga) {
		b7.addActionListener(adauga);
	}

	public void stergereClientListener(ActionListener adauga) {
		b4.addActionListener(adauga);
	}

	public void stergereProdusListener(ActionListener adauga) {
		b8.addActionListener(adauga);
	}

	public void setidClient(String s) {
		t4.setText(s);
	}

	public void setNumeClient(String s) {
		t5.setText(s);
	}

	public void setidProdus(String s) {
		t10.setText(s);
	}

	public void setCantitate(String s) {
		t11.setText(s);
	}

	public void showError(String mesajEroare) {
		JOptionPane.showMessageDialog(this, mesajEroare);
	}

	public int getCantitateDorita() {
		return Integer.parseInt(t12.getText());
	}

	public void setCantitateDorita(String s) {
		t12.setText(s);
	}

	public int getIdClient() {
		return Integer.parseInt(t4.getText());
	}

	public int getIdProdus() {
		return Integer.parseInt(t10.getText());
	}

	public int getIdClientdeIntrodus() {
		return Integer.parseInt(t1.getText());
	}

	public int getCreditdeIntrodus() {
		return Integer.parseInt(t3.getText());
	}

	public String getNumedeIntrodus() {
		return t2.getText();
	}

	public int getIdProdusdeIntrodus() {
		return Integer.parseInt(t6.getText());
	}

	public int getProdCantitateIntrodus() {
		return Integer.parseInt(t8.getText());
	}

	public String getDenimiredeIntrodus() {
		return t7.getText();
	}

	public int getPretIntrodus() {
		return Integer.parseInt(t9.getText());
	}

}
