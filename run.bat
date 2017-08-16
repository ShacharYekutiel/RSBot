@ECHO OFF
"C:\Program Files\Java\jre1.8.0_144\bin\java.exe" -Djava.search.path="C:\RSBot\out" -Dcom.jagex.config="http://runescape.com/l=en/jav_config.ws" -javaagent:"C:\RSBot\RSBot.jar" -jar "C:\RSBot\jagexappletviewer.jar" runescape
pause