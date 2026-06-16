# TiEL-ProgLanguage

TiEL Interpreter is an educational Java project for the Tiny Educational Language
(TiEL), used in compiler and language courses at THM Giessen.

TiEL (Tiny Educational Language) is a rudimentary programming language used in the
"Automata, Languages and Compilers" course at the MNI department of THM Giessen. It
supports functions, variables, mathematical expressions, and basic control flow
statements. Examples of TiEL programs can be found in the `examples` subfolder.

## Development Information

It is recommended to use IntelliJ IDEA when working with this project. The following
steps describe how the project can be set up. The project requires Java 25.

By default, the file `examples/hello_world.tiel` is used as input for the
interpreter. The file to be executed can be changed by adjusting the run
configuration.

## Creating a Portable JAR File

The project allows creating a portable JAR file using the
[Shadow Plugin](https://gradleup.com/shadow/) for Gradle. The following steps
describe how such a file can be generated:

1. Open the Gradle menu in IntelliJ.
2. Open `tiel-land/Tasks/shadow`.
3. Run `shadowJar`.

You can find the generated JAR file in the `build/libs/` folder under the name
`tiel-1.0-SNAPSHOT-all.jar`.

## Using the CLI (i.e., the Portable JAR File)

```text
Usage: tiel [-hV] [--ast] [--tokens] <input>
      <input>     Source code file to execute.
      --ast       Print generated AST.
  -h, --help      Show this help message and exit.
      --tokens    Print scanned tokens.
  -V, --version   Print version information and exit.
```

Example: `java -jar tiel-1.0-SNAPSHOT-all.jar --help`
