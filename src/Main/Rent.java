package Main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import Database.*;

public class Rent extends JPanel {

	private static final long serialVersionUID = -8675085512817236365L;

	public static JTextField titletxt;
	public static JTextField member_no;
	public static JTextField confirm;
	public static JTextField isbn;
	public static String image;
	public static JTextField name;
	public static JLabel text;
	public static JLabel book;
	public static Border border;
	// public int category_value;
	private JButton button1, button2;

	//DBManipulation db;
	RentDTO dto;
	String title,  result;
	int status;
	

	public Rent() {

		dto = DBManipulation.rent(title);

		this.setBackground(new Color(42, 42, 42));
		this.setLayout(null);

		text = new JLabel("Rent Status");
		text.setBounds(360, 20, 400, 100);
		text.setFont(new Font("����", Font.BOLD, 40));
		text.setBackground(new Color(42, 42, 42));
		text.setForeground(new Color(200, 200, 200));
		this.add(text);
		text.setOpaque(true);
		text.repaint();

		text = new JLabel("책 제목 : ");
		text.setEnabled(false);
		text.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		text.setHorizontalAlignment(JLabel.RIGHT);
		text.setForeground(new Color(128, 128, 128));
		text.setBounds(600, 250, 90, 30);
		this.add(text);

		text = new JLabel("회원번호 : ");
		text.setEnabled(false);
		text.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		text.setHorizontalAlignment(JLabel.RIGHT);
		text.setForeground(new Color(128, 128, 128));
		text.setBounds(600, 300, 90, 30);
		this.add(text);

		text = new JLabel("회원이름 : ");
		text.setEnabled(false);
		text.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		text.setHorizontalAlignment(JLabel.RIGHT);
		text.setForeground(new Color(128, 128, 128));
		text.setBounds(600, 350, 90, 30);
		this.add(text);

		text = new JLabel("대출상태 : ");
		text.setEnabled(false);
		text.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		text.setHorizontalAlignment(JLabel.RIGHT);
		text.setForeground(new Color(128, 128, 128));
		text.setBounds(600, 400, 90, 30);
		this.add(text);

		titletxt = new JTextField(30);
		border = BorderFactory.createLineBorder(new Color(100, 100, 100));
		titletxt.setBorder(border);
		titletxt.setBounds(700, 250, 300, 30);
		titletxt.setFont(new Font("나눔바른고딕", Font.BOLD, 12));
		titletxt.setForeground(Color.BLACK);
		this.add(titletxt);
		titletxt.setOpaque(true);
		titletxt.repaint();

		member_no = new JTextField(30);
		member_no.setBounds(700, 300, 300, 30);
		member_no.setBorder(border);
		member_no.setFont(new Font("나눔바른고딕", Font.BOLD, 12));
		member_no.setForeground(Color.BLACK);
		this.add(member_no);
		member_no.setOpaque(true);
		member_no.repaint();

		name = new JTextField(30);
		name.setBorder(border);
		name.setBounds(700, 350, 300, 30);
		name.setFont(new Font("나눔바른고딕", Font.BOLD, 12));
		name.setForeground(Color.BLACK);
		this.add(name);
		name.setOpaque(true);
		name.repaint();

		confirm = new JTextField(30);
		confirm.setBorder(border);
		confirm.setBounds(700, 400, 300, 30);
		confirm.setFont(new Font("나눔바른고딕", Font.BOLD, 12));
		confirm.setForeground(Color.BLACK);
		this.add(confirm);
		confirm.setOpaque(true);
		confirm.repaint();

		button1 = new JButton("대출");
		button1.setBorder(new JButton().getBorder());
		button1.setBackground(new Color(220, 26, 32));
		button1.setForeground(Color.WHITE);
		button1.setOpaque(true);
		button1.setBorderPainted(false);
		button1.setFocusPainted(false);
		button1.setBorderPainted(false);
		button1.setBounds(700, 500, 100, 30);
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// 대출전: 0;
				if (result == "미대출") {
					status = 1;
				}
				DBManipulation.rentStatus(status);

				JOptionPane.showMessageDialog(null, "[" + dto.getbDTO().getTitle() + "] 이 대출되었습니다.","Message", JOptionPane.INFORMATION_MESSAGE);

				setVisible(false);
				// MainFrame.contentPane.remove(Rent);
				Home home = new Home();
				home.setSize(1124, 700);
				MainFrame.contentPane.add(home, BorderLayout.CENTER);
				home.updateUI();
			}
		});
		add(button1);

		button2 = new JButton("반납");
		button2.setBorder(new JButton().getBorder());
		button2.setBackground(new Color(117, 177, 117));
		button2.setForeground(Color.WHITE);
		button2.setOpaque(true);
		button2.setBorderPainted(false);
		button2.setFocusPainted(false);
		button2.setBorderPainted(false);
		button2.setBounds(900, 500, 100, 30);
		button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// 반납: 1;
				if (result == "대출") {
					status = 0;
				}
				
				DBManipulation.rentStatus(status);

				JOptionPane.showMessageDialog(null, "[" + dto.getbDTO().getTitle() + "] 이 반납되었습니다.","Message", JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
				// MainFrame.contentPane.remove(Rent);
				Home home = new Home();
				home.setSize(1124, 700);
				MainFrame.contentPane.add(home, BorderLayout.CENTER);
				home.updateUI();

			}
		});
		add(button2);

		// DTO 입력
		//
		titletxt.setText(dto.getbDTO().getTitle());
		member_no.setText(Integer.toString(dto.getmDTO().getMember_no()));
		name.setText(dto.getmDTO().getName());
		if (dto.getConfirm() == 0) {
			confirm.setText("미대출");
		} else {
			confirm.setText("대출");
		}
			
		//confirm.setText(Integer.toString(dto.getConfirm()));
		
		System.out.println(dto.getbDTO().getTitle());
		System.out.println(Integer.toString(dto.getmDTO().getMember_no()));
		System.out.println(dto.getmDTO().getName());
		System.out.println(Integer.toString(dto.getConfirm()));
	}

}
