package Database;

import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

public class DBManipulation {

	static DBConnection conn;

	public DBManipulation() {
		conn = new DBConnection();
	}

	/******************************************************************/
	/******************* Administer query *************************/

	// login
	// AdminLogin �̶�� Ŭ������ ���̵�� �н����带 �޾ƿ´�
	public AdminDTO login(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from admin where id=?";
		AdminDTO DTO = null;
		conn = new DBConnection();
		try {

			con = conn.getConnection();// DB����
			pstmt = con.prepareStatement(query);// ����SQL(��üȭ��)�۽�
			pstmt.setString(1, id); // (1, id) ���° ����ǥ���� ǥ��//����ǥ�� ����
									// ����
			rs = pstmt.executeQuery();// ������� �޾ƿ�

			while (rs.next()) {
				DTO = new AdminDTO();
				DTO.setId(rs.getString(2));
				DTO.setPassword(rs.getString(3));
				DTO.setName(rs.getString(4));
				// System.out.println(rs.getString(2));
				// System.out.println(rs.getString(3));
			} // dto = null -> �Է¹��� id���� ����
		} catch (SQLException e) {
			e.printStackTrace(); // sql���� �߻���
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return DTO;
	}

	// admin registration
	public ArrayList<AdminDTO> adminInsert(String employeeNumber, String id, String password, String name,
			String department, String cellphone, String emailAddress) {

		Connection con = null;
		con = conn.getConnection();
		PreparedStatement pstmt = null;
		ArrayList<AdminDTO> list = new ArrayList<AdminDTO>();
		String query = "insert into admin values (?,?,?,?,?,?,?)";

		try {
			pstmt = con.prepareStatement(query);// �������� ��Ʈ���� �޾Ƽ� ?
												// �κ����� ����
			pstmt.setString(1, employeeNumber); // ?�κп� name�������� ����
			pstmt.setString(2, id);
			pstmt.setString(3, password);
			pstmt.setString(4, name);
			pstmt.setString(5, department);
			pstmt.setString(6, cellphone);
			pstmt.setString(7, emailAddress);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	/************************************************************/
	/**************** Book Query *****************/

	// insert
	public int bookInsert(String title, String author, String price, String image, String isbn, String publisher,
			int category) {

		Connection con = null;
		con = conn.getConnection();
		PreparedStatement pstmt = null;
		// ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		String query = " INSERT INTO book (title,author,price,image,isbn,publisher,category) VALUES (?,?,?,?,?,?,?) ";
		int result = 0;
		try {
			pstmt = con.prepareStatement(query);// PreparedStatement.RETURN_GENERATED_KEYS
			// ResultSet res = pstmt.getGeneratedKeys();
			pstmt.setString(1, title);
			pstmt.setString(2, author);
			pstmt.setString(3, price);
			pstmt.setString(4, image);
			pstmt.setString(5, isbn);
			pstmt.setString(6, publisher);
			pstmt.setInt(7, category);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				// con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// view all
	public ArrayList<BookDTO> overallBook() {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		String query = "select * from book";

		try {
			con = conn.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				BookDTO DTO = new BookDTO();
				DTO.setBook_no(rs.getInt(1));
				DTO.setTitle(rs.getString(2));
				DTO.setAuthor(rs.getString(3));
				DTO.setPrice(rs.getString(4));
				DTO.setImage(rs.getString(5));
				DTO.setIsbn(rs.getString(6));
				DTO.setPublisher(rs.getString(7));
				DTO.setCategory(rs.getInt(8));
				list.add(DTO);
			}
			rs.close();
		} catch (SQLException e) {
		} finally {
			try {
				// rs.close();
				stmt.close();
			} catch (SQLException e) {
			}
		}
		return list;
	}

	// search-숫자
	public ArrayList<BookDTO> searchBookNO(int book_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		String query = "select * from book where book_no=?";
		BookDTO DTO = null;
		conn = new DBConnection();
		try {
			con = conn.getConnection();// DB����
			pstmt = con.prepareStatement(query);// ����SQL(��üȭ��)�۽�
			pstmt.setInt(1, book_no);
			rs = pstmt.executeQuery();// ������� �޾ƿ�

			while (rs.next()) {
				DTO = new BookDTO();
				DTO.setBook_no(rs.getInt(1));
				DTO.setTitle(rs.getString(2));
				DTO.setAuthor(rs.getString(3));
				DTO.setPrice(rs.getString(4));
				DTO.setImage(rs.getString(5));
				DTO.setIsbn(rs.getString(6));
				DTO.setPublisher(rs.getString(7));
				DTO.setCategory(rs.getInt(8));
				// DTO.setCount(rs.getInt(8));
				// DTO.setMember_number(rs.getInt(9));
				// DTO.setBook_number(rs.getInt(10));
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				// System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				// System.out.println(rs.getString(5));
				System.out.println(rs.getString(6));
				System.out.println(rs.getString(7));
				System.out.println(rs.getInt(8));
				list.add(DTO);
			}
		} catch (SQLException e) {
			e.printStackTrace(); // sql���� �߻���
		} finally {
			try {
				// rs.close();
				pstmt.close();
				// con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// search-문자_수정필!!
	public BookDTO searchBookTitle(String title) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from book where title=?";
		BookDTO DTO = null;
		conn = new DBConnection();
		System.out.println("받은 문자열" + title);
		System.out.println("여까지 왔나??");
		try {
			con = conn.getConnection();// DB����
			pstmt = con.prepareStatement(query);// ����SQL(��üȭ��)�۽�
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();// ������� �޾ƿ�

			while (rs.next()) {
				DTO = new BookDTO();
				DTO.setBook_no(rs.getInt(1));
				DTO.setTitle(rs.getString(2));
				DTO.setAuthor(rs.getString(3));
				DTO.setPrice(rs.getString(4));
				DTO.setImage(rs.getString(5));
				DTO.setIsbn(rs.getString(6));
				DTO.setPublisher(rs.getString(7));
				DTO.setCategory(rs.getInt(8));
				// DTO.setCount(rs.getInt(8));
				// DTO.setMember_number(rs.getInt(9));
				// DTO.setBook_number(rs.getInt(10));
				// System.out.println(rs.getInt(1));
				// System.out.println(rs.getString(2));
				// System.out.println(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace(); // sql���� �߻���
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return DTO;
	}

	// modi 끝
	public ArrayList<BookDTO> modifyBook(int book_no, String title, String price, String isbn, String publisher,
			int category) {

		Connection con = null;
		PreparedStatement ps = null;
		// Statement st= null;
		ArrayList<BookDTO> list = null;
		String query = "update book set book_no=?, title=?, price=?, isbn=?, publisher=?, category=? where book_no='"
				+ book_no + "' ";

		try {
			con = conn.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, book_no);
			ps.setString(2, title);
			ps.setString(3, price);
			ps.setString(4, isbn);
			ps.setString(5, publisher);
			ps.setInt(6, category);

			System.out.println(ps.toString());
			ps.executeUpdate();

			// System.out.println("쿼리후 책번호"+book_no);
			// System.out.println("쿼리후 타이틀"+title);
			// st = con.createStatement();
			// st.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("DB오류발생" + e);
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
			}
		}
		return list;

	}

	// deletion
	public ArrayList<BookDTO> deleteBook(int book_no) {
		Connection con = null;
		Statement st = null;
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		String query = "delete from book where book_no = '" + book_no + "'";

		try {
			con = conn.getConnection();
			st = con.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("오류");
		} finally {
			try {
				st.close();
				// con.close();
			} catch (SQLException e) {
			}
		}
		return list;
	}

	/***************************************************************************/
	/*************
	 * Member Query
	 ************************************************/

	// regist
	public ArrayList<MemberDTO> memberInsert(String name, String address, String cellphone, String email) {

		Connection con = null;
		con = conn.getConnection();
		PreparedStatement pstmt = null;
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		String query = "insert into member(name, address, cellphone, email) values (?,?,?,?)";
		int result = 0;
		try {
			pstmt = con.prepareStatement(query);// �������� ��Ʈ���� �޾Ƽ� ?
												// �κ����� ����
			// pstmt.setInt(1, member_no); // ?�κп� name�������� ����
			pstmt.setString(1, name);
			pstmt.setString(2, address);
			pstmt.setString(3, cellphone);
			pstmt.setString(4, email);
			// pstmt.executeUpdate();
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				// con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// view all
	public ArrayList<MemberDTO> overallMember() {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		String query = "selct * from member";

		try {
			con = conn.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				MemberDTO DTO = new MemberDTO();
				DTO.setName(rs.getString(1));
				DTO.setAddress(rs.getString(2));
				DTO.setCellphone(rs.getString(3));
				DTO.setEmail(rs.getString(4));
				// DTO.setCount(rs.getInt(5));
				// DTO.setBooknumber(rs.getInt(6));
				list.add(DTO);
			}
		} catch (SQLException e) {
		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
			}
		}
		return list;
	}

	// search_num
	public ArrayList<MemberDTO> searchMember(int member_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		String query = "select * from book where member_no=?";
		MemberDTO DTO = null;
		conn = new DBConnection();
		try {
			con = conn.getConnection();// DB����
			pstmt = con.prepareStatement(query);// ����SQL(��üȭ��)�۽�
			pstmt.setInt(1, member_no);
			rs = pstmt.executeQuery();// ������� �޾ƿ�

			while (rs.next()) {
				DTO = new MemberDTO();
				DTO.setName(rs.getString(1));
				DTO.setAddress(rs.getString(2));
				DTO.setCellphone(rs.getString(3));
				DTO.setEmail(rs.getString(4));
				
				list.add(DTO);
			}
		} catch (SQLException e) {
			e.printStackTrace(); // sql���� �߻���
		} finally {
			try {
				// rs.close();
				pstmt.close();
				// con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	// modi 끝
	public ArrayList<MemberDTO> modifyMember(int member_no, String name, String address, String cellphone, String email) {

		Connection con = null;
		PreparedStatement ps = null;
		// Statement st= null;
		ArrayList<MemberDTO> list = null;
		String query = "update book set member_no=?, name=?, address=?, cellphone=?, email=? '";
				
		try {
			con = conn.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, member_no);
			ps.setString(2, name);
			ps.setString(3, address);
			ps.setString(4, cellphone);
			ps.setString(5, email);
			
			//System.out.println(ps.toString());
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("DB오류발생" + e);
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
			}
		}
		return list;
	}

	// deletion
	public ArrayList<MemberDTO> deleteMember(String cellphone) {
		Connection con = null;
		Statement st = null;
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		String query = "delete from member where cellphone = '" + cellphone + "'";

		try {
			con = conn.getConnection();
			st = con.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("�׵��� ����.");
		} finally {
			try {
				st.close();
				// con.close();
			} catch (SQLException e) {
			}
		}
		return list;
	}

	/******************************************************/
	/******************************************************/
	public static void bestBook() {
		DBConnection conn;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT title, COUNT, image FROM book ORDER BY COUNT DESC LIMIT 1";
		conn = new DBConnection();
		try {

			con = conn.getConnection();// DB접속
			pstmt = con.prepareStatement(sql);// 서버SQL(객체화로)송신
			rs = pstmt.executeQuery();// 결과값을 받아옴
			while (rs.next()) {
				// System.out.println("제목 : " + rs.getString("title"));
				// System.out.println("대여횟수 : " + rs.getInt("count"));
				// title = rs.getString("title");
				// book_count = rs.getInt("count");
				// image = rs.getString("image");
			}
		} catch (SQLException e) {
			e.printStackTrace(); // sql에러 발생시
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	// ArrayList.get(i).getTitle() = BookDTO.
	// ArrayList.size()

	public static ArrayList<BookDTO> bookList() {
		DBConnection conn;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM book"; // ORDER BY COUNT DESC LIMIT 1";
		conn = new DBConnection();
		// String [] [] data = new String[100][100];
		ArrayList<BookDTO> data = new ArrayList<BookDTO>();
		try {

			con = conn.getConnection();// DB접속
			pstmt = con.prepareStatement(sql);// 서버SQL(객체화로)송신
			rs = pstmt.executeQuery();// 결과값을 받아옴

			while (rs.next()) {
				BookDTO information = new BookDTO();
				// System.out.println("이름 : " + rs.getString("name"));
				// System.out.println("대여횟수 : " + rs.getInt("count"));
				information.setTitle(rs.getString("title"));
				information.setAuthor(rs.getString("author"));
				information.setPrice(rs.getString("price"));
				information.setIsbn(rs.getString("isbn"));
				information.setPublisher(rs.getString("publisher"));
				information.setCategory(rs.getInt("category"));
				// information.setCount(rs.getInt("count"));
				// information.setMember_number(rs.getInt("member_number"));
				// data[0][0] = rs.getString("name");
				// data[0][1] = rs.getInt("count");
				// data[1][0];
				data.add(information);

			}
		} catch (SQLException e) {
			e.printStackTrace(); // sql에러 발생시
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return data;

		// public static ArrayList<BookDTO> bookList2() {
		// DBConnection conn;
		// Connection con = null;
		// PreparedStatement pstmt = null;
		// ResultSet rs = null;
		// }
		// String title[]= {"클럽","등수","경기","승","무","패","승점","득","실","득실차"};
		// JFrame frame = new JFrame("test");
		// DefaultTableModel model = new DefaultTableModel(title, 0);
		// JTable table = new JTable(model);
		// String arr[]={"클럽명", "랭킹","경기","승","무","패","승점","득","실","차"};
		// model.addRow(arr); //테이블에 행 추가
		// String str=null;
		// int a,i;
		// try {
		// JdbcConnect jdbc=new JdbcConnect("KLeague","angel3"); //(table명,
		// 패스워드)
		// String sql = "select * from ranking_table;";
		// ResultSet rs =(ResultSet) jdbc.show(sql);
		// while(rs.next()){
		// str=rs.getString(1); //getString(컬럼 번호)
		// //여기서 컬럼번호는 1부터 시작
		// arr[0]=str;
		// for(i=2;i<11;i++){
		// a=rs.getInt(i); //getInt(컬럼 번호)
		// arr[i-1]=a+"";
		// }
		// model.addRow(arr);
		//
		// }
		// //리소스 반환
		// jdbc.closeDB();
		// rs.close();
		// }

	}

	public static void bestMember() {
		DBConnection conn;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT name, COUNT FROM member ORDER BY COUNT DESC LIMIT 1";
		conn = new DBConnection();
		try {

			con = conn.getConnection();// DB접속
			pstmt = con.prepareStatement(sql);// 서버SQL(객체화로)송신
			rs = pstmt.executeQuery();// 결과값을 받아옴
			while (rs.next()) {
				// System.out.println("이름 : " + rs.getString("name"));
				// System.out.println("대여횟수 : " + rs.getInt("count"));
				// name = rs.getString("name");
				// member_count = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace(); // sql에러 발생시
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//대출상태 검색
//	public static RentDTO rent(String title) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		//ArrayList<RentDTO> list = new ArrayList<RentDTO>();
//		String query = "SELECT m.*,n.* FROM (SELECT r.confirm,r.member_no ,b.* FROM book AS b LEFT OUTER JOIN rent AS r ON b.book_no=r.book_no) AS n LEFT OUTER JOIN member AS m ON m.member_no=n.member_no WHERE title LIKE CONCAT('%', ?,'%')";
//		//String query = "SELECT r.confirm,m.*,b.* FROM member AS m, book AS b, rent AS r WHERE m.member_no=r.member_no AND b.book_no=r.book_no AND b.title LIKE CONCAT('%', ? ,'%')";
//		RentDTO DTO = new RentDTO();
//		BookDTO bDTO;
//		MemberDTO mDTO;
//		//conn = new DBConnection();
//		System.out.println("query:"+query);
//		try {
//			con = conn.getConnection();// DB����
//			pstmt = con.prepareStatement(query);// ����SQL(��üȭ��)�۽�
//			pstmt.setString(1, title);
//			System.out.println("pstmt: "+pstmt);
//			rs = pstmt.executeQuery();// ������� �޾ƿ�
//			System.out.println("rs: "+rs);
//			while (rs.next()) {
//				bDTO = DTO.bDTO;
//				bDTO.setBook_no(rs.getInt("book_no"));
//				bDTO.setTitle(rs.getString("Title"));
//				bDTO.setAuthor(rs.getString("Author"));
//				bDTO.setPrice(rs.getString("Price"));
//				bDTO.setImage(rs.getString("Image"));
//				bDTO.setIsbn(rs.getString("Isbn"));
//				bDTO.setPublisher(rs.getString("Publisher"));
//				bDTO.setCategory(rs.getInt("Category"));
//
//				mDTO = DTO.mDTO;
//				mDTO.setMember_no(rs.getInt("member_no"));
//				mDTO.setName(rs.getString("name"));
//				DTO.setConfirm(rs.getInt("confirm"));
//				System.out.println(rs.getInt("confirm"));
//				//list.add(DTO);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace(); // sql���� �߻���
//			System.out.println("오류발생");
//		} finally {
//			try {
//				// rs.close();
//				pstmt.close();
//				// con.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return DTO;
//	}
	
	public static RentDTO rent(String title) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//ArrayList<RentDTO> list = new ArrayList<RentDTO>();
		String query = "SELECT m.*,n.* FROM (SELECT r.confirm,r.member_no ,b.* FROM book AS b LEFT OUTER JOIN rent AS r ON b.book_no=r.book_no) AS n LEFT OUTER JOIN member AS m ON m.member_no=n.member_no WHERE title LIKE CONCAT('%', ?,'%')";
		//String query = "SELECT r.confirm,m.*,b.* FROM member AS m, book AS b, rent AS r WHERE m.member_no=r.member_no AND b.book_no=r.book_no AND b.title LIKE CONCAT('%', ? ,'%')";
		RentDTO DTO = new RentDTO();
		BookDTO bDTO;
		MemberDTO mDTO;
		conn = new DBConnection();
		System.out.println("query:"+query);
		try {
			con = conn.getConnection();// DB����
			pstmt = con.prepareStatement(query);// ����SQL(��üȭ��)�۽�
			pstmt.setString(1, title);
			System.out.println("pstmt: "+pstmt);
			rs = pstmt.executeQuery();// ������� �޾ƿ�
			System.out.println("rs: "+rs);
			while (rs.next()) {
				mDTO = DTO.mDTO;
				//mDTO.setMember_no(rs.getInt("member_no"));
				System.out.println("회원번호: "+rs.getString(1));
				mDTO.setName(rs.getString("name"));
				System.out.println("이름: "+rs.getString(2));
				//mDTO.setAddress(rs.getString("address"));
				System.out.println("주소: "+rs.getString(3));
				//mDTO.setCellphone(rs.getString("cellphone"));
				System.out.println("전화: "+rs.getString(4));
				
				DTO.setConfirm(rs.getInt("confirm"));
				System.out.println("confirm: "+rs.getInt(6));
				

				bDTO = DTO.bDTO;
				//bDTO.setBook_no(rs.getInt("book_no"));
				System.out.println("책등록번호: "+rs.getInt(8));
				bDTO.setTitle(rs.getString("Title"));
				System.out.println("책제목: "+rs.getString(9));
				//bDTO.setAuthor(rs.getString("Author"));
				//System.out.println(rs.getString(3));
				//bDTO.setPrice(rs.getString("Price"));
				//System.out.println(rs.getString(4));
				//bDTO.setImage(rs.getString("Image"));
				//bDTO.setIsbn(rs.getString("Isbn"));
				//bDTO.setPublisher(rs.getString("Publisher"));
				//bDTO.setCategory(rs.getInt("Category"));

				//list.add(DTO);
			}
		} catch (SQLException e) {
			e.printStackTrace(); // sql���� �߻���
			System.out.println("오류발생");
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return DTO;
	}
	
	
	
	
	
	//대출값 변경
	public static RentDTO rentStatus(int status) {

		Connection con = null;
		PreparedStatement ps = null;		
		RentDTO dto = new RentDTO();
		String query = "update rent set confirm = ? ";

		System.out.println(query);
		try {
			con = conn.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, status);
			

			System.out.println(ps.toString());
			ps.executeUpdate();

			// System.out.println("쿼리후 책번호"+book_no);
			// System.out.println("쿼리후 타이틀"+title);
			// st = con.createStatement();
			// st.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("DB오류발생" + e);
		} finally {
			try {
				//ps.close();
				con.close();
			} catch (SQLException e) {
			}
		}
		return dto;

	}
}
