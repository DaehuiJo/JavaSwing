package Chat;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ChatInitial extends JFrame {
	
	private static final long serialVersionUID = 2792125188820716457L;
	
	private LineBorder line;
	private JLabel newServerLine, newPortLabel, existServerLine, existIpLabel, existPortNum;
	private JTextField newPortText;
	private JTextField existIpText;
	private JTextField existPortText;
	private JButton newServerBt, JoinServerBt;
	
	static String ip = null;
	static int port=0;
	
	static ChatServer server = null;
	public static ChatClient client = null;
	
	
	public ChatInitial() {
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		setContentPane(new ContentPane());
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().add(panel);
		panel.setLayout(null);
		this.setLayout(null);

		/*****************************************************/
		/**       build the contents below this line      ****/
		
		line = new LineBorder(Color.BLUE);
		
		newServerLine = new JLabel();
		newServerLine.setEnabled(false);
		newServerLine.setBounds(100, 160, 340, 280);
		newServerLine.setBorder(line);
		this.add(newServerLine);
		
		newPortLabel = new JLabel("Port Number");
		newPortLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		newPortLabel.setForeground(Color.WHITE);
		newPortLabel.setBounds(130, 250, 100, 30);
		this.add(newPortLabel);
		
		newPortText = new JTextField();
		newPortText.setColumns(10);
		newPortText.setBounds(260, 250, 150, 30);
		this.add(newPortText);
		
		newServerBt = new JButton("New Server");
		newServerBt.setBounds(160, 360, 220, 30);
		this.add(newServerBt);
		newServerBt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				port = Integer.parseInt(newPortText.getText());
				dispose();
				server = new ChatServer();
				client = new ChatClient();
			}
		});
		
		
		//
		existServerLine = new JLabel();
		existServerLine.setEnabled(false);
		existServerLine.setBorder(line);
		existServerLine.setBounds(460, 160, 340, 280);
		this.add(existServerLine);
		
		existIpLabel = new JLabel("IP Address");
		existIpLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		existIpLabel.setForeground(Color.WHITE);
		existIpLabel.setBounds(490, 220, 100, 30);
		this.add(existIpLabel);
		
		existIpText = new JTextField();
		existIpText.setColumns(10);
		existIpText.setBounds(620, 220, 150, 30);
		this.add(existIpText);
		
		existPortNum = new JLabel("Port Number");
		existPortNum.setFont(new Font("Segoe UI", Font.BOLD, 16));
		existPortNum.setForeground(Color.WHITE);
		existPortNum.setBounds(490, 280, 100, 30);
		this.add(existPortNum);
		
		existPortText = new JTextField();
		existPortText.setColumns(10);
		existPortText.setBounds(620, 280, 152, 30);
		this.add(existPortText);
		
		JoinServerBt = new JButton("Join Server");
		JoinServerBt.setBounds(520, 360, 220, 30);
		this.add(JoinServerBt);
		JoinServerBt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ip = existIpText.getText();
				port = Integer.parseInt(existPortText.getText());
				dispose();
				client = new ChatClient();
			}
		});
		

		
		/*************************************************************/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setSize(900, 640);
		setLocationRelativeTo(null);
		//setLocation(0, 0);
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
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
			g2d.setColor(getBackground());
			g2d.fill(getBounds());
		}
	}
	

	
	public static void main(String[] args)  {
		new ChatInitial();
	}


}
