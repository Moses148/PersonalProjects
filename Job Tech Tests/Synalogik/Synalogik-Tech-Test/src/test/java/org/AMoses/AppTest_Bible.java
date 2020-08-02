package org.AMoses;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class AppTest_Bible
{
    @Test
    public void Bible() throws Exception
    {
        App Main = new App();
        String UserInput = "bible_daily";
        InputStream in = new ByteArrayInputStream(UserInput.getBytes());
        System.setIn(in);
        assertEquals( 793824, Main.main());
    }
}
