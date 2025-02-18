package RamdomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private int mssv;
    private String name;
    private List<Subject> subjects = new ArrayList<Subject>();

    public Student(int mssv, String name, List<Subject> subjects) {
        this.mssv = mssv;
        this.name = name;
        this.subjects = subjects;
    }

    public int getMssv() {
        return mssv;
    }

    public void setMssv(int mssv) {
        this.mssv = mssv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        String sub = "";
        int size = 1;
        for(Subject subject : getSubjects()){
            sub += "\nstt " + size + "\nTenMH " + subject.getSubName() + "\nĐiểm " + subject.getCredit();
            size++;
        }
        return "\nTên " + getName() + "\n" + "MSSV " + getMssv() + "\nCác Môn Hoc" + sub;
    }
}
