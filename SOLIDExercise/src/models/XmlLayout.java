package models;

import enums.ReportLevel;
import interfaces.Layout;

public class XmlLayout implements Layout {
    @Override
    public String format(String time, String message, ReportLevel reportLevel) {
        return String.format(
                "<log>" +
                "<date>%s</date>+" +
                "<level>%s</level> +" +
                "<message>%s</message>+" +
                "</log>",time,reportLevel.toString(),message);
    }
}



















