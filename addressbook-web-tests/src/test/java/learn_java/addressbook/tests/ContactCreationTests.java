package learn_java.addressbook.tests;

import learn_java.addressbook.model.ContactData;
import learn_java.addressbook.model.Groups;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class ContactCreationTests extends TestBase {

//  @Test (enabled = false)
//  public void testContactCreation() throws Exception {
//    app.contact().createContact(new ContactData("test_name", "test_surname",
//            "test1"));
//
//  }

    File photo = new File("src/test/resources/girl.png");

    @Test
    public void testContactCreation() {
        Groups groups = app.db().groups();
        long before = app.db().contacts().stream().count();
        File photo = new File("src/test/resources/girl.png");
        ContactData newContact = new ContactData().withFirstName("Jane").withLastName("Doe").withPhoto(photo)
                .inGroup(groups.iterator().next());
        app.goTo().homePage();
        app.contact().initContactCreation();
        app.contact().fillContactForm(newContact, true);
        app.contact().submitContactCreation();
        app.contact().returnToHomePage();
        long after = app.db().contacts().stream().count();
        Assert.assertEquals(after, before + 1);
    }
}
