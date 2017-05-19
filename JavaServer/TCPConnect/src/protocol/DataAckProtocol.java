package protocol;


import feature.ProtocolException;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

import util.SocketUtil;

/**
 * Created by Yang on 16/11/16.
 */
public class DataAckProtocol extends BasicProtocol {

    public static final int PROTOCOL_TYPE = 1;

    private static final int ACKMSGID_LEN = 4;

    private int ackMsgId;

    private String unused;

    @Override
    public int getLength() {
        return super.getLength() + ACKMSGID_LEN + unused.getBytes().length;
    }

    @Override
    public int getProtocolType() {
        return PROTOCOL_TYPE;
    }

    public int getAckMsgId() {
        return ackMsgId;
    }

    public void setAckMsgId(int ackMsgId) {
        this.ackMsgId = ackMsgId;
    }

    public String getUnused() {
        return unused;
    }

    public void setUnused(String unused) {
        this.unused = unused;
    }

    /**
     * ƴ�ӷ�������
     *
     * @return
     */
    @Override
    public byte[] genContentData() {
        byte[] base = super.genContentData();
        byte[] ackMsgId = SocketUtil.int2ByteArrays(this.ackMsgId);
        byte[] unused = this.unused.getBytes();

        ByteArrayOutputStream baos = new ByteArrayOutputStream(getLength());
        baos.write(base, 0, base.length);              //Э��汾���������ͣ����ݳ��ȣ���Ϣid
        baos.write(ackMsgId, 0, ACKMSGID_LEN);         //��Ϣid
        baos.write(unused, 0, unused.length);          //unused
        return baos.toByteArray();
    }

    @Override
    public int parseContentData(byte[] data) throws ProtocolException {
        int pos = super.parseContentData(data);

        //����ackMsgId
        ackMsgId = SocketUtil.byteArrayToInt(data, pos, ACKMSGID_LEN);
        pos += ACKMSGID_LEN;

        //����unused
        try {
            unused = new String(data, pos, data.length - pos, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return pos;
    }
}
