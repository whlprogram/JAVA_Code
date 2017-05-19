package util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeUtil {   
  
    /** 
     * ���л�  
     *  
     * @param object 
     * @return 
     * @throws IOException 
     */  
    public static byte[] serialize(Object object){  
        ObjectOutputStream oos = null;  
        ByteArrayOutputStream baos = null;  
        try {  
            // ���л�   
            baos = new ByteArrayOutputStream();  
            oos = new ObjectOutputStream(baos);  
            oos.writeObject(object);  
            byte[] bytes = baos.toByteArray();  
            return bytes;  
        } catch (Exception e) {  
            System.out.println("���л����������󣬷���NULL");  
            return null;  
        }  
    }  
  
    /** 
     * �����л� 
     *  
     * @param bytes 
     * @return 
     */  
    public static Object unserialize(byte[] bytes) {  
        ByteArrayInputStream bais = null;  
        try {  
            // �����л�  
            bais = new ByteArrayInputStream(bytes);  
            ObjectInputStream ois = new ObjectInputStream(bais);  
            return ois.readObject();  
        } catch (Exception e) {  
            System.out.println("�����л����������󣬷���NULL");  
            return null;  
        }  
    }  
}  
