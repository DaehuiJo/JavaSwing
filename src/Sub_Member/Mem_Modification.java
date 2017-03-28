package Sub_Member;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import Database.BookDTO;
import Database.DBManipulation;
import Database.MemberDTO;
import Main.Home;
import Main.MainFrame;
import Sub_Book.Book_Search;

public class Mem_Modification extends JPanel{
	private static final long serialVersionUID = -3497112135995949787L;
	
	public static JTextField member_no, name, address, cellphone, email;
	//public int category_value;
	//String[] genre = { "미분류", "소설", "시 / 에세이", "경제 / 경영", "자기계발", "인문", "역사 / 문화", "생활 / 요리" };

	// ??
	public static JLabel text, book;

	public static Border border;
	private JTable table;
	DefaultTableModel tabelModel;
	private String[] col = { "member_no", "name", "address", "cellphone", "email" };

	DBManipulation manipulation = new DBManipulation();
	ArrayList<MemberDTO> list;
	MemberDTO dto;

	public Mem_Modification(ArrayList<MemberDTO> list) {

		this.setBackground(new Color(42, 42, 42));
		this.setLayout(null);

		// title
		text = new JLabel("Modification_Member");
		text.setBounds(360, 20, 400, 100);
		text.setFont(new Font("����", Font.BOLD, 40));
		text.setBackground(new Color(42, 42, 42));
		text.setForeground(new Color(200, 200, 200));
		this.add(text);
		text.setOpaque(true);
		text.repaint();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBounds(60, 250, 480, 330);
		add(scrollPane);

		// JTable
		tabelModel = new DefaultTableModel();
		tabelModel.setColumnIdentifiers(col);

		table = new JTable(tabelModel);
		table.setEnabled(false);
		table.setBackground(new Color(0, 0, 0, 0));
		table.setForeground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);
		table.getTableHeader().setReorderingAllowed(false);

		// DTO
		this.list = list;
		dto = list.get(0);

		String result[] = new String[col.length];
		result[0] = Integer.toString(dto.getMember_no());
		// System.out.println("책번호"+dto.getBook_no());
		result[1] = dto.getName();
		// System.out.println("책타이틀"+dto.getTitle());
		result[2] = dto.getAddress();
		// System.out.println("출판사"+dto.getPublisher());
		result[3] = dto.getCellphone();
		result[4] = dto.getEmail();
		// result[0][5] = String.valueOf(dto.getCategory());
		
		// System.out.println("result 값: "+result);
		tabelModel.addRow(result);

		// Update option
		text = new JLabel("회원번호: ");
		text.setEnabled(false);
		text.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		text.setHorizontalAlignment(JLabel.RIGHT);
		text.setForeground(new Color(128, 128, 128));
		text.setBounds(600, 250, 90, 30);
		this.add(text);

		text = new JLabel("이름: ");
		text.setEnabled(false);
		text.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		text.setHorizontalAlignment(JLabel.RIGHT);
		text.setForeground(new Color(128, 128, 128));
		text.setBounds(600, 300, 90, 30);
		this.add(text);

		text = new JLabel("주소 : ");
		text.setEnabled(false);
		text.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		text.setHorizontalAlignment(JLabel.RIGHT);
		text.setForeground(new Color(128, 128, 128));
		text.setBounds(600, 350, 90, 30);
		this.add(text);

		text = new JLabel("전화번호 : ");
		text.setEnabled(false);
		text.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		text.setHorizontalAlignment(JLabel.RIGHT);
		text.setForeground(new Color(128, 128, 128));
		text.setBounds(600, 400, 90, 30);
		this.add(text);

		text = new JLabel("Email : ");
		text.setEnabled(false);
		text.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		text.setHorizontalAlignment(JLabel.RIGHT);
		text.setForeground(new Color(128, 128, 128));
		text.setBounds(600, 450, 90, 30);
		this.add(text);

//		text = new JLabel("카테고리 : ");
//		text.setEnabled(false);
//		text.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
//		text.setHorizontalAlignment(JLabel.RIGHT);
//		text.setForeground(new Color(128, 128, 128));
//		text.setBounds(600, 500, 90, 30);
//		this.add(text);

		member_no = new JTextField(30);
		border = BorderFactory.createLineBorder(new Color(100, 100, 100));
		member_no.setBorder(border);
		member_no.setBounds(700, 250, 300, 30);
		member_no.setFont(new Font("나눔바른고딕", Font.BOLD, 12));
		member_no.setForeground(Color.BLACK);
		this.add(member_no);
		member_no.setOpaque(true);
		member_no.repaint();

		name = new JTextField(30);
		name.setBounds(700, 300, 300, 30);
		name.setBorder(border);
		name.setFont(new Font("나눔바른고딕", Font.BOLD, 12));
		name.setForeground(Color.BLACK);
		this.add(name);
		name.setOpaque(true);
		name.repaint();

		address = new JTextField(30);
		address.setBorder(border);
		address.setBounds(700, 350, 300, 30);
		address.setFont(new Font("나눔바른고딕", Font.BOLD, 12));
		address.setForeground(Color.BLACK);
		this.add(address);
		address.setOpaque(true);
		address.repaint();

		cellphone = new JTextField(30);
		cellphone.setBorder(border);
		cellphone.setBounds(700, 400, 300, 30);
		cellphone.setFont(new Font("나눔바른고딕", Font.BOLD, 12));
		cellphone.setForeground(Color.BLACK);
		this.add(cellphone);
		cellphone.setOpaque(true);
		cellphone.repaint();

		email = new JTextField(30);
		email.setBorder(border);
		email.setBounds(700, 450, 300, 30);

		email.setFont(new Font("나눔바른고딕", Font.BOLD, 12));
		email.setForeground(Color.BLACK);
		this.add(email);
		email.setOpaque(true);
		email.repaint();

//		JComboBox<String> category = new JComboBox<String>(genre);
//		category.setBounds(700, 500, 300, 30);
//		this.add(category);
//		category.addItemListener(new ItemListener() {
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				// System.out.println(category.getSelectedIndex());
//				category_value = category.getSelectedIndex();
//				// System.out.println(category_value);
//			}
//		});

		JButton ok = new JButton("수정");
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int mem_no_modi = Integer.parseInt((member_no.getText()));
				String name_modi = name.getText();
				String address_modi = address.getText();
				String cellphone_modi = cellphone.getText();
				String email_modi = email.getText();
				
				
				manipulation.modifyMember(mem_no_modi, name_modi, address_modi, cellphone_modi, email_modi);
				
				Object[] options = { "OK", "CANCEL" };
				int result = JOptionPane.showOptionDialog(null, "계속 수정하시겠습니까.", null, JOptionPane.DEFAULT_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				if (result == JOptionPane.YES_OPTION) {
					// 개귀찮...
					setVisible(false);
					Book_Search sear = new Book_Search();
					sear.setSize(1124,700);
					MainFrame.contentPane.add(sear, BorderLayout.CENTER); /// ����...
					sear.updateUI();
				} else {
					// 개귀찮... main 복귀
					setVisible(false);
					Home home = new Home();
					home.setSize(1124,700);
					MainFrame.contentPane.add(home, BorderLayout.CENTER); /// ����...
					home.updateUI();					
				}
			}
		});
		ok.setBorder(new JButton().getBorder());
		ok.setBackground(new Color(117, 177, 117));
		ok.setForeground(Color.WHITE);
		ok.setOpaque(true);
		ok.setBorderPainted(false);
		ok.setFocusPainted(false);
		ok.setBorderPainted(false);
		ok.setBounds(700, 550, 300, 30);
		this.add(ok);
		ok.setOpaque(true);
		ok.repaint();

		// data값 setting
		member_no.setText(Integer.toString(dto.getMember_no()));
		name.setText(dto.getName());
		address.setText(dto.getAddress());
		cellphone.setText(dto.getCellphone());
		email.setText(dto.getEmail());
		
		updateUI();
		repaint();

	}
}