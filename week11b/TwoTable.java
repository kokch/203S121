package expenses;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TwoTable extends JFrame {
	private JPanel contentPane;
	private JTable paymentTable;
	private JTable productTable;
	private Expenses expenses;
	private PaymentTM paymentModel;
	private ProductTM productModel;
	
	private AddCCJD accjd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TwoTable frame = new TwoTable();
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
	public TwoTable() {
		expenses = new Expenses("James Bond");
		setTitle("Expenses for " + expenses.getName());
		paymentModel = new PaymentTM(expenses);
		productModel = new ProductTM();
		
		accjd = new AddCCJD(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 10));
		
		JPanel topPanel = new JPanel();
		topPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(topPanel);
		topPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblListOfPayments = new JLabel("List of Payments");
		topPanel.add(lblListOfPayments, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		topPanel.add(scrollPane, BorderLayout.CENTER);
		
		paymentTable = new JTable();
		paymentTable.setModel(paymentModel);
		scrollPane.setViewportView(paymentTable);
		
		JPanel btnPanel = new JPanel();
		topPanel.add(btnPanel, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accjd.setVisible(true); // will block
				Payment p = accjd.getPayment();
				if (p == null)
					JOptionPane.showMessageDialog(TwoTable.this, 
						"Addition Cancelled");
				else {
					paymentModel.add(p);
				}
			}
		});
		btnPanel.add(btnAdd);

		paymentTable.getSelectionModel().addListSelectionListener(
			new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent lse)
			{
				int row = paymentTable.getSelectedRow();
				if (row != -1) // paymentTable.isRowSelected(row);
				{
					Payment p = paymentModel.get(row);
					productModel.setItems(p.getItems());
				}			
			}
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = paymentTable.getSelectedRow();
				if (paymentTable.isRowSelected(row)) {
					paymentModel.remove(row);
					productModel.setItems(new ArrayList<>());
				}
				else
					JOptionPane.showMessageDialog(null,
						"Please select a row to delete");
			}
		});
		btnPanel.add(btnDelete);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(bottomPanel);
		bottomPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblListOfProducts = new JLabel("List of Products");
		bottomPanel.add(lblListOfProducts, BorderLayout.NORTH);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		bottomPanel.add(scrollPane_1, BorderLayout.CENTER);
		
		productTable = new JTable();
		productTable.setModel(productModel);
		scrollPane_1.setViewportView(productTable);
		
		JPanel panel = new JPanel();
		bottomPanel.add(panel, BorderLayout.SOUTH);
		
		JButton btnDelete_1 = new JButton("Delete");
		panel.add(btnDelete_1);
	}
}
