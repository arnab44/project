package logger;

import logger.messages.Message;
import logger.sink.Configurable;


public interface Config {
    public void handleMessage(Message msg);
    public void subscribe(Configurable cfg);
    public  void unSubscribe(Configurable cfg);
}
