#!/bin/bash

if [ "$#" -ne 1 ]; then
    echo "Usage: $0 <java dir>"
    exit 1
fi

SCRIPT_DIR=$(dirname $0)

# Generate the plantuml file
java -jar ${SCRIPT_DIR}/java2plantuml.jar ${PWD}/$1

# Generate the image
java -jar ${SCRIPT_DIR}/plantuml-mit-1.2024.4.jar ${PWD}/output.puml

# Change the name and remove the utility files
cp ${PWD}/output.png ${PWD}/${1}_UML.png
rm ${PWD}/output.puml
rm ${PWD}/output.png
