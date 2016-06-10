#!/bin/bash

testConfig="{ \"test_client_id\": \"${test_client_id}\", \"test_username\": \"${test_username}\", \"test_password\": \"${test_password}\" }"
echo $testConfig
echo $testConfig > testConfig.json
echo "AGENT_WORKFOLDER is $AGENT_WORKFOLDER"
