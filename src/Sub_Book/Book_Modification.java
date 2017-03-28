package Sub_Book;

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
import Main.Home;
import Main.MainFrame;

public class Book_Modification extends JPanel {

	private static final long serialVersionUID = 1733442535521768877L;

	public static JTextField book_no, title, publisher, price, isbn;
	public int category_value;
	String[] genre = { "미분류", "소설", "시 / 에세이", "경제 / 경영", "자기계발", "인문", "역사 / 문화", "생활 / 요리" };

	// ??
	public static JLabel text, book;

	public static Border border;
	private JTable table;
	DefaultTableModel tabelModel;
	private String[] col = { "title", "author", "publisher", "price", "isbn", "category" };

	DBManipulation manipulation = new DBManipulation();
	ArrayList<BookDTO> list;
	BookDTO dto;

	public Book_Modification(ArrayList<BookDTO> list) {

		this.setBackground(new Color(42, 42, 42));
		this.setLayout(null);

		// title
		text = new JLabel("Modification_Book");
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
		result[0] = Integer.toString(dto.getBook_no());
		// System.out.println("책번호"+dto.getBook_no());
		result[1] = dto.getTitle();
		// System.out.println("책타이틀"+dto.getTitle());
		result[2] = dto.getPublisher();
		// System.out.println("출판사"+dto.getPublisher());
		result[3] = dto.getPrice();
		result[4] = dto.getIsbn();
		// result[0][5] = String.valueOf(dto.getCategory());
		result[5] = Integer.toString(dto.getCategory());
		// System.out.println("result 값: "+result);
		tabelModel.addRow(result);

		// Update option
		text = new JLabel("등록번호: ");
		text.setEnabled(false);
		text.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		text.setHorizontalAlignment(JLabel.RIGHT);
		text.setForeground(new Color(128, 128, 128));
		text.setBounds(600, 250, 90, 30);
		this.add(text);

		text = new JLabel("제목: ");
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

		book_no = new JTextField(30);
		border = BorderFactory.createLineBorder(new Color(100, 100, 100));
		book_no.setBorder(border);
		book_no.setBounds(700, 250, 300, 30);
		book_no.setFont(new Font("나눔바른고딕", Font.BOLD, 12));
		book_no.setForeground(Color.BLACK);
		this.add(book_no);
		book_no.setOpaque(true);
		book_no.repaint();

		title = new JTextField(30);
		title.setBounds(700, 300, 300, 30);
		title.setBorder(border);
		title.setFont(new Font("나눔바른고딕", Font.BOLD, 12));
		title.setForeground(Color.BLACK);
		this.add(title);
		title.setOpaque(true);
		title.repaint();

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

		JComboBox<String> category = new JComboBox<String>(genre);
		category.setBounds(700, 500, 300, 30);
		this.add(category);
		category.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// System.out.println(category.getSelectedIndex());
				category_value = category.getSelectedIndex();
				// System.out.println(category_value);
			}
		});

		JButton ok = new JButton("수정");
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// System.out.println("쿼리전 책번호: "+book_no_modi);
				// System.out.println("쿼리전 타이틀: "+title_modi);
				// System.out.println("쿼리전 출판사: "+publisher_modi);
				try {
					int book_no_modi = Integer.parseInt((book_no.getText()));
					String title_modi = title.getText();
					String publisher_modi = publisher.getText();
					String price_modi = price.getText();
					String isbn_modi = isbn.getText();
					int num_modi = category.getSelectedIndex();

					manipulation.modifyBook(book_no_modi, title_modi, publisher_modi, price_modi, isbn_modi, num_modi);

				} catch (Exception s) {
					JOptionPane.showConfirmDialog(null, "오류발생");
				}
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
		book_no.setText(Integer.toString(dto.getBook_no()));
		title.setText(dto.getTitle());
		publisher.setText(dto.getPublisher());
		price.setText(dto.getPrice());
		isbn.setText(dto.getIsbn());
		int num = dto.getCategory();
		category.setSelectedIndex(num);
		updateUI();
		repaint();

	}
}