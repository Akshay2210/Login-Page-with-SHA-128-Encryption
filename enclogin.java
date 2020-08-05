import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import java.io.*;

import com.mysql.cj.protocol.Resultset;

public class enclogin extends JFrame implements ActionListener {
	JButton b1=new JButton("Login");
	JTextField t1=new JTextField();
	JPasswordField t2 = new JPasswordField();

	JLabel l1=new JLabel("Name:");
	JLabel l2=new JLabel("Password:");
	Connection con;
	String jdbcurl;
	JFrame f=new JFrame();
	ResultSet rs;
	PreparedStatement ps;

	public enclogin() {
        setVisible(true);
        setSize(500,500);
        setLayout(new GridLayout(3,2));
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b1);
   
        b1.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 jdbcurl="jdbc:mysql://localhost:3306/emp2";
	 try {
		con =DriverManager.getConnection(jdbcurl,"your_username","your_password");
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
     String sql="select * from employee where name=? and password=sha1(?)";
     try {
		ps=con.prepareStatement(sql);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}  
     try {
		ps.setString(1,t1.getText());
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
     try {
		ps.setString(2,t2.getText());
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    try {
		rs=ps.executeQuery();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
     try {
		if(rs.next())
		 {
			
			JOptionPane.showMessageDialog(f,"Login Successful");
		 }
		 else
		 {
			 
			 JOptionPane.showMessageDialog(f,"Login Unsuccessful");
		 }
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	}
	public static void main(String x[])

	{
		new enclogin();
	}
}
