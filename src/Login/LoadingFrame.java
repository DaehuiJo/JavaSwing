package Login;

import java.awt.*;
import javax.swing.*;

public class LoadingFrame extends JFrame {

	private static final long serialVersionUID = 2792125188820716457L;
	private JPanel panel;
	private JLabel lblImage;
	//DBManipulation manipulation = new DBManipulation(); //DAO
	//ArrayList<AdminDTO>list;

	public LoadingFrame() {
		panel = new JPanel() {
			private static final long serialVersionUID = 2730520065090889404L;
			public void paintComponent(Graphics g) {
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		setContentPane(new ContentPane());
		getContentPane().setBackground(Color.BLACK);
		getContentPane().add(panel);
		// panel.setLayout(null);
		this.setLayout(null);

//		list = manipulation.login();
//		String name = list.get(0).getName();
//		lblString = new JLabel(name);
//		lblString.setFont(new Font("굴림", Font.BOLD, 30));
//		lblString.setForeground(new Color(255, 255, 255));
//		lblString.setBounds(200, 200, 200, 200);
//		this.add(lblString);
//		System.out.println(name);
		
		lblImage = new JLabel();
		lblImage.setIcon(new ImageIcon("Images/ajax-loader.gif"));
		lblImage.setBounds(400, 200, 400, 300);
		this.add(lblImage);
		
		setUndecorated(true);
		setSize(1200, 700);
		setLocationRelativeTo(null);
		setBackground(new Color(0, 255, 0, 0));
		setVisible(true);

	}

	class ContentPane extends JPanel { // 컨텐트패인 배경 투명 검정 설정
		private static final long serialVersionUID = 2730520065090889404L;
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
		}
	}
	
}
