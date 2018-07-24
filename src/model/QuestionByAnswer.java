package model;

import java.util.List;

public class QuestionByAnswer {

    private long id;
    List<favorites> favoritesList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<favorites> getFavoritesList() {
        return favoritesList;
    }

    public void setFavoritesList(List<favorites> favoritesList) {
        this.favoritesList = favoritesList;
    }
}
