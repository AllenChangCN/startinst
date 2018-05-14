#!/usr/bin/env bash

# docker run -it frontend sh

echo "building frontend image ..."
cd frontend
docker build -t frontend .

