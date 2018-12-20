import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;

import javax.swing.JTable;
import javax.swing.JButton;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Rectangle;
import javax.swing.JScrollPane;


public class Token extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection con=null;
	DefaultTableModel dtm;
	String click;
	PreparedStatement pst;
	private JButton btnEnroll;
	private JButton btnUpdate;
	private JButton btnRemove;
	private JLabel lblToken;
	private JSpinner spinner;
	private JButton btnNewButton;
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblAddress;
	private JTextField txtAddress;
	private JLabel lblContact;
	private JTextField txtContact;
	private JLabel lblWages;
	JComboBox comboWage;
	JComboBox comboToken;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Token frame = new Token();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void refresh(){
		try {
			pst = con.prepareStatement("SELECT Name,Gender,Address,Contact,Joining_Date,Token,Wage,Salary from WorkerData");
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public Token() {
		setBounds(new Rectangle(100, 100, 700, 400));
		con=WorkerDB.dbConnector();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\token.png"));
		setResizable(false);
		setTitle("Token Window");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 150, 718, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Object[] title={"Name","Gender","Address","Contact No","Joining Date","Tokens","Wage Status","Salary"};
		dtm=new DefaultTableModel();
		dtm.setColumnIdentifiers(title);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 534, 243);
		contentPane.add(scrollPane);
		

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int row=table.getSelectedRow();
				if(row>-1)
					click=(table.getModel().getValueAt(row, 0).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Gender", "Address", "Contact No.", "Joining Date", "Tokens", "Wage", "Salary"
			}
		));
		
		JButton btnLoad = new JButton("Load Data");
		btnLoad.setToolTipText("Load the workers' database");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					pst = con.prepareStatement("SELECT Name,Gender,Address,Contact,Joining_Date,Token,Wage,Salary from WorkerData");
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnLoad.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnLoad.setBounds(573, 11, 129, 29);
		contentPane.add(btnLoad);
		
		btnEnroll = new JButton("Enroll");
		btnEnroll.setToolTipText("Add new worker to database");
		btnEnroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Enrollment().setVisible(true);
				refresh();
				
			}
		});
		btnEnroll.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnEnroll.setBounds(573, 62, 129, 29);
		contentPane.add(btnEnroll);
		
		btnUpdate = new JButton("Update Data");
		btnUpdate.setToolTipText("Update the existing worker's information(Name,Address,Contact No.,Wage Status)");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int i=table.getSelectedRow();
				String name=model.getValueAt(i, 0).toString();
				try {
					PreparedStatement ps=con.prepareStatement("UPDATE WorkerData set Name=?,Address=?,Contact=?,Wage=? where Name=?");
					ps.setString(1, txtName.getText());
					ps.setString(2,txtAddress.getText());
					ps.setString(3,txtContact.getText());
					ps.setString(4,comboWage.getSelectedItem().toString());
					ps.setString(5,name);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Updated");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				refresh();
			}
		});
		btnUpdate.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnUpdate.setBounds(272, 301, 176, 36);
		contentPane.add(btnUpdate);
		
		btnRemove = new JButton("Remove");
		btnRemove.setToolTipText("Remove an entry from database");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int sr=0;
					DefaultTableModel model=(DefaultTableModel)table.getModel();
					sr=table.getSelectedRow();
						String name=model.getValueAt(sr,0).toString();
						PreparedStatement ps=con.prepareStatement("DELETE from WorkerData where Name=?");
						ps.setString(1,name);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null,"Data Removed");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				refresh();
			}
		});
		btnRemove.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnRemove.setBounds(573, 112, 129, 29);
		contentPane.add(btnRemove);
		
		lblToken = new JLabel("Token");
		lblToken.setHorizontalAlignment(SwingConstants.CENTER);
		lblToken.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblToken.setBounds(554, 166, 78, 29);
		contentPane.add(lblToken);
		
		spinner = new JSpinner();
		spinner.setBounds(658, 170, 44, 26);
		contentPane.add(spinner);
		
		btnNewButton = new JButton("Update Tokens");
		btnNewButton.setToolTipText("Update the tokens of selected worker");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 DefaultTableModel model=(DefaultTableModel)table.getModel();
				 int i=table.getSelectedRow();
				 String name=model.getValueAt(i, 0).toString();
				 Object temp=spinner.getValue();
				 int n=Integer.parseInt(temp.toString());
				 try {
					PreparedStatement ps=con.prepareStatement("UPDATE WorkerData set Token=? where Name=?");
					ps.setInt(1,n);
					ps.setString(2, name);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Tokens Updated");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				 refresh();
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnNewButton.setBounds(550, 225, 152, 36);
		contentPane.add(btnNewButton);
		
		lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Arial", Font.BOLD, 16));
		lblName.setBounds(10, 261, 61, 19);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtName.setBounds(104, 261, 117, 19);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setBounds(10, 296, 78, 19);
		contentPane.add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtAddress.setColumns(10);
		txtAddress.setBounds(104, 298, 117, 19);
		contentPane.add(txtAddress);
		
		lblContact = new JLabel("Contact");
		lblContact.setHorizontalAlignment(SwingConstants.CENTER);
		lblContact.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblContact.setBounds(10, 332, 78, 19);
		contentPane.add(lblContact);
		
		txtContact = new JTextField();
		txtContact.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtContact.setColumns(10);
		txtContact.setBounds(104, 334, 117, 19);
		contentPane.add(txtContact);
		
		lblWages = new JLabel("Wages");
		lblWages.setHorizontalAlignment(SwingConstants.CENTER);
		lblWages.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblWages.setBounds(231, 261, 78, 19);
		contentPane.add(lblWages);
		
		comboWage = new JComboBox();
		comboWage.setModel(new DefaultComboBoxModel(new String[] {"Provided", "Pending", "Suspended"}));
		comboWage.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		comboWage.setBounds(333, 261, 115, 21);
		contentPane.add(comboWage);
		
		comboToken = new JComboBox();
		comboToken.setModel(new DefaultComboBoxModel(new String[] {"50", "100", "200", "500", "2000"}));
		comboToken.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		comboToken.setBounds(627, 282, 57, 20);
		contentPane.add(comboToken);
		
		JLabel lblValue = new JLabel("Token Value(Rs.)");
		lblValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblValue.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblValue.setBounds(476, 282, 134, 20);
		contentPane.add(lblValue);
		
		JButton btnNewButton_1 = new JButton("Calculate Salary");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 DefaultTableModel model=(DefaultTableModel)table.getModel();
				 int i=table.getSelectedRow();
				 String name=model.getValueAt(i, 0).toString();
				 int tokenVal=Integer.parseInt(model.getValueAt(i,5).toString());
				 int val=Integer.parseInt(comboToken.getSelectedItem().toString());
				 int result=tokenVal*val;
				 
				 try {
						PreparedStatement ps=con.prepareStatement("UPDATE WorkerData set Salary=? where Name=?");
						ps.setInt(1,result);
						ps.setString(2, name);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null,name+" owns salary of Rs. "+result);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				 refresh();
			}
		});
		btnNewButton_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnNewButton_1.setBounds(508, 314, 176, 36);
		contentPane.add(btnNewButton_1);
	}
}
