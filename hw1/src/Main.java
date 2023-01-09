import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        KeelungSightsCrawler crawler = new KeelungSightsCrawler();
        ArrayList<Sight> sights = crawler.getItem("七堵區");
        for(Sight s : sights){
            System.out.println(s);
        }
    }
}