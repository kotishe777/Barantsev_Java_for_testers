package learn_java.addressbook.tests;

import learn_java.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

  @Test (enabled = false)
  public void testContactCreation() throws Exception {
    app.getContactHelper().createContact(new ContactData("test_name", "test_surname",
            "test1"));

  }
}
