package hello.egen_teto.dto;

public class ResultDto {

    private int egen;
    private int teto;
    private String resultText;

    public ResultDto(int egen, int teto, String resultText) {
        this.egen = egen;
        this.teto = teto;
        this.resultText = resultText;
    }

    public int getEgen() {
        return egen;
    }

    public int getTeto() {
        return teto;
    }

    public String getResultText() {
        return resultText;
    }
}
