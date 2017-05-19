package feature;

import protocol.DataProtocol;

/**
 * Created by Yang on 16/11/17.
 */
public interface ResponseCallback {//œÏ”¶ªÿ÷¥

    void targetIsOffline(DataProtocol reciveMsg);

    void targetIsOnline(String clientIp);
}
