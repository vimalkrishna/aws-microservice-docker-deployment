# aws-microservice-docker-deployment
The project shows how to containerise microservices and deploy them on EC2 instances.
A monorepo structure has been used for deployment, where the root folder contains subfolders, each of which has individual microservices. 
Another possibility is Polyrepo using a GitHub organisation. Monorepo has distinct advantages. I use it often as it brings projects together and
for CI/CD, it is a convenient and acceptable structure for sharing with others and for a CI/CD pipeline like Jenkins.
The POC Microservices will be containerised, and Docker Compose and SWARM will be used to run on an EC2 instance.

The Jenkins pipeline will be straightforward because the repository is clean and adheres to best practices.
1.	Clone: Jenkins will clone the aws-microservice-docker-deployment.git repository.
2.	Navigate: The Jenkins job will navigate into the specific microservice directory (e.g., cd ms-eureka-registry).
3.	Build: It will run a clean Maven build (mvn clean package).
4.	Docker: It will use the Dockerfile in that directory to build a Docker image.
5.	Deploy: The image will be pushed to a registry and deployed to your AWS EC2 Swarm.

It will be useful to separate the aws-microservice-docker-deployment folder, containing the microservices and import it to another folder that has
workspace folder. From the workspace folder with IDE of your choice, import (Here a Maven project) and do the development work.
This way, you will be able to separate the workspace needs with all .metafiles from what you push to GitHub. 
This import links to the workspace, and any changes are reflected in the aws-microservice-docker-deployment folder for a clean push to GitHub.
