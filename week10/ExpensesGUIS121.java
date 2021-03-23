package finalassign;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExpensesGUIS121 extends JFrame {

	private JPanel contentPane;
	private JTable paymentTable;
	private AddPD addDialog;
	
	private Expenses expenses;
	private PaymentTableModel paymentTM;

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
		expenses = new Expenses("James Bond");
		addDialog = new AddPD(expenses);
		paymentTM = new PaymentTableModel(expenses);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				if (selectedRow >= 0)
					paymentTM.delPayment(selectedRow);
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
