package io.utility;

import java.nio.file.Paths;

public abstract class BasicTest {

	protected static String BASE_PATH = Paths.get(".").toAbsolutePath().normalize().toString();

}
