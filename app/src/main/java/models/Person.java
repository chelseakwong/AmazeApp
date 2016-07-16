import CuratedList;

public class Person {

    private String firstName;
    private String lastName;
    private String userName;
    private char[] password;
    private List<CuratedList> lists;

    public Person(String firstName, String lastName, String userName, char[] password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.lists = new List<CuratedList>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public List<CuratedList> getLists() {
        return lists;
    }

    public void setLists(List<CuratedList> lists) {
        this.lists = lists;
    }
}