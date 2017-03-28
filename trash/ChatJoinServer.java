package Transh;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;

public class ChatJoinServer extends JFrame {
	
	private static final long serialVersionUID = 2792125188820716457L;
	


	public ChatJoinServer() {
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		setContentPane(new ContentPane());
		getContentPane().setBackground(Color.BLACK);
		getContentPane().add(panel);
		panel.setLayout(null);
		this.setLayout(null);

		/*****************************************************/
		/** build the contents below this line ****/
		
		
		

		/*************************************************************/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setSize(900, 640);
		setLocationRelativeTo(null);
		// setLocation(0, 0);
		setBackground(new Color(0, 255, 0, 0));
		setVisible(true);

	}


	class ContentPane extends JPanel { // 컨텐트패인 배경 투명 검정 설정
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

	public static void main(String[] args) {
		new ChatJoinServer();
	}

}
