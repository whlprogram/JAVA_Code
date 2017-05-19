package util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeUtil {   
  
    /** 
     * 序列化  
     *  
     * @param object 
     * @return 
     * @throws IOException 
     */  
    public static byte[] serialize(Object object){  
        ObjectOutputStream oos = null;  
        ByteArrayOutputStream baos = null;  
        try {  
            // 序列化   
            baos = new ByteArrayOutputStream();  
            oos = new ObjectOutputStream(baos);  
            oos.writeObject(object);  
            byte[] bytes = baos.toByteArray();  
            return bytes;  
        } catch (Exception e) {  
            System.out.println("序列化对象发生错误，返回NULL");  
            return null;  
        }  
    }  
  
    /** 
     * 反序列化 
     *  
     * @param bytes 
     * @return 
     */  
    public static Object unserialize(byte[] bytes) {  
        ByteArrayInputStream bais = null;  
        try {  
            // 反序列化  
            bais = new ByteArrayInputStream(bytes);  
            ObjectInputStream ois = new ObjectInputStream(bais);  
            return ois.readObject();  
        } catch (Exception e) {  
            System.out.println("反序列化对象发生错误，返回NULL");  
            return null;  
        }  
    }  
}  
