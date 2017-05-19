package util;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

import protocol.BasicProtocol;
import protocol.DataAckProtocol;
import protocol.DataProtocol;
import protocol.PingAckProtocol;
import protocol.PingProtocol;

/**
 * java.net.SocketException: Connection reset
 * ����ԭ��
 * 1���ͻ��˺ͷ����������һ�˵�Socket���رգ���һ���Է������ݣ����͵ĵ�һ�����ݰ��������쳣��
 * 2���ͻ��˺ͷ�������һ���˳������˳�ʱ��δ�رո����ӣ���һ������ڴ������ж��������׳����쳣
 * ��˵�����������ӶϿ���Ķ�д��������ģ�����û�йر����������
 * 
 */
public class SocketUtil {

    private static Map<Integer, String> msgImp = new HashMap<>();

    static {
        msgImp.put(DataProtocol.PROTOCOL_TYPE, "DataProtocol");       //0
        msgImp.put(DataAckProtocol.PROTOCOL_TYPE, "DataAckProtocol"); //1
        msgImp.put(PingProtocol.PROTOCOL_TYPE, "PingProtocol");       //2
        msgImp.put(PingAckProtocol.PROTOCOL_TYPE, "PingAckProtocol"); //3
    }

    /**
     * ������������
     *
     * @param data
     * @return
     */
    public static BasicProtocol parseContentMsg(byte[] data) {
        int protocolType = BasicProtocol.parseType(data);
        String className = msgImp.get(protocolType);
        BasicProtocol basicProtocol;
        try {
        	className="protocol."+className;
        	Class clazz = Class.forName(className);
            basicProtocol = (BasicProtocol) clazz.newInstance();
            basicProtocol.parseContentData(data);
        } catch (Exception e) {
            basicProtocol = null;
            e.printStackTrace();
        }
        return basicProtocol;
    }
    
    /**
     * ������
     *
     * @param inputStream
     * @return
     * @throws SocketExceptions
     */
    public static BasicProtocol readFromStream(InputStream inputStream) {
        BasicProtocol protocol;
        BufferedInputStream bis;
        byte[] header = new byte[BasicProtocol.LENGTH_LEN];//header�б�������������ݵĳ���ֵ��4���ֽڱ�ʾ

        try {
            bis = new BufferedInputStream(inputStream);

            int temp;
            int len = 0;
            while (len < header.length) {
                temp = bis.read(header, len, header.length - len);
                if (temp > 0) {
                    len += temp;
                } else if (temp == -1) {
                    bis.close();
                    return null;
                }
            }

            int length = byteArrayToInt(header);//���ݵĳ���ֵ
            byte[] content = new byte[length];
            len = 0;
            while (len < length) {
                temp = bis.read(content, len, length - len);

                if (temp > 0) {
                    len += temp;
                }
            }
            protocol = parseContentMsg(content);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return protocol;
    }

    /**
     * д����
     *
     * @param protocol
     * @param outputStream
     */
    public static void write2Stream(BasicProtocol protocol, OutputStream outputStream) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        byte[] buffData = protocol.genContentData();
        byte[] header = int2ByteArrays(buffData.length);
        try {
            bufferedOutputStream.write(header);
            bufferedOutputStream.write(buffData);
            bufferedOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * �ر�������
     *
     * @param is
     */
    public static void closeInputStream(InputStream is) {
        try {
            if (is != null) {
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * �ر������
     *
     * @param os
     */
    public static void closeOutputStream(OutputStream os) {
        try {
            if (os != null) {
                os.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] int2ByteArrays(int i) {
        byte[] result = new byte[4];
        result[0] = (byte) ((i >> 24) & 0xFF);
        result[1] = (byte) ((i >> 16) & 0xFF);
        result[2] = (byte) ((i >> 8) & 0xFF);
        result[3] = (byte) (i & 0xFF);
        return result;
    }

    public static int byteArrayToInt(byte[] b) {
        int intValue = 0;
        for (int i = 0; i < b.length; i++) {
            intValue += (b[i] & 0xFF) << (8 * (3 - i));
        }
        return intValue;
    }

    public static int byteArrayToInt(byte[] b, int offset, int bytecount) {
        int intValue = 0;
        for (int i = offset; i < (offset + bytecount); i++) {
            intValue += (b[i] & 0xFF) << (8 * (3 - (i - offset)));
        }
        return intValue;
    }

    public static int bytes2Int(byte[] b, int offset) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(Integer.SIZE / Byte.SIZE);
        byteBuffer.put(b, offset, 4);
        byteBuffer.flip();
        return byteBuffer.getInt();
    }
    
    public static String byte2String(byte[]data){  
        String result="";  
        for (int i = 0; i < data.length; i++) {  
            result+=Integer.toHexString((data[i] & 0xFF) | 0x100).toUpperCase().substring(1, 3);  
        }  
        return result;  
    }

	public static String byteArray2String(byte[] data, int offset, int length) {
		byte[] bytes = new byte[length];
		for (int i = 0; i < length; i++) {
			bytes[i] = data[i+offset];
		}
		return new String(bytes);
	}  
	
}
