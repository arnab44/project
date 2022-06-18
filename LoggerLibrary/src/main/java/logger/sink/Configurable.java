package logger.sink;

import logger.messages.Message;

public interface Configurable {
    public void handleMessage(Message msg);
}
