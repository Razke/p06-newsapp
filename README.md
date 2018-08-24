#### Table of Contents
<img align="right" width="100" height="100" src="https://raw.githubusercontent.com/Razke/p06-newsapp/master/app/src/main/res/mipmap-xxxhdpi/ic_launcher.png">

  1. [About](#about)
  2. [Resources used in this project](#resources-used-in-this-project)
  3. [Reflections](#reflections)

# About
This project is made up of **[Stage 1](#stage-1)** and **[Stage 2](#stage-2)**.

## Stage 1
Objective: create a **News feed app** which gives a user regularly-updated news from the internet related to a particular topic, person, or location. The presentation of the information as well as the topic is up to you.

For this stage, create an app to display recent news stories on a topic of your choice using an API.

**Note: the app is using a test key for The Guardian API. If the API rate limit has exceeded, you need to add your own API key to the code.**

NewsActivity **Stage 1**|EmptyView No News|EmptyView No Internet
:-------------------------:|:-------------------------:|:-------------------------:
<img src="https://i.imgur.com/0YGogm9.jpg" width="250" height="500"> | <img src="https://i.imgur.com/QkvsSHn.jpg" width="250" height="500"> | <img src="https://i.imgur.com/www1dS0.jpg" width="250" height="500">

This project is about combining various ideas and skills practiced throughout the course. They include:
* Connecting to an API
* Parsing the JSON response
* Handling error cases gracefully
* Updating information regularly
* Using an AsyncTask
* Doing network operations independent of the Activity lifecycle

## Stage 2
Objective: add a **Settings Screen** to the News Feed app you made earlier in Part 1 which will allow users to narrow down the stories displayed in from the feed. The available preference options presented to the user will be left up to you to decide (e.g. publishing time, country, topic category, etc. )

In this second and final stage, you'll add a preference screen to the News App you've already created.

**Note: the app is using a test key for The Guardian API. If the API rate limit has exceeded, you need to add your own API key to the code.**

NewsActivity Settings Menu Icon **Stage 2**|Settings Activity
:-------------------------:|:-------------------------:
<img src="https://i.imgur.com/BfAxKsB.jpg" width="255" height="500">  |  <img src="https://i.imgur.com/4U6RUDt.jpg" width="250" height="500">



This project is about combining various ideas and skills we’ve been practicing throughout the course. They include:

* Implement the Preference Fragment
* Launch a Settings Activity from a menu in the Main Activity
* Use Uri.Builder class to add query parameters to the URL
* Update and display the Preference Summary


## Resources used in this project
* [Changing onBackPressed animation](https://stackoverflow.com/a/12047942/8651044)

* [Checking if there is an app to open the intent](https://cloud.tencent.com/developer/article/1122024)

* [Registering for a Guardian API key](https://bonobo.capi.gutools.co.uk/register/developer)

* [Used TheGuardian Open Platform to generate query](https://open-platform.theguardian.com/explore/)

* [Fix for "Failed to load AppCompat ActionBar” error](https://stackoverflow.com/a/44858887/8651044)

* [Fade animations](https://stackoverflow.com/a/6822116/8651044)

* [Mentor review for Stage 1](https://review.udacity.com/#!/reviews/1416116/shared)

* [Mentor review for Stage 2 #1](https://review.udacity.com/#!/reviews/1417631/shared)

* [Mentor review for Stage 2 #2](https://review.udacity.com/#!/reviews/1418520/shared) - really pleased with the notes received from this review and the added challenge.

* Android Studio Plugins:
    * [CodeGlance](https://plugins.jetbrains.com/plugin/7275-codeglance)
    * [Key Promoter X](https://plugins.jetbrains.com/plugin/9792-key-promoter-x)
    * [Markdown Navigator](https://plugins.jetbrains.com/plugin/7896-markdown-navigator)
    * [Material Theme UI](https://plugins.jetbrains.com/plugin/8006-material-theme-ui)
    * [WIFI ADB ULTIMATE](https://plugins.jetbrains.com/plugin/9207-wifi-adb-ultimate)
    * [.ignore](https://plugins.jetbrains.com/plugin/7495--ignore)
    * [Presentation Assistant](https://plugins.jetbrains.com/plugin/7345-presentation-assistant)
    * [Android Drawable Importer](https://plugins.jetbrains.com/plugin/7658-android-drawable-importer)

## Reflections
* Had fun combining this project with things learned from the previous ones

[Back to Top](#table-of-contents)
