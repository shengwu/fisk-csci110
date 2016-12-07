#!/usr/local/bin/zsh
# Run in an unzipped pack of submissions downloaded from Canvas.
# This will split each student's java files into a folder with his/her name.

# Sometimes there are spaces in filenames
SAVEIFS=$IFS
IFS=$(echo -en "\n\b")

for filename in `ls`
do
    # A new filename with "late_" removed
    sfilename=`echo $filename | sed s/late_//`
    FOLDER=`echo $sfilename | awk -F _ '{print $1}'`
    FILE=`echo $sfilename | awk -F _ '{print $4}'`
    mkdir -p "$FOLDER"
    mv "$filename" "$FOLDER/$FILE"
done

IFS=$SAVEIFS
