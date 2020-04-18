package com.example.week11;

public class DataTransferSingleton {
    private static DataTransferSingleton dataTransferSingleton = new DataTransferSingleton();

    private int textSize = 12;
    private int lineNumber = 9;
    // 0 = normal, 1 = Bold, 2 = Italic, 3 = Bold Italic
    private int textStyle = 0;
    private String textColor = "#FFFFFF";
    private String backgroundColor = "#C0C0C0";
    private String language = "English";
    private String textFromInputBox = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam tempus libero vel odio gravida dapibus. "
            + "Ut rutrum ante faucibus mauris semper, id hendrerit ipsum porta. Donec vestibulum efficitur arcu, id interdum est. Phasellus sit amet turpis consectetur, iaculis erat sed, lacinia enim.";
    private String textDisplay = "This can be edited in the settings.";

    private boolean textEditable = true;


    private DataTransferSingleton() {
    }

    public static DataTransferSingleton getInstance() {return dataTransferSingleton;}

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public int getTextStyle() {
        return textStyle;
    }

    public void setTextStyle(int textStyle) {
        this.textStyle = textStyle;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public boolean isTextEditable() {
        return textEditable;
    }

    public void setTextEditable(boolean textEditable) {
        this.textEditable = textEditable;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTextFromInputBox() {
        return textFromInputBox;
    }

    public void setTextFromInputBox(String textFromInputBox) {
        this.textFromInputBox = textFromInputBox;
    }
    public String getTextDisplay() {
        return textDisplay;
    }

    public void setTextDisplay(String textDisplay) {
        this.textDisplay = textDisplay;
    }
}
