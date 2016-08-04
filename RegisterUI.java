import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RegisterUI extends javax.swing.JFrame {

	public RegisterUI() {
		initComponents();
		getIdentifyWords();
		clearInputData();
	}
	
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		txtName = new javax.swing.JTextField();
		txtID = new javax.swing.JTextField();
		txtPassword = new javax.swing.JTextField();
		txtIdentify = new javax.swing.JTextField();
		lbIdentify = new javax.swing.JLabel();
		checkRobot = new javax.swing.JCheckBox();
		btnRegister = new javax.swing.JButton();
		btnCancel = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("資策會訂餐系統-使用者註冊");
		setResizable(false);

		jLabel1.setFont(new java.awt.Font("新細明體", 1, 36)); // NOI18N
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("資策會訂餐系統-使用者註冊");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE));

		jLabel2.setFont(new java.awt.Font("新細明體", 1, 18)); // NOI18N
		jLabel2.setText("姓名：");

		jLabel3.setFont(new java.awt.Font("新細明體", 1, 18)); // NOI18N
		jLabel3.setText("帳號：");

		jLabel4.setFont(new java.awt.Font("新細明體", 1, 18)); // NOI18N
		jLabel4.setText("密碼：");

		jLabel5.setFont(new java.awt.Font("新細明體", 1, 18)); // NOI18N
		jLabel5.setText("驗證碼：");

		txtName.setFont(new java.awt.Font("新細明體", 0, 18)); // NOI18N

		txtID.setFont(new java.awt.Font("新細明體", 0, 18)); // NOI18N

		txtPassword.setFont(new java.awt.Font("新細明體", 0, 18)); // NOI18N

		txtIdentify.setFont(new java.awt.Font("新細明體", 0, 18)); // NOI18N

		lbIdentify.setFont(new java.awt.Font("新細明體", 3, 24)); // NOI18N

		checkRobot.setFont(new java.awt.Font("新細明體", 1, 24)); // NOI18N
		checkRobot.setText("我不是機器人");

		btnRegister.setFont(new java.awt.Font("新細明體", 1, 24)); // NOI18N
		btnRegister.setText("註冊");
		btnRegister.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnRegisterActionPerformed(evt);
			}
		});

		btnCancel.setFont(new java.awt.Font("新細明體", 1, 24)); // NOI18N
		btnCancel.setText("返回");
		btnCancel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCancelActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout
						.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel2Layout
										.createSequentialGroup().addContainerGap()
										.addGroup(jPanel2Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel3).addComponent(jLabel4).addComponent(jLabel5))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(txtName).addComponent(txtID)
														.addComponent(txtPassword).addComponent(txtIdentify,
																javax.swing.GroupLayout.DEFAULT_SIZE, 226,
																Short.MAX_VALUE))
										.addGap(18, 18, 18)
										.addGroup(jPanel2Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lbIdentify, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(checkRobot, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addGroup(jPanel2Layout.createSequentialGroup().addGap(124, 124, 124)
										.addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 134,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(42, 42, 42)
										.addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE)))
						.addContainerGap()));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addGroup(jPanel2Layout.createSequentialGroup()
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel3).addComponent(txtID,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(jPanel2Layout.createSequentialGroup()
								.addComponent(lbIdentify, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(4, 4, 4)))
						.addGroup(
								jPanel2Layout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(
												jPanel2Layout.createSequentialGroup()
														.addGroup(jPanel2Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(jLabel4).addComponent(txtPassword,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGap(18, 18, 18)
														.addGroup(jPanel2Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(jLabel5).addComponent(txtIdentify,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addComponent(checkRobot, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
												javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(btnRegister, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
								.addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));

		pack();
	}

	private void connectSQL() {
		String name = txtName.getText();
		String id = txtID.getText();
		String pass = txtPassword.getText();

		try {
			Properties prop = new Properties();
			prop.setProperty("user", "sa");
			prop.setProperty("password", "mj6361948");
			Connection con = DriverManager
					.getConnection("jdbc:sqlserver://59.127.112.147:1433;" + "databaseName=launchorder", prop);
			PreparedStatement pps = con.prepareStatement("INSERT INTO orderuser(name,id,password) VALUES(?,?,?)");
			pps.setString(1, name);
			pps.setString(2, id);
			pps.setString(3, pass);
			pps.executeUpdate();
			JOptionPane.showMessageDialog(rootPane, "新增資料成功");
		} catch (SQLException ee) {
			JOptionPane.showMessageDialog(rootPane, "SQL連線失敗");
		}
	}

	private void getIdentifyWords() {
		char[] identifyWords = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
				'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		String identify = "";
		for (int i = 0; i < 4; i++) {
			int getWord = (int) (Math.random() * identifyWords.length + 1);
			identify += identifyWords[getWord];
		}
		lbIdentify.setText(identify);
	}
	
	private boolean checkIdWords(){
		String[] words = {"0","1","2","3","4","5","6","7","8","9"};
		boolean isCorrectFormat = false;
		String id = txtID.getText();
		if(id.length() != 4){
			JOptionPane.showMessageDialog(rootPane, "ID長度須為4位數字");
			return isCorrectFormat;
		}
		else {
			for(int i=0; i < id.length();i++){
				String idWord = id.substring(i,i+1);
				for(int j=0; j<words.length; j++){
					if(idWord.equals(words[j])){
						break;
					}
					if(j== words.length-1){
						JOptionPane.showMessageDialog(rootPane, "ID格式不符");
						return isCorrectFormat;
					}
				}
			}
			isCorrectFormat = true;
			return isCorrectFormat;
		}
		
	}
	private boolean checkIdentify() {
		boolean checkOK = false;
		boolean isNotRobot = checkRobot.isSelected();

		if (txtIdentify.getText().equals(lbIdentify.getText()) && isNotRobot == true) {
			checkOK = true;
		}
		return checkOK;
	}

	public void clearInputData() {
		txtName.setText("");
		txtID.setText("");
		txtPassword.setText("");
		txtIdentify.setText("");
	}

	private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {
		if(checkIdWords() == true){
			if (checkIdentify() == true) {
				connectSQL();
				clearInputData();
				getIdentifyWords();
			} else {
				JOptionPane.showMessageDialog(rootPane, "請勾選非機器人或輸入正確驗證碼");
				getIdentifyWords();
			}
		}
		
	}

	private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
		clearInputData();
		getIdentifyWords();
		Login.userLogin.setVisible(true);
		Login.userLogin.closeRegisterUI();
	}

	private javax.swing.JButton btnCancel;
	private javax.swing.JButton btnRegister;
	private javax.swing.JCheckBox checkRobot;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JLabel lbIdentify;
	private javax.swing.JTextField txtID;
	private javax.swing.JTextField txtIdentify;
	private javax.swing.JTextField txtName;
	private javax.swing.JTextField txtPassword;
}
