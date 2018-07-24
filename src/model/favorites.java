package model;

public class favorites  implements  Comparable<favorites>{

    private String company_name;
    private float fav;
    private int question_id;


    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public float getFav() {
        return fav;
    }

    public void setFav(float fav) {
        this.fav = fav;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    @Override
    public int compareTo(favorites outro) {

        if(this.fav > outro.fav){

            return -1;

        }else if(this.fav < outro.fav){

            return 1;

        }

        return 0;
    }
}
