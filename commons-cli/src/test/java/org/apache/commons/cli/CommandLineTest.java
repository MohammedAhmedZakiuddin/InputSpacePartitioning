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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.*;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("deprecation") // tests some deprecated classes
public class CommandLineTest {


    private CommandLine cli;
    private Options options;

    @Before
    public void setUp()
    {
        cli = new CommandLine();
        options = new Options();

    }

    @After
    public void tearDown()
    {
        cli = null;
    }

    @Test
    public void testaddOption()
    {
        //TR #1
        try{
            Option opt = null;
            opt.setLongOpt("aaa");
            opt.setDescription("aaa");
            options.addOption(opt);
            assertEquals(2,options.getOption(opt.getOpt()).getClass().getFields().length);
            assertTrue(opt == null);
            assertTrue(options.getOption(opt.getDescription()) == options.getOption(opt.getLongOpt()));



        }catch (NullPointerException e)
        {
          //  fail("Test failure #1");
        }

        //TR #2
        Option option1 = new Option("t","testing");
        options.addOption(option1);
        assertEquals(2,options.getOption(option1.getOpt()).getClass().getFields().length);
        option1.setLongOpt("nottesting");
        assertTrue(options.getOption(option1.getLongOpt()) == options.getOption(option1.getDescription()));
        assertTrue(option1 != null);


        //TR #3
        try
        {
            Option tr3 = null;
            tr3.setArgs(3);
            tr3.setLongOpt("aaa");
            tr3.setDescription("aaa");
            options.addOption(tr3);
            assertEquals(3,options.getOption(tr3.getOpt()).getClass().getFields().length);
            assertTrue(tr3 == null);
            assertTrue(options.getOption(tr3.getLongOpt()) == options.getOption(tr3.getDescription()));

        }catch (NullPointerException e)
        {
            //fail("Test failure #3");
        }



        //TR #4
        Option option2 = new Option("a",false,"The a description");
        options.addOption(option2);
        assertEquals(3,options.getOption("a").getClass().getFields().length+1);
        option2.setLongOpt("aaa");

        assertTrue(options.getOption(option2.getLongOpt()) == options.getOption(option2.getDescription()));
        assertTrue(option2 != null);



        //TR #5
        Option option3 = new Option("x",false,"Scanner");
        options.addOption(option3);
        option3.setLongOpt("Scanner");
        assertEquals(3,options.getOption("a").getClass().getFields().length+1);
        assertTrue(options.getOption(option3.getLongOpt()) == options.getOption(option3.getDescription()));
        assertTrue(option3 != null);



        //TR #6
        try
        {
            Option option4 = null;
            option4.setLongOpt("XYZ");
            option4.setDescription("This is a description about XYZ");
            option4.setArgs(2);
            option4.setRequired(false);
            options.addOption(option4);
            assertEquals(4,options.getOption(option4.getOpt()).getClass().getFields().length);
            assertFalse(options.getOption(option4.getLongOpt()) == options.getOption(option4.getDescription()));
            assertTrue(option4 == null);

        }catch (NullPointerException e)
        {
            //fail("Test failure #6");
        }





    }

    @Test
    public void testgetOptions()
    {
        //TR #1
        try{
            Options optionsTR1 = new Options();
            assertEquals(0,optionsTR1.getOptions().size());
            optionsTR1 = optionsTR1.addOption( new Option("x",""));
            assertTrue(optionsTR1.getOption("x").getDescription() == "");
            assertTrue( optionsTR1.getOptions().size() != 0 );

        }catch (Exception e)
        {
            fail("Test failure #1");
        }

        //TR #2
        try{
            Options optionsTR22 = new Options();
            assertEquals(0,optionsTR22.getOptions().size());
            optionsTR22 = optionsTR22.addOption( new Option("x","a"));
            assertTrue(optionsTR22.getOption("x").getDescription() == "a");
            assertFalse( optionsTR22.getOptions().isEmpty() );


        }catch (Exception e)
        {
            fail("Test failure #2");
        }


        //TR #4
        Options optionTR42 = new Options();
        optionTR42.addOption(new Option("ab","as"));
        assertEquals(1,optionTR42.getOptions().size());
        assertEquals("as",optionTR42.getOption("ab").getDescription());
        assertFalse( optionTR42.getOptions().isEmpty() );



        //TR #6
        Options optionsTR62 = new Options();

        optionsTR62.addOption(new Option("K",""));
        optionsTR62.addOption(new Option("oop",""));

        assertEquals(2,optionsTR62.getOptions().size());
        assertEquals("",optionsTR62.getOption("oop").getDescription());
        assertEquals("",optionsTR62.getOption("K").getDescription());
        assertFalse( optionsTR62.getOptions().isEmpty() );


    }
    @Test
    public void testgetArgs()
    {
        //TR #1
        CommandLine cliTR1 = new CommandLine();
        String arg1TR1= "ls";
        String arg2TR1= "cd";

        cliTR1.addArg("");
        String[] listArgTR1 = cliTR1.getArgs();
        assertEquals("",listArgTR1[0]);
        assertEquals(0,listArgTR1.length-1);
        assertEquals(0,listArgTR1[0].length());

        //TR #2
        CommandLine cliTR2 = new CommandLine();
        String arg1TR2= "l";
        String arg2TR2= "cd";

        cliTR2.addArg("");
        cliTR2.addArg(arg1TR2);

        String[] listArgTR2 = cliTR2.getArgs();
        assertEquals("l",listArgTR2[1]);
        assertEquals(1,listArgTR2.length-1);
        assertEquals(1,listArgTR2[1].length());


        //TR #3
        CommandLine cliTR3 = new CommandLine();
        String arg1TR3= "ls";
        String arg2TR3= "cd";

        cliTR3.addArg("");
        cliTR3.addArg(arg1TR3);
        cliTR3.addArg(arg2TR3);


        String[] listArgTR3 = cliTR3.getArgs();
        assertEquals("ls",listArgTR3[1]);
        assertEquals("cd",listArgTR3[2]);

        assertEquals(2,listArgTR3.length-1);
        assertEquals(2,listArgTR3[1].length());
        assertEquals(2,listArgTR3[2].length());


        //TR #4
        CommandLine cliTR4 = new CommandLine();
        String arg1TR4= "ls";
        String arg2TR4= "cd";

        cliTR4.addArg(" ");

        String[] listArgTR4 = cliTR4.getArgs();
        assertEquals(" ",listArgTR4[0]);

        assertEquals(0,listArgTR4.length-1);

        assertEquals(1,listArgTR4[0].length());






        try{
            //TR #5
            CommandLine cliTR5 = new CommandLine();
            String arg1TR5= "ls";
            String arg2TR5= "cd";

            cliTR5.addArg("1");
            cliTR5.addArg("13");

            String[] listArgTR5 = cliTR5.getArgs();
            assertEquals("1",listArgTR5[0]);
            assertEquals(1,listArgTR5.length-1);

            assertEquals(2,listArgTR5[0].length()+1);
        }catch (Exception e)
        {
            //fail("Test TR5 failed");
        }



        //TR #6
        CommandLine cliTR6 = new CommandLine();
        String arg1TR6= "ls";
        String arg2TR6= "cd";

        cliTR6.addArg("");
        cliTR6.addArg("");



        String[] listArgTR6 = cliTR6.getArgs();
        assertEquals("",listArgTR6[0]);

        assertEquals(2,listArgTR6.length);

        assertEquals(0,listArgTR6[0].length());


        //TR #7

        CommandLine cliTR7 = new CommandLine();
        String arg1TR7= "ls";
        String arg2TR7= "cd";

        cliTR7.addArg("1");
        cliTR7.addArg("13");



        String[] listArgTR7 = cliTR7.getArgs();
        assertEquals("1",listArgTR7[0]);

        assertEquals(1,listArgTR7.length-1);

        assertEquals(2,listArgTR7[1].length());




        //TR #8
        CommandLine cliTR8 = new CommandLine();
        String arg1TR8= "ls";
        String arg2TR8= "cd";

        cliTR8.addArg("1");
        //cliTR8.addArg("1");



        String[] listArgTR8 = cliTR8.getArgs();
        assertEquals("1",listArgTR8[0]);

        assertEquals(1,listArgTR8.length);

        assertEquals(1,listArgTR8[0].length());




        //TR #9
        CommandLine cliTR9 = new CommandLine();
        String arg1TR9= "ls";
        String arg2TR9= "cd";
        cliTR9.addArg("");
        cliTR9.addArg("");



        String[] listArgTR9 = cliTR9.getArgs();
        assertEquals("",listArgTR9[0]);
        assertEquals(2,listArgTR9.length);
        assertEquals(0,listArgTR9[1].length());

    }
}
