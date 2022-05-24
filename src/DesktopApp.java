import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
class StudFrame implements ActionListener
{
    JFrame frame;
    JPanel panel;
    JLabel lblId,lblName;
    JTextField tfId,tfName;
    JButton btnAdd,btnCancel;
    public StudFrame() {
        frame=new JFrame("stud app");
        frame.setVisible(true);
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel=new JPanel();
        panel.setLayout(null);
        
        lblId=new JLabel("Student Id:");
        lblId.setBounds(40, 50, 100, 50);
        
        lblName=new JLabel("Student Name:");
        lblName.setBounds(40, 130, 100, 50);
        
        tfId=new JTextField(10);
        tfId.setBounds(200, 50, 100, 20);
        
        tfName=new JTextField(10);
        tfName.setBounds(200, 130, 100, 20);
        
        btnAdd=new JButton("save");
        btnAdd.setBounds(50, 200, 100, 20);
        
        btnCancel=new JButton("cancel");
        btnCancel.setBounds(200, 200, 100, 20);
        
        btnAdd.addActionListener(this);
        btnCancel.addActionListener(this);
        
        panel.add(lblId);
        panel.add(lblName);
        panel.add(tfId);
        panel.add(tfName);
        panel.add(btnAdd);
        panel.add(btnCancel);
        
        frame.add(panel);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnAdd)
        {
            int id=Integer.parseInt(tfId.getText());
            String name=tfName.getText();
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StudFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        //Step-2: connection to database
          final String DB_URL="jdbc:mysql://localhost:3306/abu";
          final String DB_USER="root";
          final String DB_PASS="";
          
          
        Connection con=null;
            try {
                con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
                PreparedStatement stmt;
         
                stmt = con.prepareStatement("insert into student(stuid,name)values(?,?)");
                stmt.setInt(1,id);
        stmt.setString(2,name);
        int result=stmt.executeUpdate();
        if(result>0)
        {
            System.out.println("data inserted successfully");
            JOptionPane.showMessageDialog(null,"data saved");
        }
        else
        {
            System.err.println("data insertion error");
        }
            } catch (SQLException ex) {
                System.err.println("exception is"+ex);
            }
        
                
        //Step-3: create preparestatement to execute SQL query
        
        
        }
        if(e.getSource()==btnCancel)
        {
            tfId.setText("");
            tfName.setText("");
        }
    }
    
}
public class DesktopApp {

    public static void main(String[] args) {
        StudFrame obj=new StudFrame();
        
    }
    
}
