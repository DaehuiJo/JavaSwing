package Chat;

import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {

	
	/******************************************/
	/************ 객체 선언 *********************/


	// 네트워크 자원변수
	private ServerSocket serverSocket = null;
	private Socket socket;
	static int portNumber;
	//public static ChatClient call;
	private StringTokenizer st;
	// 서버에 백터 생성
	private Vector userVC = new Vector();
	private Vector roomVC = new Vector();

	/************        *****************/
	// GUI
	public ChatServer() {
		serverStart();
	}
	
	
	/*****************************************************************/
	// server 생성
	public void serverStart() {

		portNumber = ChatInitial.port;
		System.out.println("넘겨받은 포트번호"+portNumber);

		try {
			serverSocket = new ServerSocket(portNumber); // 입력받은 포트번호로 서버소켓 생성
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, portNumber + " can't be used now");
		}
		if (serverSocket != null) {
			connection();
			//call = new ChatClient(); // 어케 접근하지....
			//setVisible(false); // 서버생성 후 서버화면 감춤
		}
	}

	// 통신 설정
	private void connection() {

		Thread th = new Thread(new Runnable() {

			@Override
			public void run() {
				// thread에서 처리할 내용
				// TODO Auto-generated method stub
				while (true) {
					try {
						// 사용자 접속 무한대기
						socket = serverSocket.accept();
						// 소켓번호를 받은 각각의 스레드 생성
						userInfo user = new userInfo(socket);

						user.start(); // 객체의 스레드 실행
					} catch (IOException e) {
						System.out.println("socket 접속 오류");
						break;
					}
				} // while문 끝
			}

		});

		th.start();
	}

	// 개별 client에 대한 쓰레드 생성을 위한 inner class
	class userInfo extends Thread {

		private InputStream is;
		private OutputStream os;
		private DataInputStream dis;
		private DataOutputStream dos;

		private Socket userSocket;
		private String userName;

		private boolean roomCheck = true;

		// 생성자 method
		userInfo(Socket soc) {

			this.userSocket = soc;

			userNetwork();
		}

		// 네트워크 자원 설정
		public void userNetwork() {

			try {
				is = userSocket.getInputStream();
				dis = new DataInputStream(is);
				os = userSocket.getOutputStream();
				dos = new DataOutputStream(os); // server->client로 이동

				userName = dis.readUTF();
				//userName = new String(ChatMain.chatID); // client별 name값
				// System.out.println("'" + userName + "'" + "가 접속");
				//ChatMain.chatText.append("[" + userName + "]" + "님이 미쳐 날뛰고 있습니다." + "\n");

				// 새로운 사용자 추가 알림(BroadCast??)
				broadCast("newUser/" + userName);

				// 서버에서 기존 사용자 받아오기
				for (int i = 0; i < userVC.size(); i++) {
					userInfo u = (userInfo) userVC.elementAt(i); // userInfo //
																	// 형식으로 형변환
					this.serverMessage("oldUser/ " + u.userName);
				}
				// 전체 사용자에게 알린 후 vector에 추가
				userVC.add(this);
				broadCast("userListUpdate/ ");

				// 서버에서 기존 방 목록 받아오기
				for (int i = 0; i < roomVC.size(); i++) {
					roomInfo r = (roomInfo) roomVC.elementAt(i);
					serverMessage("oldRoom/ " + r.roomName);
				}

				serverMessage("roomListUpdate/ ");

			} catch (IOException e) {
				System.out.println("Stream 설정 오류");
				JOptionPane.showMessageDialog(null, "Stream설정 에러", "알림", JOptionPane.ERROR_MESSAGE);
			}

		}

		public void run() { // 스레드에서 처리할 내용

			while (true) {
				try {
					// 현재 프로그램 사용자의 이름과 메시지를 보낸 사용자의 이름 비교???
					String msg = dis.readUTF(); // client에서 메시지 수신
					System.out.println("클라이언트에서 수신한 메시지: " + msg);
					// ChatMain.chatText.append(userName + ": " + msg + "\n");
					// 스크로 자동
					// ChatMain.chatText.setCaretPosition(ChatMain.chatText.getDocument().getLength());

					inputMsg(msg); // 오류
					// System.out.println(msg);
				} catch (IOException e) {
					System.out.println(userName + " 접속 단락");
					try {
						dos.close();
						dis.close();
						userSocket.close();
						userVC.remove(this);
						broadCast("userOut/"+ userName);
						broadCast("userListUpdate/ ");
					} catch (IOException e1) {
					}
					break;
				}
			}
		} // run method 종료

		// client로 부터 들어오는 메시지 처리
		private void inputMsg(String str) {

			st = new StringTokenizer(str, "/");

			String protocol = st.nextToken();
			String message = st.nextToken(); // 오류
			//System.out.println("클라이언트에서 수신한 프로토콜: " + protocol);
			//System.out.println("클라이언트에서 수신한 메시지: " + message);
			
			//고자상태
			if (protocol.equals("note")) {
				
				String note = st.nextToken();
				System.out.println("클라이언트에서 수신한 노트: " + note);

				// vector에서 user확인 후 message 전송
				for (int i = 0; i < userVC.size(); i++) {
					userInfo u = (userInfo) userVC.elementAt(i);
					boolean bool = u.userName.equals(message);
					System.out.println("메시지 수신자가 VC내 존재여부: "+bool+"!!!"); //히밤 false...
					if (u.userName.equals(message)) {
						System.out.println("note 수신자: "+userName);
						System.out.println("note 내용: "+note);
						u.serverMessage("note/"+userName+"/"+note);
					}
				}
			} else if (protocol.equals("createRoom")) {
				for (int i = 0; i < roomVC.size(); i++) {
					roomInfo r = (roomInfo) roomVC.elementAt(i);
					if (r.roomName.equals(message)) {
						serverMessage("createRoomFail/ " + message);
						roomCheck = false;
						break;
					}
				}
				if (roomCheck) {
					roomInfo newRoom = new roomInfo(message, this);
					// roomVC 에 newRoom 추가
					roomVC.add(newRoom);
					//currentRoom = message;
					serverMessage("createRoom/" + message);
					serverMessage("chatting/notice/["+userName+"]님이 채팅방을 개설하였습니다.");
					broadCast("new_Room/" + message);
				} else {
					roomCheck = true;
				}
			} else if (protocol.equals("chatting")) {
				String msg = st.nextToken();
				for (int i = 0; i < roomVC.size(); i++) {
					roomInfo r = (roomInfo) roomVC.elementAt(i);
					if (r.roomName.equals(message)) {
						r.roomBroadCast("chatting/"+userName+"/"+msg);
					}
				}
				// 고자상태
			} else if (protocol.equals("joinRoom")) {
				System.out.println("joinRoom protocol 수신여부: "+protocol);
				System.out.println("채팅방 이름:"+message);
				for (int i = 0; i < roomVC.size(); i++) {
					roomInfo r = (roomInfo) roomVC.elementAt(i);
					boolean bool = r.roomName.equals(message);
					System.out.println("방이름과 VC내 이름과 일치여부: "+bool+"!!!!"); //히발 false...
					//뭐지.. 백터가 불안정함...
					if (r.roomName.equals(message)) {
						r.addUser(this);
						r.roomBroadCast("chatting/notice/["+userName+"]님이 미쳐 날뛰고 있습니다.");
						serverMessage("joinRoom/"+message);
					}
				}
			}
		}

		// 전체 사용자에게 메시지 보내는 부분
		private void broadCast(String str) {

			for (int i = 0; i < userVC.size(); i++) {
				userInfo u = (userInfo) userVC.elementAt(i);

				u.serverMessage(str); // Protocol+데이터
			}
		}

		private void serverMessage(String str) { // 문자열을 받아 전송
			try {
				dos.writeUTF(str);
				System.out.println("서버가 클라이언트에게 보내는 메시지: "+str);
			} catch (IOException e) {
				System.out.println("메시지 전송 실패");
			}
		}

	}

	class roomInfo {

		private String roomName;
		private Vector roomUserVC = new Vector();

		roomInfo(String str, userInfo u) {
			this.roomName = str;
			this.roomUserVC.addElement(u);
		}

		// room 안에서 msg를 전달하는 메소드
		public void roomBroadCast(String str) {
			for (int i = 0; i < roomUserVC.size(); i++) {
				userInfo u = (userInfo) roomUserVC.elementAt(i);
				u.serverMessage(str);
			}
		}

		public void addUser(userInfo u) {
			this.roomUserVC.addElement(u);
		}
	}

}
