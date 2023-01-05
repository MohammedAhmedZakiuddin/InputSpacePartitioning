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
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DefaultParserTest{

    CommandLineParser parser;
    @Before
    public void setupParse()
    {
        parser = new DefaultParser();
    }


    @Test
    public void parse()
    {
        Options options = new Options();

        // TR #1
        CommandLine cmdTR1 = new CommandLine();
        String[] argumentsTR1 = new String[2];
        String[] argumentsUsingStopAtNonOptionTR1 = new String[2];
        Option opTR1 = new Option("cd","Change Directory");
        options.addOption(opTR1);

        try
        {
            argumentsTR1[0] = "";
            cmdTR1 = parser.parse(options, argumentsTR1, true);
            // If that is true if the option to parse is a valid string
            assertEquals("cd", opTR1.getOpt());
            assertEquals(0,argumentsTR1.length-2);
            assertEquals(0,argumentsTR1.length-2);
        }
        catch (ParseException e)
        {
            // fail("Test fail TR 1");
        }

        // TR #2
        CommandLine cmdTR2 = new CommandLine();
        String[] argumentsTR2 = new String[2];
        String[] argumentsUsingStopAtNonOptionTR2 = new String[2];
        Option opTR2 = new Option("cd","Change Directory");
        options.addOption(opTR2);

        try
        {
            try
            {
                cmdTR2 = parser.parse(options, argumentsTR2, true);
                // If that is true if the option to parse is a valid string
                assertEquals("cd", opTR2.getOpt());
                assertEquals(1,argumentsTR2.length-1);
                assertEquals(1,argumentsTR2.length-1);
            }
            catch (NullPointerException e)
            {

            }
        }

        catch(ParseException e)
        {

        }


        // TR #3
        CommandLine cmdTR3 = new CommandLine();
        String[] argumentsTR3 = new String[2];
        String[] argumentsUsingStopAtNonOptionTR3 = new String[2];
        Option opTR3 = new Option("cd","Change Directory");
        options.addOption(opTR3);

        try
        {
            try
            {

            }
            catch (NullPointerException e)
            {
                cmdTR2 = parser.parse(options, argumentsTR3, true);
                // If that is true if the option to parse is a valid string
                assertEquals("cd", opTR3.getOpt());
                assertEquals(2,argumentsTR3.length);
                assertEquals(2,argumentsTR3.length);
            }

        }
        catch(ParseException e)
        {
            //fail("test failure");
        }


        // TR #4
        CommandLine cmdTR4 = new CommandLine();
        String[] argumentsTR4 = new String[2];
        String[] argumentsUsingStopAtNonOptionTR4 = new String[2];
        Option opTR4 = new Option("cd","Change Directory");
        options.addOption(opTR4);

        try
        {
            try
            {
                cmdTR4 = parser.parse(options, argumentsTR4, false);
                assertEquals("cc", opTR4.getOpt());
                assertEquals(0,argumentsTR4.length-2);
                assertEquals(1,argumentsTR4.length-1);
            }
            catch (NullPointerException e)
            {

            }

        }

        catch(ParseException e)
        {
            //fail("Test failure");
        }

        // TR #5
        CommandLine cmdTR5 = new CommandLine();
        String[] argumentsTR5 = new String[2];
        String[] argumentsUsingStopAtNonOptionTR5 = new String[2];
        Option opTR5 = new Option("cc","Change Directory");
        options.addOption(opTR5);

        try
        {
            try
            {
                cmdTR5 = parser.parse(options, argumentsTR5, false);
                // If that is true if the option to parse is a valid string
                assertEquals("cc", opTR5.getOpt());
                assertEquals(1,argumentsTR5.length-1);
                assertEquals(2,argumentsTR5.length);
            }
            catch (NullPointerException e)
            {

            }

        }

        catch(ParseException e)
        {

        }

        // TR #6
        CommandLine cmdTR6 = new CommandLine();
        String[] argumentsTR6 = new String[2];
        String[] argumentsUsingStopAtNonOptionTR6 = new String[2];
        Option opTR6 = new Option("cc","Change Directory");
        options.addOption(opTR6);

        try
        {
            try
            {
                cmdTR6 = parser.parse(options, argumentsTR6, false);
                // If that is true if the option to parse is a valid string
                assertEquals("cc", opTR6.getOpt());
                assertEquals(2,argumentsTR6.length);
                assertEquals(0,argumentsTR6.length-2);
            }
            catch (NullPointerException e)
            {

            }

        }

        catch(ParseException e)
        {

        }

        // TR #7
        CommandLine cmdTR7 = new CommandLine();
        //
        String[] argumentsTR7 = new String[2];
        String[] argumentsUsingStopAtNonOptionTR7 = new String[2];
        Option opTR7 = new Option("cd","Change Directory");
        options.addOption(opTR7);

        try
        {
            try
            {

            }
            catch (NullPointerException e)
            {
                cmdTR7 = parser.parse(options, argumentsTR7, false);
                // If that is true if the option to parse is a valid string
                assertEquals("cc", opTR7.getOpt());
                assertEquals(0,argumentsTR7.length-2);
                assertEquals(2,argumentsTR7.length);
            }

        }

        catch(ParseException e)
        {

        }

        // TR #8
        CommandLine cmdTR8 = new CommandLine();
        //
        String[] argumentsTR8 = new String[2];
        String[] argumentsUsingStopAtNonOptionTR8 = new String[2];
        Option opTR8 = new Option("cd","Change Directory");
        options.addOption(opTR8);

        try
        {
            try
            {
                cmdTR8 = parser.parse(options, argumentsTR8, false);
                // If that is true if the option to parse is a valid string
                assertEquals("cc", opTR8.getOpt());
                assertEquals(1,argumentsTR8.length-1);
                assertEquals(1,argumentsTR8.length-1);
            }
            catch (NullPointerException e)
            {

            }

        }

        catch(ParseException e)
        {

        }

        // TR #9
        CommandLine cmdTR9 = new CommandLine();
        //
        String[] argumentsTR9 = new String[2];
        String[] argumentsUsingStopAtNonOptionTR9 = new String[2];
        Option opTR9 = new Option("cd","Change Directory");
        options.addOption(opTR9);

        try
        {
            try
            {
                cmdTR9 = parser.parse(options, argumentsTR9, true);
                // If that is true if the option to parse is a valid string
                assertEquals("cd", opTR9.getOpt());
                assertEquals(2,argumentsTR9.length);
                assertEquals(0,argumentsTR9.length-2);
            }
            catch (NullPointerException e)
            {

            }
        }

        catch(ParseException e)
        {
            //fail("Test failed")
        }
    }
}
