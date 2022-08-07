import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Connection1 connection1 = new Connection1();
        while (true) {
            System.out.print("Меню:\n" +
                    "Создать новость -- 1\n" +
                    "Прочетать новость -- 2\n" +
                    "Удалить новость -- 3\n" +
                    "Обновить новость -- 4\n" +
                    "Завершить программу -- 5\n" +
                    "Ввод: ");
            int menu = scanner.nextInt();
            if (menu == 1) {
                newNews(connection1);
            } else if (menu == 2) {
                getNews(connection1);
            } else if (menu == 3) {
                deleteNews(connection1);
            } else if (menu == 4) {
                updateNews(connection1);
            } else if (menu == 5) {
                break;
            } else {

            }
        }
    }

    public static void newNews(Connection1 connection1) {
        News news = new News();
        System.out.print("Введите название новости: ");
        scanner.nextLine();
        news.setName_news(scanner.nextLine());
        System.out.print("Введите новость: ");
        news.setText_news(scanner.nextLine());
        connection1.insertNews(news);

    }

    public static void getNews(Connection1 connection1) {
        System.out.print("Введите id новости для её чтения: ");
        int id_news = scanner.nextInt();
        connection1.getNews(id_news);
    }

    public static void deleteNews(Connection1 connection1) {
        System.out.print("Введите id новости для её удаления: ");
        int id_news = scanner.nextInt();
        connection1.deleteNews(id_news);
    }

    public static void updateNews(Connection1 connection1) {
        System.out.print("Введите id новости для её обнавления: ");
        int id_news = scanner.nextInt();
        connection1.updateNews(id_news);
    }


}
