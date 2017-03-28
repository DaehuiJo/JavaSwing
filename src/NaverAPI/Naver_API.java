package NaverAPI;
/*
 * 정건우
 * 네이버 API 호출
 */
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Naver_API{
	
	static String title;
	static String author;
	static String price;
	static String publisher;
	static String image;
	static int count;
	
	Naver_API(final String isbn) throws IOException{
	
	
    String clientID="l8BOHe92EsNTGj7O1kEB";  // clinetID 값  입력
    String clientSecret = "Lo38O4bmlG";      // clientSecret 값 입력
    URL url = new URL("https://openapi.naver.com/v1/search/book_adv.xml?query=JSL21&d_isbn=" + isbn);    
    
    URLConnection urlConn=url.openConnection(); 
    
    urlConn.setRequestProperty("X-Naver-Client-ID", clientID); 
    urlConn.setRequestProperty("X-Naver-Client-Secret", clientSecret);
    
    BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

    String setXML = null; // xml 값을 읽어옴
    String getXML = null; // xml 값을 저장함
    //int count =0;         // 에러 처리용 카운터
        
    while((setXML = br.readLine())!=null)
    {
    //  System.out.println(setXML);   //xml 전체 출력 테스트용
    	getXML = setXML;
    }
    
    //읽어온 xml값 가공
    Matcher author = Pattern.compile("<author>[^<]+").matcher(getXML);
    //Matcher title = Pattern.compile("<item><title>[^(]+").matcher(getXML);
    Matcher title = Pattern.compile("<item><title>[^(|/]+").matcher(getXML);
    Matcher price = Pattern.compile("<price>[^<]+").matcher(getXML);
    Matcher publisher = Pattern.compile("<publisher>[^<]+").matcher(getXML);
    Matcher image = Pattern.compile("<image>[^?]+").matcher(getXML);
  //Matcher desc = Pattern.compile("</isbn><description>[^>]+</description></item>").matcher(getXML);
    
    while( author.find() ) { // 작가    	
    	
    	String group_author = author.group();        
    	String output_author = group_author.substring(8, group_author.length()); 
    	//System.out.println("작가 : " + output_author);
    	Naver_API.author = output_author;
    	count = 1;
    }
    
    while (title.find()) { // 제목
    	String group_title = title.group();
    	String output_title = group_title.substring(13, group_title.length()-1);
    	System.out.println("제목 : " + output_title);
    	Naver_API.title = output_title;
    }   
    
    while (price.find()) { // 가격
    	String group_price = price.group();
    	String output_price = group_price.substring(7, group_price.length());
    	//System.out.println("정가 : " + output_price +"원");
    	Naver_API.price = output_price;
    }  
    
    while (publisher.find()) { // 출판사
    	String group_publisher = publisher.group();
    	String output_publisher = group_publisher.substring(11, group_publisher.length());
    	//System.out.println("출판사 : " + output_publisher);
    	Naver_API.publisher = output_publisher;
    }  
    /*
    while (desc.find()) { // 설명
    	String group_desc = desc.group();
    	String output_desc = group_desc.substring(20, group_desc.length()-21);
    	System.out.println("설명 : " + output_desc);
    }  
    */
    while (image.find()) { // 표지 사진
    	String group_image = image.group();
    	String output_image = group_image.substring(7, group_image.length());
    	//System.out.println("이미지 : " + output_image);
    	Naver_API.image = output_image;
    }
    
    if (count == 0 ) // 에러 처리
		// System.out.println("잘못입력하셨습니다");
		JOptionPane.showMessageDialog(null, "잘못된 isbn을 입력하셨습니다.", "입력오류", JOptionPane.ERROR_MESSAGE);
	}
} 
