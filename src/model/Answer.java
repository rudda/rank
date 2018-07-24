package model;

public class Answer {

    private int answer; // 0, 1, 2, 3, 4
    private int status; //0 => favorable, 1=> neutral , 2=> unfavorable 3=>invalido
    private boolean valid; //if answer is valid (0,1,2,3,4)

    public Answer(int answer) {
        this.answer = answer;

        this.setValid(answer>=0 && answer <=4);

        if(this.isValid()){

            if(answer==0 || answer==1 ){

                this.setStatus(0);

            }else if(answer == 2){

                this.setStatus(1);

            }else if(answer==3 || answer ==4){

                this.setStatus(2);

            }


        }else{

            //status invalido
            this.setStatus(3);

        }

    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
