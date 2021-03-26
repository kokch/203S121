package finalassign;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ExpensesGUIS121 extends JFrame {

	private JPanel contentPane;
	private JTable paymentTable;
	private AddPD addDialog;
	
	private Expenses expenses;
	private PaymentTableModel paymentTM;
	private JFileChooser fileChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExpensesGUIS121 frame = new ExpensesGUIS121();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ExpensesGUIS121() {
		expenses = new Expenses("Jimmy"); //James Bond");
		setTitle(expenses.getName());
		//addDialog = new AddPD(expenses);
		paymentTM = new PaymentTableModel(expenses);
		fileChooser = new JFileChooser();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int returnValue = fileChooser.showOpenDialog(ExpensesGUIS121.this);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					try (ObjectInputStream ois = new ObjectInputStream(
						new FileInputStream(file));
						BufferedReader br = new BufferedReader(new FileReader(
							file.getName() + ".txt"));) {
						
						expenses = (Expenses) ois.readObject();
						Payment.setAutoGN(Integer.parseInt(br.readLine()));
						
						setTitle(expenses.getName());
						paymentTM.setExpenses(expenses);
						paymentTM.fireTableDataChanged();
					} catch (ClassNotFoundException cnfe) {
						JOptionPane.showMessageDialog(ExpensesGUIS121.this,
								"Error in saving....");						
					} catch (IOException ioe) {
						JOptionPane.showMessageDialog(ExpensesGUIS121.this,
							"Error in saving....");
					}
				}
			}
		});
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int returnValue = fileChooser.showSaveDialog(ExpensesGUIS121.this);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					try (ObjectOutputStream oos = new ObjectOutputStream(
						new FileOutputStream(file));
						PrintWriter pw = new PrintWriter(new FileWriter(
							file.getName() + ".txt"));) {
						
						oos.writeObject(expenses);
						pw.println(Payment.getAutoGN());
						
					} catch (IOException ioe) {
						JOptionPane.showMessageDialog(ExpensesGUIS121.this,
							"Error in saving....");
					}
				}
			}
		});
		mnFile.add(mntmSave);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmDetail = new JMenuItem("Detail");
		mntmDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(ExpensesGUIS121.this,
					"The app is created by So and so.\nDate: March 2021.");
			}
		});
		mnAbout.add(mntmDetail);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDialog = new AddPD(expenses);
				addDialog.setVisible(true);
				paymentTM.fireTableDataChanged();
			}
		});
		panel.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = paymentTable.getSelectedRow();
				// if (paymentTable.isRowSelected(selectedRow))
				if (selectedRow >= 0) {
					int response = JOptionPane.showConfirmDialog(ExpensesGUIS121.this, 
						"Are you sure you want to delete?");
					if (response == JOptionPane.YES_OPTION)
						paymentTM.delPayment(selectedRow);
				}
				else
					JOptionPane.showMessageDialog(ExpensesGUIS121.this, 
						"Please select a row to delete!");
			}
		});
		panel.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		paymentTable = new JTable();
		paymentTable.setModel(paymentTM);
		scrollPane.setViewportView(paymentTable);
	}

}
