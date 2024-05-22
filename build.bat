@echo off
FOR /R "src/main" %%G IN (*.java) DO (
	echo Building %%G
	javac -encoding UTF-8 -classpath src/main/java -d build\bin %%G
)
echo Copying resources
xcopy .\src\main\resources\ .\build\bin\ /E /I /Y
echo Build complete