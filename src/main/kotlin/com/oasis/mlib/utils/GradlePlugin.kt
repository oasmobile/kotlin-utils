@file:Suppress("unused")
package com.oasis.mlib.utils

import org.gradle.api.Plugin
import org.gradle.api.Project

class GradlePlugin: Plugin<Project> {
    override fun apply(project: Project) {
        project.tasks.create("buildDist") { task->
            task.doLast {
                println("Build for project distribution")
            }
        }.apply {
            group = "distribution"
        }.dependsOn("build")
    }
}
