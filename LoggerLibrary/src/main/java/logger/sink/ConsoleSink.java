package logger.sink;

import logger.messages.Message;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ConsoleSink implements  Configurable{
    private final String name;


    @Override
    public void handleMessage(Message msg) {
        System.out.println("Handling message at console sink: " + name);
        System.out.println("Message: " + msg.getContent());
    }
}
