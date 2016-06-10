#!/bin/bash

testConfig="{ \"test_client_id\": \"$TEST_CLIENT_ID\", \"test_username\": \"$TEST_USERNAME\", \"test_password\": \"$TEST_PASSWORD\" }"
echo $testConfig
echo $testConfig > testConfig.json
