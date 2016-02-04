#!/bin/bash -i


function hist() {
    history
}

HISTFILE=/home/alpc/.bash_history  # Or wherever you bash history file lives
set -o history             # enable history


hist
str=`history`
echo $str

