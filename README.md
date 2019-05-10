# SENG 275 Te(s)tris Game

Welcome to SENG 275. We hope you'll have a wonderful time in this course exploring some essential tools often found in industry.

To start, here we have a Tetris game build in Java for you to test, continue to build, and integrate with other services.

## Working and Building Te(s)tris

There are various commands to help you develop your Testris game.

### Building

To create a jar SNAPSHOT, you can run:  
`./gradlew build` or, `./gradlew buildJar` (they are equivalent)

To create a versioned jar, run:  
`./gradlew releaseCurrVersion`

If you'd like to increment the version number and build a new jar, run one of:  
`./gradlew releasePatchVersion`  
`./gradlew releaseMinorVersion`  
`./gradlew releaseMajorVersion`

To read up on how semantic versioning works, check out [this source](https://semver.org/).

### Running

While developing you can use:  
`./gradlew run`  
to run the program with your current state of code.

If you already have a jar built, you can run:  
`java -jar <path_to_jar>`  
to run the prebuilt code

## Technologies

### Gradle

Gradle is a package and build manager for Java. It allows for dependency version tracking, automated imports, and test & build script configuration.

### Gradle Wrapper

Graddle Wrapper in short is a Gradle runner and version manager. For more details check out [this link](http://kevinpelgrims.com/blog/2015/05/25/use-the-gradle-wrapper-for-your-android-projects/_).

### Git

A widely used version control system. Developped by Linus Torvald, popularized by GitHub, and also used by coding repository platforms such as BitBucket, and what we'll be using, GitLab. Git allows for distributed and asynchronous code development. For futher readings, check out Atlassian's [Git guide](https://www.atlassian.com/git/).

### GitLab

As mentioned above, we are using GitLab as our cloud coding repository platform. It allows users to manage and share code versions and progress, fork other projects, track issues, and build continuous integration and deployment pipelines.
