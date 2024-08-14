package xyz.vdeltagabriel.tasks;

import groovy.lang.Closure;
import groovy.util.MapEntry;
import org.gradle.api.DefaultTask;
import org.gradle.api.Task;
import org.gradle.api.file.FileTreeElement;
import org.gradle.api.file.FileVisitDetails;
import org.gradle.api.file.FileVisitor;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.Property;
import org.gradle.api.specs.Spec;
import org.gradle.api.tasks.Internal;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.tasks.TaskInputs;
import org.gradle.api.tasks.bundling.Zip;
import org.gradle.api.tasks.util.PatternFilterable;
import org.gradle.api.tasks.util.PatternSet;
import xyz.vdeltagabriel.extensions.GradleJarSignerExtension;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.Map.Entry;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class SignTask extends DefaultTask
{
	@TaskAction
	public void action()
	{
		GradleJarSignerExtension extension = getProject().getExtensions().findByType(GradleJarSignerExtension.class);
		if (extension == null) extension = new GradleJarSignerExtension();

		Map<String, String> map = new HashMap<>();
		map.put("alias", extension.alias);
		map.put("storePass", extension.storePass);
		map.put("jar", extension.inputFile.getAbsolutePath());
		map.put("signedJar", extension.outputFile.getAbsolutePath());
		map.put("keyStore", extension.keystoreFile.getAbsolutePath());
		if (extension.timestampUrl != null)
			map.put("tsaurl", extension.timestampUrl);
		if (extension.keyPass != null)
			map.put("keypass", extension.keyPass);

		try {
			getProject().getAnt().invokeMethod("signjar", map);
		} finally {
			/*
			if (!this.keyStoreFile.isPresent())
				keyStore.delete();
			 */
		}
	}
}
