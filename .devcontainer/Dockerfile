FROM eclipse-temurin:21-jdk

WORKDIR /workspace

RUN apt-get update && apt-get install -y \
    git \
    curl \
    unzip \
    zip \
    vim \
    jq \
    && rm -rf /var/lib/apt/lists/*