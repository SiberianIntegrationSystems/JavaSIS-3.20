package pro.sisit.logger.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import pro.sisit.logger.Logger;

public class SystemOutputLogger implements Logger {

    @Override
    public void log(String text) {
        System.out.printf("[%s]:%s: %s%n", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
            Thread.currentThread().toString(), text);
    }
}
