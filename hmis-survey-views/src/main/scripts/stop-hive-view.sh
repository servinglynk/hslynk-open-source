#!/usr/bin/env bash
pid=$(ps aux | grep com.servinglynk.servey.views.ActiveListView | grep -v "grep" | awk '{print $2}')
kill -9 $pid
