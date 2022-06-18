package logger.sink;

import logger.messages.Message;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DatabaseSink implements Configurable {

    private final String name;


    @Override
    public void handleMessage(Message msg) {
        System.out.println("Handling message at database sink: " + name);
        System.out.println("Message: " + msg.getContent());
    }
}
