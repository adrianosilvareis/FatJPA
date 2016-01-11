@ECHO off
NET USE S: "\\192.168.0.8\mapeamento\dist"

xcopy S:\*.* "%PROGRAMFILES%\SFT - Sistema Faturamento Tommasi\" /Y /E

NET USE S: /delete /Y
@ECHO on

pause
EXIT