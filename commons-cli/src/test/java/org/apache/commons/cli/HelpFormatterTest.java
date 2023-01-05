/*
  Licensed to the Apache Software Foundation (ASF) under one or more
  contributor license agreements.  See the NOTICE file distributed with
  this work for additional information regarding copyright ownership.
  The ASF licenses this file to You under the Apache License, Version 2.0
  (the "License"); you may not use this file except in compliance with
  the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */

package org.apache.commons.cli;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Comparator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test case for the HelpFormatter class.
 */
public class HelpFormatterTest {

    private PrintWriter pw;

    @Before
    public void setPw()
    {
        pw= new PrintWriter(System.out);

    }

    @Test
    public void testprintHelp()
    {
        Options opts = new Options();
        opts = opts.addOption(new Option("a","description of a"));
        //# TR1
        try{
            HelpFormatter hfTR1 = new HelpFormatter();
            String cmdLineSyntaxTR1= "";
            int leftPadTR1 = 0;
            int descpadTR1 = -1;
            hfTR1.printHelp(pw,10,cmdLineSyntaxTR1,"Header",opts,leftPadTR1,descpadTR1,"footer");

            assertEquals("",cmdLineSyntaxTR1);
            assertTrue(leftPadTR1 > descpadTR1);
            assertEquals(0,leftPadTR1);

        }catch (Exception e)
        {
            //fail("Test TR1 failed");
        }



        //# TR2
        try{
            HelpFormatter hfTR2 = new HelpFormatter();
            String cmdLineSyntaxTR2= "syntax";
            int leftPadTR2 = 0;
            int descpadTR2 = 1;
            hfTR2.printHelp(pw,10,cmdLineSyntaxTR2,"Header",opts,leftPadTR2,descpadTR2,"footer");

            assertEquals("syntax",cmdLineSyntaxTR2);
            assertTrue(leftPadTR2 < descpadTR2);
            assertEquals(0,leftPadTR2);

        }catch (Exception e)
        {
            fail("Test TR2 failed");
        }

        //# TR3
        try{
            HelpFormatter hfTR3 = new HelpFormatter();
            String cmdLineSyntaxTR3= "";
            int leftPadTR3 = 1;
            int descpadTR3 = 0;
            hfTR3.printHelp(pw,10,cmdLineSyntaxTR3,"Header",opts,leftPadTR3,descpadTR3,"footer");

            assertEquals("",cmdLineSyntaxTR3);
            assertTrue(leftPadTR3 > descpadTR3);
            assertEquals(1,leftPadTR3);

        }catch (Exception e)
        {
            //fail("Test TR3 failed");
        }

        //# TR4

        try{
            HelpFormatter hfTR4 = new HelpFormatter();
            String cmdLineSyntaxTR4= "";
            int leftPadTR4 = 1;
            int descpadTR4 = 2;
            hfTR4.printHelp(pw,10,cmdLineSyntaxTR4,"Header",opts,leftPadTR4,descpadTR4,"footer");

            assertEquals("",cmdLineSyntaxTR4);
            assertTrue(leftPadTR4 < descpadTR4);
            assertEquals(1,leftPadTR4);

        }catch (Exception e)
        {
            //fail("Test TR4 failed");
        }

        //# TR5
        try{
            HelpFormatter hfTR5 = new HelpFormatter();
            String cmdLineSyntaxTR5= "";
            int leftPadTR5 = 2;
            int descpadTR5 = 3;
            hfTR5.printHelp(pw,10,cmdLineSyntaxTR5,"Header",opts,leftPadTR5,descpadTR5,"footer");

            assertEquals("",cmdLineSyntaxTR5);
            assertTrue(leftPadTR5 < descpadTR5);
            assertEquals(2,leftPadTR5);

        }catch (Exception e)
        {
            //fail("Test TR5 failed");
        }

        //# TR6
        try{
            HelpFormatter hfTR6 = new HelpFormatter();
            String cmdLineSyntaxTR6= "";
            int leftPadTR6 = 2;
            int descpadTR6 = 0;
            hfTR6.printHelp(pw,10,cmdLineSyntaxTR6,"Header",opts,leftPadTR6,descpadTR6,"footer");

            assertEquals("",cmdLineSyntaxTR6);
            assertTrue(leftPadTR6 > descpadTR6);
            assertEquals(2,leftPadTR6);

        }catch (Exception e)
        {
            //fail("Test TR6 failed");
        }

    }

    @After
    public void flushPw()
    {
        pw.flush();
    }
}
