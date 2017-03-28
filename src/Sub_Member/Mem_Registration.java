package Sub_Member;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Database.DBManipulation;
import Database.MemberDTO;

public class Mem_Registration extends JPanel{
	private static final long serialVersionUID = 8316046178908165913L;
	public static JLabel text;
	public static Border border;
	public static JLabel book;
	
	DBManipulation manipulation = new DBManipulation();
	ArrayList<MemberDTO> list;
	MemberDTO dto;

//	public Image img = null;
//	static File imagefile = new File("images/test3.jpg");

	public Mem_Registration() {

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
			
		text = new JLabel("Registration_Member");		
		text.setBounds(360,20,400,100);
		text.setFont(new Font("����", Font.BOLD, 40));		
		text.setBackground(new Color(42,42,42));
		text.setForeground(new Color(200,200,200));
		this.add(text);
		text.setOpaque(true);
		text.repaint();
		
		book = new JLabel();
		book.setIcon(new ImageIcon("Images/icon_people_default.png"));
		book.setBounds(40,140,512,512);
		book.setBackground(new Color(42,42,42));
		
		book.setHorizontalAlignment(JLabel.CENTER);
		book.setVerticalAlignment(JLabel.CENTER);
		this.add(book);
		book.setOpaque(true);
		book.repaint();
		
		text = new JLabel("이름 : ");
		text.setEnabled(false);
		text.setFont(new Font("나눔바른고딕", Font.BOLD, 14));		
		text.setHorizontalAlignment(JLabel.RIGHT);
		text.setForeground(new Color(128, 128, 128));
		text.setBounds(600, 250, 90, 30);
		this.add(text);
		
		text = new JLabel("주소 : ");
		text.setEnabled(false);
		text.setFont(new Font("나눔바른고딕", Font.BOLD, 14));		
		text.setHorizontalAlignment(JLabel.RIGHT);
		text.setForeground(new Color(128, 128, 128));
		text.setBounds(600, 300, 90, 30);
		this.add(text);
		
		text = new JLabel("전화번호 : ");
		text.setEnabled(false);
		text.setFont(new Font("나눔바른고딕", Font.BOLD, 14));		
		text.setHorizontalAlignment(JLabel.RIGHT);
		text.setForeground(new Color(128, 128, 128));
		text.setBounds(600, 350, 90, 30);
		this.add(text);
		
		text = new JLabel("이메일 : ");
		text.setEnabled(false);
		text.setFont(new Font("나눔바른고딕", Font.BOLD, 14));		
		text.setHorizontalAlignment(JLabel.RIGHT);
		text.setForeground(new Color(128, 128, 128));
		text.setBounds(600, 400, 90, 30);
		this.add(text);
		
		JTextField name = new JTextField(30);
		name.setBounds(700, 250, 300, 30);
		name.setBorder(border);
		name.setFont(new Font("나눔바른고딕", Font.BOLD, 12));			
		name.setForeground(Color.BLACK);
		this.add(name);
		name.setOpaque(true);
		name.repaint();
		
		JTextField address = new JTextField(30);
		address.setBorder(border);
		address.setBounds(700, 300, 300, 30);
		address.setFont(new Font("나눔바른고딕", Font.BOLD, 12));			
		address.setForeground(Color.BLACK);
		this.add(address);
		address.setOpaque(true);
		address.repaint();
		
		JTextField cellphone = new JTextField(30);
		cellphone.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				String chk = "";
				JTextField s=(JTextField)arg0.getSource();
				try{
					if(!s.getText().isEmpty())
					Integer.parseInt(s.getText());
					chk=s.getText();
					} catch(NumberFormatException nfe){
						s.setText(chk);
						JOptionPane.showMessageDialog(null, "숫자만 입력 가능합니다.");	
					}
			}
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		cellphone.setBorder(border);
		cellphone.setBounds(700, 350, 300, 30);
		cellphone.setFont(new Font("나눔바른고딕", Font.BOLD, 12));			
		cellphone.setForeground(Color.BLACK);
		this.add(cellphone);
		cellphone.setOpaque(true);
		cellphone.repaint();
		
		JTextField email = new JTextField(30);
		email.setBorder(border);
		email.setBounds(700, 400, 300, 30);		
		email.setFont(new Font("나눔바른고딕", Font.BOLD, 12));			
		email.setForeground(Color.BLACK);
		this.add(email);
		email.setOpaque(true);
		email.repaint();
		
		
		JButton ok = new JButton("등록");
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String dbName = name.getText();
				String dbAddress = address.getText();
				String dbCellphone = cellphone.getText();
				String dbEmail = email.getText();;
				
				
				manipulation.memberInsert(dbName, dbAddress, dbCellphone, dbEmail);
				JOptionPane.showMessageDialog(null, "입력이 완료되었습니다.");	
				
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
