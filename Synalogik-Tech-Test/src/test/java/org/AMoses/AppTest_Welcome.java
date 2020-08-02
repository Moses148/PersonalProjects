package org.AMoses;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class AppTest_Welcome
{
    @Test
    public void Welcome() throws Exception
    {
        App Main = new App();
        String UserInput = "welcome";
        InputStream in = new ByteArrayInputStream(UserInput.getBytes());
        System.setIn(in);
        assertEquals( 9, Main.main());
    }
}
