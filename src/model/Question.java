package model;

import java.util.ArrayList;
import java.util.List;

public class Question implements Comparable<Question>{

    private long id;
    private int valid_answers=0;
    private int invalid_answers=0;
    private List<Answer> answers = new ArrayList<>();

    private double fav, netral, unfav;

    private double fav_total=0;
    private double netral_total=0;
    private double unfav_total=0;


    public Question() {


    }

    public void addAswer(Answer a){

        this.answers.add(a);

        if(a.isValid()){

           this.incrementValidAnswer();

        }else{

            this.incrementInvalidAnswer();

        }

        switch (a.getStatus()){

            case 0:

                this.setFav_total(  this.getFav_total() +1 );
                this.setFav( this.getFav_total() / this.getValid_answers() );

                break;

            case 1:

                this.setNetral_total( this.getNetral_total() +1);
                this.setNetral( this.getNetral_total() / this.getValid_answers() );

                break;

            case 2:

                this.setUnfav_total(this.getUnfav_total()+1);
                this.setUnfav(this.getUnfav_total() / this.getValid_answers());

                break;

                default:
                    break;

        }


    }

    private void incrementInvalidAnswer() {

        this.setInvalid_answers(this.getInvalid_answers()+1);

    }

    private void incrementValidAnswer(){

        this.setValid_answers(this.getValid_answers()+1);

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getValid_answers() {
        return valid_answers;
    }

    public void setValid_answers(int valid_answers) {
        this.valid_answers = valid_answers;
    }

    public int getInvalid_answers() {
        return invalid_answers;
    }

    public void setInvalid_answers(int invalid_answers) {
        this.invalid_answers = invalid_answers;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public double getFav() {
        return fav;
    }

    public void setFav(double fav) {
        this.fav = fav;
    }

    public double getNetral() {
        return netral;
    }

    public void setNetral(double netral) {
        this.netral = netral;
    }

    public double getUnfav() {
        return unfav;
    }

    public void setUnfav(double unfav) {
        this.unfav = unfav;
    }

    public double getFav_total() {
        return fav_total;
    }

    public void setFav_total(double fav_total) {
        this.fav_total = fav_total;
    }

    public double getNetral_total() {
        return netral_total;
    }

    public void setNetral_total(double netral_total) {
        this.netral_total = netral_total;
    }

    public double getUnfav_total() {
        return unfav_total;
    }

    public void setUnfav_total(double unfav_total) {
        this.unfav_total = unfav_total;
    }

    @Override
    public int compareTo(Question outraQuestion) {

        if (this.getFav() > outraQuestion.getFav()) {

            return -1;
        }
        if (this.getFav() < outraQuestion.getFav()) {

            return 1;
        }

        return 0;

    }
}
