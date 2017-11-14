#!/usr/bin/env bash
pid=$(ps aux | grep com.servinglynk.hmis.warehouse.SyncLive2017 | grep -v "grep" | awk '{print $2}')
kill -9 $pid
