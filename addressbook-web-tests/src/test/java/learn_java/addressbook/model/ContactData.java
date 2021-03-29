package learn_java.addressbook.model;

public class ContactData {

  private final String firstName;
  private final String secondName;

  private final String group;

  public ContactData(String firstName, String secondName, String group){
    this.firstName = firstName;
    this.secondName = secondName;
    this.group = group;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return secondName;
  }

  public String getGroup() {
    return group;
  }

}
