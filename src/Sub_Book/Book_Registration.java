package Sub_Book;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import Database.*;
import Main.*;
import NaverAPI.*;


public class Book_Registration extends JPanel {
	
	private static final long serialVersionUID = 1733442535521768877L;
	public static JTextField title;
	public static JTextField author;
	public static JTextField price;
	public static JTextField isbn;
	public static String image;
	public static JTextField publisher;
	public static JLabel text;
	public static JLabel book;
	public static Border border;
	public int category_value;
	
	DBManipulation manipulation = new DBManipulation();
	ArrayList<BookDTO> list;
	BookDTO dto;

//	public Image img = null;
//	static File imagefile = new File("images/test3.jpg");

	public Book_Registration() {

//		try {
//			img = ImageIO.read(imagefile);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	@Override
//	public void paint(Graphics g) {
//
//		g.drawImage(img, 0, 0, this);
		
		this.setBackground(new Color(42,42,42));
		this.setLayout(null);
		
		Insert_Book_ISBN ib = new Insert_Book_ISBN();
		ib.setLocationRelativeTo(null);
			
		text = new JLabel("Registration_Book");		
		text.setBounds(360,20,400,100);
		text.setFont(new Font("����", Font.BOLD, 40));		
		text.setBackground(new Color(42,42,42));
		text.setForeground(new Color(200,200,200));
		this.add(text);
		text.setOpaque(true);
		text.repaint();
		
		book = new JLabel();
		book.setIcon(new ImageIcon("Images/icon_book_default.png"));
		book.setBounds(40,140,512,512);
		book.setBackground(new Color(42,42,42));
		
		book.setHorizontalAlignment(JLabel.CENTER);
		book.setVerticalAlignment(JLabel.CENTER);
		this.add(book);
		book.setOpaque(true);
		book.repaint();
		
		text = new JLabel("제목 : ");
		text.setEnabled(false);
		text.setFont(new Font("나눔바른고딕", Font.BOLD, 14));		
		text.setHorizontalAlignment(JLabel.RIGHT);
		text.setForeground(new Color(128, 128, 128));
		text.setBounds(600, 250, 90, 30);
		this.add(text);
		
		text = new JLabel("작가 : ");
		text.setEnabled(false);
		text.setFont(new Font("나눔바른고딕", Font.BOLD, 14));		
		text.setHorizontalAlignment(JLabel.RIGHT);
		text.setForeground(new Color(128, 128, 128));
		text.setBounds(600, 300, 90, 30);
		this.add(text);
		
		text = new JLabel("출판사 : ");
		text.setEnabled(false);
		text.setFont(new Font("나눔바른고딕", Font.BOLD, 14));		
		text.setHorizontalAlignment(JLabel.RIGHT);
		text.setForeground(new Color(128, 128, 128));
		text.setBounds(600, 350, 90, 30);
		this.add(text);
		
		text = new JLabel("가격 : ");
		text.setEnabled(false);
		text.setFont(new Font("나눔바른고딕", Font.BOLD, 14));		
		text.setHorizontalAlignment(JLabel.RIGHT);
		text.setForeground(new Color(128, 128, 128));
		text.setBounds(600, 400, 90, 30);
		this.add(text);
		
		text = new JLabel("ISBN : ");
		text.setEnabled(false);
		text.setFont(new Font("나눔바른고딕", Font.BOLD, 14));		
		text.setHorizontalAlignment(JLabel.RIGHT);
		text.setForeground(new Color(128, 128, 128));
		text.setBounds(600, 450, 90, 30);
		this.add(text);
		
		text = new JLabel("카테고리 : ");
		text.setEnabled(false);
		text.setFont(new Font("나눔바른고딕", Font.BOLD, 14));		
		text.setHorizontalAlignment(JLabel.RIGHT);
		text.setForeground(new Color(128, 128, 128));
		text.setBounds(600, 500, 90, 30);
		this.add(text);
		
		title = new JTextField(30);
		border = BorderFactory.createLineBorder(new Color(100,100,100));
		title.setBorder(border);
		title.setBounds(700, 250, 300, 30);
		title.setFont(new Font("나눔바른고딕", Font.BOLD, 12));			
		title.setForeground(Color.BLACK);
		this.add(title);
		title.setOpaque(true);
		title.repaint();
		
		author = new JTextField(30);
		author.setBounds(700, 300, 300, 30);
		author.setBorder(border);
		author.setFont(new Font("나눔바른고딕", Font.BOLD, 12));			
		author.setForeground(Color.BLACK);
		this.add(author);
		author.setOpaque(true);
		author.repaint();
		
		publisher = new JTextField(30);
		publisher.setBorder(border);
		publisher.setBounds(700, 350, 300, 30);
		publisher.setFont(new Font("나눔바른고딕", Font.BOLD, 12));			
		publisher.setForeground(Color.BLACK);
		this.add(publisher);
		publisher.setOpaque(true);
		publisher.repaint();
		
		price = new JTextField(30);
		price.setBorder(border);
		price.setBounds(700, 400, 300, 30);
		price.setFont(new Font("나눔바른고딕", Font.BOLD, 12));			
		price.setForeground(Color.BLACK);
		this.add(price);
		price.setOpaque(true);
		price.repaint();
		
		isbn = new JTextField(30);
		isbn.setBorder(border);
		isbn.setBounds(700, 450, 300, 30);
		
		isbn.setFont(new Font("나눔바른고딕", Font.BOLD, 12));			
		isbn.setForeground(Color.BLACK);
		this.add(isbn);
		isbn.setOpaque(true);
		isbn.repaint();
		
		String[] genre = { "미분류", "소설", "시 / 에세이", "경제 / 경영", "자기계발", "인문", "역사 / 문화", "생활 / 요리" };
		
		
		
		JComboBox<String> category = new JComboBox<String>(genre);
		category.setBounds(700, 500, 300, 30);
		this.add(category);
		category.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				//System.out.println(category.getSelectedIndex());
				category_value = category.getSelectedIndex();
			}
		});	
		
		JButton ok = new JButton("등록");
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String dbTitle = title.getText();
				String dbAuthor = author.getText();
				String dbPrice = price.getText();
				String dbImage = image;
				String dbIsbn = isbn.getText();
				String dbPublisher = publisher.getText();
				int dbCategory = category_value;
				
				manipulation.bookInsert(dbTitle, dbAuthor, dbPrice, dbImage, dbIsbn, dbPublisher, dbCategory);
				JOptionPane.showMessageDialog(null, "입력이 완료되었습니다.");	
				Object[] options = { "OK", "CANCEL" };
				int result = JOptionPane.showOptionDialog(null, "계속 등록하시겠습니까?", "추가등록", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
				             null, options, options[0]);
				if (result==JOptionPane.YES_OPTION) {
					Insert_Book_ISBN ib = new Insert_Book_ISBN();
					ib.setLocationRelativeTo(null);
					title.setText(""); author.setText(""); price.setText(""); isbn.setText(""); publisher.setText("");
				}
				else {
					setVisible(false);
					Home home = new Home();
					MainFrame.contentPane.add(home, BorderLayout.CENTER);
					home.updateUI();
				}	
			}
		});
	    ok.setBorder(new JButton().getBorder());
	    ok.setBackground(new Color(117,177,117));
	    ok.setForeground(Color.WHITE);
	    ok.setOpaque(true);
	    ok.setBorderPainted(false);
	    ok.setFocusPainted(false);
	    ok.setBorderPainted(false);
		ok.setBounds(700, 550, 300, 30);
		this.add(ok);
		ok.setOpaque(true);
		ok.repaint();
		}
}
