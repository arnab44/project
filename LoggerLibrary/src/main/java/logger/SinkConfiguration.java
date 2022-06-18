package logger;

import logger.messages.Message;
import logger.sink.Configurable;

import java.util.ArrayList;
import java.util.List;


public class SinkConfiguration implements Config {
    private List<Configurable> sinks;

    SinkConfiguration() {
        sinks = new ArrayList<Configurable>();
    }

    @Override
    public void subscribe(Configurable sink) {
        sinks.add(sink);

    }

    @Override
    public void unSubscribe(Configurable sink) {
        sinks.remove(sink);

    }

    public void handleMessage(Message msg) {
        sinks.stream().forEach(sink -> sink.handleMessage(msg));
    }

//    @Override
//    public void subscribe(logger.Configurable cfg) {
//
//    }
//
//    @Override
//    public void unSubscribe(logger.Configurable cfg) {
//
//    }


}
