package hello.egen_teto.dto;

public class ResultDtO {

    private int egen;
    private int teto;
    private String resultText;

    public ResultDtO(int egen, int teto, String resultText) {
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
