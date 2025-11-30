FROM maven:3.9.6-eclipse-temurin-21

WORKDIR /app
COPY . .

RUN apt-get update && apt-get install -y \
    wget \
    curl \
    unzip \
    ca-certificates

# Install Chrome for Testing + Driver (resmi Google)
RUN CHROME_VERSION=stable && \
    wget -q https://googlechromelabs.github.io/chrome-for-testing/last-known-good-versions-with-downloads.json -O /tmp/versions.json && \
    DRIVER_URL=$(cat /tmp/versions.json | grep -A 20 "\"Stable\"" | grep "chromedriver_linux64.zip" | head -n 1 | cut -d '"' -f 4) && \
    CHROME_URL=$(cat /tmp/versions.json | grep -A 20 "\"Stable\"" | grep "chrome-linux64.zip" | head -n 1 | cut -d '"' -f 4) && \
    wget -O /tmp/chrome.zip "$CHROME_URL" && \
    wget -O /tmp/driver.zip "$DRIVER_URL" && \
    unzip /tmp/chrome.zip -d /opt && \
    unzip /tmp/driver.zip -d /opt && \
    ln -s /opt/chrome-linux64/chrome /usr/bin/google-chrome && \
    ln -s /opt/chromedriver-linux64/chromedriver /usr/local/bin/chromedriver && \
    chmod +x /usr/local/bin/chromedriver

RUN mvn clean test -DskipTests
CMD ["mvn", "test"]
