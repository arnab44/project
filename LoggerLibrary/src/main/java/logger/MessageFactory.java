package logger;


import logger.messages.Message;
import logger.sink.Configurable;
import logger.sink.ConsoleSink;
import logger.sink.DatabaseSink;

public class MessageFactory {

    public static Message getErrorMessage(String content) {
        Config errorSinkConfig = new SinkConfiguration();
        errorSinkConfig.subscribe(getMysqlSink());
        errorSinkConfig.subscribe(getTerminalSink());
        return new Message(content, Level.ERROR, errorSinkConfig);
    }

    public static Message getFatalMessage(String content) {
        return new Message(content, Level.DEBUG, new SinkConfiguration());
    }

    public  static  Configurable getMysqlSink() {
        return  new DatabaseSink("mysql_db");
    }
    public static Configurable getTerminalSink() {
        return new ConsoleSink("my ubuntu terminal");
    }

}
