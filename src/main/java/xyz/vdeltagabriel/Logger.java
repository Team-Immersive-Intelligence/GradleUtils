package xyz.vdeltagabriel;

public class Logger
{
	public enum LogLevel
	{
		DEBUG,
		INFO,
		WARN,
		ERROR,
		CRITICAL
	}

	public static void Log(LogLevel level, String message)
	{
		System.out.println("[GradleUtils/"+level.toString()+"] "+message);
	}

	public static void Debug(String message)
	{
		Log(LogLevel.DEBUG, message);
	}

	public static void Info(String message)
	{
		Log(LogLevel.INFO, message);
	}

	public static void Warn(String message)
	{
		Log(LogLevel.WARN, message);
	}

	public static void Error(String message)
	{
		Log(LogLevel.ERROR, message);
	}

	public static void Critical(String message)
	{
		Log(LogLevel.CRITICAL, message);
	}
}
