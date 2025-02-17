# Use the official Gradle image with JDK 21 for the build stage
FROM gradle:8.4.0-jdk21 AS build
WORKDIR /app

# Copy the Gradle build files first (for dependency download optimizations)
COPY build.gradle .
COPY settings.gradle .

# Download dependencies (optional but can help layer caching)
RUN gradle dependencies

# Now copy the source code
COPY src ./src

# Build the application
RUN gradle build --no-daemon

# ──────────────────────────────
# 2) Runtime Stage
# ──────────────────────────────
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copy the generated .jar from the build stage
COPY --from=build /app/build/libs/*.jar app.jar