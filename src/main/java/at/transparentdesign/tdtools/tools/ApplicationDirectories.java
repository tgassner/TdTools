package at.transparentdesign.tdtools.tools;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationDirectories {
    private static final Logger logger =
            Logger.getLogger(ApplicationDirectories.class.getName());

    private static final Path config;

    private static final Path data;

    private static final Path cache;

    static {
        String os = System.getProperty("os.name");
        String home = System.getProperty("user.home");

        if (os.contains("Mac")) {
            config = Paths.get(home, "Library", "Application Support");
            data = config;
            cache = config;
        } else if (os.contains("Windows")) {
            config = getFromEnv("APPDATA", false,
                    Paths.get(home, "AppData", "Roaming"));
            data = config;
            cache = getFromEnv("LOCALAPPDATA", false,
                    Paths.get(home, "AppData", "Local"));
        } else {
            config = getFromEnv("XDG_CONFIG_HOME", true,
                    Paths.get(home, ".config"));
            data = getFromEnv("XDG_DATA_HOME", true,
                    Paths.get(home, ".local", "share"));
            cache = getFromEnv("XDG_CACHE_HOME", true,
                    Paths.get(home, ".cache"));
        }
    }

    /** Prevents instantiation. */
    private ApplicationDirectories() {
    }

    /**
     * Retrieves a path from an environment variable, substituting a default
     * if the value is absent or invalid.
     *
     * @param envVar name of environment variable to read
     * @param mustBeAbsolute whether enviroment variable's value should be
     *                       considered invalid if it's not an absolute path
     * @param defaultPath default to use if environment variable is absent
     *                    or invalid
     *
     * @return environment variable's value as a {@code Path},
     *         or {@code defaultPath}
     */
    private static Path getFromEnv(String envVar,
                                   boolean mustBeAbsolute,
                                   Path defaultPath) {
        Path dir;
        String envDir = System.getenv(envVar);
        if (envDir == null || envDir.isEmpty()) {
            dir = defaultPath;
            logger.log(Level.CONFIG,
                    envVar + " not defined in environment"
                            + ", falling back on \"{0}\"", dir);
        } else {
            dir = Paths.get(envDir);
            if (mustBeAbsolute && !dir.isAbsolute()) {
                dir = defaultPath;
                logger.log(Level.CONFIG,
                        envVar + " is not an absolute path"
                                + ", falling back on \"{0}\"", dir);
            }
        }
        return dir;
    }

    /**
     * Returns directory where the native system expects an application
     * to store configuration files for the current user.  No attempt is made
     * to create the directory, and no checks are done to see if it exists.
     *
     * @param appName name of application
     */
    public static Path configDir(String appName)
    {
        return config.resolve(appName);
    }

    /**
     * Returns directory where the native system expects an application
     * to store implicit data files for the current user.  No attempt is made
     * to create the directory, and no checks are done to see if it exists.
     *
     * @param appName name of application
     */
    public static Path dataDir(String appName)
    {
        return data.resolve(appName);
    }

    /**
     * Returns directory where the native system expects an application
     * to store cached data for the current user.  No attempt is made
     * to create the directory, and no checks are done to see if it exists.
     *
     * @param appName name of application
     */
    public static Path cacheDir(String appName)
    {
        return cache.resolve(appName);
    }
}