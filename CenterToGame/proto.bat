
::Э���ļ�·��, ���Ҫ����\������
set SOURCE_FOLDER=.\ProtoSrc
::����ļ��������˱��proto�ļ���IMP_FOLDER�����õ�proto�ļ���Ŀ¼
::set IMP_FOLDER=.\ProtoSrc\Common
::Java������·��
set JAVA_COMPILER_PATH=.\ProtoTool\bin\protoc.exe
::Java�ļ�����·��, ���Ҫ����\������
set JAVA_TARGET_PATH=..\Center\proto


::ɾ��֮ǰ�������ļ�
del %JAVA_TARGET_PATH%\*.* /f /s /q
for /f "delims=" %%a in ('dir /ad/b/s %JAVA_TARGET_PATH%') do (rd /q /s "%%a")


::���������ļ�
for /f "delims=" %%i in ('dir /b "%SOURCE_FOLDER%\*.proto"') do (
    
    %JAVA_COMPILER_PATH% -I=%SOURCE_FOLDER%  --java_out=%JAVA_TARGET_PATH% %SOURCE_FOLDER%\%%i
    %JAVA_COMPILER_PATH% --proto_path=%SOURCE_FOLDER%  --java_out=%JAVA_TARGET_PATH% %SOURCE_FOLDER%\%%i
    
)


echo Э��������ϡ�





::.\ProtoTool\bin\protoc.exe -I=./ProtoSrc --java_out=../Center/proto test.proto
pause