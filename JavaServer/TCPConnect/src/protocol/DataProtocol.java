package protocol;

import feature.ProtocolException;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import util.SocketUtil;

public class DataProtocol extends BasicProtocol implements Serializable {//����Э��

    public static final int PROTOCOL_TYPE = 0;

    private static final int PATTION_LEN = 1;
    private static final int DTYPE_LEN = 1;
    private static final int MSGID_LEN = 4;
    private static final int CLIENTID_LEN = 36;
    
    private int pattion;
    private int dtype;
    private int msgId;
    private String clientId; 
    
    private String data;

    @Override
    public int getLength() {
        return super.getLength() + PATTION_LEN + DTYPE_LEN + MSGID_LEN + CLIENTID_LEN + data.getBytes().length;
    }

    @Override
    public int getProtocolType() {
        return PROTOCOL_TYPE;
    }

    public int getPattion() {
        return pattion;
    }

    public void setPattion(int pattion) {
        this.pattion = pattion;
    }

    public int getDtype() {
        return dtype;
    }

    public void setDtype(int dtype) {
        this.dtype = dtype;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public int getMsgId() {
        return msgId;
    }
    
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
    
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    

    /**
     * ƴ�ӷ�������
     *
     * @return
     */
    @Override
    public byte[] genContentData() {
        byte[] base = super.genContentData();
        byte[] pattion = {(byte) this.pattion};
        byte[] dtype = {(byte) this.dtype};
        byte[] msgid = SocketUtil.int2ByteArrays(this.msgId);
        byte[] clientid = this.clientId.getBytes();
        byte[] data = this.data.getBytes();

        ByteArrayOutputStream baos = new ByteArrayOutputStream(getLength());
        baos.write(base, 0, base.length);          //���ݳ���+Э��汾����������
        baos.write(pattion, 0, PATTION_LEN);       //ҵ������
        baos.write(dtype, 0, DTYPE_LEN);           //ҵ�����ݸ�ʽ
        baos.write(msgid, 0, MSGID_LEN);           //��Ϣid
        baos.write(clientid, 0, CLIENTID_LEN);     //�ͻ���id
        baos.write(data, 0, data.length);          //ҵ������
        return baos.toByteArray();
    }

    /**
     * �����������ݣ���˳�����
     *
     * @param data
     * @return
     * @throws ProtocolException
     */
    @Override
    public int parseContentData(byte[] data) throws ProtocolException {
        int pos = super.parseContentData(data);

        //����pattion
        pattion = data[pos] & 0xFF;
        pos += PATTION_LEN;

        //����dtype
        dtype = data[pos] & 0xFF;
        pos += DTYPE_LEN;

        //����msgId
        msgId = SocketUtil.byteArrayToInt(data, pos, MSGID_LEN);
        pos += MSGID_LEN;
        
        //����clientId
        clientId = SocketUtil.byteArray2String(data, pos, CLIENTID_LEN);
        pos += CLIENTID_LEN;
        
        //����data
        try {
            this.data = new String(data, pos, data.length - pos, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return pos;
    }

	@Override
	public String toString() {
		return "DataProtocol [pattion=" + pattion + ", dtype=" + dtype
				+ ", msgId=" + msgId + ", clientId=" + clientId + ", data="
				+ data + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + dtype;
		result = prime * result + msgId;
		result = prime * result + pattion;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataProtocol other = (DataProtocol) obj;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (dtype != other.dtype)
			return false;
		if (msgId != other.msgId)
			return false;
		if (pattion != other.pattion)
			return false;
		return true;
	}

   

}
