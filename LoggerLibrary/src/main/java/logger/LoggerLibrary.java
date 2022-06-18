package logger;

import logger.messages.Message;


public class LoggerLibrary {
    public  static void main(String[] args) {

        Message errorMessage = MessageFactory.getErrorMessage("This is an error message");
        errorMessage.getConfig().handleMessage(errorMessage);
        Message fatalMessage = MessageFactory.getFatalMessage("This is a fatal message");

    }
}
