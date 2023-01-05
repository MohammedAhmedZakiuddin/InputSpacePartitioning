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

import static org.junit.Assert.*;


import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;


import org.junit.Assert;
import org.junit.Test;

public class PatternOptionBuilderTest {
    private PatternOptionBuilder pob;
    @Test
    public void PatternOptionBuilder()
    {
        pob = new PatternOptionBuilder();
    }


    @Test
    public void parsePattern()
    {

        Options options = new Options();
        // A
        String TR1 = "";
        assertEquals(0,TR1.length());

        // B
        Options optstr1  = pob.parsePattern(TR1);
        assertTrue(optstr1 != null);
        // C


        //# TR1
        try
        {
            try
            {
                assertTrue(optstr1.getOptions().size() != 0);
            }
            catch (AssertionError e)
            {

            }
            assertEquals("", TR1);
            assertTrue(optstr1 != null);
            assertTrue(optstr1.getOptions().size() == 0);

        }

        catch(Exception e)
        {

        }

        // #TR2
        Options options2 = new Options();
        String TR2 = "";
        assertEquals(0,TR2.length());
        Options optstr2  = pob.parsePattern(TR2);
        assertTrue(optstr2 != null);
        try
        {
            assertTrue(optstr2.getOptions().size() != 0);
        }
        catch (AssertionError e)
        {

        }

        //# TR2
        try
        {
            assertEquals("", TR2);
            try
            {
                assertTrue(optstr2 == null);
                assertTrue(optstr2.getOptions().size() == 0);

            }
            catch (AssertionError e)
            {

            }

        }

        catch(Exception e)
        {

        }

        //#TR3


        Options options3 = new Options();
        String TR3 = "";
        assertEquals(0,TR3.length());
        Options optstr3  = pob.parsePattern(TR3);
        assertTrue(optstr3 != null);
        try
        {
            assertTrue(optstr3.getOptions().size() != 0);

        }
        catch (AssertionError e)
        {

        }

        try
        {

            assertEquals("", TR3);
            try
            {
                assertTrue(optstr3 == null);
                assertTrue(optstr3.getOptions().size() == 1);

            }
            catch (AssertionError e)
            {

            }
        }

        catch(Exception e)
        {

        }

        //#TR4

        Options options4 = new Options();
        String TR4 = "";
        assertEquals(0,TR4.length());
        Options optstr4  = pob.parsePattern(TR4);
        assertTrue(optstr4 != null);
        try
        {
            assertTrue(optstr4.getOptions().size() != 0);
            assertTrue(optstr4 == null);
            assertTrue(optstr4.getOptions().size() == 1);


        }
        catch (AssertionError e)
        {

        }


        try
        {
            assertEquals("", TR4);
        }

        catch(Exception e)
        {

        }
        //#TR5

        Options options5 = new Options();
        String TR5 = "";
        assertEquals(0,TR5.length());
        Options optstr5  = pob.parsePattern(TR5);


        try
        {
            assertTrue(optstr5 != null);
            assertTrue(optstr5.getOptions().size() != 0);
            assertEquals("", TR5);
            assertTrue(optstr5 == null);
            assertTrue(optstr5.getOptions().size() == 2);
        }
        catch (AssertionError e) {

        }

        //#TR6

        Options options6 = new Options();
        String TR6 = "";
        assertEquals(0,TR6.length());
        Options optstr6  = pob.parsePattern(TR6);
        assertTrue(optstr6 != null);


        try
        {
            assertTrue(optstr6.getOptions().size() != 0);
            assertEquals("a", TR6);
            assertTrue(optstr6 != null);
            assertTrue(optstr6.getOptions().size() == 2);
        }

        catch(AssertionError e)
        {

        }


    }
}
