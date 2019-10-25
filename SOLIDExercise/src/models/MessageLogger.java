package models;

import enums.ReportLevel;
import interfaces.Appender;
import interfaces.Logger;

public class MessageLogger implements Logger {
    private Appender[] appenders;

    public MessageLogger(Appender...appenders) {
        this.appenders = appenders;
    }

    @Override
    public void log(String time, String message, ReportLevel reportLevel) {
        this.logAll(time,message,reportLevel);
    }


    private void logAll(String time, String message, ReportLevel reportLevel){
        for (Appender appender : this.appenders) {
            appender.append(time,message,reportLevel);


        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Logger info");

        for (Appender appender : this.appenders){
            sb.append(System.lineSeparator());
            sb.append(appender.toString());
        }

        return sb.toString();
    }
}























