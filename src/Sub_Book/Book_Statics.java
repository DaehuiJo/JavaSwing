package Sub_Book;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Database.DBManipulation;
import NaverAPI.Naver_API;

public class Book_Statics extends JPanel {
	private static final long serialVersionUID = -2754822775712624183L;
	
	

	public Book_Statics(){
		DBManipulation.bestBook(); 
		DBManipulation.bookList();
		
//		String clientID="l8BOHe92EsNTGj7O1kEB";  // clinetID 값  입력
//		String clientSecret = "Lo38O4bmlG";
//		URL url2;
//		try {
//			url2 = new URL("https://openapi.naver.com/v1/search/book_adv.xml?query=JSL21");
//			URLConnection urlConn=url2.openConnection(); 
//		    urlConn.setRequestProperty("X-Naver-Client-ID", clientID); 
//		    urlConn.setRequestProperty("X-Naver-Client-Secret", clientSecret);
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		
//		this.setBackground(new Color(42,42,42));
//		this.setLayout(null);
//		
//		JLabel best = new JLabel("최고의 책");
//		best.setBounds(100,100,400,56);
//		best.setForeground(Color.white);
//		best.setFont(new Font("Koverwatch", Font.ITALIC, 56));
//		this.add(best);
//		
//		JLabel play = new JLabel(DBManipulation.title);
//		play.setBounds(120, 150, 800, 100);
//		play.setForeground(new Color(247,219,12));
//		play.setFont(new Font("Koverwatch", Font.ITALIC, 100));
//		this.add(play);
//		
//		JLabel member = new JLabel("대여횟수 : " + Integer.toString(DBManipulation.book_count));
//		member.setBounds(130, 250, 600, 44);
//		member.setForeground(Color.white);
//		member.setFont(new Font("Koverwatch", Font.ITALIC, 44));
//		this.add(member);
//		
//		Image image = null;
//        try {
//            URL url = new URL(DBManipulation.image);
//            image = ImageIO.read(url);
//        } catch (IOException e) {
//        	e.printStackTrace();        
//		}
//        ImageIcon show = new ImageIcon(image);
//        Image original = show.getImage();
//        Image resized = original.getScaledInstance(350, 500, java.awt.Image.SCALE_SMOOTH);
//        JLabel label = new JLabel(new ImageIcon(resized));
//        label.setBounds(720, 100, 350, 500);
//        this.add(label);
        
        
	}		
}