import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Invoice extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtName;
	private JLabel lblPriceValue;
	private JLabel jTotalValue;
	private JComboBox comboItem;
	private JComboBox comboQuantity;
	private String[] cropName={"Wheat","Rice","Jowar","Ragi","Bajra"};
	private int[] cropPrice={100,200,300,400,500};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Invoice frame = new Invoice();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void calSum(){
		int val=0,sum=0;
		String selectedItem=comboItem.getSelectedItem().toString();
		int quantity=Integer.parseInt(comboQuantity.getSelectedItem().toString());
		for(int i=0;i<5;i++){
			if(selectedItem.equals(cropName[i])){
				val=cropPrice[i];
				break;
			}
		}
		int resultantPrice=val*quantity;
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		model.addRow(new Object[]{ selectedItem , quantity, resultantPrice});
	}
	
	public void getTotal(){
		int sum=0;
		for(int i=0;i<table.getRowCount();i++)
			sum+=Integer.parseInt(table.getValueAt(i, 2).toString());
		jTotalValue.setText(Integer.toString(sum));
	}
	/**
	 * Create the frame.
	 */
	public Invoice() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\records.png"));
		setTitle("Invoice");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(350, 100, 651, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 104, 502, 239);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Item Name", "Quantity", "Price"
			}
		));
		scrollPane.setViewportView(table);
		table.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		
		JLabel jInvoiceLabel = new JLabel(" Invoice No :");
		jInvoiceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jInvoiceLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
		jInvoiceLabel.setBounds(10, 11, 113, 26);
		contentPane.add(jInvoiceLabel);
		
		JLabel jNumberLabel = new JLabel("");
		jNumberLabel.setForeground(new Color(0, 0, 255));
		jNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jNumberLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
		jNumberLabel.setBounds(133, 11, 94, 26);
		contentPane.add(jNumberLabel);
		
		JLabel jNameLabel = new JLabel("Name :");
		jNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jNameLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
		jNameLabel.setBounds(246, 11, 94, 26);
		contentPane.add(jNameLabel);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtName.setBounds(356, 10, 199, 27);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel jItemLabel = new JLabel("Select Item :");
		jItemLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jItemLabel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		jItemLabel.setBounds(20, 64, 94, 19);
		contentPane.add(jItemLabel);
		
		comboItem = new JComboBox();
		comboItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selectedItem=comboItem.getSelectedItem().toString();
				int val=0;
				for(int i=0;i<5;i++){
					if(selectedItem.equals(cropName[i])){
						val=cropPrice[i];
					}
				}				
				lblPriceValue.setText(Integer.toString(val));
			}
		});
		comboItem.setModel(new DefaultComboBoxModel(new String[] {"Wheat", "Rice", "Jowar", "Ragi", "Bajra", "Cardamom", "Nutmeg", "Turmeric", "DryChillis", "Pepper", "SafflowerSeed", "SesameSeed", "CottonSeed", "MastardSeed", "SoyabeanSeed", "Coriander", "LadyFinger", "Cauliflowers", "GreenPeas", "Pumpkin", "Potatoes", "BitterGourds", "Tomatoes", "Cabbages", "Onions", "FrenchBeans", "Brinjal", "Radish", "Carrots", "Spinach", "Capsicum", "Fenugreek", "Chawli", "Cucumber", "Beetroot", "Apples", "CusterdApples", "Pineapples", "Coconuts", "Banana", "Mangoes", "Guavas", "Papaya", "Strawberries", "Pomogranets", "Grapes", "Oranges", "Chickoos", "Muskmelon", "Watermelon", "Sugarcane", "Jackfruits", "Jamuns", "Litches", "Peaches", "Dates", "Marigold", "Lotus", "Sunflower", "Rose", "Jasmine", "Tulips", "Daffodils", "Pansy", "Hibiscus", "Bougainvillea", "CashewNuts", "Groundnuts", "Tea", "Coffee", "Cocoa"}));
		comboItem.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		comboItem.setBounds(124, 60, 118, 26);
		contentPane.add(comboItem);
		
		JLabel jPriceLabel = new JLabel("Price :");
		jPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jPriceLabel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		jPriceLabel.setBounds(246, 64, 88, 19);
		contentPane.add(jPriceLabel);
		
		lblPriceValue = new JLabel("");
		lblPriceValue.setForeground(new Color(255, 0, 255));
		lblPriceValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblPriceValue.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblPriceValue.setBounds(316, 48, 88, 45);
		contentPane.add(lblPriceValue);
		
		JLabel jQuantityLabel = new JLabel("Quantity :");
		jQuantityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jQuantityLabel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		jQuantityLabel.setBounds(400, 64, 88, 19);
		contentPane.add(jQuantityLabel);
		
		comboQuantity = new JComboBox();
		comboQuantity.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "10", "15", "20"}));
		comboQuantity.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		comboQuantity.setBounds(498, 60, 51, 26);
		contentPane.add(comboQuantity);
		
		JButton btnAdd = new JButton("");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calSum();
				getTotal();
			}
		});
		btnAdd.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Actions-list-add-icon.png"));
		btnAdd.setBounds(559, 48, 72, 57);
		contentPane.add(btnAdd);
		
		JLabel jTotalLabel = new JLabel("Total :");
		jTotalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jTotalLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
		jTotalLabel.setBounds(412, 354, 100, 26);
		contentPane.add(jTotalLabel);
		
		jTotalValue = new JLabel("");
		jTotalValue.setForeground(new Color(255, 0, 0));
		jTotalValue.setFont(new Font("Century Gothic", Font.BOLD, 20));
		jTotalValue.setHorizontalAlignment(SwingConstants.CENTER);
		jTotalValue.setBounds(522, 354, 88, 26);
		contentPane.add(jTotalValue);
	}
}
