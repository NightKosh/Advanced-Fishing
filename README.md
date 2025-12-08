# Advanced Fishing [![Curseforge](http://cf.way2muchnoise.eu/full_advanced-fishing_downloads.svg)](https://minecraft.curseforge.com/projects/advanced-fishing) [![Curseforge](http://cf.way2muchnoise.eu/versions/For%20MC_advanced-fishing_all.svg)](https://minecraft.curseforge.com/projects/advanced-fishing)

This mod adds new 43 fishes, blaze fishing rod, luck potion recipe, experience bottle recipe and overrides fishing mechanics. All new and vanilla fishes can be caught only in own types of biomes, dimensions and liquids.

![advanced_fishing](https://user-images.githubusercontent.com/4181327/46245962-92192b80-c3ff-11e8-9f61-02d8ef7eb9e7.png)

## Luck potion recipe

![luck_potion](https://user-images.githubusercontent.com/4181327/45934183-23714380-bfa3-11e8-8d02-37cb78e65472.png)


## Crafting recipes

![fish_recipes](https://user-images.githubusercontent.com/4181327/46245968-9fceb100-c3ff-11e8-956b-ad451c2c9eb8.png)


## Minecraft versions
"Master branch" contains mod sources for the latest version of the Minecraft I'm working on. Any previous versions contains in an own branches.

## Requirements
1. [Forge](http://files.minecraftforge.net/) (check "build.gradle" file to know required forge version)
2. [jdk 1.17](https://jdk.java.net/archive/) (do not forget to enable its support in your IDE)
3. [Gradle 8.14.3](https://gradle.org/releases/)


## Get started
1. Clone mod repository
2. [Download forge](http://files.minecraftforge.net/) and copy "gradlew.bat", "gradlew" files and "gradle" directory to mod folder(and any other files which may requires)
3. Download MDK from forge
4. Import mod to your ide as "new Gradle project"

## Gradle commands
1. Download MDK from forge
   for eclipse:
    ```
        gradlew genEclipseRuns
    ```
   for IntelliJ IDEA:
    ```
        gradlew genIntellijRuns
    ```
2. Running client
    ```
        gradlew runClient
    ```
3. Running Server
    ```
        gradlew runServer
    ```
4. Build mod as .jar file
    ```
        gradlew build
    ```

For more information, look at "minecraft forge" README.txt file (it's not included to this repository) or [this link](https://gist.github.com/mcenderdragon/6c7af2daf6f72b0cadf0c63169a87583)

## How to test:

1. To run GameTests:
    ```
        gradlew runGameTestServer
    ```
2. Nether bridge loot modification(in game command):
    ```
        /loot spawn ~ ~ ~ loot minecraft:chests/nether_bridge
    ```
