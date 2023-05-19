# Overall Architechture



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

# Extra Credit Awards
I believe I may be an honorable mention for the enterprise quality award for creating this on a windows machine.
# Journal Entries

