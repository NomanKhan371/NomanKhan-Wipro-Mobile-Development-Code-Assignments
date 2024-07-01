#!/bin/bash
# Write a script that reads numbers from the user until they enter '0'. The script should also print whether each number is odd or even.

while true; do
    read -p "Enter a number (0 to quit): " number

    # Check if the number is 0
    if [ "$number" -eq 0 ]; then
        echo "Exiting..."
        break
    fi

    # Check if the number is odd or even
    if [ $((number % 2)) -eq 0 ]; then
        echo "The number $number is even."
    else
        echo "The number $number is odd."
    fi
done