package learn_java.addressbook.tests;

import learn_java.addressbook.model.ContactData;
import learn_java.addressbook.model.Contacts;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactModificationTests extends TestBase{

//  @Test (enabled = false)
//  public void testContactModification() throws Exception {
//    app.goTo().homePage();
//    int before = app.group().count();
//    if (!app.contact().isThereAContact()) {
//      app.contact().create(new ContactData("test_name", "test_surname", "test1"));
//    }
//    app.contact().initContactModification();
//    app.contact().fillContactForm(new ContactData("test_name", "test_surname",null),
//            false);
//    app.contact().submitContactModification();
//    int after = app.group().count();
//    Assert.assertEquals(after, before);
//  }

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().allContacts().size() == 0) {
      app.contact().create(new ContactData().withFirstName("John").withLastName("Doe").withGroup("test1"));
    }
  }

  @Test
  public void testContactModification() {

    Contacts before = app.contact().allContacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstName("Jane").withLastName("Doe").withGroup("test1");
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().allContacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }

}
