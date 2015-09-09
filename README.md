# bulk-loader
Code for importing big HMIS CSV, XML, and someday soon, JSON files.  bulk-loader stages the data, dedupes, and loads the records into the operational database, keeping logs of the activity, so rollback of an import can happen.
