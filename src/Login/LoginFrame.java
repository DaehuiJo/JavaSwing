package Login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Database.*;
import Main.*;

public class LoginFrame extends JFrame {
	
	private static final long serialVersionUID = 2792125188820716457L;
	DBManipulation manipulation = new DBManipulation(); // DAO
	//ArrayList<AdminDTO> list;
	AdminDTO dto; // DTO

	private JPanel contentPane;
	private JTextField idField;
	private JPasswordField passwordField ;
	static LoadingFrame load = null;
	public static String name;

	public LoginFrame() {

		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// 1 /********************배경***************************/
		MyPanel backGround_panel = new MyPanel();
		backGround_panel.setBounds(0, 0, 1200, 700);
		contentPane.add(backGround_panel);
		backGround_panel.setLayout(null);
		// 2 /*********************메인페널**************************/
		JPanel centerPanel = new JPanel();
		centerPanel.setBounds(290, 130, 640, 480);
		backGround_panel.add(centerPanel);
		centerPanel.setLayout(new BorderLayout(0, 0));

		// 3 /***********************************************/

		JPanel center_North = new JPanel();
		// center_North.setPreferredSize(new Dimension(800, 150));
		center_North.setBackground(new Color(51, 51, 51));
		centerPanel.add(center_North, BorderLayout.NORTH);
		center_North.setLayout(new FlowLayout(FlowLayout.LEADING, 100, 0));

		JPanel string_Panel = new JPanel();
		string_Panel.setLayout(new GridLayout(3, 0, 0, 20));
		string_Panel.setBackground(new Color(51, 51, 51));
		center_North.add(string_Panel);

		JLabel none = new JLabel();
		string_Panel.add(none);

		JLabel title = new JLabel("Administer Login");
		title.setForeground(new Color(128, 128, 128));
		title.setFont(new Font("굴림", Font.BOLD, 37));
		title.setVerticalAlignment(SwingConstants.BOTTOM);
		title.setHorizontalAlignment(SwingConstants.LEFT);
		string_Panel.add(title);

		JLabel subTitle = new JLabel("Please fill your Information.");
		subTitle.setForeground(new Color(192, 192, 192));
		subTitle.setFont(new Font("굴림", Font.PLAIN, 15));
		subTitle.setVerticalAlignment(SwingConstants.TOP);
		subTitle.setHorizontalAlignment(SwingConstants.LEFT);
		string_Panel.add(subTitle);

		
		/***********************************************/
		// main_center_center panel: ID & PW
		JPanel center_Center = new JPanel();
		center_Center.setLayout(new FlowLayout(FlowLayout.LEADING, 100, 0));
		center_Center.setBackground(new Color(51, 51, 51));
		centerPanel.add(center_Center, BorderLayout.CENTER);
		
		// ID Panel
		JPanel idpanel = new JPanel();
		idpanel.setBackground(new Color(102, 102, 102));
		idpanel.setLayout(new FlowLayout());
		center_Center.add(idpanel);

		JLabel id_Label = new JLabel();
		id_Label.setIcon(new ImageIcon("Images/icon_people_active.png"));
		idpanel.add(id_Label);

		idField = new JTextField();
		idField.setFont(new Font("굴림", Font.PLAIN, 20));
		idpanel.add(idField);
		idField.setColumns(20);

		JLabel none2 = new JLabel("           ");
		idpanel.add(none2);

		// ID/pw Panel
		JPanel id_PWpanel = new JPanel();
		id_PWpanel.setBackground(new Color(51, 51, 51));
		center_Center.add(id_PWpanel);
		JLabel none3 = new JLabel(
				"                                                                                                                                             ");
		id_PWpanel.add(none3);


		// PW Panel
		JPanel pwpanel = new JPanel();
		pwpanel.setBackground(new Color(102, 102, 102));
		pwpanel.setLayout(new FlowLayout());
		center_Center.add(pwpanel);

		JLabel pw_Label = new JLabel();
		pw_Label.setIcon(new ImageIcon("Images/icon_login_password.png"));
		pwpanel.add(pw_Label);

		passwordField = new JPasswordField();
		passwordField.setColumns(20);
		passwordField.setFont(new Font("굴림", Font.PLAIN, 20));
		pwpanel.add(passwordField);

		JLabel none4 = new JLabel("           ");
		pwpanel.add(none4);

		/***********************************************/
		// main_center_south panel: action
		JPanel center_South = new JPanel();
		center_South.setPreferredSize(new Dimension(800, 90));
		center_South.setBackground(new Color(51, 51, 51));
		center_South.setLayout(null);
		centerPanel.add(center_South, BorderLayout.SOUTH);

		JLabel login_Action_label = new JLabel("LOGIN");
		login_Action_label.setOpaque(true);
		login_Action_label.setBackground(new Color(255, 69, 0));
		login_Action_label.setForeground(new Color(255, 255, 255));
		login_Action_label.setBounds(100, 0, 100, 45);
		login_Action_label.setHorizontalAlignment(SwingConstants.CENTER);
		center_South.add(login_Action_label);

		login_Action_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				login_Action_label.setBackground(new Color(0, 153, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				login_Action_label.setBackground(new Color(255, 69, 0));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				String id = idField.getText();
				String pw = passwordField.getText();
				//String name = new String();
				
				dto = manipulation.login(id);
				//name = dto.getName();
				//name = list.get(0).getName();
				// System.out.println(name);
				// 다른 클레스에서 입력한 id에 따른 값 가져오기...

				//manipulation.login(id);
				/*******************************************************/
				//dto.getPassword() password
				//dto = null -> id가 없음
				
				
				if (null==dto) { //오류발생!!!!!   dto.equals(null)  //변수 비교시 고정값을 앞에 비교값을 뒤에
					JOptionPane.showMessageDialog(null, "' "+id+" '"+" doesn't not exist.", "ErroMessage", JOptionPane.ERROR_MESSAGE);
					idField.setText("");
					passwordField.setText("");
				} else if (!pw.equals(dto.getPassword())) {
					JOptionPane.showMessageDialog(null, "Password is wrong.", "ErroMessage", JOptionPane.ERROR_MESSAGE);
					passwordField.setText("");
				} else {	
					name = dto.getName();
					//JOptionPane.showMessageDialog(null, name+" 님의 접속이 확인되었습니다.");
					MainFrame op = new MainFrame();
					op.repaint();
					try {
						MainFrame.playSound();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					//화면이 멈춰야 보임....
					load = new LoadingFrame();
					JLabel message = new JLabel(name+" 님의 접속이 확인되었습니다.");
					message.setForeground(new Color(192, 192, 192));
					message.setFont(new Font("굴림", Font.PLAIN, 30));
					message.setBounds(350, 50, 600, 100);
					load.add(message);
					load.repaint();
					//load.updateUI();
					
					Show begin = new Show();
					//load.dispose();
					Show.loading.dispose();
					begin.execute();
					dispose();
				}
			}
		});

		JLabel regist_Action_label = new JLabel("REGIST");
		regist_Action_label.setOpaque(true);
		regist_Action_label.setBackground(new Color(255, 69, 0));
		regist_Action_label.setForeground(new Color(255, 255, 255));
		regist_Action_label.setBounds(225, 0, 100, 45);
		regist_Action_label.setHorizontalAlignment(SwingConstants.CENTER);
		center_South.add(regist_Action_label);
		regist_Action_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				regist_Action_label.setBackground(new Color(3, 181, 44));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				regist_Action_label.setBackground(new Color(255, 69, 0));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				AdministerRegistration admin = new AdministerRegistration();
			}
		});

		JLabel exit_Action_label = new JLabel("EXIT");
		exit_Action_label.setOpaque(true);
		exit_Action_label.setBackground(new Color(255, 69, 0));
		exit_Action_label.setForeground(new Color(255, 255, 255));
		exit_Action_label.setBounds(435, 0, 100, 45);
		exit_Action_label.setHorizontalAlignment(SwingConstants.CENTER);
		center_South.add(exit_Action_label);
		exit_Action_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exit_Action_label.setBackground(new Color(255, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exit_Action_label.setBackground(new Color(255, 69, 0));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

		// /***********************************************/
		// JPanel inoformation = new JPanel();
		// inoformation.setBounds(1020, 130, 100, 300);
		// backGround_panel.add(inoformation);
		// login_Action_label.setBackground(new Color(0, 128, 128));
		//
		// infotxt = new JTextField(10);
		// infotxt.setEnabled(false);
		// infotxt.setEditable(false);
		// infotxt.setBackground(new Color(47, 79, 79));
		// infotxt.setText("this is the space to input some info");
		// infotxt.setForeground(new Color(245, 255, 250));
		// inoformation.add(infotxt);

		setSize(1200, 700);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		ImageIcon icon = new ImageIcon("Images/Resize_blur_bg.png");
		Image img = icon.getImage();

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this);
		}
	}
}

/******************************************************/

class Show extends SwingWorker<Void, Void> {
	
	static LoadingFrame loading = new LoadingFrame(); 
	
	@Override
	public Void doInBackground() throws Exception {
		// do something in background
		Thread.sleep(3000);
		//loading.dispose();
		return null;
	}

	public void done() {
		// something that needs to be done afterwards
		// OperationPanel op = new OperationPanel();
		// op.repaint();
		LoginFrame.load.dispose();
	}
}
