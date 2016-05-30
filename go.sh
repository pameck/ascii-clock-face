#!/bin/bash
command -v lein >/dev/null 2>&1 || { echo "I require lein but it's not installed.  You can download it from: http://leiningen.org/#install" >&2; exit 1; }

if [ -z "$1" ]
  then
    echo "What time do you want me to print?"
    read clockTime 
  else
    clockTime="$1"
fi

lein run "$clockTime"