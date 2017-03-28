package NaverAPI;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import javax.imageio.*;


import Sub_Book.Book_Registration;

public class Insert_Book_ISBN extends JFrame {
	private static final long serialVersionUID = -6189534215973021716L;
	ImageIcon icon;

	public Insert_Book_ISBN() { // 이미지 배경으로 지정
		icon = new ImageIcon("images/Insert_Book_ISBN.png");

		JPanel panel = new JPanel() { // 이미지 배경 처리
			private static final long serialVersionUID = 1467414925871873994L;

			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 00, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		JTextField jt = new JTextField(30) { // 이미지 배경 처리
			private static final long serialVersionUID = -4962099621715870348L;

			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 00, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		}; // isbn 입력창
		jt.setBounds(280, 338, 252, 40);
		jt.setFont(new Font("나눔바른고딕", Font.BOLD, 32));
		jt.setHorizontalAlignment(JTextField.CENTER);
		jt.setForeground(new Color(213, 44, 63));
		jt.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		JButton b = new JButton("찾아보기"); // 찾아보기 버튼
		b.setBackground(new Color(235, 48, 77));
		b.setForeground(Color.WHITE);
		b.setFocusPainted(false);
		b.setBounds(500, 456, 190, 64);
		b.setFont(new Font("윤고딕310", Font.BOLD, 18));
		b.addActionListener(new ActionListener() { // 버튼 클릭 액션 처리
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand() == "찾아보기") {
					String n = jt.getText();
					if (n.length() == 0) { // 값이 입력되지 않았을 경우 처리
						JOptionPane.showMessageDialog(null, "값을 입력하지 않았습니다.", "입력오류", JOptionPane.ERROR_MESSAGE);
					} else // 값이 입력될 경우 처리
						try {
							new Naver_API(n);
							String isbn = n;

							if (Naver_API.count == 1) {
								Book_Registration.title.setText(Naver_API.title);
								Book_Registration.isbn.setText(isbn);
								Book_Registration.author.setText(Naver_API.author);
								Book_Registration.price.setText(Naver_API.price);
								Book_Registration.publisher.setText(Naver_API.publisher);
								Book_Registration.image = Naver_API.image;
								Image img;
								URL url = new URL(Naver_API.image);
								img = ImageIO.read(url);
								// int width = img.getWidth(null);
								// int height = img.getHeight(null);
								ImageIcon im = new ImageIcon(img);
								Image change = im.getImage();
								Image changed = change.getScaledInstance(350, 500, java.awt.Image.SCALE_SMOOTH);
								ImageIcon changed_icon = new ImageIcon(changed);
								Book_Registration.book.setIcon(changed_icon);
								dispose();
							}
						} catch (Exception e1) { // 입력 예외처리
							e1.printStackTrace();
						}
				}
			}
		});

		JButton old = new JButton("직접입력"); // 직접 입력 버튼
		old.setBackground(new Color(65, 219, 1));
		old.setForeground(Color.WHITE);
		old.setFocusPainted(false);
		old.setBounds(500, 524, 190, 20);
		old.setFont(new Font("윤고딕310", Font.PLAIN, 10));
		old.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}

		});
		setContentPane(new ContentPane()); // 컨텐트패인 설정
		// setContentPane(panel);
		getContentPane().setBackground(Color.BLACK);
		setLayout(new BorderLayout());
		getContentPane().add(panel);

		panel.setLayout(null); // 패널에 부착
		panel.add(jt);
		panel.add(b);
		panel.add(old);

		//setTitle("isbn입력창"); // 창설정
		setLocationRelativeTo(null);
		setUndecorated(true);
		setBackground(new Color(0, 255, 0, 0));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(830, 600);
		setVisible(true);
	}

	class ContentPane extends JPanel { // 컨텐트패인 배경 투명 검정 설정
		private static final long serialVersionUID = -2437275990867417095L;

		public ContentPane() {
			setOpaque(false);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g.create();
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
			g2d.setColor(getBackground());
			g2d.fill(getBounds());
			g2d.dispose();
		}
	}
//	public static void main(String[] args) {
//		new Insert_Book_ISBN();
//	}
}

// public static void main(String[] args) {
// Insert_Book_ISBN frame = new Insert_Book_ISBN();
//
// }
// }