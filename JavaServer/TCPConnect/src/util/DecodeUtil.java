package util;

import java.math.BigInteger;

public class DecodeUtil {
	/** 
     * ��byte[]תΪ���ֽ��Ƶ��ַ��� 
     * @param bytes byte[] 
     * @param radix ��������ת�����Ƶķ�Χ����Character.MIN_RADIX��Character.MAX_RADIX��������Χ���Ϊ10���� 
     * @return ת������ַ��� 
     */  
    public static String binary(byte[] bytes, int radix){  
        return new BigInteger(1, bytes).toString(radix);// �����1��������
    }  
}
