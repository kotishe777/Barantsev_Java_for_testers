package learn_java.addressbook.tests;

import learn_java.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{

  @Test (enabled = false)
  public void testContactModification() throws Exception {
    app.goTo().goToHomePage();
    int before = app.group().getGroupCount();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("test_name", "test_surname", "test1"));
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("test_name", "test_surname",null),
            false);
    app.getContactHelper().submitContactModification();
    int after = app.group().getGroupCount();
    Assert.assertEquals(after, before);
  }
}
