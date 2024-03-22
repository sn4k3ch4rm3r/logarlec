@echo off
FOR /R "src" %%G IN (*.java) DO (
	echo Building %%G
	javac -classpath src/main/java;src/skeleton/java -d build\bin %%G
)
echo Build complete