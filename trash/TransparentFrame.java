package Transh;
import java.awt.*;
import javax.swing.*;

public class TransparentFrame extends JFrame {

	public TransparentFrame() {
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
		/**       build the contents below this line      ****/
		
//		label = new JLabel();
//		label.setIcon(new ImageIcon("Images/ajax-loader.gif"));
//		label.setBounds(400, 200, 400, 300);
//		this.add(label);
		
		
		
		
		
		
		
		/*************************************************************/
		setUndecorated(true);
		setSize(1200,700);
		setLocationRelativeTo(null);
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
	

	
//	public static void main(String[] args)  {
//		new TransparentFrame();
//	}


}
