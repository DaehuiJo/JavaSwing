package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Database.BookDTO;
import Database.DBManipulation;

public class Home extends JPanel {
	
	private static final long serialVersionUID = 7600061506565679665L;
	public Image img = null;
	static File imagefile = new File("images/test1.jpg");
	private JTextField searchText;
	static boolean result = false;

	DBManipulation manipulation = new DBManipulation();
	ArrayList<BookDTO> list;
	BookDTO dto;
	

	public Home() {


		
		setLayout(null);
		
		searchText = new JTextField("   도서 등록번호 또는 도서 제목을 입력하시오.");
		searchText.setFont(new Font("굴림", Font.PLAIN, 20));
		searchText.setBounds(340, 320, 440, 50);
		searchText.setBackground(Color.WHITE);
		searchText.setForeground(Color.BLACK);
		searchText.setOpaque(true);
		searchText.repaint();
		searchText.updateUI();
		
		// searchText.setColumns(30);
		add(searchText);
		// input = searchText.getText();
		searchText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchText.setText(null);
			}
		});
		searchText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String input = searchText.getText();
					DBManipulation.rent(input);
					
					setVisible(false);
					Rent check = new Rent();
					check.setSize(1124,700);
					MainFrame.contentPane.add(check, BorderLayout.CENTER);
					check.updateUI();
				}
			}
		});
		
		
		
		try {
			img = ImageIO.read(imagefile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this);
	}
	

}
	
	


	
	
	
	
	
	
	
	
	
	

