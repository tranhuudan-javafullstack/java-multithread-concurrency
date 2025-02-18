package RamdomAccessFile;
public class Subject {
    private String subID;
    private String subName;
    private Double credit;

    public Subject(String subID, String subName, Double credit) {
        this.subID = subID;
        this.subName = subName;
        this.credit = credit;
    }

    public String getSubID() {
        return subID;
    }

    public void setSubID(String subID) {
        this.subID = subID;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }
}
