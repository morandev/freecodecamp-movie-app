# Use an official Node.js runtime as the base image
FROM node:14

# Set the working directory
WORKDIR /app

# Copy the package.json file
COPY frontend/package*.json ./

# Install the application dependencies
RUN npm install

# Copy the rest of the application code
COPY frontend/src/ .

# Build the application
RUN npm run build

# Run the application
CMD ["npm", "start"]