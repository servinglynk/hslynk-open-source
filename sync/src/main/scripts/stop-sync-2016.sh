#!/usr/bin/env bash
pid=$(ps aux | grep com.servinglynk.hmis.warehouse.SyncMain2016 | grep -v "grep" | awk '{print $2}')
kill -9 $pid
