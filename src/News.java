public class News {
    private int id;
    private String name_news;
    private String text_news;
    private String publicationTime;

    public News() {

    }

    public News(String name_news, String text_news) {
        this.name_news = name_news;
        this.text_news = text_news;
    }

    @Override
    public String toString() {
        return "                              Внимание НОВОСТИ!!!\n" +
                "--------------------------------------------------------------------\n" +
                "                                " + name_news + "\n" +
                "--------------------------------------------------------------------\n" +
                "     " + text_news + "\n" +
                "--------------------------------------------------------------------\n" +
                "                             Спасибо За Внимание!!!";
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getName_news() {
        return name_news;
    }

    public void setName_news(String name_news) {
        this.name_news = name_news;
    }

    public String getText_news() {
        return text_news;
    }

    public void setText_news(String text_news) {
        this.text_news = text_news;
    }

    public String getPublicationTime() {
        return publicationTime;
    }

    public void setPublicationTime(String publicationTime) {
        this.publicationTime = publicationTime;
    }
}
