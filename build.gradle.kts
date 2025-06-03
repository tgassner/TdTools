plugins {
    java
    application
    id("org.javamodularity.moduleplugin") version "1.8.12"
    id("org.openjfx.javafxplugin") version "0.0.13"
    id("org.beryx.jlink") version "2.25.0"
}

group = "at.transparentdesign"
version = "1.0.1"

repositories {
    mavenCentral()
}

val junitVersion = "5.10.2"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

application {
    mainModule.set("at.transparentdesign.tdtools")
    mainClass.set("at.transparentdesign.tdtools.TdToolsApplication")
}

javafx {
    version = "21"
    modules = listOf("javafx.controls", "javafx.fxml", "javafx.web", "javafx.swing" )
}

dependencies {
    implementation("org.controlsfx:controlsfx:11.2.1")
    implementation("com.dlsc.formsfx:formsfx-core:11.6.0") {
      exclude(group = "org.openjfx")
    }
    implementation("net.synedra:validatorfx:0.5.0") {
      exclude(group = "org.openjfx")
    }
    implementation("eu.hansolo:tilesfx:21.0.3") {
        exclude(group = "org.openjfx")
    }
    implementation("org.apache.commons:commons-lang3:3.17.0")
    implementation("org.apache.commons:commons-csv:1.14.0")

    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

jlink {
    imageZip.set(layout.buildDirectory.file("/distributions/TdTools-${javafx.platform.classifier}.zip"))
    options.set(listOf("--strip-debug", "--compress", "2", "--no-header-files", "--no-man-pages"))
    /* targetPlatform("linux-x64", "C:\\programm\\jdk-21.0.7+6_linux_x64_jdk_hotspot") */
    launcher {
        name = "TdTools"
    }
    jpackage {
        imageName = "TdTools"
        installerName = "TdToolsInstaller"
        installerType = "exe"
        appVersion = project.version.toString()
        icon = "src/main/resources/icon.ico"
    }
}

/*
runtime {
    options.set(listOf(
        "--strip-debug", "--compressed", "2", "--no-header-files", "--no-man-pages"
    ))
    modules.set(listOf("javafx.controls"))
    jpackage {
        imageName = "TdTools"
        installerName = "TdToolsInstaller"
        installerType = "exe"
        appVersion = project.version.toString()
        icon = "src/main/resources/icon.png"
    }
}
*/
