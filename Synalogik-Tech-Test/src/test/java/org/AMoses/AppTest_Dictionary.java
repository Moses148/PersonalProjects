package org.AMoses;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AppTest_Dictionary
{
    @Test
    public void Dictionary() throws Exception
    {
        App Main = new App();
        String UserInput = "english3";
        InputStream in = new ByteArrayInputStream(UserInput.getBytes());
        System.setIn(in);
        assertEquals( 194433, Main.main());
    }
}
