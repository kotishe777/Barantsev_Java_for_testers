package learn_java.addressbook.tests;

import learn_java.addressbook.model.ContactData;
import learn_java.addressbook.model.Groups;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class ContactModificationTests extends TestBase {

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
//      app.contact().create(new ContactData().withFirstName("John").withLastName("Doe").withGroup("test1"));
        }
    }

    @Test
    public void testContactModification() {
        Groups groups = app.db().groups();
        var beforeContactList = app.db().contacts().stream().count();

        ContactData modifiedContact = app.contact().allContacts().iterator().next();
        File photo = new File("src/test/resources/girl.png");
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withFirstName("Jane").withLastName("Doe").withPhoto(photo).inGroup(groups.iterator().next());
        app.contact().modify(contact);

        var afterContactList = app.db().contacts().stream().count();
        Assert.assertEquals(afterContactList, beforeContactList + 1);
    }

}
