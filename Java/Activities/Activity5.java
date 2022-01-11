package activities;

public class Activity5 {
    public static void main(String[] args) {
        MyBook newNovel = new MyBook();
        String titles = "New Book";
        newNovel.setTitle(titles);
        System.out.println(newNovel.getTitle());
    }
}
