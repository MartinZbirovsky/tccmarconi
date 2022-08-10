public class UserChoice {
    private final Integer choiceNumber;
    private final String fistFilePath;
    private final String secondFilePath;

    public UserChoice(Integer choiceNumber, String fistFilePath, String secondFilePath) {
        this.choiceNumber = choiceNumber;
        this.fistFilePath = fistFilePath;
        this.secondFilePath = secondFilePath;
    }

    public UserChoice(Integer choiceNumber, String fistFilePath) {
        this.choiceNumber = choiceNumber;
        this.fistFilePath = fistFilePath;
        this.secondFilePath = "";
    }

    public UserChoice(Integer choiceNumber) {
        this.choiceNumber = choiceNumber;
        this.fistFilePath = "";
        this.secondFilePath = "";
    }

    public Integer getChoiceNumber() {
        return choiceNumber;
    }

    public String getFistFilePath() {
        return fistFilePath;
    }

    public String getSecondFilePath() {
        return secondFilePath;
    }
}
