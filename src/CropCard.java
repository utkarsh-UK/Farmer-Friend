import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import java.awt.Toolkit;


public class CropCard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTree tree;
	JLabel jHeadLabel;
	JLabel jImgLabel;
	private JTextField txtTemp;
	private JTextField txtRain;
	private JTextField txtSoil;
	private JTextField txtDur;
	private JTextField txtSeed;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CropCard frame = new CropCard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void FillDataToJTree(){
		DefaultMutableTreeNode list=new DefaultMutableTreeNode("Crops List");
		DefaultMutableTreeNode grains=new DefaultMutableTreeNode("Food Grains");
		DefaultMutableTreeNode wheat=new DefaultMutableTreeNode("Wheat");
		DefaultMutableTreeNode rice=new DefaultMutableTreeNode("Rice");
		DefaultMutableTreeNode jowar=new DefaultMutableTreeNode("Jowar");
		DefaultMutableTreeNode ragi=new DefaultMutableTreeNode("Ragi");
		DefaultMutableTreeNode bajra=new DefaultMutableTreeNode("Bajra");
		grains.add(wheat);
		grains.add(rice);
		grains.add(jowar);
		grains.add(ragi);
		grains.add(bajra);
		list.add(grains);
		
		DefaultMutableTreeNode spices=new DefaultMutableTreeNode("Spices");
		DefaultMutableTreeNode cardamom=new DefaultMutableTreeNode("Cardamom");
		DefaultMutableTreeNode nutmeg=new DefaultMutableTreeNode("Nutmeg");
		DefaultMutableTreeNode turmeric=new DefaultMutableTreeNode("Turmeric");
		DefaultMutableTreeNode chillis=new DefaultMutableTreeNode("DryChillis");
		DefaultMutableTreeNode pepper=new DefaultMutableTreeNode("Pepper");
		spices.add(cardamom);
		spices.add(nutmeg);
		spices.add(turmeric);
		spices.add(chillis);
		spices.add(pepper);
		list.add(spices);
		
		DefaultMutableTreeNode herbs=new DefaultMutableTreeNode("Herbs");
		DefaultMutableTreeNode safflower=new DefaultMutableTreeNode("SafflowerSeed");
		DefaultMutableTreeNode seasame=new DefaultMutableTreeNode("SesameSeed");
		DefaultMutableTreeNode cotton=new DefaultMutableTreeNode("CottonSeed");
		DefaultMutableTreeNode mustard=new DefaultMutableTreeNode("MastardSeed");
		DefaultMutableTreeNode soyabean=new DefaultMutableTreeNode("SoyabeanSeed");
		herbs.add(safflower);
		herbs.add(seasame);
		herbs.add(cotton);
		herbs.add(mustard);
		herbs.add(soyabean);
		list.add(herbs);
		
		DefaultMutableTreeNode vegie=new DefaultMutableTreeNode("Vegetables");
		DefaultMutableTreeNode coriander=new DefaultMutableTreeNode("Coriander");
		DefaultMutableTreeNode finger=new  DefaultMutableTreeNode("LadyFinger");
		DefaultMutableTreeNode cauli=new DefaultMutableTreeNode("Cauliflowers");
		DefaultMutableTreeNode peas=new DefaultMutableTreeNode("GreenPeas");
		DefaultMutableTreeNode pumpkin=new DefaultMutableTreeNode("Pumpkin");
		DefaultMutableTreeNode potato=new DefaultMutableTreeNode("Potatoes");
		DefaultMutableTreeNode gourds=new DefaultMutableTreeNode("BitterGourds");
		DefaultMutableTreeNode tomato=new DefaultMutableTreeNode("Tomatoes");
		DefaultMutableTreeNode cabbage=new DefaultMutableTreeNode("Cabbages");
		DefaultMutableTreeNode onion=new DefaultMutableTreeNode("Onions");
		DefaultMutableTreeNode beans=new DefaultMutableTreeNode("FrenchBeans");
		DefaultMutableTreeNode brinjal=new DefaultMutableTreeNode("Brinjal");
		DefaultMutableTreeNode radish=new DefaultMutableTreeNode("Radish");
		DefaultMutableTreeNode palak=new DefaultMutableTreeNode("Palak");
		DefaultMutableTreeNode carrot=new DefaultMutableTreeNode("Carrots");
		DefaultMutableTreeNode capsicum=new DefaultMutableTreeNode("Capsicum");
		DefaultMutableTreeNode fenugreek=new DefaultMutableTreeNode("Fenugreek");
		DefaultMutableTreeNode chawli=new DefaultMutableTreeNode("Chawli");
		DefaultMutableTreeNode cucumber=new DefaultMutableTreeNode("Cucumber");
		DefaultMutableTreeNode beet=new DefaultMutableTreeNode("Beetroot");
		vegie.add(coriander);
		vegie.add(finger);
		vegie.add(cauli);
		vegie.add(peas);
		vegie.add(pumpkin);
		vegie.add(potato);
		vegie.add(gourds);
		vegie.add(tomato);
		vegie.add(cabbage);
		vegie.add(onion);
		vegie.add(beans);
		vegie.add(brinjal);
		vegie.add(radish);
		vegie.add(palak);
		vegie.add(carrot);
		vegie.add(capsicum);
		vegie.add(fenugreek);
		vegie.add(chawli);
		vegie.add(cucumber);
		vegie.add(beet);
		list.add(vegie);
		
		DefaultMutableTreeNode fruit=new DefaultMutableTreeNode("Fruits");
		DefaultMutableTreeNode apple=new DefaultMutableTreeNode("Apples");
		DefaultMutableTreeNode custard=new DefaultMutableTreeNode("CusterdApples");
		DefaultMutableTreeNode pine=new DefaultMutableTreeNode("Pineapples");
		DefaultMutableTreeNode coconut=new DefaultMutableTreeNode("Coconuts");
		DefaultMutableTreeNode banana=new DefaultMutableTreeNode("Banana");
		DefaultMutableTreeNode mango=new DefaultMutableTreeNode("Mangoes");
		DefaultMutableTreeNode guavas=new DefaultMutableTreeNode("Guavas");
		DefaultMutableTreeNode papaya=new DefaultMutableTreeNode("Papaya");
		DefaultMutableTreeNode strawberry=new DefaultMutableTreeNode("Strawberries");
		DefaultMutableTreeNode pomo=new DefaultMutableTreeNode("Pomogranets");
		DefaultMutableTreeNode grape=new DefaultMutableTreeNode("Grapes");
		DefaultMutableTreeNode orange=new DefaultMutableTreeNode("Oranges");
		DefaultMutableTreeNode chickoo=new DefaultMutableTreeNode("Chickoos");
		DefaultMutableTreeNode muskmelon=new DefaultMutableTreeNode("Muskmelon");
		DefaultMutableTreeNode watermelon=new DefaultMutableTreeNode("Watermelon");
		DefaultMutableTreeNode sugarcane=new DefaultMutableTreeNode("Sugarcane");
		DefaultMutableTreeNode jackfruit=new DefaultMutableTreeNode("Jackfruits");
		DefaultMutableTreeNode jamun=new DefaultMutableTreeNode("Jamuns");
		DefaultMutableTreeNode litches=new DefaultMutableTreeNode("Litches");
		DefaultMutableTreeNode peaches=new DefaultMutableTreeNode("Peaches");
		DefaultMutableTreeNode dates=new DefaultMutableTreeNode("Dates");
		fruit.add(apple);
		fruit.add(custard);
		fruit.add(pine);
		fruit.add(coconut);
		fruit.add(banana);
		fruit.add(mango);
		fruit.add(guavas);
		fruit.add(papaya);
		fruit.add(strawberry);
		fruit.add(pomo);
		fruit.add(grape);
		fruit.add(orange);
		fruit.add(chickoo);
		fruit.add(muskmelon);
		fruit.add(watermelon);
		fruit.add(sugarcane);
		fruit.add(jackfruit);
		fruit.add(jamun);
		fruit.add(litches);
		fruit.add(peaches);
		fruit.add(dates);
		list.add(fruit);
		
		DefaultMutableTreeNode flower=new DefaultMutableTreeNode("Flowers");
		DefaultMutableTreeNode marigold=new DefaultMutableTreeNode("Marigold");
		DefaultMutableTreeNode lotus=new DefaultMutableTreeNode("Lotus");
		DefaultMutableTreeNode sun=new DefaultMutableTreeNode("Sunflower");
		DefaultMutableTreeNode rose=new DefaultMutableTreeNode("Rose");
		DefaultMutableTreeNode jasmine=new DefaultMutableTreeNode("Jasmine");
		DefaultMutableTreeNode tulip=new DefaultMutableTreeNode("Tulips");
		DefaultMutableTreeNode daffodil=new DefaultMutableTreeNode("Daffodils");
		DefaultMutableTreeNode pansy=new DefaultMutableTreeNode("Pansy");
		DefaultMutableTreeNode hibiscus=new DefaultMutableTreeNode("Hibiscus");
		DefaultMutableTreeNode bougainvillea=new DefaultMutableTreeNode("Bougainvillea");
		flower.add(marigold);
		flower.add(lotus);
		flower.add(sun);
		flower.add(rose);
		flower.add(jasmine);
		flower.add(tulip);
		flower.add(daffodil);
		flower.add(pansy);
		flower.add(hibiscus);
		flower.add(bougainvillea);
		list.add(flower);
		
		DefaultMutableTreeNode nuts=new DefaultMutableTreeNode("Nuts");
		DefaultMutableTreeNode cashew=new DefaultMutableTreeNode("CashewNuts");
		DefaultMutableTreeNode ground =new DefaultMutableTreeNode("Groundnuts");
		nuts.add(cashew);
		nuts.add(ground);
		list.add(nuts);
		
		DefaultMutableTreeNode beverages=new DefaultMutableTreeNode("Beverages");
		DefaultMutableTreeNode tea=new DefaultMutableTreeNode("Tea");
		DefaultMutableTreeNode coffee=new DefaultMutableTreeNode("Coffee");
		DefaultMutableTreeNode cocoa=new DefaultMutableTreeNode("Cocoa");
		beverages.add(tea);
		beverages.add(coffee);
		beverages.add(cocoa);
		list.add(beverages);
		
		
		
		DefaultTreeModel dtm=new DefaultTreeModel(list);
		this.tree.setModel(dtm);

	}
	
	class SelectionListener implements TreeSelectionListener{
		public void valueChanged(TreeSelectionEvent arg0){
			if(tree.isSelectionEmpty())
				return;
			TreePath tp=tree.getSelectionPath();
			DefaultMutableTreeNode dmtn=(DefaultMutableTreeNode)tp.getLastPathComponent();
			String objName=dmtn.getUserObject().toString();
			jHeadLabel.setText(objName);
			
			try{
				Connection c=DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\CropInfo.accdb");
				Statement st=c.createStatement();
				ResultSet rs;
				
				if(objName.equals("Wheat")){
					rs=st.executeQuery("Select * from CropList where Name='Wheat'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Wheat.png"));
					}
				}
				
				if(objName.equals("Rice")){
					rs=st.executeQuery("Select * from CropList where Name='Rice'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Rice.jpg"));
					}
				}
				
				if(objName.equals("Jowar")){
					rs=st.executeQuery("Select * from CropList where Name='Jowar'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Jowar.jpg"));
					}
				}
				
				if(objName.equals("Ragi")){
					rs=st.executeQuery("Select * from CropList where Name='Ragi'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Ragi.jpg"));
					}
				}
				
				if(objName.equals("Bajra")){
					rs=st.executeQuery("Select * from CropList where Name='Bajra'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Bajra.jpg"));
					}
				}
				
				if(objName.equals("Cardamom")){
					rs=st.executeQuery("Select * from CropList where Name='Cardamom'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Cardamom.jpg"));
					}
				}
				
				if(objName.equals("Nutmeg")){
					rs=st.executeQuery("Select * from CropList where Name='Nutmeg'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Nutmeg.jpg"));
					}
				}
				
				if(objName.equals("Turmeric")){
					rs=st.executeQuery("Select * from CropList where Name='Turmeric'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Turmeric.jpg"));
					}
				}
				
				if(objName.equals("DryChillis")){
					rs=st.executeQuery("Select * from CropList where Name='DryChillis'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Dry Chillis.jpg"));
					}
				}
				
				if(objName.equals("Pepper")){
					rs=st.executeQuery("Select * from CropList where Name='Pepper'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Pepper.jpg"));
					}
				}
				
				if(objName.equals("SafflowerSeed")){
					rs=st.executeQuery("Select * from CropList where Name='SafflowerSeed'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Safflower Seeds.jpg"));
					}
				}
				
				if(objName.equals("SesameSeed")){
					rs=st.executeQuery("Select * from CropList where Name='SesameSeed'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Sesame Seeds.jpg"));
					}
				}
				
				if(objName.equals("CottonSeed")){
					rs=st.executeQuery("Select * from CropList where Name='CottonSeed'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Cotton Seeds.jpg"));
					}
				}
				
				if(objName.equals("MastardSeed")){
					rs=st.executeQuery("Select * from CropList where Name='MastardSeed'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Mastard Seeds.jpg"));
					}
				}
				
				if(objName.equals("SoyabeanSeed")){
					rs=st.executeQuery("Select * from CropList where Name='SoyabeanSeed'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Soyabean Seeds.jpg"));
					}
				}
				
				if(objName.equals("Coriander")){
					rs=st.executeQuery("Select * from CropList where Name='Coriander'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Coriander.jpg"));
					}
				}
				
				if(objName.equals("LadyFinger")){
					rs=st.executeQuery("Select * from CropList where Name='LadyFinger'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Lady Finger.jpg"));
					}
				}
				
				if(objName.equals("Cauliflowers")){
					rs=st.executeQuery("Select * from CropList where Name='Cauliflowers'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Cauliflower.jpg"));
					}
				}
				
				if(objName.equals("GreenPeas")){
					rs=st.executeQuery("Select * from CropList where Name='GreenPeas'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Green Peas.jpg"));
					}
				}
				
				if(objName.equals("Pumpkin")){
					rs=st.executeQuery("Select * from CropList where Name='Pumpkin'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Pumpkin.jpg"));
					}
				}
				
				if(objName.equals("Potatoes")){
					rs=st.executeQuery("Select * from CropList where Name='Potatoes'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Potato.jpg"));
					}
				}
				
				if(objName.equals("BitterGourds")){
					rs=st.executeQuery("Select * from CropList where Name='BitterGourds'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Bitter Gourds.jpg"));
					}
				}
				
				if(objName.equals("Tomatoes")){
					rs=st.executeQuery("Select * from CropList where Name='Tomatoes'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Tomato.jpg"));
					}
				}
				
				if(objName.equals("Cabbages")){
					rs=st.executeQuery("Select * from CropList where Name='Cabbages'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Cabbage.jpg"));
					}
				}
				
				if(objName.equals("Onions")){
					rs=st.executeQuery("Select * from CropList where Name='Onions'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Onion.jpg"));
					}
				}
				
				if(objName.equals("FrenchBeans")){
					rs=st.executeQuery("Select * from CropList where Name='FrenchBeans'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\French Beans.jpg"));
					}
				}
				
				if(objName.equals("Brinjal")){
					rs=st.executeQuery("Select * from CropList where Name='Brinjal'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Brinjal.jpg"));
					}
				}
				
				if(objName.equals("Radish")){
					rs=st.executeQuery("Select * from CropList where Name='Radish'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Radish.jpg"));
					}
				}
				
				if(objName.equals("Carrots")){
					rs=st.executeQuery("Select * from CropList where Name='Carrots'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Carrot.jpg"));
					}
				}
				
				if(objName.equals("Spinach")){
					rs=st.executeQuery("Select * from CropList where Name='Spinach'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Spinach.jpg"));
					}
				}
				
				if(objName.equals("Capsicum")){
					rs=st.executeQuery("Select * from CropList where Name='Capsicum'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Capsicum.jpg"));
					}
				}
				
				if(objName.equals("Fenugreek")){
					rs=st.executeQuery("Select * from CropList where Name='Fenugreek'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Fenugreek.jpg"));
					}
				}
				
				if(objName.equals("Chawli")){
					rs=st.executeQuery("Select * from CropList where Name='Chawli'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Chawli.jpg"));
					}
				}
				
				if(objName.equals("Cucumber")){
					rs=st.executeQuery("Select * from CropList where Name='Cucumber'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Cucumber.jpg"));
					}
				}
				
				if(objName.equals("Beetroot")){
					rs=st.executeQuery("Select * from CropList where Name='Beetroot'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Beet Root.jpg"));
					}
				}
				
				if(objName.equals("Apples")){
					rs=st.executeQuery("Select * from CropList where Name='Apples'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Apple.jpg"));
					}
				}
				
				if(objName.equals("CusterdApples")){
					rs=st.executeQuery("Select * from CropList where Name='CusterdApples'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Custard Apple.jpg"));
					}
				}
				
				if(objName.equals("Pineapples")){
					rs=st.executeQuery("Select * from CropList where Name='Pineapples'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Pine Apple.jpg"));
					}
				}
				
				if(objName.equals("Coconuts")){
					rs=st.executeQuery("Select * from CropList where Name='Coconuts'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Coconut.jpg"));
					}
				}
				
				if(objName.equals("Banana")){
					rs=st.executeQuery("Select * from CropList where Name='Banana'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Banana.jpg"));
					}
				}
				
				if(objName.equals("Mangoes")){
					rs=st.executeQuery("Select * from CropList where Name='Mangoes'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Mango.jpg"));
					}
				}
				
				if(objName.equals("Guavas")){
					rs=st.executeQuery("Select * from CropList where Name='Guavas'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Guavas.jpg"));
					}
				}
				
				if(objName.equals("Papaya")){
					rs=st.executeQuery("Select * from CropList where Name='Papaya'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Papaya.jpg"));
					}
				}
				
				if(objName.equals("Strawberries")){
					rs=st.executeQuery("Select * from CropList where Name='Strawberries'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Strawberry.jpg"));
					}
				}
				
				if(objName.equals("Pomogranets")){
					rs=st.executeQuery("Select * from CropList where Name='Pomogranets'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Pomogranate.jpg"));
					}
				}
				
				if(objName.equals("Grapes")){
					rs=st.executeQuery("Select * from CropList where Name='Grapes'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Grapes.jpg"));
					}
				}
				
				if(objName.equals("Oranges")){
					rs=st.executeQuery("Select * from CropList where Name='Oranges'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Oranges.jpg"));
					}
				}
				
				if(objName.equals("Chickoos")){
					rs=st.executeQuery("Select * from CropList where Name='Chickoos'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Chikoos.jpg"));
					}
				}
				
				if(objName.equals("Muskmelon")){
					rs=st.executeQuery("Select * from CropList where Name='Muskmelon'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Muskmelon.jpg"));
					}
				}
				
				if(objName.equals("Watermelon")){
					rs=st.executeQuery("Select * from CropList where Name='Watermelon'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Watermelon.jpg"));
					}
				}
				
				if(objName.equals("Sugarcane")){
					rs=st.executeQuery("Select * from CropList where Name='Sugarcane'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Sugarcane.jpg"));
					}
				}
				
				if(objName.equals("Jackfruits")){
					rs=st.executeQuery("Select * from CropList where Name='Jackfruits'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Jackfruit.jpg"));
					}
				}
				
				if(objName.equals("Jamuns")){
					rs=st.executeQuery("Select * from CropList where Name='Jamuns'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Jamuns.jpg"));
					}
				}
				
				if(objName.equals("Litches")){
					rs=st.executeQuery("Select * from CropList where Name='Litches'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Litches.jpg"));
					}
				}
				
				if(objName.equals("Peaches")){
					rs=st.executeQuery("Select * from CropList where Name='Peaches'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Peaches.jpg"));
					}
				}
				
				if(objName.equals("Dates")){
					rs=st.executeQuery("Select * from CropList where Name='Dates'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Dates.jpg"));
					}
				}
				
				if(objName.equals("Marigold")){
					rs=st.executeQuery("Select * from CropList where Name='Marigold'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Marigold.jpg"));
					}
				}
				
				if(objName.equals("Lotus")){
					rs=st.executeQuery("Select * from CropList where Name='Lotus'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Lotus.jpg"));
					}
				}
				
				if(objName.equals("Sunflower")){
					rs=st.executeQuery("Select * from CropList where Name='Sunflower'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Sunflower.jpg"));
					}
				}
				
				if(objName.equals("Rose")){
					rs=st.executeQuery("Select * from CropList where Name='Rose'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Roses.jpg"));
					}
				}
				
				if(objName.equals("Jasmine")){
					rs=st.executeQuery("Select * from CropList where Name='Jasmine'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Jasmine.jpg"));
					}
				}
				
				if(objName.equals("Tulips")){
					rs=st.executeQuery("Select * from CropList where Name='Tulips'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Tulips.jpg"));
					}
				}
				
				if(objName.equals("Daffodils")){
					rs=st.executeQuery("Select * from CropList where Name='Daffodils'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Daffodils.jpg"));
					}
				}
				
				if(objName.equals("Pansy")){
					rs=st.executeQuery("Select * from CropList where Name='Pansy'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Pansy.jpg"));
					}
				}
				
				if(objName.equals("Hibiscus")){
					rs=st.executeQuery("Select * from CropList where Name='Hibiscus'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Hibiscus.jpg"));
					}
				}
				
				if(objName.equals("Bougainvillea")){
					rs=st.executeQuery("Select * from CropList where Name='Bougainvillea'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Bougainvillea.jpg"));
					}
				}
				
				if(objName.equals("CashewNuts")){
					rs=st.executeQuery("Select * from CropList where Name='CashewNuts'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Cashew Nuts.jpg"));
					}
				}
				
				if(objName.equals("Groundnuts")){
					rs=st.executeQuery("Select * from CropList where Name='Groundnuts'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Ground Nuts.jpg"));
					}
				}
				
				if(objName.equals("Tea")){
					rs=st.executeQuery("Select * from CropList where Name='Tea'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Tea.jpg"));
					}
				}
				
				if(objName.equals("Coffee")){
					rs=st.executeQuery("Select * from CropList where Name='Coffee'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Coffee.jpg"));
					}
				}
				
				if(objName.equals("Cocoa")){
					rs=st.executeQuery("Select * from CropList where Name='Cocoa'");
					while(rs.next()){
						txtTemp.setText(rs.getString("Temperature"));
						txtRain.setText(rs.getString("Rainfall"));
						txtSoil.setText(rs.getString("Soil"));
						txtDur.setText(rs.getString("Duration"));
						txtSeed.setText(rs.getString("Seed_Rate"));
						jImgLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Cocoa.jpg"));
					}
				}
	 		}
			catch(Exception e){
				System.out.println(e);
			}

		}
	}
	/**
	 * Create the frame.
	 */
	public CropCard() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\cropcard.png"));
		setTitle("Crop Card");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		tree = new JTree();
		tree.setToolTipText("Select one of the crop for information");
		tree.addTreeSelectionListener(new SelectionListener());
		tree.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		splitPane.setLeftComponent(tree);
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		panel.setLayout(null);
		
		jHeadLabel = new JLabel("Welcome..!!!!");
		jHeadLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jHeadLabel.setForeground(new Color(75, 0, 130));
		jHeadLabel.setFont(new Font("Algerian", Font.BOLD, 30));
		jHeadLabel.setBackground(Color.WHITE);
		jHeadLabel.setBounds(302, 11, 319, 51);
		panel.add(jHeadLabel);
		
		jImgLabel = new JLabel("");
		jImgLabel.setBounds(22, 94, 230, 290);
		panel.add(jImgLabel);
		
		JLabel jTempLabel = new JLabel("Temperature");
		jTempLabel.setToolTipText("Displays the temperature required by the respective crop");
		jTempLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
		jTempLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jTempLabel.setBounds(280, 94, 130, 40);
		panel.add(jTempLabel);
		
		txtTemp = new JTextField();
		txtTemp.setHorizontalAlignment(SwingConstants.CENTER);
		txtTemp.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtTemp.setBackground(Color.WHITE);
		txtTemp.setEditable(false);
		txtTemp.setBounds(480, 94, 175, 40);
		panel.add(txtTemp);
		txtTemp.setColumns(10);
		
		JLabel jRainLabel = new JLabel("Rain Fall");
		jRainLabel.setToolTipText("Displays the required raain fall per year for respective crop");
		jRainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jRainLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
		jRainLabel.setBounds(280, 160, 130, 40);
		panel.add(jRainLabel);
		
		txtRain = new JTextField();
		txtRain.setHorizontalAlignment(SwingConstants.CENTER);
		txtRain.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtRain.setBackground(Color.WHITE);
		txtRain.setEditable(false);
		txtRain.setColumns(10);
		txtRain.setBounds(480, 160, 175, 40);
		panel.add(txtRain);
		
		JLabel jSoilLabel = new JLabel("Soil");
		jSoilLabel.setToolTipText("Display the soil type for respective crop");
		jSoilLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jSoilLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
		jSoilLabel.setBounds(280, 224, 130, 40);
		panel.add(jSoilLabel);
		
		txtSoil = new JTextField();
		txtSoil.setHorizontalAlignment(SwingConstants.CENTER);
		txtSoil.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtSoil.setEditable(false);
		txtSoil.setColumns(10);
		txtSoil.setBackground(Color.WHITE);
		txtSoil.setBounds(480, 224, 175, 40);
		panel.add(txtSoil);
		
		JLabel jDurLabel = new JLabel("Duration");
		jDurLabel.setToolTipText("Displays the sowing and harvesting time for respective crop");
		jDurLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jDurLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
		jDurLabel.setBounds(280, 291, 130, 40);
		panel.add(jDurLabel);
		
		txtDur = new JTextField();
		txtDur.setHorizontalAlignment(SwingConstants.CENTER);
		txtDur.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtDur.setEditable(false);
		txtDur.setColumns(10);
		txtDur.setBackground(Color.WHITE);
		txtDur.setBounds(480, 291, 175, 40);
		panel.add(txtDur);
		
		JLabel jSeedLabel = new JLabel("Seed Rate");
		jSeedLabel.setToolTipText("Displays the seed rate for respective crop in Kg per hactre");
		jSeedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jSeedLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
		jSeedLabel.setBounds(280, 356, 130, 40);
		panel.add(jSeedLabel);
		
		txtSeed = new JTextField();
		txtSeed.setHorizontalAlignment(SwingConstants.CENTER);
		txtSeed.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtSeed.setEditable(false);
		txtSeed.setColumns(10);
		txtSeed.setBackground(Color.WHITE);
		txtSeed.setBounds(480, 356, 175, 40);
		panel.add(txtSeed);
		
		JLabel jBackgroundLabel = new JLabel("");
		jBackgroundLabel.setIcon(new ImageIcon("C:\\Users\\Pankaj\\Desktop\\UK\\Eclipse Projects\\FarmerProject\\Images\\Farmer.jpg"));
		jBackgroundLabel.setBounds(0, 0, 882, 550);
		panel.add(jBackgroundLabel);
		
		FillDataToJTree();
	}
}
