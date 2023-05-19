# Overall Architechture

![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/4c9169f5-3b1f-41cb-a73b-bee42dbbaa02)

# Cashiers App

![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/a4e3e592-664d-4acc-bbd2-fa7c7312f625)


In my project the cashiers app is refered to as the starbucks client. I ported the nodeJS version of the client and recreated it as a Spring MVC application. This application was initially wrapped up as a jar using maven and deployed to a docker container.

![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/49cac3d4-fb93-432b-bbba-b6c32332943b)

Now, with GKE, the image is uploaded to my cloud project, and the client is able to be accessed through it's public IP address. The buttons on the client have been coded as REST API calls that go through KONG Authentication.

![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/39366cac-b697-4d36-96c6-70c5ab3245a7)


After the API call is authenticated, it will be sent to the starbucks API. New login and registration pages were created, however they were not implemented in the final demo recording.
# Starbucks REST API

![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/a8c1cd21-a975-4e74-bbab-e786c8f6a3db)


The Starbucks Rest API folder was heavily modififed for this project. New models, Repositiories, and Controllers were made for User login and registration, however I was unable to fully implement it before the final demo. The origional starbucks REST API was modified to work with my program. Origionally data was stored in a hashmap for the API, and that ahs been removed for the final version.

![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/1dc9ee9c-0492-4ffb-8a8b-20fdb171ae93)

# Cloud Deployments

![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/91f3d339-4850-48c2-a389-ed83e88d02f4)

I was able to 'successfully' deploy my project on GKE. However, I am constantly running into issues regarding the heathchecks of my services. Although this was a persistent, irregullarly occuring problem, I was able to get the whole thing up and running on the cloud, as can be seen in my demo recording.

![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/36538c69-faa4-4e2b-bfa7-68fb706deca2)

![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/2bbafc5e-cfb4-4f52-b864-8d2b2d1a939a)


I had to use kompose to convert my origional dockercompose.yaml into the required files needed to run my project on GKE. The kompose process was relatively clean, however I had to do some cleaning up and wiring to make sure everythign worked as intended.

![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/478dd964-319d-42ba-93fe-8667e067673b)

# Technical Requirements

Cashier's App - Cashiers App Deployed and running on GKE PODS (2 points)

![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/1cc47b9e-7850-484e-8074-7e703c88f110)
![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/9c5dd735-17f5-4a82-a484-80ea6398aca0)


Cashier's App - Rendering must use MVC by processing REST API calls from Starbucks API via Kong Gateway on GCP (5 points)

![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/a88f0133-9044-47be-a099-9a27f3a11112)


Cashier's App - Order Created via REST API call to Kong Endpoint with API key running on GCP (5 points)

![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/dac785a3-9fe0-4b1b-a149-ddfe50dde1d5)


Cashier's App - Order Payment Reflected on UI with Updated Balance Paid by Mobile App (5 points) (More Visible During Demo)

![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/ff7008b2-6ac5-49c0-a7c5-ef025583cba5)
![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/6b29fb8a-bfff-41fd-bf8b-fc2e47b7e782)

GCP Cashier's App LB - External IP of Load Balancer used for Demo/Screnshots of Cashier's App (1 point)

![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/578b3039-e282-4175-bd2e-ea06c09ebb8a)\

GCP Cashier's App LB - Evidence of Load Balancer with Heahtly Backends on GCP / GKE (2 points)

![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/14573d44-ce63-4f1d-a94d-52ba5621affe)
![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/78865f89-be9c-4f0a-af36-0c93c608a7d6)

GCP Starbucks API Internal LB - Evidence of Healthy Running Starbucks API Pods in GKE (2 points)

![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/0cc2cc51-f1e8-43d4-bcc7-c914c57db55f)

GCP Starbucks API Internal LB - Evidence of Reachability Tests via Ping API call with Kong API key to Service Endpoint (10 points)

![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/d5a2cf9f-6717-4ab3-b91f-ee673a3449f3)

MySQL Cloud SQL - Evidence of Running MySQL Instance on Cloud SQL (5 points)

![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/02e09843-8a45-4d75-819d-4ac760609ac2)

MySQL Cloud SQL - Evidence that MySQL IP is used by Cashier's App to Persist Order Data (Spring JPA Requirement) (5 points)

![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/52995602-0e77-4092-97a3-c84890be8728)

MySQL Cloud SQL - Evidence that Data Stored in MySQL DB cooresponds to Data visible on Web UI (5 points)(more visible during Demo)

![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/ff7008b2-6ac5-49c0-a7c5-ef025583cba5)
![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/ba9ef6ae-f51b-4f8b-a321-a7a091c01cd4)

Kong Connection - Moible App should be connected to Starbucks API via Kong using API key (demo'ed during startup of Mobile App) (15 points)

![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/43f307e7-afe8-4c8d-a341-6c3bb39a7f31)

Kong Connection - Cashier's App and other Apps in Demo must connect to Starbucks API via Kong using API Key (5 points)

![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/7bebc6fd-bd74-443c-b329-7fd47466ec9b)
![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/e3b05368-b3cf-4f63-99e5-5c6cd0b02f64)
![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/afe202ea-244d-4ba2-9a05-fad4429210b7)
![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/250adc61-0cad-497d-b0d2-9d294821731c)

Kong API Auth - Source code for Apps shows evidence that REST API requests are using API Key Auth (5 points)

![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/e81dd33d-a72a-416f-b93e-ece2840aae11)
![image](https://github.com/MarkSaweres/Starbucks/assets/46986292/400115bf-5d38-429a-ad85-b6c0c5cb9b1c)


# Extra Credit Awards

I believe I may be an honorable mention for the enterprise quality award for creating this on a windows machine.

# Journal Entries

https://github.com/MarkSaweres/StarbucksProject for prior commits, split the repo up about a week ago

April 26 - May 5:

Download the project, and couldn't get it to run. Tried to get the various java verisons correct for the project, but couldn't.

May 5 - May 7:

Got the application to run, through a lot of bugfixing. This is around the time my gitPod trial ran out, and moved the project over to IntelliJ. Project mostly working on docker. Ported Node JS version of project to Spring MVC. Still had issues running the mobile application

May 7 - May 8:

Got application to run with the rest of the program while on docker. Mobile Application needed work to use REST API calls.

May 8 - May 9:

Began working on Auth using REST API and session cookies. The session cookie will only hold username, and not any confidential data. program will check if the cookie has a username, if not, send to login/register page.

May 9 - May 11:

Auth Repository, Controller, adn service built, along with REST calls and HTML pages.

May 11 - May 13:

Began working on implementing KONG. First time trying to implement it in a project, it took some time to uderstand. However, I was able to make good progress.

May 13 - May 14:

Kong API working with docker. Whole system functions correctly over docker using KONG API Gateway. Began researching how to implement GKE.

May 14 - May 15:

Through my research, came to the conclusion that we need to use Kompose to convert my docker compose file into files used for Kubernetes. Because my whole program was created using docker-compose up, it posed as a problem for me to deploy it to GKE. However, this was a workable solution for me.

May 15 - May 16:

GKE mostly working , still needs a lot of work to completely connect everything together. Constant issues with HealthChecks.

May 16 - May 17:

GKE progress is getting better. Found workaround for healthcheck issues, however they are very temporary and revert to origional settings after 5-10 minutes. 

May 17 - May 18:

GKE fully working, just with some small healthChekc issues for KONG. All other services and ingresses haved worked great. Mobile App connected through KONG on GKE. Final day of Commits







