import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JTextArea;

import java.awt.Font;


public class News extends JFrame {

	private JPanel contentPane;
	private JTextArea txtNews;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					News frame = new News();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void newsReport(){
		Document doc;
		try {
			doc=Jsoup.connect("https://economictimes.indiatimes.com/news/economy/agriculture").userAgent("Mozilla/17.0").get();
			
			int i=1;
			String str="";
			String data="";
			Elements temp1=doc.select("section#pageContent");
			for(Element a:temp1){
				for(i=0;i<17;i++){
					str+=a.select("div.eachStory h3 a").get(i).text()+"\n";
					data+=a.select("div.eachStory p").get(i).text()+"\n";
					txtNews.setText(str+data);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Create the frame.
	 */
	public News() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\news.png"));
		setTitle("News");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(350, 100, 779, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNews = new JTextArea();
		txtNews.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		txtNews.setEditable(false);
		txtNews.setRows(8);
		txtNews.setBounds(10, 11, 753, 386);
		JScrollPane  scrollPane=new JScrollPane(txtNews);
		scrollPane.setBounds(10,11,753,386);
		contentPane.add(scrollPane);
		//contentPane.add(txtNews);
		
		newsReport();
	}
}
