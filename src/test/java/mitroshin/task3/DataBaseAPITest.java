package mitroshin.task3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataBaseAPITest {
    private DataBaseAPI dataBaseAPI;

    @Before
    public void init() {
        dataBaseAPI = new DataBaseAPI();
    }

    @Test
    public void addingAndGettingStudent() throws Exception {
        Student inStudent = new Student("Ivanov", 5);
        dataBaseAPI.addStudentToDB(inStudent);
        Student outStudent = dataBaseAPI.getStudentBySurname(inStudent.getSurname());

        assertTrue("Surnames differ", inStudent.getSurname().equals(outStudent.getSurname()));
        assertEquals("Scores differ", inStudent.getScore(), outStudent.getScore());

        assertTrue("Test student isn't removed", dataBaseAPI.deleteStudent(inStudent.getSurname()));
    }

    @Test
    public void checkForOriginalStudents() throws Exception {
        Student student = dataBaseAPI.getStudentBySurname("Petrov");
        assertNotNull("There is no original student 'Petrov' in DB", student);
    }

    @Test
    public void isScoreChangedProperly() throws Exception {
        Student testStudent = new Student("Sidorov2", 10);

        dataBaseAPI.addStudentToDB(testStudent);
        assertEquals("adding student " + testStudent.getSurname() + " error", testStudent.getScore(),
                dataBaseAPI.getStudentBySurname(testStudent.getSurname()).getScore());

        dataBaseAPI.updateStudentScore(testStudent.getSurname(), 15);
        assertEquals("student score hasn't been updated", 15,
                dataBaseAPI.getStudentBySurname(testStudent.getSurname()).getScore());

        assertTrue("test student " + testStudent.getSurname() + " hasn't been deleted from DB",
                dataBaseAPI.deleteStudent(testStudent.getSurname()));
    }

    @After
    public void tearDown() throws Exception {
        dataBaseAPI.close();
    }
}