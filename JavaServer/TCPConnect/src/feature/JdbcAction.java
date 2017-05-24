package feature;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
  
import protocol.DataProtocol;  
  
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
                    "jdbc:mysql://localhost:3306/test", "root", "root");// ������������    
                
        } catch (Exception e) {    
            System.out.println("���ݿ�����ʧ��" + e.getMessage());    
        }    
        return con; //���������������ݿ�����    
    }    
      
    public static void insert(DataSplit v){  
        conn = getConnection(); // ����Ҫ��ȡ���ӣ������ӵ����ݿ�    
        try {    
            String sql = "INSERT INTO data(Id, EnvHumidity, EnvTemperature"
            		+ ", LightVal1, LightVal2, LightVal3, WaterLevel, Electricity, SoilHumidity)"    
                    + " VALUES ('1','"+v.getEnvHumidity()+"','"+v.getEnvTemperature() +"','"+v.getLightVal1() 
                    +"','"+v.getLightVal2() +"','"+v.getLightVal3() +"','"+v.getWaterLevel()
                    +"','"+v.getElectricity() +"','"+v.getSoilHumidity() +"')";  // �������ݵ�sql���    
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
        
    public static String backQuery(int guid) {    
        conn = getConnection(); //ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�   
        String m2 = "";
        try {    
            String sql = "select * from users where Id="+guid;     // ��ѯ���ݵ�sql���    
            st = (Statement) conn.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����    
                
            ResultSet rs = st.executeQuery(sql);    //ִ��sql��ѯ��䣬���ز�ѯ���ݵĽ����    
            if(rs.next()) { // �ж��Ƿ�����һ������    
            	m2 = rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5)+","
            				+ rs.getString(6)+","+rs.getString(7)+","+ rs.getString(8)+","+rs.getString(9)+",#";  
            }  
            conn.close();   //�ر����ݿ�����    
                
        } catch (SQLException e) {    
            System.out.println("��ѯ����ʧ��");    
        }  
        return m2;    
    }
    
    /* ���·���Ҫ��ļ�¼�������ظ��µļ�¼��Ŀ*/    
    public static void update(DataSplit v) {    
        conn = getConnection(); //ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�    
        try {    
            String sql = "update data set EnvHumidity=" + v.getEnvHumidity() +",EnvTemperature=" + v.getEnvTemperature()
            		+ ", LightVal1=" + v.getLightVal1() +", LightVal2=" + v.getLightVal2() +", LightVal3=" + v.getLightVal3() 
            		+ ", WaterLevel=" + v.getWaterLevel() +", Electricity=" + v.getElectricity() 
            		+", SoilHumidity=" + v.getSoilHumidity() +" where Id='1' ";// �������ݵ�sql���    
                
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