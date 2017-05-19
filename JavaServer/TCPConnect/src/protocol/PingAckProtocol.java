package protocol;


import feature.ProtocolException;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

import util.SocketUtil;

public class PingAckProtocol extends BasicProtocol {

    public static final int PROTOCOL_TYPE = 3;

    private static final int ACKPINGID_LEN = 4;

    private int ackPingId;

    private String unused;

    @Override
    public int getProtocolType() {
        return PROTOCOL_TYPE;
    }

    @Override
    public int getLength() {
        return super.getLength() + ACKPINGID_LEN + unused.getBytes().length;
    }

    public int getAckPingId() {
        return ackPingId;
    }

    public void setAckPingId(int ackPingId) {
        this.ackPingId = ackPingId;
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
        byte[] ackPingId = SocketUtil.int2ByteArrays(this.ackPingId);
        byte[] unused = this.unused.getBytes();

        ByteArrayOutputStream baos = new ByteArrayOutputStream(getLength());
        baos.write(base, 0, base.length);                //Э��汾���������ͣ����ݳ��ȣ���Ϣid
        baos.write(ackPingId, 0, ACKPINGID_LEN);         //��Ϣid
        baos.write(unused, 0, unused.length);            //unused
        return baos.toByteArray();
    }

    @Override
    public int parseContentData(byte[] data) throws ProtocolException {
        int pos = super.parseContentData(data);

        //����ackPingId
        ackPingId = SocketUtil.byteArrayToInt(data, pos, ACKPINGID_LEN);
        pos += ACKPINGID_LEN;

        //����unused
        try {
            unused = new String(data, pos, data.length - pos, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return pos;
    }
}
