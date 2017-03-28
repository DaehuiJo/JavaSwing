package Sub_Member;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Database.BookDTO;
import Database.DBManipulation;
import Database.MemberDTO;
import Main.MainFrame;
import Sub_Book.Book_Modification;

public class Mem_Search extends JPanel{

	private JLabel title, textLabel;
	private JTextField searchText;
	static boolean result = false;

	DBManipulation manipulation = new DBManipulation();
	ArrayList<MemberDTO> list;
	MemberDTO dto;

	public Mem_Search() {

		this.setBackground(new Color(42, 42, 42));
		this.setLayout(null);

		title = new JLabel("Searching_Member");
		title.setBounds(390, 20, 400, 100);
		title.setFont(new Font("����", Font.BOLD, 40));
		title.setBackground(new Color(42, 42, 42));
		title.setForeground(new Color(200, 200, 200));
		this.add(title);
		title.setOpaque(true);
		title.repaint();

		// 왜 안보이냐???
//		textLabel = new JLabel("도서 등록번호를 입력하시오.");
//		textLabel.setEnabled(false);
//		textLabel.setFont(new Font("굴림", Font.PLAIN, 16));
//		textLabel.setForeground(new Color(128, 128, 128));
//		textLabel.setBounds(350, 320, 420, 50);
//		// textLabel.setOpaque(true);
//		// textLabel.repaint();
//		this.add(textLabel);

		searchText = new JTextField("  회원 등록번호 또는 이름을 입력하시오.");
		searchText.setFont(new Font("굴림", Font.PLAIN, 20));
		searchText.setBounds(340, 320, 440, 50);
		// searchText.setColumns(30);
		this.add(searchText);
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
					// 숫자로 검색할 경우 _ true
					//isNumber(searchText.getText());
					//System.out.println(isNumber(searchText.getText()));
					//try-catch로 묶어야 하나
					//if (result == true) {
						list = manipulation.searchMember(Integer.parseInt(searchText.getText()));
						
//						if (null == list) {
//							JOptionPane.showMessageDialog(null, " '" + Integer.parseInt(searchText.getText()) + "'" + "번은 등록되지 않은 번호입니다.",
//									"ErroMessage", JOptionPane.ERROR_MESSAGE);
//							searchText.setText(null);
//						} else {
							setVisible(false);
							Mem_Modification modi = new Mem_Modification(list);
							modi.setSize(1124, 700);
							MainFrame.contentPane.add(modi, BorderLayout.CENTER);
							// modi.repaint();
							modi.updateUI();
						}
					} 
//					else { //문자로 검색할 경우_false
//						dto = manipulation.searchBookTitle(searchText.getText());
//						if (null == dto) {
//							JOptionPane.showMessageDialog(null, "[" + searchText.getText() + "]" + "은 등록되지 않은 도서입니다.",
//									"ErroMessage", JOptionPane.ERROR_MESSAGE);
//							searchText.setText(null);
//						} else {
//							setVisible(false);
//							Book_Modification modi = new Book_Modification(list);
//							modi.setSize(1124, 700);
//							MainFrame.contentPane.add(modi, BorderLayout.CENTER);
//							// modi.repaint();
//							modi.updateUI();
//						}
//					}
//				}
//			}
		});
	}

//	public static boolean isNumber(String str) {
//		try {
//			Double.parseDouble(str);
//			result = true; // 숫자
//		} catch (Exception e) {}
//		return result;
//	}
	
}
