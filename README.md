# Jetpack Compose Text-Based Game

An unfinished but functional Android game created entirely with Jetpack Compose. The game takes inspiration from other text-based mobile games and puts the player in the role of operating and managing a business.

## Architecture

This project was created with the hope of getting a better understanding of Clean Architecture with an MVVM Framework and using Dagger Hilt for dependency injection. 

### Features

Each aspect of the game is broken down into a feature and has a file structure like the one shown here:

📦feature_example\
 ┣ 📂data\
 ┃ ┣ 📂data_source\
 ┃ ┗ 📂repository\
 ┣ 📂di\
 ┣ 📂domain\
 ┃ ┣ 📂model\
 ┃ ┣ 📂repository\
 ┃ ┗ 📂use_case\
 ┗ 📂presentation\
 ┃ ┣ 📂components\
 ┃ ┣ 📂screens\
 ┃ ┣ 📂view_models\
