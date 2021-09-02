# Report First Assignment - DAT250
### installing JDE
I first installed the java Development Environment
Then I downloaded the maven zip and extracted it in a specific folder
> I had some issues with installing Maven correctly, but I forgot to add maven to the path of my system variables.

I checked whether my development environment was working by entering the following commands:
* java -version
* echo %JAVA_HOME%
* mvm -version
### downloading & learning Heroku
Then I proceeded to download Heroku.
After installing heroku I logged in to it, using the web browser.
Then I cloned the sample application from Heroku, created an heroku app and deployed my code.
I checked whether my application was working by typing heroku open, which opened the web browser and showed my newly
created application.
After deploying my application I learned some more about logs,procfiles and scaling up the application.
After reading about the app dependencies I ran mvn clean install to prepare my system to run the app locally.
Then I ran the command heroku local web and my app was visible on localhost after this.
Now I needed to push my local changes, so I first made some changes in my application (by adding a new page).
After running mvn clean install and heroku local web again the changes where pushed locally, which worked.
Then I proceeded to do the basic git commands:
* git add .
* git commit -m "demo"
* git push heroku main
* heroku open hello

When I ran these commands my browser opened on the hello page
Then I learned some more about config vars and how to keep them secure, I also learned some more about one-off dynos
After this I initiated some add-ons, but I needed a creditcard for this so I skipped this step.
Then I learned how to work with a database (Postgresql) in heroku.
> the command heroku pg:psql didn't work so I had to install postgres locally
## URL to Heroku App
[Application](https://fierce-inlet-82737.herokuapp.com/)
