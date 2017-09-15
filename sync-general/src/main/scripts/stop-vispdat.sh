#!/usr/bin/env bash
pid=$(ps aux | grep com.servinglynk.hmis.warehouse.ViSpdatView | grep -v "grep" | awk '{print $2}')
kill -9 $pid
