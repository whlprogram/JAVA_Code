
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
  
  
  
public class JdbcAction {  
     // ������̬ȫ�ֱ���    
    static Connection conn;    
    
    static Statement st;    
    /* ��ȡ���ݿ����ӵĺ���*/    
    public static Connection getConnection() {    
        Connection con = null;  //���������������ݿ��Connection����    
        try {    
            Class.forName("com.mysql.jdbc.Driver");// ����Mysql��������    
                
            con = DriverManager.getConnection(    
                    "jdbc:mysql://localhost:3306/user", "root", "root");// ������������    
                
        } catch (Exception e) {    
            System.out.println("���ݿ�����ʧ��" + e.getMessage());    
        }    
        return con; //���������������ݿ�����    
    }    
      
    public static void insert(userInformation v){  
        conn = getConnection(); // ����Ҫ��ȡ���ӣ������ӵ����ݿ�    
        try {    
            String sql = "INSERT INTO users(Id, name, password)"    
                    + " VALUES ('"+v.getId()+"','"+v.getname()+"','"+v.getpassword() +"')";  // �������ݵ�sql���    
            System.out.println("sql="+sql);  
            st = (Statement) conn.createStatement();    // ��������ִ�о�̬sql����Statement����    
                
            int count = st.executeUpdate(sql);  // ִ�в��������sql��䣬�����ز������ݵĸ���    
                
            System.out.println("��users���в��� " + count + " ������"); //�����������Ĵ������    
                
            conn.close();   //�ر����ݿ�����    
                
        } catch (SQLException e) {    
            System.out.println("��������ʧ��" + e.getMessage());    
        }    
    }  
      
    public static boolean query(String guid) {    
        conn = getConnection(); //ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�    
        try {    
            String sql = "select * from users where Id="+guid;     // ��ѯ���ݵ�sql���    
            st = (Statement) conn.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����    
                
            ResultSet rs = st.executeQuery(sql);    //ִ��sql��ѯ��䣬���ز�ѯ���ݵĽ����    
            while (rs.next()) { // �ж��Ƿ�����һ������    
                return true ;  
            }  
            conn.close();   //�ر����ݿ�����    
                
        } catch (SQLException e) {    
            System.out.println("��ѯ����ʧ��");    
        }  
        return false;    
    }    
        
      
    /* ���·���Ҫ��ļ�¼�������ظ��µļ�¼��Ŀ*/    
    public static void update(userInformation v) {    
        conn = getConnection(); //ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�    
        try {    
            String sql = "update user set name='wang' where Id="+v.getId();// �������ݵ�sql���    
                
            st = (Statement) conn.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����    
                
            int count = st.executeUpdate(sql);// ִ�и��²�����sql��䣬���ظ������ݵĸ���    
                
            System.out.println("users���и��� " + count + " ������");      //������²����Ĵ������    
                
            conn.close();   //�ر����ݿ�����    
                
        } catch (SQLException e) {    
            System.out.println("��������ʧ��");    
        }    
    }
    public static void main(String[] args) {
    	
    	
    }
}  