package models;

import enums.ReportLevel;
import interfaces.File;
import interfaces.Layout;

public class FileAppender extends AppenderImpl {
    private File file;

    public FileAppender(Layout layout) {
        super(layout);
        this.file = new LogFile();
    }

    public FileAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
        this.file = new LogFile();
    }

    public void setFile(File file){
        this.file = file;
    }

    @Override
    public void append(String time, String message, ReportLevel reportLevel) {
        if(this.file == null){
            throw new IllegalCallerException("File not set!");
        }

        if(this.canAppend(reportLevel)){
            this.file.append(this.getLayout().format(time,message,reportLevel));
            super.increaseMessagesCount();
            this.file.write();
        }
    }

    @Override
    public String toString() {
        return super.toString() + "File size: " + this.file.getSize();
    }
}





















