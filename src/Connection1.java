import java.sql.*;
import java.util.Scanner;

public class Connection1 {
    static Scanner scanner = new Scanner(System.in);
    private final String url = "jdbc:postgresql://localhost:5432/";
    private final String user = "postgres";
    private final String password = "diyaz18";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to server successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insertNews(News news) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String SQL = "INSERT INTO \"ekzam_2\".\"news\" " +
                " (name_news, text_news, publication_time)" +
                " VALUES (?, ?, ?); ";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(1, news.getName_news());
            stmt.setString(2, news.getText_news());
            stmt.setTimestamp(3, timestamp);
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException e) {
            System.out.println("Новость добавлена в базу!!");
        }
    }

    public void deleteNews(int id_news) {
        String SQL = "DELETE FROM \"ekzam_2\".\"news\" where id = " + id_news + "";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SQL);
        } catch (SQLException e) {
            System.out.println("Запись удаленна!!");
        }
    }

    public void updateNews(int id_news) {
        System.out.print("Введите название новости: ");
        String nameNews = scanner.nextLine();
        System.out.print("Введите новость: ");
        String textNews = scanner.nextLine();
        String SQL = "UPDATE \"ekzam_2\".\"news\" set name_news = \'" + nameNews + "\',text_news = \'" + textNews + "\' where id = " + id_news + "";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SQL);
        } catch (SQLException e) {
            System.out.println("Запись обновлена!!");
        }
    }

    public void getNews(int id_news) {
        String SQL = "SELECT * FROM \"ekzam_2\".\"news\" where id = " + id_news + "";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                String name_news;
                String text_news;
                name_news = rs.getString("name_news");
                text_news = rs.getString("text_news");
                News news = new News(name_news, text_news);
                System.out.println(news);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


}
