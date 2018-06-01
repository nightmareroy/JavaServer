
::Э���ļ�·��, ���Ҫ����\������
set SOURCE_FOLDER=.\ProtoSrc
::����ļ��������˱��proto�ļ���IMP_FOLDER�����õ�proto�ļ���Ŀ¼
::set IMP_FOLDER=.\ProtoSrc\Common
::Java������·��
set JAVA_COMPILER_PATH=.\ProtoToJava\bin\protoc.exe
::C#������·��
set CS_COMPILER_PATH=.\ProtoToCS\protogen.exe
::Java�ļ�����·��, ���Ҫ����\������
set JAVA_TARGET_PATH1=..\Center\proto
set JAVA_TARGET_PATH2=..\Game\proto
set CS_TARGET_PATH=..\TestCSProto

::ɾ��֮ǰ�������ļ�
del %JAVA_TARGET_PATH1%\*.* /f /s /q
del %JAVA_TARGET_PATH2%\*.* /f /s /q
del %CS_TARGET_PATH%\*.* /f /s /q
for /f "delims=" %%a in ('dir /ad/b/s %JAVA_TARGET_PATH1%') do (rd /q /s "%%a")
for /f "delims=" %%a in ('dir /ad/b/s %JAVA_TARGET_PATH2%') do (rd /q /s "%%a")
for /f "delims=" %%a in ('dir /ad/b/s %CS_TARGET_PATH%') do (rd /q /s "%%a")

::���������ļ�
for /f "delims=" %%i in ('dir /b "%SOURCE_FOLDER%\*.proto"') do (
  %JAVA_COMPILER_PATH% -I=%SOURCE_FOLDER%  --java_out=%JAVA_TARGET_PATH1% %SOURCE_FOLDER%\%%i
  %JAVA_COMPILER_PATH% -I=%SOURCE_FOLDER%  --java_out=%JAVA_TARGET_PATH2% %SOURCE_FOLDER%\%%i
  %CS_COMPILER_PATH% -i:%SOURCE_FOLDER%\%%i -o:%CS_TARGET_PATH%\%%~ni.cs

)


echo Э��������ϡ�





::.\ProtoTool\bin\protoc.exe -I=./ProtoSrc --java_out=../Center/proto test.proto
pause