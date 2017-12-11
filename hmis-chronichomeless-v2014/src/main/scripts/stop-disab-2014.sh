#!/usr/bin/env bash
pid=$(ps aux | grep 2014 | grep -v "grep" | awk '{print $2}')
kill -9 $pid
