package Login;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import Database.*;

public class AdministerRegistration extends JFrame {

	private static final long serialVersionUID = 2792125188820716457L;
	private JPanel contentPane;
	private JLabel lblTitle, lblId, lblPassword, lblrePassword, lblName,
					lblDepartment, lblCellphone, lblEmail, lblSubmit;
	private JTextField textEmNum, textID, textName, textDepart, textCell, textEmail;
	private JPasswordField passwordField, confirmPasswordField;
	DBManipulation manipulation = new DBManipulation();
	ArrayList<AdminDTO> list;
	AdminDTO dto;

	AdministerRegistration() {
		
		//list=manipulation.adminInsert();
		
		//main Panel
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(new Color(38, 46, 59));
		contentPane.setLayout(null);
		
		//top subPanel
		lblTitle = new JLabel("Administer Registration");
		//lblTitle.setBackground(new Color(38, 46, 59));
		//lblTitle.setOpaque(true);
		lblTitle.setFont(new Font("굴림", Font.BOLD, 30));
		lblTitle.setForeground(new Color(255, 255, 255));
		//lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(80, 30, 600, 60);
		contentPane.add(lblTitle);
		
		//center subPanel
		//option #1
		JLabel employeeNum = new JLabel("Employee Number");
		employeeNum.setEnabled(false);
		employeeNum.setForeground(new Color(128, 128, 128));
		employeeNum.setBounds(80, 110, 200, 27);
		contentPane.add(employeeNum);
		
		JLabel employeeNum_Text = new JLabel("Ex) 1601001");
		employeeNum_Text.setEnabled(false);
		employeeNum_Text.setForeground(new Color(128, 128, 128));
		employeeNum_Text.setBounds(90, 135, 200, 27);
		contentPane.add(employeeNum_Text);
		
		textEmNum = new JTextField(10);
		textEmNum.setBounds(80, 135, 200, 27);
		contentPane.add(textEmNum);
		
		//option #2
		lblId = new JLabel("ID");
		lblId.setForeground(Color.GRAY);
		lblId.setEnabled(false);
		lblId.setBounds(80, 185, 200, 27);
		contentPane.add(lblId);
		
		JLabel lblId_text = new JLabel("Ex) superman");
		lblId_text.setEnabled(false);
		lblId_text.setForeground(new Color(128, 128, 128));
		lblId_text.setBounds(90, 210, 200, 27);
		contentPane.add(lblId_text);
		
		textID = new JTextField();
		textID.setColumns(10);
		textID.setBounds(80, 210, 200, 27);
		contentPane.add(textID);
		
		//option #3
		lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.GRAY);
		lblPassword.setEnabled(false);
		lblPassword.setBounds(80, 260, 200, 27);
		contentPane.add(lblPassword);
		
		JLabel lblPass_Text = new JLabel("Ex) !abcd123!");
		lblPass_Text.setEnabled(false);
		lblPass_Text.setForeground(new Color(128, 128, 128));
		lblPass_Text.setBounds(90, 285, 200, 27);
		contentPane.add(lblPass_Text);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(80, 285, 200, 27);
		contentPane.add(passwordField);
		
		//option #4
		lblrePassword = new JLabel("Password Confirm");
		lblrePassword.setForeground(Color.GRAY);
		lblrePassword.setEnabled(false);
		lblrePassword.setBounds(80, 335, 249, 27);
		contentPane.add(lblrePassword);
		
		JLabel lblPassConf_Text = new JLabel("Ex) !abcd123!");
		lblPassConf_Text.setEnabled(false);
		lblPassConf_Text.setForeground(new Color(128, 128, 128));
		lblPassConf_Text.setBounds(90, 360, 200, 27);
		contentPane.add(lblPassConf_Text);
		
		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setBounds(80, 360, 200, 27);
		contentPane.add(confirmPasswordField);
		
		//option #5
		lblName = new JLabel("Name");
		lblName.setForeground(Color.GRAY);
		lblName.setEnabled(false);
		lblName.setBounds(380, 110, 200, 27);
		contentPane.add(lblName);
		
		JLabel lblName_text = new JLabel("Ex) Bruce Lee");
		lblName_text.setEnabled(false);
		lblName_text.setForeground(new Color(128, 128, 128));
		lblName_text.setBounds(390, 135, 200, 27);
		contentPane.add(lblName_text);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(380, 135, 200, 27);
		contentPane.add(textName);
		
		//option #6
		lblDepartment = new JLabel("Department");
		lblDepartment.setForeground(Color.GRAY);
		lblDepartment.setEnabled(false);
		lblDepartment.setBounds(380, 185, 200, 27);
		contentPane.add(lblDepartment);
		
		JLabel lblDepart_text = new JLabel("Ex) Purchasing Division");
		lblDepart_text.setEnabled(false);
		lblDepart_text.setForeground(new Color(128, 128, 128));
		lblDepart_text.setBounds(390, 210, 200, 27);
		contentPane.add(lblDepart_text);
		
		textDepart = new JTextField();
		textDepart.setColumns(10);
		textDepart.setBounds(380, 210, 200, 27);
		contentPane.add(textDepart);
		
		//option #7
		lblCellphone = new JLabel("Cellphone");
		lblCellphone.setForeground(Color.GRAY);
		lblCellphone.setEnabled(false);
		lblCellphone.setBounds(380, 260, 200, 27);
		contentPane.add(lblCellphone);
		
		JLabel lblCellph_Text = new JLabel("Ex) 000 0000 0000");
		lblCellph_Text.setEnabled(false);
		lblCellph_Text.setForeground(new Color(128, 128, 128));
		lblCellph_Text.setBounds(390, 285, 200, 27);
		contentPane.add(lblCellph_Text);
		
		textCell = new JTextField();
		textCell.setColumns(10);
		textCell.setBounds(380, 285, 200, 27);
		contentPane.add(textCell);
		
		//option #7
		lblEmail = new JLabel("Email Address");
		lblEmail.setForeground(Color.GRAY);
		lblEmail.setEnabled(false);
		lblEmail.setBounds(380, 335, 200, 27);
		contentPane.add(lblEmail);
		
		JLabel lblEmail_Text = new JLabel("Ex) xxxx@xxxx.xxx");
		lblEmail_Text.setEnabled(false);
		lblEmail_Text.setForeground(new Color(128, 128, 128));
		lblEmail_Text.setBounds(390, 360, 200, 27);
		contentPane.add(lblEmail_Text);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(380, 360, 200, 27);
		contentPane.add(textEmail);
		

		//south subPanel
		//submit label
		lblSubmit = new JLabel("Submit");
		lblSubmit.setForeground(new Color(255, 255, 255));
		lblSubmit.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubmit.setBackground(new Color(255, 69, 0));
		lblSubmit.setOpaque(true);
		lblSubmit.setBounds(380, 430, 70, 30);
		lblSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSubmit.setBackground(new Color(255, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblSubmit.setBackground(new Color(255, 69, 0));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				//주키ㅣ id, 보조키: 사원번호
				
				//String id = textID.getText();
				//boolean idResult = (textID.getText()).equals(list.get(0).getId());
				//System.out.println("입력한 ID값 중에 DB에 있는 ID값이 있는지 여부: "+idResult);  //아놔...
				
				//boolean passwordResult = (passwordField.getPassword() == confirmPasswordField.getPassword());
				boolean passwordResult = passwordField.equals(confirmPasswordField);
				//System.out.println(passwordField.getPassword());
				//System.out.println(confirmPasswordField.getPassword());
				//System.out.println(passwordResult);
				
				//if ((textID.getText()).equals(list.get(0).getId())) {
				//	JOptionPane.showMessageDialog(null, textID.getText()+"is alreay exist.");
				//	textID.setText("");
				//}

				//비밀번호 일치여부 확인
				//if (!(passwordField.getPassword()).equals(confirmPasswordField.getPassword())) {
				//	JOptionPane.showMessageDialog(null, "password dosen't same.");
				//	passwordField.setText("");
				//	confirmPasswordField.setText("");
				//} else {
					String employeeNumber = textEmNum.getText();
					String id = textID.getText();
					//@SuppressWarnings("deprecation")
					String password = passwordField.getText();
					String name = textName.getText();
					String department = textDepart.getText();
					String cellphone = textCell.getText();
					String emailAddress = textEmail.getText();
					manipulation.adminInsert(employeeNumber, id, password, name, department, cellphone, emailAddress);
					JOptionPane.showMessageDialog(null, "입력이 완료되었습니다.");
					dispose();
				//}
			}
		});
		contentPane.add(lblSubmit);
		
		//exit label
		JLabel exit_Action_label = new JLabel("Cancel");
		exit_Action_label.setBackground(new Color(255, 69, 0));
		exit_Action_label.setForeground(new Color(255, 255, 255));
		exit_Action_label.setOpaque(true);
		exit_Action_label.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(exit_Action_label);
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
				dispose();
			}
		});
		exit_Action_label.setBounds(510, 430, 70, 30);
		contentPane.add(exit_Action_label);
		
		/*********************************************************/
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(660, 520);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setVisible(true);
	}
	
//	public static void main(String[] args) {
//		new AdministerRegistration();
//	}
}
