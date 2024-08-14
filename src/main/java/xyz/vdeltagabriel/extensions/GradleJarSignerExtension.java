package xyz.vdeltagabriel.extensions;

import groovy.lang.Closure;
import org.gradle.api.Project;
import org.gradle.api.tasks.bundling.Zip;
import xyz.vdeltagabriel.tasks.SignTask;

import java.io.File;
import java.util.function.Consumer;

public class GradleJarSignerExtension
{
	public String alias;
	public String storePass;
	public String timestampUrl;
	public String keyPass;
	public String keystoreData;
	public File keystoreFile;
	public File inputFile;
	public File outputFile;
}
