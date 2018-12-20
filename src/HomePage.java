import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class HomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\icon.png"));
		setSize(new Dimension(636, 486));
		setTitle("Green Grass");
		setResizable(false);
		setBounds(new Rectangle(400, 300, 636, 486));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 150, 636, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jWelcomeLabel = new JLabel("Welcome..!!");
		jWelcomeLabel.setForeground(Color.WHITE);
		jWelcomeLabel.setFont(new Font("Century Gothic", Font.BOLD, 24));
		jWelcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jWelcomeLabel.setBounds(216, 11, 200, 50);
		contentPane.add(jWelcomeLabel);
		
		JLabel jHomeLabel = new JLabel("");
		jHomeLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\farm1.png"));
		jHomeLabel.setBounds(10, 11, 610, 99);
		contentPane.add(jHomeLabel);
		
		JButton tokenBtn = new JButton("Token");
		tokenBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Token().setVisible(true);;
			}
		});
		tokenBtn.setIcon(null);
		tokenBtn.setForeground(Color.BLACK);
		tokenBtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
		tokenBtn.setBounds(85, 121, 210, 50);
		contentPane.add(tokenBtn);
		
		JButton notesBtn = new JButton("Remainder & Notes");
		notesBtn.setForeground(new Color(0, 0, 0));
		notesBtn.setFont(new Font("Century Gothic", Font.BOLD, 16));
		notesBtn.setBounds(85, 186, 210, 50);
		contentPane.add(notesBtn);
		
		JButton btnRecordsCalculations = new JButton("Records & Calculations");
		btnRecordsCalculations.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnRecordsCalculations.setBounds(85, 253, 210, 50);
		contentPane.add(btnRecordsCalculations);
		
		JButton btnWeatherUpdates = new JButton("Weather Updates");
		btnWeatherUpdates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new WeatherReport().setVisible(true);
			}
		});
		btnWeatherUpdates.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnWeatherUpdates.setBounds(396, 121, 210, 50);
		contentPane.add(btnWeatherUpdates);
		
		JButton btnCropCard = new JButton("Crop Card");
		btnCropCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CropCard().setVisible(true);
			}
		});
		btnCropCard.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnCropCard.setBounds(396, 186, 210, 50);
		contentPane.add(btnCropCard);
		
		JButton btnNews = new JButton("News");
		btnNews.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnNews.setBounds(396, 255, 210, 50);
		contentPane.add(btnNews);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\token.png"));
		lblNewLabel.setBounds(10, 121, 75, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Rem.png"));
		lblNewLabel_1.setBounds(10, 186, 75, 50);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\records.png"));
		lblNewLabel_2.setBounds(10, 253, 75, 50);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\weather.png"));
		lblNewLabel_3.setBounds(317, 121, 75, 50);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\cropcard.png"));
		lblNewLabel_4.setBounds(312, 186, 80, 50);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\news.png"));
		lblNewLabel_5.setBounds(317, 253, 75, 50);
		contentPane.add(lblNewLabel_5);
		
		JLabel jVersionLabel = new JLabel("Version 1.5.2018");
		jVersionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jVersionLabel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		jVersionLabel.setBounds(290, 333, 108, 14);
		contentPane.add(jVersionLabel);
	}
}
