package pl.com.tt.unittesting;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class AppTest {
    public App app = new App();

    @Test
    public void shouldReturnHelloString() {
    }

    @Test
    public void shouldReturnHelloString2() {
    }

    @Test
    public void testWitTempFolderRule() throws IOException {
	}
}
