import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test
import org.gradle.api.Project
import org.gradle.api.Task
import kotlin.test.assertTrue

class MainTest {
    @Test
    fun greeterPluginAddsGreetingTaskToProject() {
        val project: Project = ProjectBuilder.builder().build()
        project.pluginManager.apply("com.oasis.gradle.distribution")
        assertTrue(project.tasks.getByName("buildDist") is Task)
    }
}