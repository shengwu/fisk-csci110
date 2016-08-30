#!/usr/local/bin/zsh
# Count the number of test cases in each student's tests

for folder in `ls`
do
    TESTS_SUBMITTED=`find $folder -maxdepth 1 -name "*Test.java"`
    if [ $TESTS_SUBMITTED ]
    then
        for testfile in `ls $folder/*Test.java`
        do
            echo $testfile: `grep -c "public void" $testfile`
        done
    fi
done
