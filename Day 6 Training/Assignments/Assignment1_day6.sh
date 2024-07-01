#!/bin/bash

#Ensure the script checks if a specific file (e.g., myfile.txt) exists in the current directory. 
#If it exists, print "File exists", otherwise print "File not found".
# Check if the file exists
if [ -e "myfile.txt" ]; then
    echo "File exists"
else
    echo "File not found"
fi
