import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;


public class UserUI extends javax.swing.JFrame implements TableModelListener{

	String id,userMoney= "";
	String[] fields = {"品項","數量","價格"};
	HashMap shopItem = new HashMap<String,Integer>();
	private void getItem(){
		String shop = "";
		try{
			Properties prop = new Properties();
			prop.setProperty("user", "sa");
			prop.setProperty("password", "mj6361948");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://59.127.112.147:1433;" + "databaseName=launchorder",prop);
			PreparedStatement pps = con.prepareStatement("SELECT shopName FROM shop WHERE isEat = 1");
			ResultSet rs = pps.executeQuery();
			while(rs.next()){
				shop = rs.getString("shopName");
			}
			pps = con.prepareStatement("SELECT itemName,price FROM itemlist WHERE shopName = ?");
			pps.setString(1, shop);
			ResultSet rsItem = pps.executeQuery();
			while(rsItem.next()){
				String item = rsItem.getString("itemName");
				String strPrice = rsItem.getString("price");
				int price = Integer.parseInt(strPrice);
				shopItem.put(item,price);
			}
			Object[] cbItem = shopItem.keySet().toArray();
			
			cbDessert.setModel(new DefaultComboBoxModel(cbItem));
			cbDessert.setSelectedIndex(0);
		}
		catch(Exception ee){
			JOptionPane.showMessageDialog(rootPane, "取得店家品項連線SQL失敗");
		}
		
	}
	
	public LinkedList<String[]> orderData;
	private myTableModel tableModel;
	public UserUI(String userId) {
		initComponents();
		id = userId;
		getUserData();
		//setDessertItem();
		orderData = new LinkedList<>();
		tableModel = new myTableModel(fields);
		tbData.setModel(tableModel);
		getItem();
	}

	private void getUserData() {
		try {
			Properties prop = new Properties();
			prop.setProperty("user", "sa");
			prop.setProperty("password", "mj6361948");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://59.127.112.147:1433;" + "databaseName=launchorder",prop);
			PreparedStatement pps = con.prepareStatement("SELECT name,money FROM orderuser Where id =" + id);
			ResultSet rs = pps.executeQuery();
			while (rs.next()) {
				String userName = rs.getString("name");
				userMoney = rs.getString("money");
				
				lbName.setText("你好：" + userName);
				lbMoney.setText(userMoney);
			}
			PreparedStatement whatShop = con.prepareStatement("Select shopName from shop Where isEat = 1");
			ResultSet rsShopName = whatShop.executeQuery();
			while (rsShopName.next()) {
				lbShop.setText(rsShopName.getString("shopName"));
				break;
			}

		} catch (Exception ee) {
			JOptionPane.showMessageDialog(rootPane, "使用者資料SQL連線失敗");
		}
	}

	class myTableModel extends DefaultTableModel{
    	public myTableModel(String[] fields){
    		super(fields,0);
    	}
    	
    	 @Override
         public int getRowCount() {
            return orderData.size();
         }

         @Override
         public int getColumnCount() {
           return fields.length;
         }
         
         @Override
         public void fireTableCellUpdated(int row, int column) {
         	
         	super.fireTableCellUpdated(row, column);
         	System.out.println("fireTableCell");
         }
         
         @Override
         public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
         	
         	//super.setValueAt(aValue, rowIndex, columnIndex);
         	System.out.println(rowIndex + "x" + columnIndex + "x" + aValue);
         }

         @Override
         public Object getValueAt(int rowIndex, int columnIndex) {
             return orderData.get(rowIndex)[columnIndex];
         }
         
          @Override
         public boolean isCellEditable(int row, int col){
            return false;
             
         }
    }
	
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbShop = new javax.swing.JLabel();
        cbDessert = new javax.swing.JComboBox<>();
        spCount = new javax.swing.JSpinner();
        btnOK = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnQuery1 = new javax.swing.JButton();
        btnQuery2 = new javax.swing.JButton();
        btnQuery3 = new javax.swing.JButton();
        btnQuery4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbMoney = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbPrice = new javax.swing.JLabel();
        btnOrder = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbData = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("新細明體", 0, 24)); // NOI18N
        jLabel2.setText("今日店家：");

        lbShop.setFont(new java.awt.Font("新細明體", 1, 24)); // NOI18N
        lbShop.setText("jLabel1");

        cbDessert.setFont(new java.awt.Font("新細明體", 1, 14)); // NOI18N
        cbDessert.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDessert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDessertActionPerformed(evt);
            }
        });

        spCount.setFont(new java.awt.Font("新細明體", 0, 18)); // NOI18N
        
        spCount.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spCountStateChanged(evt);
            }
        });
        
        btnOK.setFont(new java.awt.Font("新細明體", 1, 48)); // NOI18N
        btnOK.setText("點餐");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("新細明體", 0, 24)); // NOI18N
        jLabel3.setText("查詢：");

        btnQuery1.setFont(new java.awt.Font("新細明體", 0, 18)); // NOI18N
        btnQuery1.setText("沒吃過");
        btnQuery1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuery1ActionPerformed(evt);
            }
        });

        btnQuery2.setFont(new java.awt.Font("新細明體", 0, 18)); // NOI18N
        btnQuery2.setText("最熱銷");
        btnQuery2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuery2ActionPerformed(evt);
            }
        });

        btnQuery3.setFont(new java.awt.Font("新細明體", 0, 18)); // NOI18N
        btnQuery3.setText("最便宜");
        btnQuery3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuery3ActionPerformed(evt);
            }
        });

        btnQuery4.setFont(new java.awt.Font("新細明體", 0, 18)); // NOI18N
        btnQuery4.setText("最昂貴");
        btnQuery4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuery4ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("新細明體", 0, 24)); // NOI18N
        jLabel4.setText("餘額：");

        lbMoney.setFont(new java.awt.Font("新細明體", 1, 24)); // NOI18N
        lbMoney.setText("jLabel5");

        lbName.setFont(new java.awt.Font("新細明體", 0, 18)); // NOI18N
        lbName.setText("你好：");

        jLabel1.setFont(new java.awt.Font("新細明體", 0, 24)); // NOI18N
        jLabel1.setText("價格：");

        lbPrice.setFont(new java.awt.Font("新細明體", 1, 18)); // NOI18N
        lbPrice.setText("jLabel5");

        btnOrder.setFont(new java.awt.Font("新細明體", 0, 18)); // NOI18N
        btnOrder.setText("加入清單");
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuery1)
                        .addGap(18, 18, 18)
                        .addComponent(btnQuery2)
                        .addGap(18, 18, 18)
                        .addComponent(btnQuery3)
                        .addGap(18, 18, 18)
                        .addComponent(btnQuery4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbName)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbShop, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbMoney))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbDessert, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbPrice)
                                .addGap(53, 53, 53)
                                .addComponent(spCount, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnOrder)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbName)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lbShop)
                            .addComponent(jLabel4)
                            .addComponent(lbMoney))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbDessert, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(lbPrice)
                            .addComponent(btnOrder)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnQuery1)
                    .addComponent(btnQuery2)
                    .addComponent(btnQuery3)
                    .addComponent(btnQuery4))
                .addContainerGap())
        );

        tbData.setFont(new java.awt.Font("新細明體", 0, 18)); // NOI18N
        tbData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        
        tbData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDataMouseClicked(evt);
            }
        });
        
        jScrollPane1.setViewportView(tbData);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
	}// </editor-fold>

	private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {
		int cusmerCount =0;
		String userName = lbName.getText().substring(3, lbName.getText().length());
		for(int i=0; i<tbData.getRowCount(); i++){
			String tb = (String) tbData.getValueAt(i,2);
			cusmerCount += Integer.parseInt(tb);	
		}
		String strUserMoney = lbMoney.getText();
		int userMoney = Integer.parseInt(strUserMoney) - cusmerCount;
		if(userMoney >=0){
			lbMoney.setText(Integer.toString(userMoney));
			try{
				Properties prop = new Properties();
				prop.setProperty("user", "sa");
				prop.setProperty("password", "mj6361948");
				Connection con = DriverManager.getConnection("jdbc:sqlserver://59.127.112.147:1433;" + "databaseName=launchorder",prop);
				PreparedStatement updateMoney = con.prepareStatement("Update orderuser Set money=? Where id =?");
				updateMoney.setString(1,lbMoney.getText());
				updateMoney.setString(2,id);
				updateMoney.execute();
				for(int i=0; i<orderData.size(); i++){
					String[] dataRow = new String[3];
					dataRow=orderData.get(i).clone();
					PreparedStatement outputOrder = con.prepareStatement("INSERT INTO orderlist(name,item,count,price) VALUES(?,?,?,?)");
					outputOrder.setString(1, userName);
					outputOrder.setString(2, dataRow[0]);
					outputOrder.setString(3, dataRow[1]);
					outputOrder.setString(4, dataRow[2]);
					outputOrder.execute();
				}
				JOptionPane.showMessageDialog(jPanel1, "點餐完成!");
			}
			catch(Exception ee){
				JOptionPane.showMessageDialog(rootPane, "Insert訂單資料失敗");
			}
		}
		else{
			JOptionPane.showMessageDialog(jPanel1, "餘額不足!，請儲值!");
		}
	}

	private void btnQuery1ActionPerformed(java.awt.event.ActionEvent evt) {
		try{
			Properties prop = new Properties();
			prop.setProperty("user", "sa");
			prop.setProperty("password", "mj6361948");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://59.127.112.147:1433;" + "databaseName=launchorder",prop);
			PreparedStatement pps = con.prepareStatement("SELECT item,SUM(count) AS orderCount FROM orderlist GROUP BY item ORDER BY orderCount DESC");
			ResultSet rs = pps.executeQuery();
			LinkedList dbOrderItems = new LinkedList<String>();
			while(rs.next()){
				String item = rs.getString("item");
				dbOrderItems.add(item);
			}
			
			Object[] arrayItem = shopItem.keySet().toArray();
			LinkedList notOrderItem = new LinkedList<String>();
			for(int i=0; i<arrayItem.length; i++){
				notOrderItem.add(arrayItem[i]);
			}
			
			for(int j=0; j<notOrderItem.size(); j++){
				String removeItem = (String) notOrderItem.get(j);
				for(int k=0; k<dbOrderItems.size(); k++){
					if(removeItem.equals(dbOrderItems.get(k).toString())){
						notOrderItem.remove(j);
					}
				}
			}
			
			int itemIndex = (int)(Math.random()*notOrderItem.size());
			JOptionPane.showMessageDialog(jPanel1, "要不要試試看： " + notOrderItem.get(itemIndex) +" ?");
		}
		catch(Exception ee){
			JOptionPane.showMessageDialog(rootPane, "取得訂單資料失敗");
		}
	}

	private void btnQuery2ActionPerformed(java.awt.event.ActionEvent evt) {
		try{
			Properties prop = new Properties();
			prop.setProperty("user", "sa");
			prop.setProperty("password", "mj6361948");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://59.127.112.147:1433;" + "databaseName=launchorder",prop);
			PreparedStatement pps = con.prepareStatement("SELECT item,SUM(count) AS orderCount FROM orderlist GROUP BY item ORDER BY orderCount DESC");
			ResultSet rs = pps.executeQuery();
			int getItemCount = 0;
			while(rs.next()){
				String item = rs.getString("item");
				String count = rs.getString("orderCount");
				getItemCount++;
				if(getItemCount ==1){
					JOptionPane.showMessageDialog(jPanel1, "本日最熱銷的餐點：" + item +",共賣出" + count + "分。");
					break;
				}
			}
			
		}
		catch(Exception ee){
			JOptionPane.showMessageDialog(rootPane, "取得訂單資料失敗");
		}
	}

	private void btnQuery3ActionPerformed(java.awt.event.ActionEvent evt) {
		
		Object[] item = shopItem.keySet().toArray();
		Object[] price = shopItem.values().toArray();
		int comparePrice = (int)price[0];
		int itemNum = 0;
		for(int i=1; i<item.length; i++){
			if(comparePrice >= (int)price[i]){
				comparePrice = (int)price[i];
				itemNum = i;
			}
		}
		JOptionPane.showMessageDialog(jPanel1,item[itemNum] + ":" +price[itemNum] + "元");
	}

	private void btnQuery4ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		Object[] item = shopItem.keySet().toArray();
		Object[] price = shopItem.values().toArray();
		int comparePrice = (int)price[0];
		int itemNum = 0;
		for(int i=1; i<item.length; i++){
			if(comparePrice <= (int)price[i]){
				comparePrice = (int)price[i];
				itemNum = i;
			}
		}
		JOptionPane.showMessageDialog(jPanel1,item[itemNum] + ":" +price[itemNum] + "元");
		
	}
	
    private void cbDessertActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
    	btnOrder.setText("加入清單");
    	String item = (String)cbDessert.getSelectedItem();
    	Object price = shopItem.get(item);
    	lbPrice.setText(price.toString());
    }       
    
    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {
    	if(btnOrder.getText().equals("加入清單")){
    		Integer orderCount = (Integer)spCount.getValue();
        	int count = orderCount;
        	int orderPrice = Integer.parseInt(lbPrice.getText())*orderCount;
        	String[] row = new String[3];
        	row[0] = cbDessert.getSelectedItem().toString();
        	row[1] = Integer.toString(count);
        	row[2] = Integer.toString(orderPrice);
        	orderData.add(row);
        	tableModel.fireTableDataChanged();
    	}
    	else if (btnOrder.getText().equals("刪除")){
    		orderData.remove(tbData.getSelectedRow());
    		tableModel.fireTableDataChanged();
    	}
    	
     
    }    
	
    private void tbDataMouseClicked(java.awt.event.MouseEvent evt) {                                    
        
    	btnOrder.setText("刪除");
    } 
    
    private void spCountStateChanged(javax.swing.event.ChangeEvent evt) {                                     
       
    	btnOrder.setText("加入清單");
    }  
    
	public static void main(String args[]) {
	}

	private javax.swing.JButton btnOK;
	private javax.swing.JButton btnOrder;
	private javax.swing.JButton btnQuery1;
	private javax.swing.JButton btnQuery2;
	private javax.swing.JButton btnQuery3;
	private javax.swing.JButton btnQuery4;
	private javax.swing.JComboBox<String> cbDessert;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel lbMoney;
	private javax.swing.JLabel lbName;
	private javax.swing.JLabel lbPrice;
	private javax.swing.JLabel lbShop;
	private javax.swing.JSpinner spCount;
	private javax.swing.JTable tbData;
	// End of variables declaration
	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}

