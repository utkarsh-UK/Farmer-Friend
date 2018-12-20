import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Enrollment extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtContact;
	private JTextField txtJoin;
	Connection con=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Enrollment frame = new Enrollment();
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
	public Enrollment() {
		con=WorkerDB.dbConnector();
		
		setTitle("Enrollment Window");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHead = new JLabel("Add Worker Information :");
		lblHead.setForeground(Color.RED);
		lblHead.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblHead.setHorizontalAlignment(SwingConstants.CENTER);
		lblHead.setBounds(44, 11, 268, 49);
		contentPane.add(lblHead);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(44, 71, 98, 27);
		contentPane.add(lblName);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setBounds(44, 120, 98, 27);
		contentPane.add(lblGender);
		
		txtName = new JTextField();
		txtName.setToolTipText("Enter name of the worker");
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtName.setBounds(215, 71, 165, 27);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		final JComboBox comboGender = new JComboBox();
		comboGender.setToolTipText("Select gender");
		comboGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboGender.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		comboGender.setBounds(215, 120, 115, 21);
		contentPane.add(comboGender);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setBounds(44, 162, 98, 27);
		contentPane.add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setToolTipText("Enter the address");
		txtAddress.setHorizontalAlignment(SwingConstants.CENTER);
		txtAddress.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtAddress.setBounds(215, 158, 165, 27);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		JLabel lblContact = new JLabel("Contact No :");
		lblContact.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblContact.setHorizontalAlignment(SwingConstants.CENTER);
		lblContact.setBounds(44, 205, 98, 27);
		contentPane.add(lblContact);
		
		txtContact = new JTextField();
		txtContact.setToolTipText("Enter contact details");
		txtContact.setHorizontalAlignment(SwingConstants.CENTER);
		txtContact.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtContact.setBounds(215, 211, 165, 27);
		contentPane.add(txtContact);
		txtContact.setColumns(10);
		
		JLabel lblJoin = new JLabel("Joining Date :");
		lblJoin.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblJoin.setHorizontalAlignment(SwingConstants.CENTER);
		lblJoin.setBounds(44, 270, 115, 27);
		contentPane.add(lblJoin);
		
		txtJoin = new JTextField();
		txtJoin.setToolTipText("Provide the joining date");
		txtJoin.setHorizontalAlignment(SwingConstants.CENTER);
		txtJoin.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtJoin.setBounds(215, 270, 165, 27);
		contentPane.add(txtJoin);
		txtJoin.setColumns(10);
		
		JLabel lblToken = new JLabel("Token :");
		lblToken.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblToken.setHorizontalAlignment(SwingConstants.CENTER);
		lblToken.setBounds(44, 332, 98, 27);
		contentPane.add(lblToken);
		
		final JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		spinner.setBounds(215, 338, 52, 28);
		contentPane.add(spinner);
		
		JLabel lblWage = new JLabel("Wage Status :");
		lblWage.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblWage.setHorizontalAlignment(SwingConstants.CENTER);
		lblWage.setBounds(44, 393, 115, 27);
		contentPane.add(lblWage);
		
		final JComboBox comboWage = new JComboBox();
		comboWage.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		comboWage.setModel(new DefaultComboBoxModel(new String[] {"Provided", "Pending", "Suspended"}));
		comboWage.setBounds(215, 399, 115, 21);
		contentPane.add(comboWage);
		
		JButton btnSave = new JButton("Save Data");
		btnSave.setToolTipText("Click to save database");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PreparedStatement stmt;
				try {
					stmt = con.prepareStatement("INSERT into WorkerData values(?,?,?,?,?,?,?,?)");
					stmt.setInt(1,101);
					stmt.setString(2,txtName.getText());
					stmt.setString(3,comboGender.getSelectedItem().toString());
					stmt.setString(4,txtAddress.getText());
					stmt.setString(5,txtContact.getText());
					stmt.setString(6,txtJoin.getText());
					Object temp=spinner.getValue();
					int i=Integer.parseInt(temp.toString());
					stmt.setInt(7,i);
					stmt.setString(8,comboWage.getSelectedItem().toString());
					int n=stmt.executeUpdate();
					con.close();
					JOptionPane.showMessageDialog(null, "Data Saved..");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnSave.setForeground(Color.BLUE);
		btnSave.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnSave.setBounds(159, 455, 126, 27);
		contentPane.add(btnSave);
	}
}
