#!/bin/bash
set -e

echo "Setting up Java development environment..."

chmod +x ./gradlew

./gradlew --version

echo "Setup completed."