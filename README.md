<div id="title" align="center">
  <h1>Notify Hub</h1>
</div>

<div id="badges" align="center">
  
  ![License](https://img.shields.io/github/license/georgejrdev/Notify-Hub.svg)
  ![Version](https://img.shields.io/badge/version-1.0.1-53918E.svg)
  ![Windows](https://img.shields.io/badge/made%20in-java-AD6845.svg)

</div>

<br>
<br>

## How to use

In docker-compose.yml there is an example of how to upload the service.

You need to use the service image available on docker hub: noxusjr/notify-hub:1.0.0

### You need to configure 3 environment variables: 

    EMAIL: YOUR EMAIL


    EMAIL_APP_PASSWORD: YOUR PASS


    EMAIL_SERVER: YOUR EMAIL SERVER (Ex- gmail, outlook, etc)

## EndPoints

### sendEmail:

Method: Post

Parameters: subject, body, to (recipient email)