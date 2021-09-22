package learn_java.addressbook.tests;

import learn_java.addressbook.model.GroupData;
import learn_java.addressbook.model.Groups;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0){
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupModification() {
        if(Boolean.getBoolean("verifyUI")) {
            Groups before = app.db().groups();
            GroupData modifiedGroup = before.iterator().next();
            GroupData group = new GroupData()
                    .withId(modifiedGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
            app.goTo().groupPage();
            app.group().modify(group);
            assertThat(app.group().count(), equalTo(before.size()));
            Groups after = app.db().groups();
            assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
            verifyGroupListInUI();
        }
    }

}
