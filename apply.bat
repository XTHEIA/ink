
SET PROJECT_NAME=ink
SET BUILD_APPEND=-0.0-all

SET BUILD_FILE_NAME = %PROJECT_NAME%%BUILD_APPEND%.jar
SET PATH_BUILT=C:\library\project\%PROJECT_NAME%\build\libs\%BUILD_FILE_NAME%
set DIR_SERVER=C:\library\minecraft\server\THEIA
set DIR_SERVER_PLUGINS=%DIR_SERVER%\plugins

xcopy "C:\library\project\ink\build\libs\ink-1.0-all.jar" "C:\library\minecraft\server\THEIA\plugins" /Y && exit