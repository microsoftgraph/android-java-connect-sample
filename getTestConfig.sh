#!/bin/bash

testConfig="{ \"test_client_id\": \"${test_client_id}\", \"test_username\": \"${test_username}\", \"test_password\": \"${test_password}\" }"
echo $testConfig
echo $testConfig > testConfig.json
echo "AGENT_WORKFOLDER is $AGENT_WORKFOLDER"
echo "test_client_id_1 is $BUILD_TEST_CLIENT_ID"
echo "test_client_id_2 is $BUILD_test_client_id"
echo "test_client_id_3 is $test_client_id"
echo "test_client_id_4 is $TEST_CLIENT_ID"
