package mitroshin.task3;

public class Main {
    public static void main(String[] args) {
        DataBaseAPI dataBaseAPI = new DataBaseAPI();

        dataBaseAPI.addStudentToDB(new Student("Petrov", 10));
        dataBaseAPI.addStudentToDB(new Student("Sidorov", 11));

        dataBaseAPI.close();
    }
}
