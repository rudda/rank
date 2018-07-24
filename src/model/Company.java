package model;

import java.util.*;

public class Company implements Comparable<Company>{

    private HashMap< Long, Question> myQuestions;
    private String companyName;


    private int total_invalid_anwers;
    private int total_valid_anwers;

    private List<Question> questionList = new ArrayList<>();

    public Company(String companyName) {

        this.companyName = companyName;
        this.setMyQuestions( new HashMap<>() );
        this.setQuestionList(new ArrayList<>());


    }


    public void addQuestion(long id, int resp){

        if(myQuestions.containsKey(id)) {

            //busca
            this.myQuestions.get(id).addAswer(new Answer(resp));

        }else{

            //crio uma nova
            Question q = new Question();
            q.setId(id);
            q.addAswer(new Answer(resp));
            this.myQuestions.put(id, q);

        }

    }


    public HashMap<Long, Question> getMyQuestions() {
        return myQuestions;
    }

    public void setMyQuestions(HashMap<Long, Question> myQuestions) {
        this.myQuestions = myQuestions;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getTotal_invalid_anwers() {
        return total_invalid_anwers;
    }

    public void setTotal_invalid_anwers(int total_invalid_anwers) {
        this.total_invalid_anwers = total_invalid_anwers;
    }

    public int getTotal_valid_anwers() {
        return total_valid_anwers;
    }

    public void setTotal_valid_anwers(int total_valid_anwers) {
        this.total_valid_anwers = total_valid_anwers;
    }

    public List<Question> getQuestionList() {

        questionList = new ArrayList<>();
        for (Map.Entry<Long,Question> pair : this.getMyQuestions().entrySet()) {

           questionList.add(pair.getValue());

        }
         Collections.sort( questionList );

         return  questionList;
    }


    public void prepareValues(){

        if(this.questionList.size()>0){

            for(Question q: this.questionList){

                this.setTotal_valid_anwers(this.getTotal_valid_anwers()+q.getValid_answers());
                this.setTotal_invalid_anwers(this.getTotal_invalid_anwers()+q.getInvalid_answers());


            }

        }else{

            for(Question q : this.getQuestionList()){

                this.setTotal_valid_anwers(this.getTotal_valid_anwers()+q.getValid_answers());
                this.setTotal_invalid_anwers(this.getTotal_invalid_anwers()+q.getInvalid_answers());


            }

        }

    }


    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    @Override
    public int compareTo(Company outherCompany) {

         return this.getCompanyName().compareTo(outherCompany.getCompanyName());

    }
}
