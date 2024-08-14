package xyz.vdeltagabriel;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import xyz.vdeltagabriel.extensions.GradleJarSignerExtension;
import xyz.vdeltagabriel.tasks.SignTask;

public class GradleUtilsPlugin implements Plugin<Project> {
    public void apply(Project project) {
        project.getExtensions().create("jarSigner", GradleJarSignerExtension.class);
        project.getTasks().create("signJar", SignTask.class);
    }
}
