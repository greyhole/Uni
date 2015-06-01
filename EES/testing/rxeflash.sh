echo Executing NeXTTool to upload helloworld_OSEK.rxe...
nexttool /COM=usb -download=helloworld_OSEK.rxe
FILE=`nexttool /COM=usb -listfiles=helloworld_OSEK.rxe`
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
