package logger.messages;

import logger.Config;
import logger.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Message {
    private final String content;
    private final Enum<Level> level;
    private Config config;
    public String getContent() {
        return content;
    }
}
