import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JTabbedPane;

import java.awt.Font;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class WeatherReport extends JFrame {

	private JPanel contentPane;
	JLabel jTempLabel;
	JLabel jHeadLabel;
	JLabel jDetailLabel;
	JLabel jVisiblityLabel;
	JLabel jTomorrowLabel;
	private JLabel jNTempLabel;
	private JLabel jNDetailLabel;
	private JLabel jTomoLabel;
	private JLabel jTTempLabel;
	private JLabel jTDetailLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WeatherReport frame = new WeatherReport();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void reportToday() {
		Document doc;
		try{
			doc=Jsoup.connect("https://www.wunderground.com/weather/in/chinchpokli/VABB?utm_source=HomeCard&utm_content=Button&cm_ven=HomeCardButton").userAgent("Mozilla/17.0").get();

			Elements temp=doc.select("span.test-true.wu-unit.wu-unit-temperature.is-degree-visible");
			int i=0;
			for(Element w:temp){
				i++;
				jTempLabel.setText(w.getElementsByTag("span").first().text());	
				if(i==2)
					break;
			}
			
			Elements temp2=doc.select("p.weather-quickie");
			for(Element a:temp2){
			  jHeadLabel.setText("Today's weather will be "+a.getElementsByTag("span").first().text()+" than tomorrow");
			}
			
			i=0;
			Elements temp3=doc.select("a.module-link");
			for(Element b:temp3){
				i++;
				jDetailLabel.setText(b.getElementsByTag("a").first().text());
				if(i==2)
					break;
			}
			
			i=0;
			Elements temp4=doc.select("div.row");
			for(Element c:temp4.select("div.small-8.columns")){
				i++;
				String txt=c.select("span.wx-value").text();
				jVisiblityLabel.setText("Visibility - "+i+txt+c.getElementsByTag("span").first().text());
				if(i==1)
					break;
			}
			
			//Elements temp5=doc.select("")
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void reportToNight(){
		Document doc;
		try{
			doc=Jsoup.connect("https://www.wunderground.com/weather/in/chinchpokli/VABB?utm_source=HomeCard&utm_content=Button&cm_ven=HomeCardButton").userAgent("Mozilla/17.0").get();
			
			int i=0;
			Elements temp1=doc.select("div.columns.small-8.medium-9.forecast-box-header");
			for(Element a:temp1){
				i++;
				jTomorrowLabel.setText(a.getElementsByTag("span").first().text());
				if(i==2)
					break;
			}
			
			i=0;
			Elements temp2=doc.select("span.test-true.wu-unit.wu-unit-temperature.is-degree-visible");
			for(Element a:temp2){
				i++;
				jNTempLabel.setText(a.getElementsByTag("span").first().text());
				if(i==3)
					break;
			}
			
			i=0;
			Elements temp3=doc.select("a.module-link");
			for(Element a:temp3){
				i++;
				jNDetailLabel.setText(a.getElementsByTag("a").first().text());
				if(i==4)
					break;
			}
		}  catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void reportTomo(){
		Document doc;
		try{
			doc=Jsoup.connect("https://www.wunderground.com/weather/in/chinchpokli/VABB?utm_source=HomeCard&utm_content=Button&cm_ven=HomeCardButton").userAgent("Mozilla/17.0").get();
			
			int i=0;
			Elements temp1=doc.select("div.columns.small-8.medium-9.forecast-box-header");
			for(Element a:temp1){
				jTomoLabel.setText(a.getElementsByTag("span").first().text());
			}
			
			Elements temp2=doc.select("span.test-true.wu-unit.wu-unit-temperature.is-degree-visible");
			for(Element a:temp2){
				jTTempLabel.setText(a.getElementsByTag("span").first().text());
			}
			
			Elements temp3=doc.select("a.module-link");
			for(Element a:temp3){
				jTDetailLabel.setText(a.getElementsByTag("a").first().text());
			}
		}  catch(IOException e){
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public WeatherReport() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\weather.png"));
		setTitle("Weather Report");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 558, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		tabbedPane.setBounds(0, 0, 552, 310);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Today", null, panel, null);
		panel.setLayout(null);
		
		jTempLabel = new JLabel("");
		jTempLabel.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		jTempLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jTempLabel.setBounds(10, 77, 112, 31);
		panel.add(jTempLabel);
		
		jHeadLabel = new JLabel("");
		jHeadLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
		jHeadLabel.setBounds(10, 11, 424, 22);
		panel.add(jHeadLabel);
		
		JLabel jTodayLabel = new JLabel("Today");
		jTodayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jTodayLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
		jTodayLabel.setBounds(10, 44, 112, 22);
		panel.add(jTodayLabel);
		
		jDetailLabel = new JLabel("");
		jDetailLabel.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		jDetailLabel.setBounds(10, 115, 424, 22);
		panel.add(jDetailLabel);
		
		jVisiblityLabel = new JLabel("");
		jVisiblityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jVisiblityLabel.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		jVisiblityLabel.setBounds(10, 150, 201, 22);
		panel.add(jVisiblityLabel);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Tomorrow", null, panel_1, null);
		panel_1.setLayout(null);
		
		jTomorrowLabel = new JLabel("");
		jTomorrowLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jTomorrowLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
		jTomorrowLabel.setBounds(10, 11, 136, 21);
		panel_1.add(jTomorrowLabel);
		
		jNTempLabel = new JLabel("");
		jNTempLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jNTempLabel.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		jNTempLabel.setBounds(10, 43, 136, 21);
		panel_1.add(jNTempLabel);
		
		jNDetailLabel = new JLabel("");
		jNDetailLabel.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		jNDetailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		jNDetailLabel.setBounds(10, 75, 424, 21);
		panel_1.add(jNDetailLabel);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Tomorrow Night", null, panel_2, null);
		panel_2.setLayout(null);
		
		jTomoLabel = new JLabel("");
		jTomoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jTomoLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
		jTomoLabel.setBounds(10, 11, 149, 22);
		panel_2.add(jTomoLabel);
		
		jTTempLabel = new JLabel("");
		jTTempLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jTTempLabel.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		jTTempLabel.setBounds(10, 44, 149, 22);
		panel_2.add(jTTempLabel);
		
		jTDetailLabel = new JLabel("");
		jTDetailLabel.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		jTDetailLabel.setBounds(10, 77, 442, 22);
		panel_2.add(jTDetailLabel);
		
		reportToday();
		reportToNight();
		reportTomo();
	}
}
