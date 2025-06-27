import org.gradle.kotlin.dsl.add

tasks.withType<JavaCompile> {
    options.compilerArgs.add("-Dorg.sqlite.tmpdir=${project.buildDir}/sqlite-tmp")
}