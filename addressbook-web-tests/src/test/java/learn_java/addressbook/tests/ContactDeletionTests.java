package learn_java.addressbook.tests;

import learn_java.addressbook.model.ContactData;
import learn_java.addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactDeletionTests extends TestBase{

//  @Test (enabled = false)
//  public void testContactDeletion() throws Exception {
//    app.goTo().homePage();
//    if (!app.contact().isThereAContact()) {
//      app.contact().create(new ContactData("test_name", "test_surname", "test1"));
//    }
//    app.contact().selectContact();
//    app.contact().deleteSelectedContacts();
//  }

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().allContacts().size() == 0) {
      app.contact().create(new ContactData().withFirstName("John").withLastName("Doe").withGroup("test1"));
    }
  }

  @Test
  public void testContactDeletion() throws Exception {
    Contacts before = app.contact().allContacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.contact().allContacts();
    assertThat(after, equalTo(before.without(deletedContact)));
  }

}
