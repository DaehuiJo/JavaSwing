package Main;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import javax.swing.*;
import Login.*;
import Chat.*;

public class MainFrame extends JFrame {

	// overriding구축, 이벤트효과 몰아서 작성(변수=lable)
	private static final long serialVersionUID = -6372776334213817121L;
	public static JPanel contentPane;
	ChatInitial chatInit = null;
	public static BorderLayout border = new BorderLayout(0, 0);

	public MainFrame() {
		
		//layout을 객체화 시킨 후 remove(method)를 이용하여 레이아웃의 특정 부분을 날림
		//remove(border.getLayoutComponent(BorderLayout.CENTER));
		
		contentPane = new JPanel();
		contentPane.setLayout(border);
		setContentPane(contentPane);
		
		//West Panel
		JPanel panel_West = new JPanel();
		panel_West.setBackground(new Color(70, 130, 180));
		contentPane.add(panel_West, BorderLayout.WEST);
		panel_West.setLayout(new GridLayout(0, 1, 0, 0));
		
		//East Panel
		JPanel panel_East = new JPanel();
		Home homo = new Home();
		contentPane.add(homo, BorderLayout.CENTER);
		homo.updateUI();
		
		
		JLabel label_1 = new JLabel();
		label_1.setToolTipText("Home");
		label_1.setIcon(new ImageIcon("Images/icon_home_inactive.png"));
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_1.setIcon(new ImageIcon("Images/icon_home_active.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_1.setIcon(new ImageIcon("Images/icon_home_inactive.png"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				//상위 메소드(프레임 종료???)
				//메소드가 호출되었는지 확인하는 방법??
				remove(border.getLayoutComponent(BorderLayout.CENTER));
				//homo.setVisible(true);
				Home homme = new Home();
				homme.setSize(1124,700);
				contentPane.add(homme, BorderLayout.CENTER);
				homme.repaint();
				homme.updateUI();
				
				if(ChatInitial.client != null) {
					ChatInitial.client.setVisible(false);
				} else if (chatInit != null) {
					chatInit.dispose();
				}
			}
		});
		panel_West.add(label_1);
		
		JLabel label_2 = new JLabel();
		label_2.setIcon(new ImageIcon("Images/icon_book_inactive.png"));
		label_2.setToolTipText("Books");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_2.setIcon(new ImageIcon("Images/icon_book_active.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_2.setIcon(new ImageIcon("Images/icon_book_inactive.png"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				//homo.setVisible(true);
				remove(border.getLayoutComponent(BorderLayout.CENTER));
				Books swp = new Books();
				contentPane.add(swp, BorderLayout.CENTER);
				swp.updateUI();
				remove(homo);
				//label_2.setIcon(new ImageIcon("Images/icon_book_active.png"));//작동 불능...
				if(ChatInitial.client != null) {
					ChatInitial.client.setVisible(false);
				} else if (chatInit != null) {
					chatInit.dispose();
				}
			}
		});
		panel_West.add(label_2);

		JLabel label_3 = new JLabel();
		label_3.setToolTipText("Member");
		label_3.setIcon(new ImageIcon("Images/icon_people_inactive.png"));
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_3.setIcon(new ImageIcon("Images/icon_people_active.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_3.setIcon(new ImageIcon("Images/icon_people_inactive.png"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				//homo.setVisible(true);
				remove(border.getLayoutComponent(BorderLayout.CENTER));
				Member mem = new Member();
				contentPane.add(mem, BorderLayout.CENTER);
				mem.updateUI();
				mem.repaint();
				remove(homo);
				//label_3.setIcon(new ImageIcon("Images/icon_people_active.png"));
				if(ChatInitial.client != null) {
					ChatInitial.client.setVisible(false);
				} else if (chatInit != null) {
					chatInit.dispose();
				}
			}
		});
		panel_West.add(label_3);

		JLabel label_4 = new JLabel();
		label_4.setIcon(new ImageIcon("Images/icon_chat_inactive.png"));
		label_4.setToolTipText("Chat");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_4.setIcon(new ImageIcon("Images/icon_chat_active.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_4.setIcon(new ImageIcon("Images/icon_chat_inactive.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//label_4.setIcon(new ImageIcon("Images/icon_chat_active.png"));
				if (chatInit == null) { //채팅창 초기화면이 없을경우
					if (ChatInitial.client == null) { //채팅 창이 호출되지 않았을 경우_채팅창 초기화면 호출
						chatInit = new ChatInitial();
					} else if(ChatInitial.client != null) { //채팅창이 호출되었을 경우_채팅창 보이기
						ChatInitial.client.setVisible(true); 
					}
				} else if(chatInit != null) { //채팅창 초기화면이 있는 경우_채팅창 초기화면 종료
					chatInit.dispose();
					chatInit=null;
				}
			}
		});
		panel_West.add(label_4);

		JLabel label_5 = new JLabel();
		label_5.setIcon(new ImageIcon("Images/icon_power_inactive.png"));
		label_5.setToolTipText("Power");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_5.setIcon(new ImageIcon("Images/icon_power_active.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_5.setIcon(new ImageIcon("Images/icon_power_inactive.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//JOptionpane 생성 
				Object[] options = { "OK", "CANCEL" };
				int result = JOptionPane.showOptionDialog(null, "프로그램을 종료하시겠습니까?", "종료", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
				             null, options, options[0]);
				if (result == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
				else {
				}				
			}
		});
		panel_West.add(label_5);
		
		//East Panel

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200,700);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setVisible(true);

	}
	
	public static void playSound() throws Exception {
        //String windowsPath = System.getenv("WINDIR");
        //String audioFile = windowsPath + "/Media/tada.wav";
    	String audioFile = "C:/Users/surpr/workspace/NewStart/test02.wav";    	
        Clip clip;
        File soundFile = new File(audioFile);

        Line.Info linfo = new Line.Info (Clip.class);
        Line line = AudioSystem.getLine (linfo);
        clip = (Clip) line;
        AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
        clip.open (ais);
        clip.start();
    }

	/******************************************************/
	//Run!!
	public static void main(String[] args) {
		 new MainFrame();
		//new LoginFrame();
	}
}
