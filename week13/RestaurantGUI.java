package restaurantapp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RestaurantGUI extends JFrame {

	private JPanel contentPane;
	private Restaurant restaurant;
	private MenuItemDialog miDialog;
	private NewOrderDialog noDialog;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestaurantGUI frame = new RestaurantGUI();
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
	public RestaurantGUI() {
		restaurant = new Restaurant();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblRestaurantOrderingSystem = new JLabel("Restaurant Ordering System");
		lblRestaurantOrderingSystem.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblRestaurantOrderingSystem, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JButton btnMaintainMenuitem = new JButton("Maintain MenuItem");
		btnMaintainMenuitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(restaurant.numOfItems());
				miDialog = new MenuItemDialog(restaurant);
				miDialog.setVisible(true);
				System.out.println("After " + restaurant.numOfItems());
			}
		});
		panel_1.add(btnMaintainMenuitem);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JButton newOrderBtn = new JButton("Create New Order");
		newOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        NewOrderDialog orderDialog = new NewOrderDialog(restaurant);
		        orderDialog.setVisible(true);

			}
		});
		panel_2.add(newOrderBtn);
		
		JButton btnViewAllOrders = new JButton("View All Orders");
		btnViewAllOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderStatusWindow osw = new OrderStatusWindow(restaurant);
				osw.setVisible(true);
			}
		});
		panel.add(btnViewAllOrders);
	}

}
