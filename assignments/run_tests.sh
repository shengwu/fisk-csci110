#!/usr/local/bin/zsh
# Runs tests in all student directories

# Example:
#
# IMPLEMENTATION="Greeter.java"
# TEST="GreeterTest"

# TODO: parse junit output
IMPLEMENTATION="Greeter.java"
TEST="GreeterTest"

for folder in `ls`
do
    # If the student submitted tests, save em in a folder called tmp
    TESTS_ALREADY_EXIST=`find $folder -maxdepth 1 -name "*Test.java"`
    if [ $TESTS_ALREADY_EXIST ]
    then
        mkdir -p $folder/tmp
        mv $folder/*.Test.java $folder/tmp/
    fi

    javac $folder/$IMPLEMENTATION $folder/$TEST_FILE.java
    java org.junit.runner.JUnitCore $folder/$TEST_FILE

    # Take student-submitted tests back out of tmp
    rm *Test.java
    if [ $TESTS_ALREADY_EXIST ]
    then
        mv $folder/tmp/* $folder/
        rmdir $folder/tmp
    fi
done
