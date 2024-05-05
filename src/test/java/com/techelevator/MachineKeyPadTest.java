package com.techelevator;

import com.techelevator.constructs.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class MachineKeyPadTest {

    private String mockedUserStringInput = "TEST";
    private String mockedUserIntInput = "3";
    private MachineKeyPad machineKeyPad;
    private ByteArrayOutputStream outStream;

    @Before
    public void setUp() {
        machineKeyPad = new MachineKeyPad(new InputStreamReader(System.in));
        outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));
    }

    @After
    public void cleanUp() {
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    public void machine_keypad_instance_should_not_be_null() {
        assertNotNull("MachineKeyPad instance should not be null", machineKeyPad);
    }
}
