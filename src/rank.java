import model.Company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import model.Question;
import model.QuestionByAnswer;
import model.favorites;


public class rank {

    public static  void main (String args[]){
        //imput sample
        // /tmp/hall_a.i._ltd._iCiSXO.txt /tmp/it_services_iqMO2z.txt /tmp/logistic_company_AbOzZl.txt /tmp/mybank_zqweSt.txt /tmp/pineapple_store_abXKXL.txt

        List<Company> companies = new ArrayList<>();

        List<QuestionByAnswer> questionByAnswers = new ArrayList<>();

        for(String file : args){
            Company c =  readFile(file);
            companies.add(c);
        }

        for(Company c : companies){

            System.out.println();
            sumary(c.getCompanyName(), c.getQuestionList());
            System.out.println();

        }

        System.out.println();
        System.out.println();

        QuestionByAnswer(companies);

        System.out.println();
        System.out.println();

        totalValidos(companies);

        System.out.println();
        System.out.println();

        totalInvalidos(companies);

    }

    public static void QuestionByAnswer(List<Company> companies){

        System.out.println("Fav answers by questions:");

        HashMap<Long, List<favorites>> favs = new HashMap<>();

        //todas as companhias
        for(Company c : companies){

            for(Question q : c.getQuestionList()){

                if( favs.containsKey(q.getId()) ){
                    //buscar e add
                    favorites f = new favorites();
                    f.setFav((float) q.getFav());
                    f.setQuestion_id((int)q.getId());
                    f.setCompany_name(c.getCompanyName());

                    favs.get(q.getId()).add(f);


                }else{

                    //criar
                    favorites f = new favorites();
                    f.setFav((float) q.getFav());
                    f.setQuestion_id((int)q.getId());
                    f.setCompany_name(c.getCompanyName());

                    favs.put(q.getId(), new ArrayList<>());
                    favs.get(q.getId()).add(f);



                }


            }


        }


        for (Map.Entry<Long,List<favorites>> pair : favs.entrySet()) {

            System.out.print(pair.getKey()+" ");
            Collections.sort(pair.getValue());

            for(favorites f : pair.getValue()){

                float fav = (float) (f.getFav()*100);
                System.out.printf("%s \t %.2f %%,   ",f.getCompany_name(), fav);

            }
            System.out.println();

        }




    }

    public static void totalValidos(List<Company> companies){

        System.out.println("total validos");

        for(Company c : companies){

            c.prepareValues();
            System.out.println(c.getCompanyName()+": "+c.getTotal_valid_anwers());

        }

    }

    public static void totalInvalidos(List<Company> companies){

        System.out.println("total invalidos ");

        for(Company c : companies ) {

            c.prepareValues();
            System.out.println(c.getCompanyName() + ": " + c.getTotal_invalid_anwers());

        }

    }

    public static void sumary(String company, List<Question> questionList){

        System.out.println(company);

        for(Question q : questionList){

            float fav = (float) (q.getFav()*100);
            float neutral = (float) (q.getNetral()*100);
            float unfav = (float)(q.getUnfav()*100);

            System.out.printf("%d fav %.2f %%  neutral %.2f %%  unfav  %.2f %%", q.getId(), fav,neutral,unfav);
            System.out.println();


        }



    }

    public static Company readFile(String filename){

        Company c = new Company("");

        BufferedReader br = null;
        try {
            br = new BufferedReader(new
                    FileReader(filename));

            String linha;
            int count = 0;
            while ((linha = br.readLine()) != null) {

                System.out.println("...wait...");
                if(count ==0){

                    c.setCompanyName(linha);

                }else{

                    String parse [] = linha.split(" ");
                    c.addQuestion(Integer.parseInt(parse[0]), Integer.parseInt(parse[1]));


                }
                count++;

            }
            br.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        System.out.print("\r\n");

        return c;


    }



}
