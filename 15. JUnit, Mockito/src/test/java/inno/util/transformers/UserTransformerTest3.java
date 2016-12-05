package inno.util.transformers;


import inno.model.User;
import inno.util.form.UserForm;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:security-config.xml")
public class UserTransformerTest3 {

    @Autowired
    UserFormTransformer transformer;

    @Test
    public void testSetName() {
        UserForm form = new UserForm();
        form.setName("aaaaa");
        form.setSurname("");
        form.setEmail("");
        form.setRepassword("");
        form.setPassword("123");
        User user = transformer.toUser(form);
        //Assert.assertTrue(user.getName().equals("aaaaa"));
        Assert.assertSame("Такая беда:", "aaaa", user.getName());
        //Assert.assertTrue(transformer.encoder.matches("123", user.getPassword()));
    }
}
