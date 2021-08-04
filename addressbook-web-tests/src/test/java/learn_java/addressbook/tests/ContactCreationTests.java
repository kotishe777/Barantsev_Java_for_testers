package learn_java.addressbook.tests;

import learn_java.addressbook.model.ContactData;
import learn_java.addressbook.model.Contacts;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactCreationTests extends TestBase{

//  @Test (enabled = false)
//  public void testContactCreation() throws Exception {
//    app.contact().createContact(new ContactData("test_name", "test_surname",
//            "test1"));
//
//  }

  File photo = new File("src/test/resources/girl.png");

  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    Contacts before = app.contact().allContacts();
    ContactData contact = new ContactData().withFirstName("Jane").withLastName("Doe").withPhoto(photo);
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().allContacts();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

  @Test
  public void testBadContactCreation() {
    app.goTo().homePage();
    Contacts before = app.contact().allContacts();
    ContactData contact = new ContactData().withFirstName("TestFirstName'").withLastName("TestLastName'").withGroup("test1");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().allContacts();
    assertThat(after, equalTo(before));
  }

}
