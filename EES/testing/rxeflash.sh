echo Executing NeXTTool to upload nxtrobotmain_OSEK.rxe...
nexttool /COM=usb -download=nxtrobotmain_OSEK.rxe
FILE=`nexttool /COM=usb -listfiles=nxtrobotmain_OSEK.rxe`
echo $FILE
if [ "$FILE" != "" ] ; then
  echo File helloworld_OSEK.rxe successfully uploaded to brick.
else
  LIST=`nexttool -listbricks`
  if [ "$LIST" == "" ] ; then
    echo ERROR: Cannot find brick. Check connection and switch the brick on.
  else
    echo ERROR: Unable to upload file.
  fi
fi
echo NeXTTool is terminated.
