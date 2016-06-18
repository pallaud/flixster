# Project 1 - Flixster

Flixster shows the latest movies currently playing in theaters. The app utilizes the Movie Database API to display images and basic information about these movies to the user.

Time spent: 9 hours spent in total

## User Stories

The following **required** functionality is completed:

* [ x] User can **scroll through current movies** from the Movie Database API

The following **optional** features are implemented:

* [x ] For each movie displayed, user can see the following details:
  * [ ] Title, Poster Image, Overview (Portrait mode)
  * [ ] Title, Backdrop Image, Overview (Landscape mode)
* [ x] Layout is optimized with the [ViewHolder](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView#improving-performance-with-the-viewholder-pattern) pattern.
* [ x] Display a nice default [placeholder graphic](http://guides.codepath.com/android/Displaying-Images-with-the-Picasso-Library#configuring-picasso) for each image during loading.
* [ x] Allow user to view details of the movie including ratings and popularity within a separate activity or dialog fragment.
* [ x] Improved the user interface by experimenting with styling and coloring.
* [ x] Apply rounded corners for the poster or background images using [Picasso transformations](https://guides.codepath.com/android/Displaying-Images-with-the-Picasso-Library#other-transformations)
* [ ] Apply the popular [Butterknife annotation library](http://guides.codepath.com/android/Reducing-View-Boilerplate-with-Butterknife) to reduce boilerplate code.
* [ ] Allow video trailers to be played in full-screen using the YouTubePlayerView from the details screen.

The following **additional** features are implemented:

* [ x] Add a 'favorite' button for users to mark movies they liked/want to watch

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='http://i.imgur.com/mcH7Bji.gifv' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

It was a challenge to work with images and style the UI precisely to get a polished look. Having worked with intents before, this time it was a smoother process.

## Open-source libraries used

- [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
- [Picasso](http://square.github.io/picasso/) - Image loading and caching library for Android

## License

    Copyright [yyyy] [name of copyright owner]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.