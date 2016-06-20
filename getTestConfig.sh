#!/bin/bash

testConfig="{ \"test_client_id\": \"$TEST_CLIENT_ID\", \"test_username\": \"$TEST_USERNAME\", \"test_password\": \"$1\" }"
echo $testConfig
echo $testConfig > testConfig.json
