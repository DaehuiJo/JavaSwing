package Chat;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import Login.*;

public class ChatClient extends JFrame {

	private static final long serialVersionUID = 2792125188820716457L;
	private JScrollPane chatScroll, roomScroll, memberScroll;
	public static JTextArea chatText;
	private JTextField messageText;
	private JLabel createRoom, enterRoom, noteSend, exitIcon;
	private TitledBorder chatBord, roomBord, memberBord, writeBord;
	private JList roomList, memberList;
	// network object
	// - socket
	private Socket socket;
	private String ip, msg;
	static String chatID;
	private int port;
	// - networking
	private InputStream is;
	private OutputStream os;
	private DataInputStream dis;
	private DataOutputStream dos;
	// 그 외
	Vector userVC = new Vector();
	Vector roomVC = new Vector();
	StringTokenizer st=null;
	private String myRoom;

	public ChatClient() {
		JPanel panel = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		setContentPane(new ContentPane());
		getContentPane().setBackground(new Color(75,43,80));
		getContentPane().add(panel);
		panel.setLayout(null);
		this.setLayout(null);

		chatBord = BorderFactory.createTitledBorder("Chat");
		chatBord.setTitleColor(Color.WHITE);
		chatBord.setTitleFont(new Font("Chiller", Font.BOLD, 28));
		roomBord = BorderFactory.createTitledBorder("Chat Room List");
		roomBord.setTitleColor(Color.WHITE);
		roomBord.setTitleFont(new Font("Chiller", Font.BOLD, 28));
		memberBord = BorderFactory.createTitledBorder("Member List");
		memberBord.setTitleColor(Color.WHITE);
		memberBord.setTitleFont(new Font("Chiller", Font.BOLD, 28));
		writeBord = BorderFactory.createTitledBorder("Write");
		writeBord.setTitleColor(Color.WHITE);
		writeBord.setTitleFont(new Font("Chiller", Font.BOLD, 20));
		

		chatScroll = new JScrollPane();
		chatScroll.setBounds(30, 30, 570, 450);
		chatScroll.setOpaque(false);
		chatScroll.getViewport().setOpaque(false);
		chatScroll.setViewportBorder(null);
		chatScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		chatScroll.setBorder(chatBord);
		add(chatScroll);

		chatText = new JTextArea();
		chatText.setBorder(null);
		chatText.setBackground(new Color(0, 0, 0, 0));
		chatText.setForeground(new Color(255, 255, 255));
		chatText.setFont(new Font("굴림", Font.BOLD, 20));
		chatText.setEditable(false);
		chatText.setEnabled(false);
		chatText.setLineWrap(true);
		chatScroll.setViewportView(chatText);

		roomScroll = new JScrollPane();
		roomScroll.setOpaque(false);
		roomScroll.getViewport().setOpaque(false);
		roomScroll.setBorder(null);
		roomScroll.setViewportBorder(null);
		roomScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		roomScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		roomScroll.setBorder(roomBord);
		roomScroll.setBounds(650, 30, 210, 180);
		add(roomScroll);

		roomList = new JList();
		roomList.setBackground(new Color(0, 0, 0, 0));
		roomList.setForeground(new Color(255, 255, 255));
		roomScroll.setViewportView(roomList);
		roomList.setListData(roomVC);
		roomList.updateUI();

		createRoom = new JLabel("create");
		createRoom.setFont(new Font("굴림", Font.BOLD, 20));
		createRoom.setForeground(Color.WHITE);
		createRoom.setHorizontalAlignment(SwingConstants.CENTER);
		// createRomm.setIcon(new ImageIcon("Images/icon_people_active.png"));
		createRoom.setBounds(650, 215, 105, 35);
		createRoom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				createRoom.setBackground(new Color(118, 149, 196));
				createRoom.setOpaque(true);
				repaint();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				createRoom.setOpaque(false);
				repaint();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				String roomName = JOptionPane.showInputDialog(null, "Chat Room Title");
				System.out.println(roomName);
				if (roomName != null) {
					sendMessage("createRoom/"+roomName);
				}
			}
		});
		add(createRoom);

		enterRoom = new JLabel("enter");
		enterRoom.setFont(new Font("굴림", Font.BOLD, 20));
		enterRoom.setForeground(Color.WHITE);
		enterRoom.setHorizontalAlignment(SwingConstants.CENTER);
		// enterRoom.setIcon(new ImageIcon("Images/icon_people_active.png"));
		enterRoom.setBounds(755, 215, 105, 35);
		enterRoom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				enterRoom.setBackground(new Color(118, 149, 196));
				enterRoom.setOpaque(true);
				repaint();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				enterRoom.setOpaque(false);
				repaint();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				String entryRoom = (String) roomList.getSelectedValue();
				sendMessage("joinRoom/"+entryRoom);
			}
		});
		add(enterRoom);

		memberScroll = new JScrollPane();
		memberScroll.setOpaque(false);
		memberScroll.getViewport().setOpaque(false);
		memberScroll.setBorder(null);
		memberScroll.setViewportBorder(null);
		memberScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		memberScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		memberScroll.setBorder(memberBord);
		memberScroll.setBounds(650, 255, 210, 180);
		add(memberScroll);

		memberList = new JList();
		memberList.setBackground(new Color(0, 0, 0, 0));
		memberList.setForeground(new Color(255, 255, 255));
		memberScroll.setViewportView(memberList);
		memberList.setListData(userVC);
		memberList.updateUI();

		noteSend = new JLabel("Note Send");
		noteSend.setFont(new Font("굴림", Font.BOLD, 20));
		noteSend.setForeground(Color.WHITE);
		noteSend.setHorizontalAlignment(SwingConstants.CENTER);
		// enterRoom.setIcon(new ImageIcon("Images/icon_people_active.png"));
		noteSend.setBounds(650, 445, 210, 30);
		noteSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				noteSend.setBackground(new Color(118, 149, 196));
				noteSend.setOpaque(true);
				repaint();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				noteSend.setOpaque(false);
				repaint();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				String user = (String) memberList.getSelectedValue();
				String note = JOptionPane.showInputDialog("content");
				if (note != null) {
					sendMessage("note/"+user+"/"+note);
					// ex) Note/user2@content => protocol name/user name@content
				}

			}
		});
		add(noteSend);

		messageText = new JTextField(20);
		messageText.setBounds(30, 500, 570, 80);
		messageText.setFont(new Font("굴림", Font.BOLD, 18));
		messageText.setColumns(10);
		messageText.setBackground(new Color(0, 0, 0, 0));
		messageText.setForeground(new Color(255, 255, 255));
		messageText.setBorder(writeBord);
		messageText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				repaint();
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					sendMessage("chatting/"+myRoom+"/"+messageText.getText());
					messageText.setText("");
					messageText.requestFocus();
				}
			}
		}); 
		add(messageText);
		
//		//미구현
//		saveIcon = new JLabel("save");
//		saveIcon.setIcon(new ImageIcon("Images/icon_people_active.png"));
//		saveIcon.setBounds(650, 540, 50, 50);
//		add(saveIcon);
		
		exitIcon = new JLabel("Exit");
		exitIcon.setForeground(new Color(255, 255, 255));
		exitIcon.setBounds(780, 540, 80, 40);
		exitIcon.setHorizontalAlignment(SwingConstants.CENTER);
		add(exitIcon);
		exitIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitIcon.setBackground(new Color(255, 0, 0));
				exitIcon.setOpaque(true);
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitIcon.setOpaque(false);
				repaint();
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				ChatInitial.client = null;
				try {
				os.close();
				is.close();
				dos.close();
				dis.close();
				socket.close();
				} catch (IOException e1) {				}
				//if (ChatInitial.server != null) {
				//	
				//}
			}
		});
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setSize(900, 640);
		setLocationRelativeTo(null);
		setBackground(new Color(0, 255, 0, 0));
		setVisible(true);

		chatID = new String(LoginFrame.name);
		network();
	}

	class ContentPane extends JPanel { // 컨텐트패인 배경 투명 검정 설정
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

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

	private void network() { // 소켓 연결

		try {
			if (ChatInitial.ip != null) {
				ip = ChatInitial.ip;
				port = ChatInitial.port;
			} else {
				ip = "127.0.0.1";
				port = ChatServer.portNumber;
			}
			socket = new Socket(ip, port);

		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "연결 실패", "알림", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "연결 실패", "알림", JOptionPane.ERROR_MESSAGE);
		}

		if (socket != null)
			connection();

	}

	private void connection() { // 데이터 통신

		try {
			is = socket.getInputStream();
			dis = new DataInputStream(is);
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);
		} catch (IOException e) { // 에러처리 부분
			JOptionPane.showMessageDialog(null, "연결 실패", "알림", JOptionPane.ERROR_MESSAGE);
		} // Stream 설정 끝

		// 처음 접속시의 아이디로 chatID설정
		//chatID = new String(LoginFrame.name);
		// System.out.println("서버 접속 후 이름값: " + chatID);
		sendMessage(chatID);
		// 사용자 리스트
		userVC.add(chatID); // userList Vector에 chatID 추가
		memberList.setListData(userVC);
		// nameL.setListData(userList); // nameList(component)에 vector추가

		// thread 설정
		Thread th = new Thread(new Runnable() {

			@Override
			public void run() {
				// 무한 루프
				while (true) {
					try {
						String msg = dis.readUTF(); // 서버로부터 메시지 수신
						// chatText.append(msg); // 메시지 수신 후 화면에 뿌림

						receiveMessage(msg); //오류발생
					} catch (IOException e) {
						JOptionPane.showMessageDialog(null, "서버 접속 단락", "알림", JOptionPane.ERROR_MESSAGE);
						try {
							os.close();
							is.close();
							dos.close();
							dis.close();
							socket.close();
							break;
						} catch (IOException e1) {

						}
					}
				}
			}
		});

		th.start();
	}

	private void receiveMessage(String str) { //오류발생

		st = new StringTokenizer(str,"/");
		System.out.println("receiving Message from server : "+str);
		String protocol = st.nextToken();
		//System.out.println("server 수신 프로토콜1: "+protocol);
		String message = st.nextToken();
		//System.out.println("server 수신 메시지1: "+message);//오류발생

		if (protocol.equals("newUser")) { // 뉴비 등장
			userVC.add(message);
			//memberList.setListData(userVC);
			//memberList.updateUI();

		} else if (protocol.equals("oldUser")) { // 기존 인간들 이름값 받아오기
			userVC.add(message);
			//memberList.setListData(userVC);
		} else if (protocol.equals("note")) {

			// String user = st.nextToken();
			String note = st.nextToken();
			JOptionPane.showMessageDialog(null, note, message + "로부터 온 쪽지", JOptionPane.CANCEL_OPTION);

		} else if (protocol.equals("userListUpdate")) {
			memberList.setListData(userVC);
			//memberList.updateUI();
		} else if (protocol.equals("createRoom")) {
			myRoom = message;
			JOptionPane.showMessageDialog(null, "채팅방에 입장했습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
		} else if (protocol.equals("createRoomFail")) {
			JOptionPane.showMessageDialog(null, "방 만들기 실패", "알림", JOptionPane.ERROR_MESSAGE);
		} else if (protocol.equals("new_Room")) {
			roomVC.add(message);
			roomList.setListData(roomVC);
			roomList.updateUI();
		} else if (protocol.equals("chatting")) {
			String msg = st.nextToken();
			//System.out.println("붙일건데 이거 되냐??"+msg);
			chatText.append(" "+message + ": " + msg + "\n");
			chatText.setCaretPosition(chatText.getDocument().getLength());
			//chatText.updateUI();
		} else if (protocol.equals("oldRoom")) {
			roomVC.add(message);
		} else if (protocol.equals("roomListUpdate")) {
			roomList.setListData(roomVC);
			roomList.updateUI();
		} else if (protocol.equals("joinRoom")) {
			myRoom = message;
			JOptionPane.showMessageDialog(null, "enter", "알림", JOptionPane.INFORMATION_MESSAGE);
		} else if (protocol.equals("userOut")) {
			userVC.remove(message);	
		}

	}

	private void sendMessage(String str) { // 서버에 메세지를 보내는 부분

		try {
			System.out.println("sending Message to Server: "+str);
			dos.writeUTF(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new ChatClient();
	}

}
