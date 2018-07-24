package model;

public class Question {

    private long id;
    private int response;
    private boolean isValide;

    public Question(long id, int response) {

        this.id = id;
        this.response = response;

        this.setValide(response>0&& response<=4);

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }

    public boolean isValide() {
        return isValide;
    }

    public void setValide(boolean valide) {
        isValide = valide;
    }
}
