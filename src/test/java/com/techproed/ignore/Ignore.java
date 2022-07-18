package com.techproed.ignore;



import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Ignore {
    /*
    1-Tüm key'ler için Private variable'lar oluşturuyoruz
    2-Tüm parametrelerle ve parametresiz  constructor'larımızı oluşturuyoruz.
    3-getters ve setters'larımızı oluşturuyoruz
    4-toString methodumuzu oluşturuyoruz
     */
    //1-Tüm key'ler için Private variable'lar oluşturuyoruz
    private Integer userId;
    private String title;
    private Boolean completed;
    //2-Tüm parametrelerle ve parametresiz  constructor'larımızı oluşturuyoruz.



    public Ignore(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;


    }

    public Ignore() {
    }
    //  3-getters ve setters'larımızı oluşturuyoruz

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
    //4-toString methodumuzu oluşturuyoruz

    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
    // farklı key -value ikililerinin uyuşmazlığını @JsonIgnoreProperties(ignoreUnknown = true)
    //anotation'ının pojo class'larımızın başına yazarak çözebiliriz
}