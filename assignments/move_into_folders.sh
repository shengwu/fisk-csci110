#!/usr/local/bin/zsh
# Run in an unzipped pack of submissions downloaded from Canvas.
# This will split each student's java files into a folder with his/her name.

for filename in `ls *.java`
do
    FOLDER=`echo $filename | awk -F _ '{print $1}'`
    FILE=`echo $filename | awk -F _ '{print $4}'`
    mkdir -p $FOLDER
    mv $filename $FOLDER/$FILE
done
