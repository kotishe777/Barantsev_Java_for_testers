package learn_java.addressbook.tests;

import learn_java.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{

  @Test (enabled = false)
  public void testContactDeletion() throws Exception {
    app.goTo().goToHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("test_name", "test_surname", "test1"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
  }

}
