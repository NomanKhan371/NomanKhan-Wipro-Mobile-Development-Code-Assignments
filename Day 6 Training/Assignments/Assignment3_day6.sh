#!/bin/bash

# Function to count and print the number of lines in a file
count_lines_in_file() {
    local filename=$1
    if [ -e "$filename" ]; then
        local line_count=$(wc -l < "$filename")
        echo "The file '$filename' has $line_count lines."
    else
        echo "The file '$filename' does not exist."
    fi
}

# Call the function with different filenames
count_lines_in_file "area.sh"
count_lines_in_file "loops.sh"
count_lines_in_file "nonexistentfile.txt"
