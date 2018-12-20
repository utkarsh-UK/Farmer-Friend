import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Weather {

	public static void main(String[] args) {
		Document doc;
		try {
			doc = Jsoup.connect("https://www.wunderground.com/weather/in/chinchpokli/VABB?utm_source=HomeCard&utm_content=Button&cm_ven=HomeCardButton").userAgent("mozilla/17.0").get();
			Elements temp=doc.select("div.small-12.medium-4.large-3.columns.forecast-wrap");
			int i=0;
			for(Element w:temp){
				i++;
				System.out.println(i+" "+w.getElementsByTag("div").first().text());
				//System.out.println(w.getElementsByTag("span").first().text());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
